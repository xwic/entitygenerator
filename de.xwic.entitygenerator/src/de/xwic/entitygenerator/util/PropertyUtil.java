/**
 * 
 */
package de.xwic.entitygenerator.util;

import de.xwic.appkit.core.model.entities.IMitarbeiter;
import de.xwic.appkit.core.model.entities.IPicklistEntry;
import de.xwic.appkit.core.model.entities.impl.Mitarbeiter;
import de.xwic.appkit.core.model.entities.impl.PicklistEntry;
import de.xwic.entitygenerator.property.EntityProperty;

/**
 * 
 * @author Aron Cotrau
 */
public class PropertyUtil {

	public boolean isPrimitive(EntityProperty property) {
		String shortJavaName = property.getShortJavaName();
		return shortJavaName.equalsIgnoreCase("boolean") || shortJavaName.equalsIgnoreCase("long") || shortJavaName.equalsIgnoreCase("int") || shortJavaName.equalsIgnoreCase("double"); 
	}
	
	public boolean isString(EntityProperty property) {
		String shortJavaName = property.getShortJavaName();
		return shortJavaName.equalsIgnoreCase("string");
	}
	
	public boolean isEntityType(EntityProperty property) {
		String shortJavaName = property.getShortJavaName();
		return shortJavaName.equalsIgnoreCase("mitarbeiter") || shortJavaName.equalsIgnoreCase("employee") || shortJavaName.equalsIgnoreCase("picklistentry") || shortJavaName.equalsIgnoreCase("imitarbeiter") || shortJavaName.equalsIgnoreCase("ipicklistentry");
	}
	
	public String getJavaImplClass(String interfaceName) {
		if (interfaceName.equalsIgnoreCase(IPicklistEntry.class.getName())) {
			return PicklistEntry.class.getName();
		} else if (interfaceName.equalsIgnoreCase(IMitarbeiter.class.getName())) {
			return Mitarbeiter.class.getName();
		}
		
		return interfaceName;
	}
	
}
