/**
 * 
 */
package de.xwic.entitygenerator.writer.impl;

import de.xwic.entitygenerator.writer.base.VelocityTemplateSourceWriter;

/**
 * Writer for the hbm.xml file.
 * 
 * @author Aron Cotrau
 */
public class HibernateMappingWriter extends VelocityTemplateSourceWriter {

	@Override
	protected String getVelocityFileName() {
		return "templates/hibernatemapping.vtl";
	}


}
