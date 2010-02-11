/**
 * 
 */
package de.xwic.entitygenerator.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Util class for formatting a .vtl file
 * 
 * @author Florian Lippisch
 */
public class FormatUtil {

	private Locale locale;
	private DateFormat dfDate;

	/**
	 * @param locale
	 */
	public FormatUtil(Locale locale) {
		super();
		this.locale = locale;
		dfDate = new SimpleDateFormat("dd-MMM-yyyy");
	}
	
	/**
	 * Format a date in short format.
	 * @param date
	 * @return
	 */
	public String date(Date date) {
		if (date == null) {
			return "";
		}
		return dfDate.format(date);
	}

	/**
	 * Format a date in short format.
	 * @param date
	 * @return
	 */
	public String dateTime(Date date) {
		if (date == null) {
			return "";
		}
		return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale).format(date);
	}

	/**
	 * Format a date in short format.
	 * @param date
	 * @return
	 */
	public String time(Date date) {
		if (date == null) {
			return "";
		}
		return DateFormat.getTimeInstance(DateFormat.SHORT, locale).format(date);
	}
	
	/**
	 * Transforms text into HTML format. Used to transform
	 * user inputed text.
	 * <p>Returns an empty string if the argument is <code>null</code>.
	 * @return java.lang.String
	 * @param text java.lang.String
	 */
	public String html(String text) {
		
		if (text == null) {
			return "";
		}
		
		StringBuffer sbHTML = new StringBuffer("");
		//boolean newline = true;
		boolean newline = true;
		boolean wascr = false;
	
		for(int i=0; i < text.length(); i++)
		{
			char c = text.charAt(i);
			switch (c) {
				case 34 :
					sbHTML.append("&quot;");
					break;
				case 60 :
					sbHTML.append("&lt;");
					break;
				case 62 :
					sbHTML.append("&gt;");
					break;
				case 38 :
					sbHTML.append("&amp;");
					break;
				case 13 :
					// do some
					sbHTML.append("<BR>");
					wascr = true;
					break;

				case 32 :
					// space
					if (newline)
						sbHTML.append("&nbsp;");
					else
						sbHTML.append(c);
					wascr = false;
					break;

				case 10 :
					if (!wascr) {
						sbHTML.append("<BR>");
					}
					wascr = false;
					break;
					
				default :
					sbHTML.append(c);
					wascr = false;
					newline = false;

				}

		}
		
		return sbHTML.toString();
	}

	/**
	 * @param str
	 * @return a string which has the first letter in upper case
	 */
	public String firstToUpper(String str) {
		if (null == str || str.length() == 0) {
			return str;
		}
		
		String first = str.substring(0, 1);
		first = first.toUpperCase();
		
		str = str.substring(1, str.length());
		
		return first + str;
	}
	
}
