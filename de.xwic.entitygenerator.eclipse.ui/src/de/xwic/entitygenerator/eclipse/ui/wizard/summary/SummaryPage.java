/**
 * 
 */
package de.xwic.entitygenerator.eclipse.ui.wizard.summary;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import de.xwic.entitygenerator.eclipse.ui.wizard.GeneratorWizardModel;

/**
 * 
 * @author Aron Cotrau
 */
public class SummaryPage extends WizardPage {

	private GeneratorWizardModel model;
	
	/**
	 * @param pageName
	 */
	public SummaryPage(String pageName, GeneratorWizardModel model) {
		super(pageName);
		
		this.model = model;
		setTitle("Operations Summary");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		
		setControl(container);
	}

}
