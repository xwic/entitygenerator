/**
 * 
 */
package de.xwic.entitygenerator.test;

import java.util.HashMap;
import java.util.Set;

import junit.framework.TestCase;
import de.xwic.appkit.core.model.entities.IPicklistEntry;
import de.xwic.entitygenerator.EntityInfo;
import de.xwic.entitygenerator.Package;
import de.xwic.entitygenerator.property.EntityProperty;
import de.xwic.entitygenerator.util.VtlUtil;

/**
 * 
 * @author Aron Cotrau
 */
public class JavaFilesGenerationTest extends TestCase {

	public void testJavaClass() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Generating JAVA class");
		
		EntityInfo info = createEntityInfo();
		
		VtlUtil util = new VtlUtil();
		HashMap<String, Object> contextObjects = new HashMap<String, Object>();
		contextObjects.put("entity", info);
		String result = util.generateContentFromTemplateFile("templates/javaclass.vtl", contextObjects);
		System.out.println(result);
		System.out.println("-----------------------------------------------------------");
	}
	
	public void testJavaInterface() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Generating JAVA interface");
		
		EntityInfo info = createEntityInfo();
		
		VtlUtil util = new VtlUtil();
		HashMap<String, Object> contextObjects = new HashMap<String, Object>();
		contextObjects.put("entity", info);
		String result = util.generateContentFromTemplateFile("templates/javainterface.vtl", contextObjects);
		System.out.println(result);
		System.out.println("-----------------------------------------------------------");
		
	}
	
	public void testDAOInterface() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Generating DAO interface");
		
		EntityInfo info = createEntityInfo();
		
		VtlUtil util = new VtlUtil();
		HashMap<String, Object> contextObjects = new HashMap<String, Object>();
		contextObjects.put("entity", info);
		String result = util.generateContentFromTemplateFile("templates/daointerface.vtl", contextObjects);
		System.out.println(result);
		System.out.println("-----------------------------------------------------------");
		
	}
	
	public void testDAOClass() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Generating DAO class");
		
		EntityInfo info = createEntityInfo();
		
		VtlUtil util = new VtlUtil();
		HashMap<String, Object> contextObjects = new HashMap<String, Object>();
		contextObjects.put("entity", info);
		String result = util.generateContentFromTemplateFile("templates/daoclass.vtl", contextObjects);
		System.out.println(result);
		System.out.println("-----------------------------------------------------------");
		
	}
	
	public void testBundleProperties() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Generating Bundle properties");
		
		EntityInfo info = createEntityInfo();
		
		VtlUtil util = new VtlUtil();
		HashMap<String, Object> contextObjects = new HashMap<String, Object>();
		contextObjects.put("entity", info);
		String result = util.generateContentFromTemplateFile("templates/propertiesbundle.vtl", contextObjects);
		System.out.println(result);
		System.out.println("-----------------------------------------------------------");
		
	}
	
	public void testListSetup() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Generating List Setup");
		
		EntityInfo info = createEntityInfo();
		
		VtlUtil util = new VtlUtil();
		HashMap<String, Object> contextObjects = new HashMap<String, Object>();
		contextObjects.put("entity", info);
		String result = util.generateContentFromTemplateFile("templates/listsetup.vtl", contextObjects);
		System.out.println(result);
		System.out.println("-----------------------------------------------------------");
	}
	
	public void testHibernateFile() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Generating Hibernate File");
		
		EntityInfo info = createEntityInfo();
		
		VtlUtil util = new VtlUtil();
		HashMap<String, Object> contextObjects = new HashMap<String, Object>();
		contextObjects.put("entity", info);
		String result = util.generateContentFromTemplateFile("templates/hibernatemapping.vtl", contextObjects);
		System.out.println(result);
		System.out.println("-----------------------------------------------------------");
	}
	
	private EntityInfo createEntityInfo() {
		EntityInfo info = new EntityInfo();
		Package packageInfo = new Package();
		packageInfo.setName("de.xwic.test.package");
		info.setPackageInfo(packageInfo);
		info.setName("TestEntity");
		
		EntityProperty[] props = new EntityProperty[6];
		
		props[0] = new EntityProperty();
		props[0].setName("testString");
		props[0].setJavaClass(String.class.getName());
		props[0].setShortJavaName("String");

		props[1] = new EntityProperty();
		props[1].setName("testPicklistEntry");
		props[1].setJavaClass(IPicklistEntry.class.getName());
		props[1].setShortJavaName("PicklistEntry");
		
		props[2] = new EntityProperty();
		props[2].setName("testSet");
		props[2].setJavaClass(Set.class.getName());
		props[2].setShortJavaName("Set");
		
		props[3] = new EntityProperty();
		props[3].setName("testBoolean");
		props[3].setShortJavaName("boolean");
		props[3].setDefaultListSetupIncluded(true);

		props[4] = new EntityProperty();
		props[4].setName("testEmployee");
		props[4].setShortJavaName("employee");
		props[4].setDefaultListSetupIncluded(true);

		props[5] = new EntityProperty();
		props[5].setName("testClob");
		props[5].setShortJavaName("String");
		props[5].setClob(true);
		
		info.setProperties(props);
		return info;
	}
	
}
