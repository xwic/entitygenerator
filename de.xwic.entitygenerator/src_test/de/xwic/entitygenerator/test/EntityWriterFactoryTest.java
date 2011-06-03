/*
 * Copyright (c) 2009 Network Appliance, Inc.
 * All rights reserved.
 */

package de.xwic.entitygenerator.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;
import de.xwic.appkit.core.model.entities.IPicklistEntry;
import de.xwic.entitygenerator.EntityInfo;
import de.xwic.entitygenerator.Package;
import de.xwic.entitygenerator.property.EntityProperty;
import de.xwic.entitygenerator.writer.IEntityWriterDestination;
import de.xwic.entitygenerator.writer.WriterDestinationManager;
import de.xwic.entitygenerator.writer.impl.JavaClassWriter;

/**
 * 
 * @author Aron Cotrau
 */
public class EntityWriterFactoryTest extends TestCase {

	public void testTransformer() {
		String packageName = "de.xwic.test";

		System.out.println("Transforming package '" + packageName + "' into folders.");

		File file;
		try {
			file = WriterDestinationManager.transformPackage(packageName);

			if (file.exists() && file.isDirectory()) {
				System.out.println("Folder Created ! Absolute path = " + file.getAbsolutePath());
			} else {
				System.out.println("Folder not Created !");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testCreateJavaClass() {
		try {
			EntityInfo createEntityInfo = createEntityInfo();
			WriterDestinationManager factory = new WriterDestinationManager(createEntityInfo); 
			IEntityWriterDestination dest = factory.createJavaClassWriter();
			
			JavaClassWriter classWriter = new JavaClassWriter();
			
			classWriter.writeEntity(createEntityInfo, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private EntityInfo createEntityInfo() {
		EntityInfo info = new EntityInfo();
		Package packageInfo = new Package();
		packageInfo.setName("de.xwic.test.pkg");
		info.setPackageInfo(packageInfo);
		info.setName("TestEntity");
		
		EntityProperty[] props = new EntityProperty[4];
		
		props[0] = new EntityProperty();
		props[0].setName("test_name0");
		props[0].setJavaClass(String.class.getName());
		props[0].setShortJavaName("String");

		props[1] = new EntityProperty();
		props[1].setName("test_name1");
		props[1].setJavaClass(IPicklistEntry.class.getName());
		props[1].setShortJavaName("IPicklistEntry");
		
		props[2] = new EntityProperty();
		props[2].setName("test_name2");
		props[2].setJavaClass(Set.class.getName());
		props[2].setShortJavaName("Set");
		
		props[3] = new EntityProperty();
		props[3].setName("test_name3");
		props[3].setJavaClass(List.class.getName());
		props[3].setShortJavaName("List");
		
		info.setProperties(props);
		return info;
	}
}
