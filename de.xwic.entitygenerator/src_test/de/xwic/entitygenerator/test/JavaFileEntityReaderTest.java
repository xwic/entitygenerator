/**
 * 
 */
package de.xwic.entitygenerator.test;

import java.util.List;
import java.util.Set;

import de.xwic.appkit.core.dao.IEntity;
import de.xwic.appkit.core.model.entities.IMitarbeiter;
import de.xwic.entitygenerator.reader.JavaFileEntityReader;
import junit.framework.TestCase;

/**
 * 
 * @author Aron Cotrau
 */
public class JavaFileEntityReaderTest extends TestCase {

	public void testReader() {
		new JavaFileEntityReader(Bean.class);
	}
	
	class Bean {
		private String str;
		private long lng;
		private int integer;
		private IMitarbeiter mit;
		/**
		 * @return the str
		 */
		public String getStr() {
			return str;
		}
		/**
		 * @param str the str to set
		 */
		public void setStr(String str) {
			this.str = str;
		}
		/**
		 * @return the lng
		 */
		public long getLng() {
			return lng;
		}
		/**
		 * @param lng the lng to set
		 */
		public void setLng(long lng) {
			this.lng = lng;
		}
		/**
		 * @return the integer
		 */
		public int getInteger() {
			return integer;
		}
		/**
		 * @param integer the integer to set
		 */
		public void setInteger(int integer) {
			this.integer = integer;
		}
		/**
		 * @return the mit
		 */
		public IMitarbeiter getMit() {
			return mit;
		}
		/**
		 * @param mit the mit to set
		 */
		public void setMit(IMitarbeiter mit) {
			this.mit = mit;
		}
		/**
		 * @return the set
		 */
		public Set<?> getSet() {
			return set;
		}
		/**
		 * @param set the set to set
		 */
		public void setSet(Set<?> set) {
			this.set = set;
		}
		/**
		 * @return the list
		 */
		public List<?> getList() {
			return list;
		}
		/**
		 * @param list the list to set
		 */
		public void setList(List<?> list) {
			this.list = list;
		}
		/**
		 * @return the entity
		 */
		public IEntity getEntity() {
			return entity;
		}
		/**
		 * @param entity the entity to set
		 */
		public void setEntity(IEntity entity) {
			this.entity = entity;
		}
		/**
		 * @return the bool
		 */
		public boolean isBool() {
			return bool;
		}
		/**
		 * @param bool the bool to set
		 */
		public void setBool(boolean bool) {
			this.bool = bool;
		}
		private Set<?> set;
		private List<?> list;
		private IEntity entity;
		private boolean bool;
	}
}
