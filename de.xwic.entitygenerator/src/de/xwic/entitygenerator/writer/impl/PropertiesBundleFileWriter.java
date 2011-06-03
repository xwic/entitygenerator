/**
 * 
 */
package de.xwic.entitygenerator.writer.impl;

import de.xwic.entitygenerator.writer.base.VelocityTemplateSourceWriter;

/**
 * 
 * @author Aron Cotrau
 */
public class PropertiesBundleFileWriter extends VelocityTemplateSourceWriter {

	@Override
	protected String getVelocityFileName() {
		return "templates/propertiesbundle.vtl";
	}

}
