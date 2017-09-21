package com.ps.aspects;

import com.ps.services.UserService;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by iuliana.cosmina on 6/5/16.
 */
public class PointcutContainer {

    @Pointcut("execution( * com.ps.repos.*.*UserRepo+.update*(Long, String))")
    public void repoUpdate() {
    }

    @Pointcut(value = "execution (* com.ps.services.*Service+.update*(..)) && args(id,pass) && target (service)", argNames = "service,id,pass")
    public void serviceUpdate(UserService service, Long id, String pass) {
    }
}
