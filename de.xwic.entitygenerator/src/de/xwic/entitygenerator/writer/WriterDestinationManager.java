/*
 * Copyright (c) 2009 Network Appliance, Inc.
 * All rights reserved.
 */

package de.xwic.entitygenerator.writer;

import java.io.File;
import java.io.IOException;

import de.xwic.appkit.core.config.Domain;
import de.xwic.entitygenerator.EntityInfo;
import de.xwic.entitygenerator.Package;
import de.xwic.entitygenerator.EntityInfo.FileType;
import de.xwic.entitygenerator.writer.impl.FileWriterDestination;

/**
 * Manager for creating {@link IEntityWriterDestination} objects, depending on the {@link FileType}
 * @author Aron Cotrau
 */
public class WriterDestinationManager {

	private EntityInfo entityInfo;
	private Package packageInfo;

	private String rootFolderName;
	
	/**
	 * @param entityInfo
	 */
	public WriterDestinationManager(EntityInfo entityInfo, String rootFolderName) {
		if (null == entityInfo) {
			throw new IllegalArgumentException("EntityInfo is not allowed to be null !");
		}

		this.entityInfo = entityInfo;
		this.packageInfo = entityInfo.getPackageInfo();
		this.rootFolderName = rootFolderName;
	}

	public IEntityWriterDestination createJavaClassWriter() throws Exception {
		File file = transformPackage(packageInfo.getEntityPackageName());
		String fileName = file.getAbsolutePath() + File.separator + entityInfo.getName() + ".java";
		FileType fileType = FileType.JAVA_CLASS;
		
		return createWriterDestination(fileName, fileType);
	}

	public IEntityWriterDestination createJavaInterfaceWriter() throws Exception {
		File file = transformPackage(packageInfo.getEntityInterfacePackageName());
		String fileName = file.getAbsolutePath() + File.separator + "I" + entityInfo.getName() + ".java";
		FileType fileType = FileType.JAVA_INTERFACE;
		
		return createWriterDestination(fileName, fileType);
	}

	public IEntityWriterDestination createDAOInterfaceWriter() throws Exception {
		File file = transformPackage(packageInfo.getDAOInterfacePackageName());
		String fileName = file.getAbsolutePath() + File.separator + "I" + entityInfo.getName() + "DAO.java";
		FileType fileType = FileType.DAO_INTERFACE;
		
		return createWriterDestination(fileName, fileType);
	}

	public IEntityWriterDestination createDAOClassWriter() throws Exception {
		File file = transformPackage(packageInfo.getDAOPackageName());
		String fileName = file.getAbsolutePath() + File.separator + entityInfo.getName() + "DAO.java";
		FileType fileType = FileType.DAO_CLASS;
		
		return createWriterDestination(fileName, fileType);
	}

	public IEntityWriterDestination createHibernateWriter() throws Exception {
		File file = transformPackage(packageInfo.getHibernatePackageName());
		String fileName = file.getAbsolutePath() + File.separator + entityInfo.getName() + ".hbm.xml";
		FileType fileType = FileType.HIBERNATE_MAPPING;
		
		return createWriterDestination(fileName, fileType);
	}

	public IEntityWriterDestination createSetupWriter() throws Exception {
		// TODO !
		return null;
	}

	public IEntityWriterDestination createEntityDescriptorWriter() throws Exception {
		Domain domain = entityInfo.getDomain();
		String folder = domain != null ? domain.getId() + File.separator : "";
		File file = transformPackage("config" + File.separator + folder + File.separator + "entitydescriptor");
		String fileName = file.getAbsolutePath() + File.separator + entityInfo.getName() + ".xml";
		FileType fileType = FileType.ENTITY_DESCRIPTOR;
		
		return createWriterDestination(fileName, fileType);
	}

	public IEntityWriterDestination createListSetupWriter() throws Exception {
		Domain domain = entityInfo.getDomain();
		String folder = domain != null ? domain.getId() + File.separator : "";
		File file = transformPackage("config" + File.separator + folder + File.separator + "listsetup");
		String fileName = file.getAbsolutePath() + File.separator + entityInfo.getName() + ".xml";
		FileType fileType = FileType.LIST_SETUP;
		
		return createWriterDestination(fileName, fileType);
	}

	public IEntityWriterDestination createPropertiesBundleWriter() throws Exception {
		Domain domain = entityInfo.getDomain();
		String folder = domain != null ? domain.getId() + "File.separator" : "";
		File file = transformPackage("config" + File.separator + folder + File.separator + "bundle");
		String fileName = file.getAbsolutePath() + File.separator + entityInfo.getName() + ".properties";
		FileType fileType = FileType.PROPERTIES_BUNDLE;
		
		return createWriterDestination(fileName, fileType);
	}
	
	private File transformPackage(String packageName) throws Exception {
		String temp = new String(packageName);
		temp = temp.replace(".", File.separator);

		if (null == rootFolderName) {
			rootFolderName = "dist";
		}
		
		temp = rootFolderName + File.separator + temp;

		File file = new File(temp);
		if (file.exists()) {
			file.delete();
			file.mkdirs();
			return file;
		} else {
			if (file.mkdirs()) {
				return file;
			}
		}

		throw new IOException("Cannot transform package '" + packageName + "'");

	}
	

	private IEntityWriterDestination createWriterDestination(String fileName, FileType fileType) throws Exception {
		File absoluteFile = new File(fileName);
		if (!absoluteFile.exists()) {
			absoluteFile.createNewFile();
		}
		
		entityInfo.putFile(fileType, absoluteFile);
		return new FileWriterDestination(absoluteFile);
	}
}
