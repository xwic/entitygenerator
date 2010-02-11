package de.xwic.entitygenerator;

import java.io.File;

import de.xwic.appkit.core.config.Domain;

/**
 * Wraps the informations for an entity.
 * 
 * @author Aron Cotrau
 */
public class EntityInfo {

	private EntityProperty[] properties;
	
	private String name;
	private String description;
	private Package packageInfo;
	private Domain domain;

	private File file;
	
	/**
	 * @return the properties
	 */
	public EntityProperty[] getProperties() {
		return properties;
	}

	/**
	 * @param properties
	 *            the properties to set
	 */
	public void setProperties(EntityProperty[] properties) {
		this.properties = properties;
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

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the packageInfo
	 */
	public Package getPackageInfo() {
		return packageInfo;
	}

	/**
	 * @param packageInfo
	 *            the packageInfo to set
	 */
	public void setPackageInfo(Package packageInfo) {
		this.packageInfo = packageInfo;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @return the domain
	 */
	public Domain getDomain() {
		return domain;
	}

	/**
	 * @param domain the domain to set
	 */
	public void setDomain(Domain domain) {
		this.domain = domain;
	}

}
