/**
 * 
 */
package de.xwic.entitygenerator.writer.impl;

import de.xwic.entitygenerator.EntityInfo;
import de.xwic.entitygenerator.writer.base.VelocityTemplateSourceWriter;

/**
 * Default implementation for writing the Java class for the {@link EntityInfo}.
 * 
 * @author Aron Cotrau
 */
public class JavaClassWriter extends VelocityTemplateSourceWriter {

	@Override
	protected String getVelocityFileName() {
		return "templates/javaclass.vtl";
	}

}
