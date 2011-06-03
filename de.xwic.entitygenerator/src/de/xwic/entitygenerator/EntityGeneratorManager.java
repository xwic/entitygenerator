/**
 * 
 */
package de.xwic.entitygenerator;

import de.xwic.entitygenerator.generator.IEntityGenerator;
import de.xwic.entitygenerator.generator.impl.EntityGeneratorImpl;

/**
 * Manager class for the {@link IEntityGenerator} interface. Users must call this class' method to provide the implementation of the EntityGenerator.
 * @author Aron Cotrau
 */
public class EntityGeneratorManager {

	/**
	 * @param entityInfo
	 * @return the {@link IEntityGenerator} implementation
	 */
	public static IEntityGenerator getEntityGenerator(EntityInfo entityInfo) {
		return new EntityGeneratorImpl(entityInfo);
	}
	
}
