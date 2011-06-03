/*
 * Copyright (c) 2009 Network Appliance, Inc.
 * All rights reserved.
 */

package de.xwic.entitygenerator.writer.base;

import java.util.HashMap;

import de.xwic.entitygenerator.EntityInfo;
import de.xwic.entitygenerator.util.VtlUtil;
import de.xwic.entitygenerator.writer.IEntityWriter;
import de.xwic.entitygenerator.writer.IEntityWriterDestination;

/**
 * Abstract class for writing infos which are returned by parsing a VTL file.
 * 
 * @author Aron Cotrau
 */
public abstract class VelocityTemplateSourceWriter implements IEntityWriter {

	/* (non-Javadoc)
	 * @see de.xwic.entitygenerator.writer.IEntityWriter#writeEntity(de.xwic.entitygenerator.EntityInfo, de.xwic.entitygenerator.writer.IEntityWriterDestination)
	 */
	@Override
	public void writeEntity(EntityInfo entityInfo, IEntityWriterDestination destination) throws Exception {

		try {
			VtlUtil util = new VtlUtil();
			HashMap<String, Object> contextObjects = new HashMap<String, Object>();
			contextObjects.put("entity", entityInfo);

			updateContextObjects(contextObjects);
			
			// write the entity class
			util.generateContentFromTemplateFile(getVelocityFileName(), contextObjects, destination.getWriter());
		} catch (Exception e) {
			throw e;
		}

	}
	
	/**
	 * default empty. to be overridden by classes that need special context objects for the VTL parsing
	 * @param contextObjects
	 */
	protected void updateContextObjects(HashMap<String, Object> contextObjects) {
		
	}

	/**
	 * @return the filename of the velocity template
	 */
	protected abstract String getVelocityFileName();
	
}
