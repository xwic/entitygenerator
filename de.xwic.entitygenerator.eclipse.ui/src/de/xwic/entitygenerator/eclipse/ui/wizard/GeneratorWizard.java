/*
 * Copyright (c) 2009 Network Appliance, Inc.
 * All rights reserved.
 */

package de.xwic.entitygenerator.eclipse.ui.wizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import de.xwic.entitygenerator.EntityGeneratorManager;
import de.xwic.entitygenerator.eclipse.ui.wizard.filespage.FilesSelectionPage;
import de.xwic.entitygenerator.eclipse.ui.wizard.hbmpage.HibernateMappingPage;
import de.xwic.entitygenerator.eclipse.ui.wizard.propertiespage.PropertiesIdentificationPage;
import de.xwic.entitygenerator.eclipse.ui.wizard.summary.SummaryPage;
import de.xwic.entitygenerator.generator.IEntityGenerator;

/**
 * 
 * @author Aron Cotrau
 */
public class GeneratorWizard extends Wizard {

	private GeneratorWizardModel model;

	private FilesSelectionPage filesSelPage;
	private PropertiesIdentificationPage propIdentPage;
	private HibernateMappingPage hbmPage;
	private SummaryPage summaryPage;

	/**
	 * 
	 */
	public GeneratorWizard(GeneratorWizardModel model) {
		this.model = model;
	}

	@Override
	public void addPages() {
		super.addPages();

		filesSelPage = new FilesSelectionPage("filesSelPage", model);
		addPage(filesSelPage);

		propIdentPage = new PropertiesIdentificationPage("propertiesPage", model);
		addPage(propIdentPage);

		hbmPage = new HibernateMappingPage("hibernateMappingPage", model);
		addPage(hbmPage);

		summaryPage = new SummaryPage("summaryPage", model);
		addPage(summaryPage);
	}

	@Override
	public boolean canFinish() {
		return getContainer().getCurrentPage() == summaryPage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		IEntityGenerator generator = EntityGeneratorManager.getEntityGenerator(model.getEntityInfo());

		try {
			if (model.isDaoClassFile()) {
				generator.writeDAOClassFile();
			}

			if (model.isDaoInterfaceFile()) {
				generator.writeDAOInterfaceFile();
			}
			
			if (model.isEntityXmlFile()) {
				generator.writeEntityXmlFile();
			}
			
			if (model.isHibernateFile()) {
				generator.writeHibernateMappingFile();
			}
			
			if (model.isJavaClassFile()) {
				generator.writeJavaClassFile();
			}
			
			if (model.isJavaInterfaceFile()) {
				generator.writeJavaInterfaceFile();
			}
			
			if (model.isListSetupFile()) {
				generator.writeListSetupFile();
			}
			
			if (model.isPropertiesBundleFile()) {
				generator.writePropertiesBundleFile();
			}
			
			return true;
		} catch (Exception e) {
			((WizardPage) getContainer().getCurrentPage()).setErrorMessage(e.getMessage());
			return false;
		}

	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page == propIdentPage) {
			// refresh the table, because values might get changed in the
			// previous page
			hbmPage.refreshTable();
			return hbmPage;
		}

		return super.getNextPage(page);
	}

}
