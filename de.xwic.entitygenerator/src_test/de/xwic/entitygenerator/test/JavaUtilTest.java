package de.xwic.entitygenerator.test;

import de.xwic.entitygenerator.util.JavaUtil;
import junit.framework.TestCase;

/**
 * 
 * @author Aron Cotrau
 */
public class JavaUtilTest extends TestCase {

	public void testBundleName() {
		System.out.println(JavaUtil.getBundleName("abcDef"));
		System.out.println(JavaUtil.getBundleName("traLaLaLa"));
		System.out.println(JavaUtil.getBundleName("FooBar"));
		System.out.println(JavaUtil.getBundleName("Foo_Bar"));
	}
	
}

