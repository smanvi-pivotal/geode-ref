package com.sm.geode.ref.security;

import com.gemstone.gemfire.LogWriter;
import com.gemstone.gemfire.distributed.DistributedMember;
import com.gemstone.gemfire.security.AuthenticationFailedException;
import com.gemstone.gemfire.security.Authenticator;

import java.security.Principal;
import java.util.Properties;

/**
 * Created by smanvi on 4/29/16.
 */
public class CustomAuthenticator implements Authenticator {

    private  LogWriter secLogger;
    private  LogWriter sysLogger;
    public void init(Properties securityProps, LogWriter systemLogger, LogWriter securityLogger) throws AuthenticationFailedException {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("INSIDE AUTHENTICATOR INIT");
        this.secLogger = securityLogger;
        this.sysLogger = systemLogger;
        secLogger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        secLogger.info("INSIDE AUTHENTICATOR INIT");


        sysLogger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        sysLogger.info("INSIDE AUTHENTICATOR INIT");

    }

    public Principal authenticate(Properties props, final DistributedMember member) throws AuthenticationFailedException {
        System.out.println("Client Trying to Connect :$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        secLogger.info("Client Trying to Connect :$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        sysLogger.info("Client Trying to Connect :$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        sysLogger.info("Host : "+member.getHost());
        sysLogger.info("Name : "+member.getName());
        sysLogger.info("ID : "+member.getId());
        sysLogger.info("ProcessID : "+member.getProcessId());
        secLogger.info("MEMBERDETAILS : "+member.toString());
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        String name = props.getProperty("security-username");
        if(name.equals("Srikanth-user")) {
            return new Principal() {
                public String getName() {
                    return member.getName();
                }
            };
        }else
            throw new AuthenticationFailedException("Unexpected User : "+name);
    }

    public static Authenticator create(){
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("INSIDE AUTHENTICATOR CREATE");
        return new CustomAuthenticator();
    }

    public void close() {

    }
}
