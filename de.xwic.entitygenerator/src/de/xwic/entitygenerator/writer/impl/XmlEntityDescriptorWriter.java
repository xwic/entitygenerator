/*
 * copyright (c) 2007 by pol GmbH
 * de.xwic.appkit.core.config.generator.XmlEntityDescriptorWriter
 */
package de.xwic.entitygenerator.writer.impl;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import de.xwic.appkit.core.config.model.Property;
import de.xwic.entitygenerator.EntityInfo;
import de.xwic.entitygenerator.property.EntityProperty;
import de.xwic.entitygenerator.writer.IEntityWriter;
import de.xwic.entitygenerator.writer.IEntityWriterDestination;

/**
 * Exports an EntityDescriptor into an XML file.
 * 
 * @author Florian Lippisch
 */
public class XmlEntityDescriptorWriter implements IEntityWriter {

	@Override
	public void writeEntity(EntityInfo entityInfo, IEntityWriterDestination destination) throws Exception {
		
		try {
			writeEntityDescriptor(entityInfo, destination.getWriter());
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @param entityInfo
	 * @param fileName
	 */
	private void writeEntityDescriptor(EntityInfo entityInfo, Writer writer) throws IOException {
		
		Document doc = DocumentFactory.getInstance().createDocument();

		Element entity = doc.addElement("entity");
		entity.addElement("class").setText(entityInfo.getJavaName());
		
		if (entityInfo.getTitlePattern() != null) {
			entity.addElement("title").setText(entityInfo.getTitlePattern());
		}
		
		Element properties = entity.addElement("properties");
		properties.addAttribute("autoDetect", "true");

		// sort the list.
		List<Property> propList = new ArrayList<Property>();
		EntityProperty[] propArray = entityInfo.getProperties();
		
		for (int i = 0; i < propArray.length; i++) {
			EntityProperty entityProperty = propArray[i];
			propList.add(entityProperty);
		}
		
		Collections.sort(propList, new Comparator<Property>() {
			public int compare(Property o1, Property o2) {
				Property p1 = (Property)o1;
				Property p2 = (Property)o2;
				if (p1.isHidden() != p2.isHidden()) {
					return p1.isHidden() ? 1 : -1;
				}
				return p1.getName().compareTo(p2.getName());
			}
		});
		
		// export the list
		for (Iterator<Property> it = propList.iterator(); it.hasNext(); ) {
			Property p = it.next();
			
			Element prop = properties.addElement("property");
			//prop.addElement("name").setText(propName);
			prop.addAttribute("name", p.getName());
			
			if (p.isHidden()) {
				prop.addAttribute("hidden", "true");
			}
			if (!p.isLazy()) {
				prop.addAttribute("lazy", "false");
			}
			if (p.getPicklistId() != null && p.getPicklistId().length() != 0) {
				prop.addAttribute("picklistId", p.getPicklistId());
			}
			if (p.getMaxLength() != 0) {
				prop.addAttribute("maxlength", Integer.toString(p.getMaxLength()));	
			}
			if (p.getRequired()) {
				prop.addAttribute("required", p.getRequired() ? "true" : "false");
			}
		}
		
		OutputFormat prettyFormat = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(writer, prettyFormat);
		xmlWriter.write(doc);
		xmlWriter.flush();
		writer.close();
		
	}
	
	
}
