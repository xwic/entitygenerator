/**
 * 
 */
package de.xwic.entitygenerator.eclipse.ui.wizard.propertiespage;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Item;

import de.xwic.entitygenerator.property.EntityProperty;

/**
 * 
 * @author Aron Cotrau
 */
public class PropertiesCellModifier implements ICellModifier {

	private TableViewer tv;
	
	public PropertiesCellModifier(TableViewer tableViewer) {
		this.tv = tableViewer;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object, java.lang.String)
	 */
	@Override
	public boolean canModify(Object element, String property) {
		if (property.equalsIgnoreCase("Clob") || property.equalsIgnoreCase("Maxlength")) {
			return ((EntityProperty) element).getShortJavaName().equalsIgnoreCase("string");
		}
		
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object getValue(Object element, String property) {
		EntityProperty prop = (EntityProperty) element;
		String[] props = Constants.columnProperties;
		
		if (property.equalsIgnoreCase(props[0])) {
			return prop.getName();
		} else if (property.equalsIgnoreCase(props[1])) {
			String[] array = Constants.entityTypes;
			for (int i = 0; i < array.length; i++) {
				if (array[i].equalsIgnoreCase(prop.getShortJavaName())) {
					return i;
				}
			}
			
			return 0;
		} else if (property.equalsIgnoreCase(props[2])) {
			return prop.getRequired();
		} else if (property.equalsIgnoreCase(props[3])) {
			return prop.isDefaultListSetupIncluded();
		} else if (property.equalsIgnoreCase(props[4])) {
			return String.valueOf(prop.getMaxLength());
		} else if (property.equalsIgnoreCase(props[5])) {
			return prop.getBundleName();
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
		String[] props = Constants.columnProperties;
		
		if (property.equalsIgnoreCase(props[0])) {
			prop.setName((String) value);
		} else if (property.equalsIgnoreCase(props[1])) {
			String[] array = Constants.entityTypes;
			prop.setShortJavaName(array[(Integer) value]);
		} else if (property.equalsIgnoreCase(props[2])) {
			prop.setRequired((Boolean) value);
		} else if (property.equalsIgnoreCase(props[3])) {
			prop.setDefaultListSetupIncluded((Boolean) value);
		} else if (property.equalsIgnoreCase(props[4])) {
			prop.setMaxLength(Integer.parseInt(value.toString()));
		} else if (property.equalsIgnoreCase(props[5])) {
			prop.setBundleName((String) value);
		}
		
		tv.refresh(element);
	}

}
