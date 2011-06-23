/**
 * 
 */
package de.xwic.entitygenerator.eclipse.ui.wizard.general;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.xwic.entitygenerator.EntityInfo;
import de.xwic.entitygenerator.eclipse.ui.wizard.AbstractGeneratorWizardPage;
import de.xwic.entitygenerator.eclipse.ui.wizard.GeneratorWizardModel;

/**
 * 
 * @author Aron Cotrau
 */
public class GeneralSettingsPage extends AbstractGeneratorWizardPage {

	private Text txtEntity;
	private Text txtDescription;

	public GeneralSettingsPage(String pageName, GeneratorWizardModel model) {
		super(pageName, model);

		setTitle("General");
		setDescription("General informations regarding the selected type");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(3, false));

		Label lblDest = new Label(container, SWT.NONE);
		lblDest.setText("Destination folder");
		lblDest.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblDest.setFont(createHeaderFont());

		final Text txtFolder = new Text(container, SWT.BORDER);
		txtFolder.setEditable(false);
		txtFolder.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		txtFolder.setFont(createValueFont());

		Button btnDialog = new Button(container, SWT.PUSH);
		btnDialog.setText("Select");
		btnDialog.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
		btnDialog.setFont(createValueFont());
		btnDialog.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dlg = new DirectoryDialog(container.getShell());
				dlg.setFilterPath("c:/");
				String newFolder = dlg.open();

				if (null != newFolder) {
					txtFolder.setText(newFolder);
					model.setFolderName(newFolder);
					setPageComplete(canGoNext());
				} else {
					setPageComplete(canGoNext());
				}
			}
		});

		Label lblEntity = new Label(container, SWT.NONE);
		lblEntity.setText("Entity Name");
		lblEntity.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblEntity.setFont(createHeaderFont());

		txtEntity = new Text(container, SWT.BORDER);
		String name = model.getEntityInfo().getName();
		txtEntity.setText(name != null ? name : "");
		txtEntity.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		txtEntity.setFont(createValueFont());

		Label lblDummy = new Label(container, SWT.NONE);
		lblDummy.setText("");
		lblDummy.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		
		Label lblComment = new Label(container, SWT.NONE);
		lblComment.setText("Entity Description");
		lblComment.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblComment.setFont(createHeaderFont());
		
		txtDescription = new Text(container, SWT.BORDER | SWT.WRAP);
		String descr = model.getEntityInfo().getDescription();
		txtDescription.setText(descr != null ? descr : "");
		txtDescription.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		txtDescription.setFont(createValueFont());
		
		final Button btnJavaClass = new Button(container, SWT.CHECK);
		btnJavaClass.setText("Java Class");
		btnJavaClass.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnJavaClass.setFont(createValueFont());
		btnJavaClass.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setJavaClassFile(btnJavaClass.getSelection());
				setPageComplete(canGoNext());
			}
		});
		//btnJavaClass.setSelection(true);

		final Button btnJavaInterface = new Button(container, SWT.CHECK);
		btnJavaInterface.setText("Java Interface");
		btnJavaInterface.setFont(createValueFont());
		btnJavaInterface.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnJavaInterface.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setJavaInterfaceFile(btnJavaInterface.getSelection());
				setPageComplete(canGoNext());
			}
		});
		//btnJavaInterface.setSelection(true);

		final Button btnDaoClass = new Button(container, SWT.CHECK);
		btnDaoClass.setText("DAO Class");
		btnDaoClass.setFont(createValueFont());
		btnDaoClass.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnDaoClass.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setDaoClassFile(btnDaoClass.getSelection());
				setPageComplete(canGoNext());
			}
		});
		//btnDaoClass.setSelection(true);
		
		final Button btnDaoInterface = new Button(container, SWT.CHECK);
		btnDaoInterface.setText("DAO Interface");
		btnDaoInterface.setFont(createValueFont());
		btnDaoInterface.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnDaoInterface.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setDaoInterfaceFile(btnDaoInterface.getSelection());
				setPageComplete(canGoNext());
			}
		});
		//btnDaoInterface.setSelection(true);
		
		final Button btnHibernate = new Button(container, SWT.CHECK);
		btnHibernate.setText("Hibernate Mapping");
		btnHibernate.setFont(createValueFont());
		btnHibernate.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnHibernate.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setHibernateFile(btnHibernate.getSelection());
				setPageComplete(canGoNext());
			}
		});
		//btnHibernate.setSelection(true);
		
		final Button btnListSetupFile = new Button(container, SWT.CHECK);
		btnListSetupFile.setText("Default List Setup");
		btnListSetupFile.setFont(createValueFont());
		btnListSetupFile.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnListSetupFile.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setListSetupFile(btnListSetupFile.getSelection());
				setPageComplete(canGoNext());
			}
		});
		//btnListSetupFile.setSelection(true);	
		
		final Button btnEntityDescriptorFile = new Button(container, SWT.CHECK);
		btnEntityDescriptorFile.setText("Entity Descriptor XML");
		btnEntityDescriptorFile.setFont(createValueFont());
		btnEntityDescriptorFile.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnEntityDescriptorFile.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setEntityXmlFile(btnEntityDescriptorFile.getSelection());
				setPageComplete(canGoNext());
			}
		});
		//btnEntityDescriptorFile.setSelection(true);		
		
		final Button btnBundleFile = new Button(container, SWT.CHECK);
		btnBundleFile.setText("Properties Bundle");
		btnBundleFile.setFont(createValueFont());
		btnBundleFile.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		btnBundleFile.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setPropertiesBundleFile(btnBundleFile.getSelection());
				setPageComplete(canGoNext());
			}
		});
		//btnBundleFile.setSelection(true);	
		
		setPageComplete(false);
		
		setControl(container);
	}
	
	@Override
	public IWizardPage getNextPage() {
		// update the model first
		EntityInfo entityInfo = model.getEntityInfo();
		entityInfo.setName(txtEntity.getText());
		entityInfo.setDescription(txtDescription.getText());
		return super.getNextPage();
	}

	private boolean canGoNext() {
		return fileSelected() && model.getFolderName() != null;
	}
	
	private boolean fileSelected() {
		boolean selection = false;
		
		// have we selected ANY file ?
		if (!selection && model.isDaoClassFile()) {
			selection = true;
		}

		if (!selection && model.isDaoInterfaceFile()) {
			selection = true;
		}
		
		if (!selection && model.isEntityXmlFile()) {
			selection = true;
		}
		
		if (!selection && model.isHibernateFile()) {
			selection = true;
		}
		
		if (!selection && model.isJavaClassFile()) {
			selection = true;
		}
		
		if (!selection && model.isJavaInterfaceFile()) {
			selection = true;
		}
		
		if (!selection && model.isListSetupFile()) {
			selection = true;
		}
		
		if (!selection && model.isPropertiesBundleFile()) {
			selection = true;
		}
		
		return selection;
	}

}
