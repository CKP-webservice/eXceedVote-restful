package exceedvote.main;

import java.net.BindException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.security.authentication.DigestAuthenticator;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.NCSARequestLog;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.security.Constraint;
import org.eclipse.jetty.util.security.Password;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import com.mongodb.Mongo;
import com.sun.jersey.spi.container.servlet.ServletContainer;

import exceedvote.helper.ConstraintHelper;
import exceedvote.model.Role;
import exceedvote.model.User;
import exceedvote.model.dao.mongo.MongoDaoFactory;

/**
 * Deploy a RESTful server using Jersey in an embedded Jetty server.
 * 
 * Requires: Jetty 8 JARs.
 * 
 * @author James Brucker
 *
 */
public class JettyMain {
	private static Server server;
	
	
	private static void startServer( int port , String path) throws BindException, Exception
	{		
		//Class clazz =  ServletContainer.class; // uncomment to help Eclipse locate import
		server = new Server(port);
		ServletHolder sh = new ServletHolder(ServletContainer.class);
		// set this parameter to a colon-delimited list of package names
		// the packages are where your REST resources are
		final String RESOURCES = "exceedvote.resource";
		
// Jersey 1.x:
		sh.setInitParameter( 
				"com.sun.jersey.config.property.resourceConfigClass",
				"com.sun.jersey.api.core.PackagesResourceConfig");
		sh.setInitParameter(
				"com.sun.jersey.config.property.packages", RESOURCES );
// Jersey 2.x:
		sh.setInitParameter(
				"org.glassfish.jersey.config.property.resourceConfigClass",
				"org.glassfish.jersey.api.core.PackagesResourceConfig");
		sh.setInitParameter(
				"org.glassfish.jersey.config.property.packages", RESOURCES );
 
// uncomment these to enable tracing of requests and responses
//		sh.setInitParameter("com.sun.jersey.config.feature.Debug", "true");
//		sh.setInitParameter("com.sun.jersey.config.feature.Trace", "true");
//		
//		sh.setInitParameter("com.sun.jersey.spi.container.ContainerRequestFilters", 
//				"com.sun.jersey.api.container.filter.LoggingFilter");
//		sh.setInitParameter("com.sun.jersey.spi.container.ContainerResponseFilters", 
//				"com.sun.jersey.api.container.filter.LoggingFilter");
		
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SECURITY);
		
// Map the context path to servlet
		
		context.setContextPath(path);
		context.addServlet(sh, "/*");
		
		
        ConstraintSecurityHandler security =(ConstraintSecurityHandler) context.getSecurityHandler();
        security.setAuthenticator(new DigestAuthenticator());
        
        
        manageUser(security,server);
        
        setConstraint(security);
        
        HandlerCollection handlers = new HandlerCollection();
        ContextHandlerCollection contexts = new ContextHandlerCollection();
        RequestLogHandler requestLogHandler = new RequestLogHandler();
        NCSARequestLog requestLog = new NCSARequestLog();
        requestLog.setRetainDays(90);
        requestLog.setAppend(true);
        requestLog.setExtended(false);
        requestLog.setLogTimeZone("GMT+7");
        requestLogHandler.setRequestLog(requestLog);
        
        handlers.setHandlers(new Handler[]{ context, new DefaultHandler() ,requestLogHandler });

		
		server.setHandler(handlers);
 
		QueuedThreadPool qtp = new QueuedThreadPool(10);
		qtp.setName("ApiServe");
		server.setThreadPool(qtp);
		server.start();
		
	}
	
	private static void manageUser(ConstraintSecurityHandler security,Server server) {
		HashLoginService realm = new HashLoginService("EXCEEDVOTE");
		realm.putUser("username",new Password("password"),new String[]{"voter"});
//		Role r = new Role("voter", 10);
//		MongoDaoFactory.getInstance().getRoleDAO().save(r);
//		User u = new User(MongoDaoFactory.getInstance().getRoleDAO().findById(1),MongoDaoFactory.getInstance().getContestantDAO().findById(67),"username","password","u@u.com");
//		u.setRole(MongoDaoFactory.getInstance().getRoleDAO().findById(1));
//		MongoDaoFactory.getInstance().getUserDAO().save(u);
//		realm.putUser("pawis",new Password("pawis"),new String[]{"voter"});
//		realm.putUser("kanin",new Password("kanin"),new String[]{"voter"});
		server.addBean(realm);
        security.setLoginService(realm);
	}

	private static void setConstraint(ConstraintSecurityHandler security) {
		List<ConstraintMapping> constraintMappings = new ArrayList<ConstraintMapping>();
        
		ConstraintHelper root = new ConstraintHelper("root page", "test", new String[]{"user","admin","voter"}, "/*", true);
        constraintMappings.add(root.getConstraintMapping());
        
//        ConstraintHelper contestants = new ConstraintHelper("contestant", "admin", new String[]{"test"}, "/contestant", true);
//        constraintMappings.add(contestants.getConstraintMapping());
//        
//        ConstraintHelper criteria = new ConstraintHelper("criteria", "admin", new String[]{"test"}, "/criteria/*", true);
//        constraintMappings.add(criteria.getConstraintMapping());
        
		
        security.setConstraintMappings(constraintMappings);
	}

	public static void stopServer( ) throws Exception {
		if (server != null) server.stop();
	}
	
	public static void main(String[] args) throws BindException, Exception {
		int port = 8080;
		String path = "/";
		if (args.length > 0) try {
			port = Integer.valueOf(args[0]);
			if (args.length > 1) {
				path = args[1];
			}
				port = Integer.valueOf(args[0]);
		} catch ( NumberFormatException nfe ) {
			usage();
		}
		
		System.out.printf("Starting server on port %d | path \"%s\" ...\n", port, path);
		startServer( port , path );
		System.out.printf("Server started on port %d | path \"%s\" \n",  port, path);
	}

	private static void usage() {
		System.out.println("usage: java -jar appname.jar [port] [path]");
		System.exit(1);
		
	}
}
