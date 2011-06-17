/**
 * 
 */
package de.xwic.entitygenerator.eclipse.ui.wizard.summary;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.xwic.entitygenerator.EntityInfo;
import de.xwic.entitygenerator.Package;
import de.xwic.entitygenerator.eclipse.ui.wizard.AbstractGeneratorWizardPage;
import de.xwic.entitygenerator.eclipse.ui.wizard.GeneratorWizardModel;

/**
 * 
 * @author Aron Cotrau
 */
public class SummaryPage extends AbstractGeneratorWizardPage {

	private Label lblDestFolder;
	private Label lblEntityName;
	private Label lblPackageName;
	
	private Label lblFiles;
	
	/**
	 * @param pageName
	 */
	public SummaryPage(String pageName, GeneratorWizardModel model) {
		super(pageName, model);
		
		setTitle("Operations Summary");
		setDescription("Short description of the operations being executed and the files created.");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));

		EntityInfo entityInfo = model.getEntityInfo();
		Package packageInfo = entityInfo.getPackageInfo();
		
		createLabel(container, "Destination Folder", false).setFont(createHeaderFont());
		lblDestFolder = createLabel(container, model.getFolderName(), true);
		lblDestFolder.setFont(createValueFont());

		createLabel(container, "Entity Name", false).setFont(createHeaderFont());
		lblEntityName = createLabel(container, entityInfo.getName(), true);
		lblEntityName.setFont(createValueFont());
		
		createLabel(container, "Package Name", false).setFont(createHeaderFont());
		lblPackageName = createLabel(container, null != packageInfo ? packageInfo.getName() : "", true);
		lblPackageName.setFont(createValueFont());
		
		createLabel(container, "Files", false).setFont(createHeaderFont());
		lblFiles = new Label(container, SWT.WRAP);
		lblFiles.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		lblFiles.setFont(createValueFont());
		
		setControl(container);
	}

	private Label createLabel(Composite container, String txt, boolean grabHSpace) {
		Label lbl = new Label(container, SWT.NONE);
		lbl.setText(txt != null ? txt : "");
		lbl.setLayoutData(new GridData(SWT.FILL, SWT.TOP, grabHSpace, false, 1, 1));
		
		return lbl;
	}
	
	public void reload() {
		EntityInfo entityInfo = model.getEntityInfo();
		
		lblDestFolder.setText(model.getFolderName());
		lblEntityName.setText(entityInfo.getName());
		Package packageInfo = entityInfo.getPackageInfo();
		lblPackageName.setText(packageInfo != null ? packageInfo.getName() : "");
		
		String filesTxt = "";
		
		if (model.isJavaClassFile()) {
			filesTxt += "Java Class \n";
		}
		
		if (model.isJavaInterfaceFile()) {
			filesTxt += "Java Interface \n";
		}
		
		if (model.isDaoClassFile()) {
			filesTxt += "DAO Class \n";
		}

		if (model.isDaoInterfaceFile()) {
			filesTxt += "DAO Interface \n";
		}
		
		if (model.isEntityXmlFile()) {
			filesTxt += "Entity XML \n";
		}
		
		if (model.isHibernateFile()) {
			filesTxt += "Hibernate Mapping \n";
		}
		
		if (model.isListSetupFile()) {
			filesTxt += "List Setup \n";	
		}
		
		if (model.isPropertiesBundleFile()) {
			filesTxt += "Properties Bundle \n";
		}
		
		lblFiles.setText(filesTxt);
		
		lblFiles.getParent().layout();
	}

}
