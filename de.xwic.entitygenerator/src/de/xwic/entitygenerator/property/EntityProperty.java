package de.xwic.entitygenerator.property;

import de.xwic.appkit.core.config.model.Property;
import de.xwic.entitygenerator.util.JavaUtil;

/**
 * defines a property of an entity
 * 
 * @author Aron Cotrau
 */
public class EntityProperty extends Property {

	/** properties used for imports */
	private String javaClass; // e.g. java.lang.String
	private String shortJavaName; // String instead of java.lang.String

	private boolean clob = false;
	
	private String bundleName;
	private String dbColumnName;

	private boolean defaultListSetupIncluded;
	
	public String getDbColumnName() {
		return dbColumnName;
	}

	public void setDbColumnName(String dbColumnName) {
		this.dbColumnName = dbColumnName;
	}

	public boolean isDefaultListSetupIncluded() {
		return defaultListSetupIncluded;
	}

	public void setDefaultListSetupIncluded(boolean defaultListSetupIncluded) {
		this.defaultListSetupIncluded = defaultListSetupIncluded;
	}

	@Override
	public void setName(String name) {
		super.setName(name);
		setBundleName(JavaUtil.getBundleName(name));
		setDbColumnName(bundleName.replaceAll(" ", "_").toUpperCase());
	}
	
	public String getBundleName() {
		return bundleName;
	}

	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}

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
		JavaUtil.normalizeShortType(shortJavaName);
		this.shortJavaName = shortJavaName;
		setJavaClass(JavaUtil.getJavaType(shortJavaName));
	}
	
	/**
	 * @return the clob
	 */
	public boolean isClob() {
		return clob;
	}

	/**
	 * @param clob the clob to set
	 */
	public void setClob(boolean clob) {
		this.clob = clob;
	}

}
