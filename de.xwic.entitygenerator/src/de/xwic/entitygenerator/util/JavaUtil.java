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
		} else if (shortType.equalsIgnoreCase("picklistentry") || shortType.equalsIgnoreCase("picklist")) {
			return IPicklistEntry.class.getName();
		} else if (shortType.equalsIgnoreCase("employee") || shortType.equalsIgnoreCase("mitarbeiter")) {
			return IMitarbeiter.class.getName();
		} else if (shortType.equalsIgnoreCase("set")) {
			return Set.class.getName();
		} else if (shortType.equalsIgnoreCase("list")) {
			return List.class.getName();
		}

		return shortType;
	}

	/**
	 * Normalizes the short type string
	 * 
	 * @param shortType
	 */
	public static void normalizeShortType(String shortType) {
		if (null == shortType) {
			return;
		}

		// normalize short type
		if (shortType.equalsIgnoreCase("int")) {
			shortType = "int";
		} else if (shortType.equalsIgnoreCase("long")) {
			shortType = "long";
		} else if (shortType.equalsIgnoreCase("boolean")) {
			shortType = "boolean";
		} else if (shortType.equalsIgnoreCase("set")) {
			shortType = "Set";
		} else if (shortType.equalsIgnoreCase("list")) {
			shortType = "List";
		} else if (shortType.equalsIgnoreCase("employee")) {
			shortType = "Mitarbeiter";
		} else if (shortType.equalsIgnoreCase("picklistentry")) {
			shortType = "PicklistEntry";
		} else if (shortType.equalsIgnoreCase("string")) {
			shortType = "String";
		}
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
