/*
 * Copyright (c) 2009 Network Appliance, Inc.
 * All rights reserved.
 */

package de.xwic.entitygenerator.eclipse.ui.wizard;

import de.xwic.entitygenerator.EntityInfo;

/**
 * 
 * @author Aron Cotrau
 */
public class GeneratorWizardModel {

	private EntityInfo entityInfo;
	
	private String folderName;

	private boolean hibernateFile;
	private boolean javaClassFile;
	private boolean javaInterfaceFile;
	private boolean daoClassFile;
	private boolean daoInterfaceFile;
	private boolean entityXmlFile;
	private boolean listSetupFile;
	private boolean propertiesBundleFile;

	/**
	 * 
	 */
	public GeneratorWizardModel(EntityInfo entityInfo) {
		this.entityInfo = entityInfo;
	}
	
	/**
	 * @return the entityInfo
	 */
	public EntityInfo getEntityInfo() {
		return entityInfo;
	}

	/**
	 * @param entityInfo the entityInfo to set
	 */
	public void setEntityInfo(EntityInfo entityInfo) {
		this.entityInfo = entityInfo;
	}

	/**
	 * @return the hibernateFile
	 */
	public boolean isHibernateFile() {
		return hibernateFile;
	}

	/**
	 * @param hibernateFile the hibernateFile to set
	 */
	public void setHibernateFile(boolean hibernateFile) {
		this.hibernateFile = hibernateFile;
	}

	/**
	 * @return the javaClassFile
	 */
	public boolean isJavaClassFile() {
		return javaClassFile;
	}

	/**
	 * @param javaClassFile the javaClassFile to set
	 */
	public void setJavaClassFile(boolean javaClassFile) {
		this.javaClassFile = javaClassFile;
	}

	/**
	 * @return the javaInterfaceFile
	 */
	public boolean isJavaInterfaceFile() {
		return javaInterfaceFile;
	}

	/**
	 * @param javaInterfaceFile the javaInterfaceFile to set
	 */
	public void setJavaInterfaceFile(boolean javaInterfaceFile) {
		this.javaInterfaceFile = javaInterfaceFile;
	}

	/**
	 * @return the daoClassFile
	 */
	public boolean isDaoClassFile() {
		return daoClassFile;
	}

	/**
	 * @param daoClassFile the daoClassFile to set
	 */
	public void setDaoClassFile(boolean daoClassFile) {
		this.daoClassFile = daoClassFile;
	}

	/**
	 * @return the daoInterfaceFile
	 */
	public boolean isDaoInterfaceFile() {
		return daoInterfaceFile;
	}

	/**
	 * @param daoInterfaceFile the daoInterfaceFile to set
	 */
	public void setDaoInterfaceFile(boolean daoInterfaceFile) {
		this.daoInterfaceFile = daoInterfaceFile;
	}

	/**
	 * @return the entityXmlFile
	 */
	public boolean isEntityXmlFile() {
		return entityXmlFile;
	}

	/**
	 * @param entityXmlFile the entityXmlFile to set
	 */
	public void setEntityXmlFile(boolean entityXmlFile) {
		this.entityXmlFile = entityXmlFile;
	}

	/**
	 * @return the listSetupFile
	 */
	public boolean isListSetupFile() {
		return listSetupFile;
	}

	/**
	 * @param listSetupFile the listSetupFile to set
	 */
	public void setListSetupFile(boolean listSetupFile) {
		this.listSetupFile = listSetupFile;
	}

	/**
	 * @return the propertiesBundleFile
	 */
	public boolean isPropertiesBundleFile() {
		return propertiesBundleFile;
	}

	/**
	 * @param propertiesBundleFile the propertiesBundleFile to set
	 */
	public void setPropertiesBundleFile(boolean propertiesBundleFile) {
		this.propertiesBundleFile = propertiesBundleFile;
	}

	/**
	 * @return the folderName
	 */
	public String getFolderName() {
		return folderName;
	}

	/**
	 * @param folderName the folderName to set
	 */
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	
}

