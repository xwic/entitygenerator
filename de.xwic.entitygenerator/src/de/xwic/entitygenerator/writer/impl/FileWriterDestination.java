/*
 * Copyright (c) 2009 Network Appliance, Inc.
 * All rights reserved.
 */

package de.xwic.entitygenerator.writer.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import de.xwic.entitygenerator.writer.IEntityWriterDestination;

/**
 * File implementation for the {@link IEntityWriterDestination} interface
 * @author Aron Cotrau
 */
public class FileWriterDestination implements IEntityWriterDestination {

	private File file;
	
	/**
	 * @param file
	 */
	public FileWriterDestination(File file) {
		super();
		this.file = file;
	}

	/* (non-Javadoc)
	 * @see de.xwic.entitygenerator.writer.IEntityWriterDestination#getWriter()
	 */
	@Override
	public Writer getWriter() throws Exception {
		return new FileWriter(file);
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
