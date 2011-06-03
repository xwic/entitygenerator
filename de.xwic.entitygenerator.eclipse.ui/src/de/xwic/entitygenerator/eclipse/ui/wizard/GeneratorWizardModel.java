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
	
}
