/**
 * 
 */
package de.xwic.entitygenerator.eclipse.ui.wizard.filespage;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.xwic.entitygenerator.EntityInfo;
import de.xwic.entitygenerator.eclipse.ui.wizard.GeneratorWizardModel;

/**
 * 
 * @author Aron Cotrau
 */
public class FilesSelectionPage extends WizardPage {

	private GeneratorWizardModel model;
	
	public FilesSelectionPage(String pageName, GeneratorWizardModel model) {
		super(pageName);
		
		this.model = model;
		
		setTitle("Files Selection");
		setDescription("Select the files that will be generated");
	}

	@Override
	public void createControl(Composite parent) {
		EntityInfo entityInfo = model.getEntityInfo();
		
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		
		Label lblEntityName = new Label(container, SWT.NONE);
		lblEntityName.setText("Entity Name");
		lblEntityName.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		
		Label lblEntityTitle = new Label(container, SWT.NONE);
		lblEntityTitle.setText(entityInfo.getName());
		
		final Button btnJavaClass = new Button(container, SWT.CHECK);
		btnJavaClass.setText("Java Class");
		btnJavaClass.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnJavaClass.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setJavaClassFile(btnJavaClass.getSelection());
			}
		});
		//btnJavaClass.setSelection(true);

		final Button btnJavaInterface = new Button(container, SWT.CHECK);
		btnJavaInterface.setText("Java Interface");
		btnJavaInterface.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnJavaInterface.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setJavaInterfaceFile(btnJavaInterface.getSelection());
			}
		});
		//btnJavaInterface.setSelection(true);

		final Button btnDaoClass = new Button(container, SWT.CHECK);
		btnDaoClass.setText("DAO Class");
		btnDaoClass.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnDaoClass.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setDaoClassFile(btnDaoClass.getSelection());
			}
		});
		//btnDaoClass.setSelection(true);
		
		final Button btnDaoInterface = new Button(container, SWT.CHECK);
		btnDaoInterface.setText("DAO Interface");
		btnDaoInterface.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnDaoInterface.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setDaoInterfaceFile(btnDaoInterface.getSelection());
			}
		});
		//btnDaoInterface.setSelection(true);
		
		final Button btnHibernate = new Button(container, SWT.CHECK);
		btnHibernate.setText("Hibernate Mapping");
		btnHibernate.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnHibernate.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setHibernateFile(btnHibernate.getSelection());
			}
		});
		//btnHibernate.setSelection(true);
		
		final Button btnListSetupFile = new Button(container, SWT.CHECK);
		btnListSetupFile.setText("Default List Setup");
		btnListSetupFile.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnListSetupFile.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setListSetupFile(btnListSetupFile.getSelection());
			}
		});
		//btnListSetupFile.setSelection(true);	
		
		final Button btnEntityDescriptorFile = new Button(container, SWT.CHECK);
		btnEntityDescriptorFile.setText("Entity Descriptor XML");
		btnEntityDescriptorFile.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnEntityDescriptorFile.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setEntityXmlFile(btnEntityDescriptorFile.getSelection());
			}
		});
		//btnEntityDescriptorFile.setSelection(true);		
		
		final Button btnBundleFile = new Button(container, SWT.CHECK);
		btnBundleFile.setText("Properties Bundle");
		btnBundleFile.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnBundleFile.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setPropertiesBundleFile(btnBundleFile.getSelection());
			}
		});
		//btnBundleFile.setSelection(true);	
		
		setControl(container);
	}

}
