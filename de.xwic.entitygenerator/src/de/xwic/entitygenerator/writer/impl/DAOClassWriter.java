/**
 * 
 */
package de.xwic.entitygenerator.writer.impl;

import de.xwic.entitygenerator.writer.base.VelocityTemplateSourceWriter;



/**
 * Writer for the DAO class and interface of an entity.
 * 
 * @author Aron Cotrau
 */
public class DAOClassWriter extends VelocityTemplateSourceWriter {

	@Override
	protected String getVelocityFileName() {
		return "templates/daoclass.vtl";
	}

	

}
