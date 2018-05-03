package com.sunsat.sathish.j2ee.health.sample;

/**
 * Created by sathishkumar_su on 4/11/2018.
 */
import org.apache.shiro.*;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.*;
import org.apache.shiro.mgt.*;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.*;
import org.apache.shiro.util.*;
import org.apache.shiro.subject.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginShiro {
    public static final transient Logger log = LoggerFactory.getLogger(LoginShiro.class);

    public static void main(String... args) {
        log.info("Hello world my First Shiro Application.");
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro.ini");
        SecurityManager mgr = factory.getInstance();
        SecurityUtils.setSecurityManager(mgr);
        Subject sub = SecurityUtils.getSubject();
        try {
            if(!sub.isAuthenticated()) {
                UsernamePasswordToken token = new UsernamePasswordToken("lonestarr","vespa");
                token.setRememberMe(true);
                sub.login(token);
            }
        } catch (UnknownAccountException uae) {

        }catch (IncorrectCredentialsException ice) {

        } catch (LockedAccountException lae) {

        }

        log.info("The subject is : " + sub.getSession());
        log.info("The subject is : " + sub.getPrincipal());
        if(sub.isAuthenticated()) {
            sub.logout();
        }
        System.exit(0);
    }
}
