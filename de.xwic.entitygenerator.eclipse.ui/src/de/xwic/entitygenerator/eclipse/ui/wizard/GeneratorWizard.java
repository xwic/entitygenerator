/*
 * Copyright (c) 2009 Network Appliance, Inc.
 * All rights reserved.
 */

package de.xwic.entitygenerator.eclipse.ui.wizard;

import org.eclipse.jface.wizard.Wizard;

import de.xwic.entitygenerator.eclipse.ui.wizard.propertiespage.PropertiesIdentificationPage;

/**
 * 
 * @author Aron Cotrau
 */
public class GeneratorWizard extends Wizard {

	private GeneratorWizardModel model;
	
	private PropertiesIdentificationPage propIdentPage;
	
	/**
	 * 
	 */
	public GeneratorWizard(GeneratorWizardModel model) {
		this.model = model;
	}
	
	@Override
	public void addPages() {
		super.addPages();
		
		propIdentPage = new PropertiesIdentificationPage("propertiesPage", model);
		addPage(propIdentPage);
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		return true;
	}

}
