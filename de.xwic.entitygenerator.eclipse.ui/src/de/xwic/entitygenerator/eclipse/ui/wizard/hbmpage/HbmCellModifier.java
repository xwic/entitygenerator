/**
 * 
 */
package de.xwic.entitygenerator.eclipse.ui.wizard.hbmpage;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Item;

import de.xwic.entitygenerator.property.EntityProperty;

/**
 * 
 * @author Aron Cotrau
 */
public class HbmCellModifier implements ICellModifier {

	private TableViewer tv;
	
	public HbmCellModifier(TableViewer tv) {
		this.tv = tv;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object, java.lang.String)
	 */
	@Override
	public boolean canModify(Object element, String property) {
		if (property.equalsIgnoreCase("Clob")) {
			return ((EntityProperty) element).getShortJavaName().equalsIgnoreCase("string");
		}
		
		if (property.equalsIgnoreCase("DBColumn")) {
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object getValue(Object element, String property) {
		EntityProperty prop = (EntityProperty) element;
		
		if (property.equalsIgnoreCase("Name")) {
			return prop.getName();
		} else if (property.equalsIgnoreCase("Type")) {
			return prop.getShortJavaName();
		} else if (property.equalsIgnoreCase("Maxlength")) {
			return prop.getMaxLength();
		} else if (property.equalsIgnoreCase("Clob")) {
			if (prop.getShortJavaName().equalsIgnoreCase("string")) {
				return prop.isClob();
			}
			
			// return false by default
			return Boolean.valueOf(false);
		} else if (property.equalsIgnoreCase("DBColumn")) {
			return prop.getDbColumnName();
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object, java.lang.String, java.lang.Object)
	 */
	@Override
	public void modify(Object element, String property, Object value) {
		if (element instanceof Item) {
			element = ((Item) element).getData();
		}
		
		EntityProperty prop = (EntityProperty) element;
		
		if (property.equalsIgnoreCase("Clob")) {
			if (prop.getShortJavaName().equalsIgnoreCase("string")) {
				prop.setClob((Boolean) value);
			}
		} else if (property.equalsIgnoreCase("DBColumn")) {
			prop.setDbColumnName((String) value);
		}
		
		tv.refresh(prop);
	}

}
