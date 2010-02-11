/**
 * 
 */
package de.xwic.entitygenerator.util;

import java.util.List;
import java.util.Set;

import de.xwic.appkit.core.model.entities.IMitarbeiter;
import de.xwic.appkit.core.model.entities.IPicklistEntry;

/**
 * Util class for Java mappings
 * 
 * @author Aron Cotrau
 */
public class JavaUtil {

	/**
	 * @param shortType a short description for a java type.<br> e.g.: string, employee, picklistentry etc.
	 * @return the full java name for a short type.<br>
	 * e.g.: returns "java.lang.String" for String
	 */
	public String getJavaType(String shortType) {
		
		if (null == shortType) {
			return "shortType is null";
		}
		
		if (shortType.equalsIgnoreCase("string") || shortType.equalsIgnoreCase("text")) {
			return String.class.getName();
		} else if (shortType.equalsIgnoreCase("picklistentry") || shortType.equalsIgnoreCase("picklist")) {
			return IPicklistEntry.class.getName();
		} else if (shortType.equalsIgnoreCase("employee") || shortType.equalsIgnoreCase("mitarbeiter")) {
			return IMitarbeiter.class.getName();
		} else if (shortType.equalsIgnoreCase("set")) {
			return Set.class.getName();
		} else if (shortType.equalsIgnoreCase("list")) {
			return List.class.getName();
		}
		
		
		return "Unknown Java Type for shortType '" + shortType + "'";
	}
	
}
