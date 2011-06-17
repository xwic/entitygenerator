/**
 * 
 */
package de.xwic.entitygenerator.eclipse.ui.wizard.hbmpage;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import de.xwic.entitygenerator.EntityInfo;
import de.xwic.entitygenerator.eclipse.ui.wizard.AbstractGeneratorWizardPage;
import de.xwic.entitygenerator.eclipse.ui.wizard.GeneratorWizardModel;

/**
 * 
 * @author Aron Cotrau
 */
public class HibernateMappingPage extends AbstractGeneratorWizardPage {

	private TableViewer tableViewer;
	
	/**
	 * @param pageName
	 */
	public HibernateMappingPage(String pageName, GeneratorWizardModel model) {
		super(pageName, model);
		
		setTitle("Hibernate Specific Settings");
		setDescription("Set the properties types for the Hibernate mapping file.");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		
		String[] properties = new String[] {"Name", "Type", "Maxlength", "Clob", "DBColumn"};
		
		EntityInfo entityInfo = model.getEntityInfo();

		tableViewer = new TableViewer(container, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI
				| SWT.FULL_SELECTION);
		tableViewer.setLabelProvider(new HbmLabelProvider());
		tableViewer.setContentProvider(new HbmContentProvider());
		tableViewer.setInput(entityInfo.getProperties());
		
		// Set up the table
		Table table = tableViewer.getTable();
		table.setFont(createValueFont());
		table.setLayoutData(new GridData(GridData.FILL_BOTH));

		TableColumn tc = new TableColumn(table, SWT.CENTER);
		tc.setText("Name");
		tc.setWidth(150);
		
		tc = new TableColumn(table, SWT.CENTER);
		tc.setText("Type");
		tc.setWidth(150);
		
		tc = new TableColumn(table, SWT.CENTER);
		tc.setText("Maxlength");
		tc.setWidth(150);

		tc = new TableColumn(table, SWT.CENTER);
		tc.setText("Clob");
		tc.setWidth(150);
		
		tc = new TableColumn(table, SWT.CENTER);
		tc.setText("Database Column");
		tc.setWidth(150);
		
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// Create the cell editors
		CellEditor[] editors = new CellEditor[5];
		editors[3] = new CheckboxCellEditor(table);
		editors[4] = new TextCellEditor(table);

		tableViewer.setColumnProperties(properties);
		tableViewer.setCellModifier(new HbmCellModifier(tableViewer));
		tableViewer.setCellEditors(editors);
		
		setControl(container);
	}
	
	public void refreshTable() {
		tableViewer.refresh();
	}

}
