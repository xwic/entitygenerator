/**
 * 
 */
package de.xwic.entitygenerator.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import de.xwic.entitygenerator.EntityInfo;
import de.xwic.entitygenerator.reader.IEntityReader;
import de.xwic.entitygenerator.reader.IEntityReaderSource;
import de.xwic.entitygenerator.reader.impl.XlsEntityReader;
import de.xwic.entitygenerator.writer.IEntityWriter;
import de.xwic.entitygenerator.writer.IEntityWriterDestination;
import de.xwic.entitygenerator.writer.impl.DAOWriter;
import de.xwic.entitygenerator.writer.impl.HibernateMappingWriter;
import de.xwic.entitygenerator.writer.impl.JavaFileWriter;
import de.xwic.entitygenerator.writer.impl.SetupWriter;

/**
 * The main class/application
 * 
 * @author Aron Cotrau
 */
public class EntityGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// define readers and writers
		List<IEntityReader> readers = new ArrayList<IEntityReader>();
		List<IEntityWriter> writers = new ArrayList<IEntityWriter>();
		
		IEntityReaderSource readerSource = new IEntityReaderSource() {
			
			@Override
			public InputStream getSource() throws Exception {
				return new FileInputStream(new File("test.xls"));
			}
		};
		
		IEntityWriterDestination dest = new IEntityWriterDestination() {
			
			@Override
			public Writer getWriterDestination() throws IOException {
				return new FileWriter("xx");
			}
		};
		
		writers.add(new DAOWriter());
		writers.add(new HibernateMappingWriter());
		writers.add(new SetupWriter());
		writers.add(new JavaFileWriter());
		
		readers.add(new XlsEntityReader());
		
		// start the readers and the registered writers
		for (IEntityReader reader : readers) {
			reader.readEntities(readerSource);
			List<EntityInfo> infos = reader.getEntityInfos();
			
			for (IEntityWriter writer : writers) {
				for (EntityInfo entityInfo : infos) {
					writer.writeEntity(entityInfo, dest);
				}
			}
		}
		
	}

}
