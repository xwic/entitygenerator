/**
 * 
 */
package de.xwic.entitygenerator;

/**
 * Wraps a Java package
 * 
 * @author Aron Cotrau
 */
public class Package {

	private String name;

	public Package() {
		
	}
	
	/**
	 * @param name
	 */
	public Package(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getEntityInterfacePackageName() {
		return name + ".entities";
	}
	
	public String getEntityPackageName() {
		return name + ".entities.impl";
	}

	public String getDAOInterfacePackageName() {
		return name + ".dao";
	}
	
	public String getDAOPackageName() {
		return name + ".dao.impl";
	}
	
	public String getHibernatePackageName() {
		return getEntityInterfacePackageName();
	}
	
}

