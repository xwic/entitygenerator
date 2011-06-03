/**
 * 
 */
package de.xwic.entitygenerator.eclipse.ui.wizard.propertiespage;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import de.xwic.entitygenerator.property.EntityProperty;

/**
 * 
 * @author Aron Cotrau
 */
public class PropertiesLabelProvider implements ITableLabelProvider {

	public PropertiesLabelProvider() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void removeListener(ILabelProviderListener listener) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	@Override
	public String getColumnText(Object element, int columnIndex) {
		EntityProperty prop = (EntityProperty) element;
		
		switch (columnIndex) {
		case 0:
			return prop.getName();
		case 1:
			return prop.getShortJavaName();
		case 2:
			return Boolean.toString(prop.getRequired());
		case 3:
			if (prop.getShortJavaName().equalsIgnoreCase("string")) {
				return String.valueOf(prop.getMaxLength());
			}
			
			return "";
		case 4:
			if (prop.getShortJavaName().equalsIgnoreCase("string")) {
				boolean clob = prop.isClob();
				return Boolean.toString(clob); 
			}
			return "";
		case 5:
			return prop.getBundleName();
		}
		
		return "";
	}

}
