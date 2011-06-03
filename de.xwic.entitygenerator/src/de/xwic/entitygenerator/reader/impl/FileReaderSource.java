/*
 * Copyright (c) 2009 Network Appliance, Inc.
 * All rights reserved.
 */

package de.xwic.entitygenerator.reader.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import de.xwic.entitygenerator.reader.IEntityReaderSource;

/**
 * Default implementation that reads the entity informations from a file
 * @author Aron Cotrau
 */
public class FileReaderSource implements IEntityReaderSource {

	private File file;
	
	public FileReaderSource(File file) {
		this.file = file;
	}
	
	/* (non-Javadoc)
	 * @see de.xwic.entitygenerator.reader.IEntityReaderSource#getSource()
	 */
	@Override
	public InputStream getSource() throws Exception {
		return new FileInputStream(file);
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

}
