/**
 * 
 */
package de.xwic.entitygenerator.eclipse.ui.wizard.propertiespage;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import de.xwic.entitygenerator.eclipse.ui.Activator;
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
		EntityProperty prop = (EntityProperty) element;
		
		if (columnIndex == 2) {
			if (prop.getRequired()) {
				return Activator.getDefault().getImage(Activator.IMG_CHECK);
			} else {
				return Activator.getDefault().getImage(Activator.IMG_UNCHECK);
			}
		} else if (columnIndex == 3) {
			if (prop.isDefaultListSetupIncluded()) {
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
		
		String shortJavaName = prop.getShortJavaName();
		switch (columnIndex) {
		case 0:
			return prop.getName();
		case 1:
			return shortJavaName;
		case 2:
			return "";
		case 3:
			return "";
		case 4:
			if (shortJavaName.equalsIgnoreCase("string")) {
				return String.valueOf(prop.getMaxLength());
			}
			
			return "";
		case 5:
			return prop.getBundleName();
		case 6:
			if (shortJavaName.equalsIgnoreCase("ipicklistentry") || shortJavaName.equalsIgnoreCase("picklistentry")) {
				return prop.getPicklistId();
			}
			
			return "";
		}
		
		return "";
	}

}
