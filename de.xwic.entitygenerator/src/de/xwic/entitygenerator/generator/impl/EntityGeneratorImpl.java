/**
 * 
 */
package de.xwic.entitygenerator.generator.impl;

import de.xwic.entitygenerator.EntityInfo;
import de.xwic.entitygenerator.generator.IEntityGenerator;
import de.xwic.entitygenerator.writer.IEntityWriter;
import de.xwic.entitygenerator.writer.IEntityWriterDestination;
import de.xwic.entitygenerator.writer.WriterDestinationManager;
import de.xwic.entitygenerator.writer.impl.DAOClassWriter;
import de.xwic.entitygenerator.writer.impl.DAOInterfaceWriter;
import de.xwic.entitygenerator.writer.impl.HibernateMappingWriter;
import de.xwic.entitygenerator.writer.impl.JavaClassWriter;
import de.xwic.entitygenerator.writer.impl.JavaInterfaceWriter;
import de.xwic.entitygenerator.writer.impl.ListSetupWriter;
import de.xwic.entitygenerator.writer.impl.PropertiesBundleFileWriter;
import de.xwic.entitygenerator.writer.impl.XmlEntityDescriptorWriter;

/**
 * 
 * @author Aron Cotrau
 */
public class EntityGeneratorImpl implements IEntityGenerator {

	private EntityInfo info;
	private WriterDestinationManager writerDestFactory;
	
	public EntityGeneratorImpl(EntityInfo info, String rootFolderName) {
		this.info = info;
		writerDestFactory = new WriterDestinationManager(info, rootFolderName);
	}
	
	/* (non-Javadoc)
	 * @see de.xwic.entitygenerator.IEntityGenerator#writeJavaClassFile()
	 */
	@Override
	public void writeJavaClassFile() throws Exception {
		IEntityWriterDestination dest = writerDestFactory.createJavaClassWriter();
		IEntityWriter writer = new JavaClassWriter();
		writer.writeEntity(info, dest);
	}

	/* (non-Javadoc)
	 * @see de.xwic.entitygenerator.IEntityGenerator#writeJavaInterfaceFile()
	 */
	@Override
	public void writeJavaInterfaceFile() throws Exception {
		IEntityWriterDestination dest = writerDestFactory.createJavaInterfaceWriter();
		IEntityWriter writer = new JavaInterfaceWriter();
		writer.writeEntity(info, dest);
	}

	/* (non-Javadoc)
	 * @see de.xwic.entitygenerator.IEntityGenerator#writeDAOClassFile()
	 */
	@Override
	public void writeDAOClassFile() throws Exception {
		IEntityWriterDestination dest = writerDestFactory.createDAOClassWriter();
		IEntityWriter writer = new DAOClassWriter();
		writer.writeEntity(info, dest);
	}
	
	/* (non-Javadoc)
	 * @see de.xwic.entitygenerator.IEntityGenerator#writeDAOInterfaceFile()
	 */
	@Override
	public void writeDAOInterfaceFile() throws Exception {
		IEntityWriterDestination dest = writerDestFactory.createDAOInterfaceWriter();
		IEntityWriter writer = new DAOInterfaceWriter();
		writer.writeEntity(info, dest);
	}
	
	/* (non-Javadoc)
	 * @see de.xwic.entitygenerator.IEntityGenerator#writeListSetupFile()
	 */
	@Override
	public void writeListSetupFile() throws Exception {
		IEntityWriterDestination dest = writerDestFactory.createListSetupWriter();
		IEntityWriter writer = new ListSetupWriter();
		writer.writeEntity(info, dest);
	}

	/* (non-Javadoc)
	 * @see de.xwic.entitygenerator.IEntityGenerator#writePropertiesBundleFile()
	 */
	@Override
	public void writePropertiesBundleFile() throws Exception {
		IEntityWriterDestination dest = writerDestFactory.createPropertiesBundleWriter();
		IEntityWriter writer = new PropertiesBundleFileWriter();
		writer.writeEntity(info, dest);
	}
	
	/* (non-Javadoc)
	 * @see de.xwic.entitygenerator.IEntityGenerator#writeHibernateMappingFile()
	 */
	@Override
	public void writeHibernateMappingFile() throws Exception {
		IEntityWriterDestination dest = writerDestFactory.createHibernateWriter();
		IEntityWriter writer = new HibernateMappingWriter();
		writer.writeEntity(info, dest);
	}
	
	public void writeEntityXmlFile() throws Exception {
		IEntityWriterDestination dest = writerDestFactory.createEntityDescriptorWriter();
		IEntityWriter writer = new XmlEntityDescriptorWriter();
		writer.writeEntity(info, dest);
	}
	
}
