/**
 * 
 */
package de.xwic.entitygenerator.writer;


import de.xwic.entitygenerator.EntityInfo;

/**
 * Defines the methods for writing an {@link EntityInfo} object into a file/external destination
 * @author Aron Cotrau
 */
public interface IEntityWriter {

	/**
	 * Writes the entity info in the destination
	 * @param entityInfo
	 * @param destination
	 */
	public void writeEntity(EntityInfo entityInfo, IEntityWriterDestination destination) throws Exception;
	
}
