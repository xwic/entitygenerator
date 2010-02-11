package de.xwic.entitygenerator.util;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * Util class for the VTL operations.
 * 
 * @author Florian Lippisch
 */
public class VtlUtil {

	private VelocityEngine velocityEngine = null;

	private Log log = LogFactory.getLog(getClass());
	private Locale locale = Locale.getDefault();

	/**
	 * Creates the velocity template engine.
	 */
	public VtlUtil() {
		velocityEngine = new VelocityEngine();
		try {
			velocityEngine.init();
		} catch (Exception ex) {
			log.error(ex);
			throw new RuntimeException("VelocityEngine initialization failed: " + ex, ex);
		}

	}

	/**
	 * @param templateUrl
	 * @param contextObjects
	 * @return
	 */
	public String generateContentFromTemplate(URL templateUrl, Map<String, Object> contextObjects) {

		try {
			VelocityContext vlContext = new VelocityContext();

			Iterator<String> i = contextObjects.keySet().iterator();

			vlContext.put("format", new FormatUtil(locale));

			while (i.hasNext()) {
				String key = i.next();
				vlContext.put(key, contextObjects.get(key));
			}
			InputStream in = templateUrl.openStream();
			try {
				Reader reader = new InputStreamReader(in);
				StringWriter writer = new StringWriter();
				velocityEngine.evaluate(vlContext, writer, templateUrl.getPath(), reader);

				return writer.toString();
			} finally {
				in.close();
			}
		} catch (Exception ex) {
			log.error(ex);
			return ex.getMessage();
		}
	}

	/**
	 * @param absoluteFileName
	 * @param contextObjects
	 * @return
	 */
	public String generateContentFromTemplateFile(String absoluteFileName, Map<String, Object> contextObjects) {

		try {
			VelocityContext vlContext = new VelocityContext();
			new VelocityContext();
			vlContext.put("format", new FormatUtil(locale));
			Iterator<String> i = contextObjects.keySet().iterator();

			while (i.hasNext()) {
				String key = i.next();

				vlContext.put(key, contextObjects.get(key));
			}

			FileReader reader = new FileReader(absoluteFileName);
			StringWriter writer = new StringWriter();
			velocityEngine.evaluate(vlContext, writer, absoluteFileName, reader);

			return writer.toString();
		} catch (Exception ex) {
			log.error(ex);
			return ex.getMessage();
		}
	}

	/**
	 * @param template
	 * @param contextObjects
	 * @return
	 */
	public String generateContentFromTemplateString(String template, Map<String, Object> contextObjects) {

		try {
			VelocityContext vlContext = new VelocityContext();
			vlContext.put("format", new FormatUtil(locale));

			Iterator<String> i = contextObjects.keySet().iterator();

			while (i.hasNext()) {
				String key = i.next();

				vlContext.put(key, contextObjects.get(key));
			}

			StringWriter writer = new StringWriter();
			velocityEngine.evaluate(vlContext, writer, "VTE", template);
			return writer.toString();
		} catch (Exception ex) {
			log.error(ex);
			return ex.getMessage();
		}
	}

	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
