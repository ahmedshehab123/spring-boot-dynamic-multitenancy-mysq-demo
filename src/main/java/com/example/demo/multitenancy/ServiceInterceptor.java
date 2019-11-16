package com.example.demo.multitenancy;


import com.example.demo.model.repo.UserRepo;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ServiceInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(getClass());
    {
        logger.debug("Creating TenantInterceptor interceptor");
    }

    @Autowired
    UserRepo repository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tenantUuid = request.getHeader("tenant-uuid");
        String tenantSchema = tenantUuid!=null? repository.findById(Long.parseLong(tenantUuid))
                .orElseThrow(()->new RuntimeException("Tenant not found"))
                .getUsername() : null;
        logger.debug("Set TenantContext: {}",tenantSchema);
        TenantContext.setTenantSchema(tenantSchema);
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        logger.debug("Clear TenantContext: {}",TenantContext.getTenantSchema());
        TenantContext.setTenantSchema(null);
    }

}
