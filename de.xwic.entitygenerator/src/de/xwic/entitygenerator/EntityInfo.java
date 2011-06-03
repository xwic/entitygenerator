package de.xwic.entitygenerator;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import de.xwic.appkit.core.config.Domain;
import de.xwic.entitygenerator.property.EntityProperty;

/**
 * Wraps the informations for an entity.
 * 
 * @author Aron Cotrau
 */
public class EntityInfo {

	public enum FileType {
		/** JAVA class type */
		JAVA_CLASS,
		/** JAVA interface file */
		JAVA_INTERFACE,
		/** Entity Descriptor XML file */
		ENTITY_DESCRIPTOR,
		/** List Setup XML file */
		LIST_SETUP,
		/** DAO Interface file */
		DAO_INTERFACE,
		/** DAO Class file */
		DAO_CLASS,
		/** Hibernate mapping file */
		HIBERNATE_MAPPING,
		/** Properties bundle file */
		PROPERTIES_BUNDLE
	}
	
	private EntityProperty[] properties;
	
	private String name;
	private String description;
	private Package packageInfo;
	private Domain domain;

	private Map<FileType, File> files = new HashMap<FileType, File>();
	
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
	public File getFile(FileType fileType) {
		return files.get(fileType);
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void putFile(FileType type, File file) {
		if (null == files) {
			files = new HashMap<FileType, File>();
		}
		
		files.put(type, file);
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
