/**
 * 
 */
package de.xwic.entitygenerator.reader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 * @author Aron Cotrau
 */
public class JavaFileEntityReader {

	public JavaFileEntityReader(Class<?> clazz) {
        Method[] m = clazz.getDeclaredMethods();
        
        for (int i = 0; i < m.length; i++) {
        	System.out.println(m[i].toString());
        }
        
        Field[] f = clazz.getFields();
        for (Field field : f) {
        	System.out.println(field.getName() + " " + field.getType());
		}
        
        f = clazz.getDeclaredFields();
        
        for (Field field : f) {
        	System.out.println(field.getName() + " " + field.getType().getName());
		}
	}
	
}
