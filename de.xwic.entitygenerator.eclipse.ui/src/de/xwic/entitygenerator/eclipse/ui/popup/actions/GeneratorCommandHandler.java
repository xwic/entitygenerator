/**
 * 
 */
package de.xwic.entitygenerator.eclipse.ui.popup.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import de.xwic.entitygenerator.EntityInfo;
import de.xwic.entitygenerator.Package;
import de.xwic.entitygenerator.eclipse.ui.wizard.GeneratorWizard;
import de.xwic.entitygenerator.eclipse.ui.wizard.GeneratorWizardModel;
import de.xwic.entitygenerator.property.EntityProperty;

/**
 * 
 * @author Aron Cotrau
 */
public class GeneratorCommandHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.
	 * ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		Object firstElement = null != selection ? selection.getFirstElement() : null;

		if (firstElement instanceof ICompilationUnit) {
			ICompilationUnit cu = (ICompilationUnit) firstElement;
			handle(cu);
		}

		return null;
	}

	private void handle(ICompilationUnit cu) {
		try {
			IType type = null;
			IType[] allTypes = cu.getAllTypes();
			
			//  Search the public class
			for (int t = 0; t < allTypes.length; t++) {
				if (Flags.isPublic((allTypes[t].getFlags()))) {
					type = allTypes[t];
					break;
				}
			}
			
			EntityInfo entityInfo = new EntityInfo();
			String fullyQualifiedName = type.getFullyQualifiedName();
			entityInfo.setName(resolveName(fullyQualifiedName));
			
			List<EntityProperty> props = new ArrayList<EntityProperty>();
			
			IField[] fields = type.getFields();
			
			for (IField field : fields) {
				EntityProperty prop = new EntityProperty();
				prop.setName(field.getElementName());
				prop.setShortJavaName(Signature.getSignatureSimpleName(field.getTypeSignature()));
				if (prop.getJavaClass() == null) {
					// try getting it from the signature
					prop.setJavaClass(Signature.toString(field.getTypeSignature()));
				}
				
				props.add(prop);
			}
			
			String packageName = type.getPackageFragment().getElementName();
			entityInfo.setPackageInfo(new Package(packageName));
			
			entityInfo.setProperties((EntityProperty[]) props.toArray(new EntityProperty[props.size()]));
			
		    GeneratorWizardModel model = new GeneratorWizardModel(entityInfo);
		    Shell activeShell = Display.getCurrent().getActiveShell();
		    WizardDialog dlg = new WizardDialog(activeShell, new GeneratorWizard(model));
		    dlg.open();
			
		} catch (JavaModelException e) {
			e.printStackTrace();
		}

	}

	private String resolveName(String fullyQualifiedName) {
		String str = "";
		
		int idx = fullyQualifiedName.lastIndexOf(".");
		if (idx > 0) {
			// trim everything till the last . char
			str = fullyQualifiedName.substring(idx + 1);
		}
		
		return str;
	}

}

