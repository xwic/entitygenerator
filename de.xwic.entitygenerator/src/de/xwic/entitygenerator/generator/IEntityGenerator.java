package de.xwic.entitygenerator.generator;

/**
 * Main interface used for writing all the important files for the generator.
 * @author Aron Cotrau
 */
public interface IEntityGenerator {

	/**
	 * writes the java class file
	 * @throws Exception
	 */
	public abstract void writeJavaClassFile() throws Exception;

	/**
	 * writes the java interface file
	 * @throws Exception
	 */
	public abstract void writeJavaInterfaceFile() throws Exception;

	/**
	 * writes the DAO class file
	 * @throws Exception
	 */
	public abstract void writeDAOClassFile() throws Exception;

	/**
	 * writes the DAO interface file
	 * @throws Exception
	 */
	public abstract void writeDAOInterfaceFile() throws Exception;

	/**
	 * writes the list setup file
	 * @throws Exception
	 */
	public abstract void writeListSetupFile() throws Exception;

	/**
	 * writes the properties bundle file
	 * @throws Exception
	 */
	public abstract void writePropertiesBundleFile() throws Exception;

	/**
	 * writes the hibernate mapping file
	 * @throws Exception
	 */
	public abstract void writeHibernateMappingFile() throws Exception;

	
	/**
	 * writes the entity descriptor XML file
	 * @throws Exception
	 */
	public abstract void writeEntityXmlFile() throws Exception;
	
}