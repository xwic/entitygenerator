/**
 * 
 */
package de.xwic.entitygenerator.writer;

import java.io.Writer;

/**
 * 
 * @author Aron Cotrau
 */
public interface IEntityWriterDestination {

	/**
	 * @return the destination for the writer
	 */
	public Writer getWriter() throws Exception;
	
}
