package exceedvote.main;

import java.net.BindException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.security.authentication.DigestAuthenticator;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.security.Constraint;
import org.eclipse.jetty.util.security.Password;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import com.sun.jersey.spi.container.servlet.ServletContainer;

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
	
	
	private static void startServer( int port ) throws BindException, Exception
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
		
		context.setContextPath("/");
		context.addServlet(sh, "/*");
		
		HashLoginService realm = new HashLoginService("EXCEEDVOTE");
		realm.putUser("testuser",new Password("password"),new String[]{"test"});
        server.addBean(realm);
        ConstraintSecurityHandler security=(ConstraintSecurityHandler) context.getSecurityHandler();
        security.setAuthenticator(new DigestAuthenticator());
        security.setLoginService(realm);
        
        List<ConstraintMapping> constraintMappings = new ArrayList<ConstraintMapping>();
        
        Constraint constraint = new Constraint("SecureTest", "test");
        constraint.setAuthenticate(true);
        constraint.setRoles(new String[]{"user","admin","test"});
        ConstraintMapping mapping = new ConstraintMapping();
        mapping.setConstraint(constraint);
        mapping.setPathSpec("/*");
        constraintMappings.add(mapping);
        
        
        Constraint constraint2 = new Constraint("ContestantConstraint","admin");
        constraint2.setAuthenticate(true);
        constraint2.setRoles(new String[]{"admin"});
        ConstraintMapping mapping2 = new ConstraintMapping();
        mapping2.setConstraint(constraint2);
        mapping2.setPathSpec("/contestant");
        constraintMappings.add(mapping2);
        
        security.setConstraintMappings(constraintMappings);
        
        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[]
        { context, new DefaultHandler() });

		
		server.setHandler(context);
 
		QueuedThreadPool qtp = new QueuedThreadPool(10);
		qtp.setName("ApiServe");
		server.setThreadPool(qtp);
		server.start();
		
	}
	
	public static void stopServer( ) throws Exception {
		if (server != null) server.stop();
	}
	
	public static void main(String[] args) throws BindException, Exception {
		int port = 8080;
		System.out.println("Starting server...");
		startServer( port );
		System.out.printf("Server started on port %d\n",  port);
	}
}
