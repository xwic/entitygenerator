/*
 * Copyright (c) 2009 Network Appliance, Inc.
 * All rights reserved.
 */

package de.xwic.entitygenerator.eclipse.ui.application;

import java.util.List;
import java.util.Set;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.xwic.appkit.core.model.entities.IPicklistEntry;
import de.xwic.entitygenerator.EntityInfo;
import de.xwic.entitygenerator.Package;
import de.xwic.entitygenerator.eclipse.ui.wizard.GeneratorWizard;
import de.xwic.entitygenerator.eclipse.ui.wizard.GeneratorWizardModel;
import de.xwic.entitygenerator.property.EntityProperty;

/**
 * 
 * @author Aron Cotrau
 */
public class HelloWorldApplicationWindow {

	public static void main(String[] args) {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    shell.setText("Hello, world!");
	    shell.open();    

	    GeneratorWizardModel model = new GeneratorWizardModel(createEntityInfo());
	    WizardDialog dlg = new WizardDialog(shell, new GeneratorWizard(model));
	    dlg.open();
	    
	    display.dispose();
	  }

	private static EntityInfo createEntityInfo() {
		EntityInfo info = new EntityInfo();
		Package packageInfo = new Package();
		packageInfo.setName("de.xwic.test.package");
		info.setPackageInfo(packageInfo);
		info.setName("TestEntity");

		EntityProperty[] props = new EntityProperty[6];

		props[0] = new EntityProperty();
		props[0].setName("testEmployee");
		props[0].setShortJavaName("Employee");
		props[0].setRequired(true);

		props[1] = new EntityProperty();
		props[1].setName("testPicklistEntry");
		props[1].setJavaClass(IPicklistEntry.class.getName());
		props[1].setShortJavaName("PicklistEntry");

		props[2] = new EntityProperty();
		props[2].setName("testSet");
		props[2].setJavaClass(Set.class.getName());
		props[2].setShortJavaName("Set");

		props[3] = new EntityProperty();
		props[3].setName("testList");
		props[3].setJavaClass(List.class.getName());
		props[3].setShortJavaName("List");

		props[4] = new EntityProperty();
		props[4].setName("testNonClob");
		props[4].setShortJavaName("String");
		props[4].setMaxLength(1024);
		
		props[5] = new EntityProperty();
		props[5].setName("testClob");
		props[5].setShortJavaName("String");
		props[5].setClob(true);
		
		info.setProperties(props);
		return info;
	}

}
