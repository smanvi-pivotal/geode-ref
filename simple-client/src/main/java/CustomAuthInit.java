import com.gemstone.gemfire.LogWriter;
import com.gemstone.gemfire.distributed.DistributedMember;
import com.gemstone.gemfire.security.AuthInitialize;
import com.gemstone.gemfire.security.AuthenticationFailedException;

import java.util.Properties;

/**
 * Created by smanvi on 4/29/16.
 */
public class CustomAuthInit implements AuthInitialize {
    public void init(LogWriter systemLogger, LogWriter securityLogger) throws AuthenticationFailedException {

    }

    public Properties getCredentials(Properties securityProps, DistributedMember server, boolean isPeer) throws AuthenticationFailedException {
        return securityProps;
    }

    public void close() {

    }

    public static AuthInitialize create(){
        return new CustomAuthInit();
    }
}
