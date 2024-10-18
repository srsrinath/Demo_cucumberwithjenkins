package utilities;

import java.util.Properties;

public class CredsLoader {
    private final Properties properties;

    public CredsLoader() {
        //properties = PropertyUtils.propertyLoader(System.getProperty("credsFilePath"));
        properties = PropertyUtils.propertyLoader(System.getProperty("someKey"));
if (properties == null) {
    System.err.println("Key 'someKey' not found in properties file");
}

    }

    public String getProperty(String property) {
        String prop = properties.getProperty(property);
        if (prop != null)
            return prop;
        else
            throw new RuntimeException("Property " + property + " is not specified in the creds file");
    }

}
