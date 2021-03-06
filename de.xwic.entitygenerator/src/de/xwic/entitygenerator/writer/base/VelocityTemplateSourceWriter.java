/*
 * Copyright (c) 2009 Network Appliance, Inc.
 * All rights reserved.
 */

package de.xwic.entitygenerator.writer.base;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

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

		Writer writer = destination.getWriter();
		
		try {
			VtlUtil util = new VtlUtil();
			Map<String, Object> contextObjects = new HashMap<String, Object>();
			contextObjects.put("entity", entityInfo);

			updateContextObjects(contextObjects);
			
			InputStream in = getClass().getResourceAsStream(getVelocityFileName());
			
			// write the entity class
			util.generateContentFromTemplateStream(in, contextObjects, writer);
		} catch (Exception e) {
			throw e;
		} 

	}
	
	/**
	 * default empty. to be overridden by classes that need special context objects for the VTL parsing
	 * @param contextObjects
	 */
	protected void updateContextObjects(Map<String, Object> contextObjects) {
		
	}

	/**
	 * @return the filename of the velocity template
	 */
	protected abstract String getVelocityFileName();
	
}
