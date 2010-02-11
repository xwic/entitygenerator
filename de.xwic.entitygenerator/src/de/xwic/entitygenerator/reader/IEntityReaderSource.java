/**
 * 
 */
package de.xwic.entitygenerator.reader;

import java.io.InputStream;

/**
 * Defines the source of the entity info generator. Can be an XML file, or a XLS file, a CSV file, etc.
 * @author Aron Cotrau
 */
public interface IEntityReaderSource {

	/**
	 * @return the source of the reader 
	 * @throws Exception 
	 */
	public InputStream getSource() throws Exception;
	
}
