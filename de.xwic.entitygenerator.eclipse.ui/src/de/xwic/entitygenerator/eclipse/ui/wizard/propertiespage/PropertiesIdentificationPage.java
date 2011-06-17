/*
 * Copyright (c) 2009 Network Appliance, Inc.
 * All rights reserved.
 */

package de.xwic.entitygenerator.eclipse.ui.wizard.propertiespage;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
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
public class PropertiesIdentificationPage extends AbstractGeneratorWizardPage {

	private TableViewer tableViewer;

	/**
	 * @param pageName
	 */
	public PropertiesIdentificationPage(String pageName, GeneratorWizardModel model) {
		super(pageName, model);
		
		setTitle("Properties Identification");
		setDescription("General overview on the entity properties");
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));

		EntityInfo entityInfo = model.getEntityInfo();

		tableViewer = new TableViewer(container, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI
				| SWT.FULL_SELECTION);
		tableViewer.setLabelProvider(new PropertiesLabelProvider());
		tableViewer.setContentProvider(new PropertiesContentProvider());
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
		tc.setText("Required");
		tc.setWidth(150);
		
		tc = new TableColumn(table, SWT.CENTER);
		tc.setText("Included in List Setup");
		tc.setWidth(150);
		
		tc = new TableColumn(table, SWT.CENTER);
		tc.setText("Maxlength");
		tc.setWidth(150);
		
		tc = new TableColumn(table, SWT.CENTER);
		tc.setText("Bundle String");
		tc.setWidth(150);
		
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// Create the cell editors
		CellEditor[] editors = new CellEditor[6];
		editors[0] = new TextCellEditor(table);
		editors[1] = new ComboBoxCellEditor(table, Constants.entityTypes, SWT.READ_ONLY);
		editors[2] = new CheckboxCellEditor(table);
		editors[3] = new CheckboxCellEditor(table);
		editors[4] = new TextCellEditor(table);
		editors[5] = new TextCellEditor(table);
		
		// Set the editors, cell modifier, and column properties
		tableViewer.setColumnProperties(Constants.columnProperties);
		tableViewer.setCellModifier(new PropertiesCellModifier(tableViewer));
		tableViewer.setCellEditors(editors);

		tableViewer.refresh();
		
		setControl(container);
	}

}
