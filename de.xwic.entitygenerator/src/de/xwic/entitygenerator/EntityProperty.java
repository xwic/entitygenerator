package de.xwic.entitygenerator;

import de.xwic.appkit.core.config.model.Property;

/**
 * defines a property of an entity
 * 
 * @author Aron Cotrau
 */
public class EntityProperty extends Property {

	/** properties used for imports */
	private String javaClass; // e.g. java.lang.String
	private String shortJavaName; // String instead of java.lang.String

	/**
	 * @return the javaClass
	 */
	public String getJavaClass() {
		return javaClass;
	}

	/**
	 * @param javaClass
	 *            the javaClass to set
	 */
	public void setJavaClass(String javaClass) {
		this.javaClass = javaClass;
	}

	/**
	 * @return the shortJavaName
	 */
	public String getShortJavaName() {
		return shortJavaName;
	}

	/**
	 * @param shortJavaName
	 *            the shortJavaName to set
	 */
	public void setShortJavaName(String shortJavaName) {
		this.shortJavaName = shortJavaName;
	}

}
