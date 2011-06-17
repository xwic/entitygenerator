package de.xwic.entitygenerator.eclipse.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "de.xwic.entitygenerator.eclipse.ui";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The image for a checked box
	 */
	public final static String IMG_CHECK = "check";

	/**
	 * The image for a checked box
	 */
	public final static String IMG_UNCHECK = "uncheck";
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);
		
		reg.put(IMG_CHECK, getImageDescriptor("icons/check1.gif"));
		reg.put(IMG_UNCHECK, getImageDescriptor("icons/uncheck1.gif"));
	}
	
	/**
	 * Returns the specified image from the ImageRegistry.
	 * @param key
	 * @return
	 */
	public Image getImage(String key) {
		return getImageRegistry().get(key);
	}
}
