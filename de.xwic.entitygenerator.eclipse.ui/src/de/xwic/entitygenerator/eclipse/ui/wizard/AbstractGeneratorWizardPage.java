/**
 * 
 */
package de.xwic.entitygenerator.eclipse.ui.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * @author Aron Cotrau
 */
public abstract class AbstractGeneratorWizardPage extends WizardPage {

	protected GeneratorWizardModel model;
	
	/**
	 * @param pageName
	 */
	public AbstractGeneratorWizardPage(String pageName, GeneratorWizardModel model) {
		super(pageName);
		this.model = model;
	}

	protected Font createHeaderFont() {
		return new Font(Display.getCurrent(), new FontData("Arial", 10, SWT.BOLD));  
	}
	
	protected Font createValueFont() {
		return new Font(Display.getCurrent(), new FontData("Arial", 10, SWT.NORMAL));  
	}
	
}
