/**
 * 
 */
package de.xwic.entitygenerator.util;

import de.xwic.entitygenerator.property.EntityProperty;

/**
 * 
 * @author Aron Cotrau
 */
public class PropertyUtil {


	public boolean isPrimitive(EntityProperty property) {
		String shortJavaName = property.getShortJavaName();
		return shortJavaName.equalsIgnoreCase("boolean") || shortJavaName.equalsIgnoreCase("long") || shortJavaName.equalsIgnoreCase("int"); 
	}
	
	public boolean isString(EntityProperty property) {
		String shortJavaName = property.getShortJavaName();
		return shortJavaName.equalsIgnoreCase("string");
	}
	
	public boolean isEntityType(EntityProperty property) {
		String shortJavaName = property.getShortJavaName();
		return shortJavaName.equalsIgnoreCase("mitarbeiter") || shortJavaName.equalsIgnoreCase("employee") || shortJavaName.equalsIgnoreCase("picklistentry");
	}
	
}
