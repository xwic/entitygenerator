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
	 * @param shortType
	 *            a short description for a java type.<br>
	 *            e.g.: string, employee, picklistentry etc.
	 * @return the full java name for a short type.<br>
	 *         e.g.: returns "java.lang.String" for String
	 */
	public static String getJavaType(String shortType) {

		if (null == shortType) {
			return "shortType is null";
		}

		if (shortType.equalsIgnoreCase("string") || shortType.equalsIgnoreCase("text")) {
			return String.class.getName();
		} else if (shortType.equalsIgnoreCase("picklistentry") || shortType.equalsIgnoreCase("picklist") || shortType.equalsIgnoreCase("ipicklistentry")) {
			return IPicklistEntry.class.getName();
		} else if (shortType.equalsIgnoreCase("employee") || shortType.equalsIgnoreCase("mitarbeiter") || shortType.equalsIgnoreCase("imitarbeiter")) {
			return IMitarbeiter.class.getName();
		} else if (shortType.equalsIgnoreCase("set")) {
			return Set.class.getName();
		} else if (shortType.equalsIgnoreCase("list")) {
			return List.class.getName();
		}

		return shortType;
	}

	public static boolean isImportable(String className) {
		if (className.lastIndexOf(".") < 0) {
			// primitive
			return false;
		} else if (className.startsWith("java.lang")) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Normalizes the short type string
	 * 
	 * @param shortType
	 */
	public static String normalizeShortType(String shortType) {
		String normalized = shortType;
		if (null == shortType) {
			return "";
		}

		// normalize short type
		if (shortType.equalsIgnoreCase("int")) {
			normalized = "int";
		} else if (shortType.equalsIgnoreCase("long")) {
			normalized = "long";
		} else if (shortType.equalsIgnoreCase("boolean")) {
			normalized = "boolean";
		} else if (shortType.equalsIgnoreCase("double")) {
			normalized = "double";
		} else if (shortType.equalsIgnoreCase("set")) {
			normalized = "Set";
		} else if (shortType.equalsIgnoreCase("list")) {
			normalized = "List";
		} else if (shortType.equalsIgnoreCase("employee")) {
			normalized = "Mitarbeiter";
		} else if (shortType.equalsIgnoreCase("picklistentry")) {
			normalized = "PicklistEntry";
		} else if (shortType.equalsIgnoreCase("string")) {
			normalized = "String";
		}
		
		return normalized;
	}

	/**
	 * @param name
	 * @return a bundle name from the given name. the bundle name will contain
	 *         spaces between the words defined by a property name
	 */
	public static String getBundleName(String name) {
		StringBuffer sb = new StringBuffer();
		
		char[] array = name.toCharArray();
		if (array.length > 0) {
			// capitalize the first letter
			array[0] = Character.toUpperCase(array[0]);
		}

		boolean first = true;
		for (int i = 0; i < array.length; i++) {
			boolean newWord = false;
			newWord = Character.isUpperCase(array[i]);

			if (newWord && !first) {
				sb.append(" ");
			} else if (first && newWord) {
				first = false;
			}
			
			sb.append(array[i]);
		}
		
		return sb.toString();
	}

}
