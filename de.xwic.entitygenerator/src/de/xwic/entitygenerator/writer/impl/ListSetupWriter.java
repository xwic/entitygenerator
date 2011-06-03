/**
 * 
 */
package de.xwic.entitygenerator.writer.impl;

import de.xwic.entitygenerator.writer.base.VelocityTemplateSourceWriter;

/**
 * 
 * @author Aron Cotrau
 */
public class ListSetupWriter extends VelocityTemplateSourceWriter {

	/* (non-Javadoc)
	 * @see de.xwic.entitygenerator.writer.base.VelocityTemplateSourceWriter#getVelocityFileName()
	 */
	@Override
	protected String getVelocityFileName() {
		return "templates/listsetup.vtl";
	}

}
