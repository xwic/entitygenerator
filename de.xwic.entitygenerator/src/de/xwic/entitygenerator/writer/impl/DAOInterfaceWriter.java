/*
 * Copyright (c) 2009 Network Appliance, Inc.
 * All rights reserved.
 */

package de.xwic.entitygenerator.writer.impl;

import de.xwic.entitygenerator.writer.base.VelocityTemplateSourceWriter;

/**
 * DAO interface writer
 * 
 * @author Aron Cotrau
 */
public class DAOInterfaceWriter extends VelocityTemplateSourceWriter {

	/* (non-Javadoc)
	 * @see de.xwic.entitygenerator.writer.impl.VelocityTemplateSourceWriter#getVelocityFileName()
	 */
	@Override
	protected String getVelocityFileName() {
		return "templates/daointerface.vtl";
	}

}
