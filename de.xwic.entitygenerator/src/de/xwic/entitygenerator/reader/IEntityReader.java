/**
 * 
 */
package de.xwic.entitygenerator.reader;

import java.util.List;

import de.xwic.entitygenerator.EntityInfo;

/**
 * Interface for reading the entities from a given {@link IEntityReaderSource}
 * @author Aron Cotrau
 */
public interface IEntityReader {

	/**
	 * Reads the entities from the source
	 * @param source
	 */
	public void readEntities(IEntityReaderSource source);
	
	/**
	 * @return a list of {@link EntityInfo} objects, wrappers for entities
	 */
	public List<EntityInfo> getEntityInfos();
	
}
