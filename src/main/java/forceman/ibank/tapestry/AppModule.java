package forceman.ibank.tapestry;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;

/**
 * Created by Igor on 21.09.2016.
 */
public class AppModule {
    public static void contributeApplicationDefaults(MappedConfiguration<String,String> configuration)
    {
        //configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en,fr,de");
        //configuration.add(SymbolConstants.FILE_CHECK_INTERVAL, "10 m");
        configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
    }
}