package exceedvote.helper;

import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.util.security.Constraint;

public class ConstraintHelper {
	private Constraint constraint = null;
	private ConstraintMapping constraintMapping = null;
	
	public ConstraintHelper(String constraintName,String constraintRole, String[] constraintRoles , String pathSpec , boolean authenticate) {
		constraint = new Constraint(constraintName,constraintRole);
		constraint.setRoles(constraintRoles);
		constraint.setAuthenticate(true);
		
		constraintMapping = new ConstraintMapping();
		constraintMapping.setConstraint(constraint);
		constraintMapping.setPathSpec(pathSpec);
	}
	
	public ConstraintMapping getConstraintMapping() {
		return this.constraintMapping;
	}
	
	public Constraint getConstraint() {
		return constraint;
	}
}
