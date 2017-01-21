package org.tests.util;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

	private static final String PROP_FILE = "application.properties";

        
        private PropertyLoader() {}

	    public static String loadProperty(String name) {
		//System.out.println("inside load property");
		Properties props = new Properties();
		try {	//System.out.println("name ="+PROP_FILE);
			props.load(PropertyLoader.class.getResourceAsStream(PROP_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String value = "";

		if (name != null) {
			value = props.getProperty(name);
		}
		return value;
	}
}