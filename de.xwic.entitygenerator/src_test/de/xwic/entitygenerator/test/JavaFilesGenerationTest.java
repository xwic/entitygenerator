/**
 * 
 */
package de.xwic.entitygenerator.test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;
import de.xwic.appkit.core.model.entities.IPicklistEntry;
import de.xwic.entitygenerator.EntityInfo;
import de.xwic.entitygenerator.EntityProperty;
import de.xwic.entitygenerator.Package;
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
	
	private EntityInfo createEntityInfo() {
		EntityInfo info = new EntityInfo();
		Package packageInfo = new Package();
		packageInfo.setName("de.xwic.test.package");
		info.setPackageInfo(packageInfo);
		info.setName("TestEntity");
		
		EntityProperty[] props = new EntityProperty[4];
		
		props[0] = new EntityProperty();
		props[0].setName("test_name0");
		props[0].setJavaClass(String.class.getName());
		props[0].setShortJavaName("String");

		props[1] = new EntityProperty();
		props[1].setName("test_name1");
		props[1].setJavaClass(IPicklistEntry.class.getName());
		props[1].setShortJavaName("IPicklistEntry");
		
		props[2] = new EntityProperty();
		props[2].setName("test_name2");
		props[2].setJavaClass(Set.class.getName());
		props[2].setShortJavaName("Set");
		
		props[3] = new EntityProperty();
		props[3].setName("test_name3");
		props[3].setJavaClass(List.class.getName());
		props[3].setShortJavaName("List");
		
		info.setProperties(props);
		return info;
	}
	
}
