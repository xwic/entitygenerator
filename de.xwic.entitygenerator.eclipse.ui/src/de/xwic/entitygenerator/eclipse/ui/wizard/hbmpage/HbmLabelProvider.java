/**
 * 
 */
package de.xwic.entitygenerator.eclipse.ui.wizard.hbmpage;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import de.xwic.entitygenerator.eclipse.ui.Activator;
import de.xwic.entitygenerator.property.EntityProperty;

/**
 * 
 * @author Aron Cotrau
 */
public class HbmLabelProvider implements ITableLabelProvider {

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
		EntityProperty prop = (EntityProperty) element;
		
		if (columnIndex == 3 && prop.getShortJavaName().equalsIgnoreCase("string")) {
			if (prop.isClob()) {
				return Activator.getDefault().getImage(Activator.IMG_CHECK);
			} else {
				return Activator.getDefault().getImage(Activator.IMG_UNCHECK);
			}
		}
		
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
			if (prop.getShortJavaName().equalsIgnoreCase("string")) {
				return String.valueOf(prop.getMaxLength());
			}
			
			return "";
		case 3:
			return "";
		case 4:
			return prop.getDbColumnName();
		}
		
		return "";
	}

}
