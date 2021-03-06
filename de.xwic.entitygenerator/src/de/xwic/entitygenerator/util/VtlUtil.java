package de.xwic.entitygenerator.util;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
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
	public void generateContentFromTemplate(URL templateUrl, Map<String, Object> contextObjects, Writer writer) {

		try {
			VelocityContext vlContext = new VelocityContext();

			Iterator<String> i = contextObjects.keySet().iterator();

			vlContext.put("format", new FormatUtil(locale));
			vlContext.put("propertyUtil", new PropertyUtil());

			while (i.hasNext()) {
				String key = i.next();
				vlContext.put(key, contextObjects.get(key));
			}
			InputStream in = templateUrl.openStream();
			try {
				Reader reader = new InputStreamReader(in);
				velocityEngine.evaluate(vlContext, writer, templateUrl.getPath(), reader);
			} finally {
				in.close();
				writer.close();
			}
		} catch (Exception ex) {
			log.error(ex);
			throw new RuntimeException(ex);
		}
	}

	public void generateContentFromTemplateStream(InputStream in, Map<String, Object> contextObjects, Writer writer) {

		try {
			VelocityContext vlContext = new VelocityContext();
			
			vlContext.put("format", new FormatUtil(locale));
			vlContext.put("propertyUtil", new PropertyUtil());
			
			Iterator<String> i = contextObjects.keySet().iterator();

			while (i.hasNext()) {
				String key = i.next();

				vlContext.put(key, contextObjects.get(key));
			}

			try {
				Reader reader = new InputStreamReader(in);
				velocityEngine.evaluate(vlContext, writer, "InputStream", reader);
			} finally {
				in.close();
				writer.close();
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public String generateContentFromTemplateStream(InputStream in, Map<String, Object> contextObjects) {

		try {
			VelocityContext vlContext = new VelocityContext();
			
			vlContext.put("format", new FormatUtil(locale));
			vlContext.put("propertyUtil", new PropertyUtil());
			
			Iterator<String> i = contextObjects.keySet().iterator();

			while (i.hasNext()) {
				String key = i.next();

				vlContext.put(key, contextObjects.get(key));
			}

			try {
				StringWriter writer = new StringWriter();
				Reader reader = new InputStreamReader(in);
				velocityEngine.evaluate(vlContext, writer, "InputStream", reader);
				
				return writer.toString();
			} finally {
				in.close();
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
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
			
			vlContext.put("format", new FormatUtil(locale));
			vlContext.put("propertyUtil", new PropertyUtil());
			
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
	 * @param absoluteFileName
	 * @param contextObjects
	 * @return
	 */
	public void generateContentFromTemplateFile(File absoluteFileName, Map<String, Object> contextObjects, Writer writer) {

		try {
			VelocityContext vlContext = new VelocityContext();
			
			vlContext.put("format", new FormatUtil(locale));
			vlContext.put("propertyUtil", new PropertyUtil());
			
			Iterator<String> i = contextObjects.keySet().iterator();

			while (i.hasNext()) {
				String key = i.next();

				vlContext.put(key, contextObjects.get(key));
			}

			FileReader reader = new FileReader(absoluteFileName);
			velocityEngine.evaluate(vlContext, writer, absoluteFileName.getName(), reader);
			
			writer.close();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
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
			vlContext.put("propertyUtil", new PropertyUtil());
			
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
