package com.lkty.yeb.server.config.security;

import com.lkty.yeb.common.pojo.server.MenuEntity;
import com.lkty.yeb.common.pojo.server.RoleEntity;
import com.lkty.yeb.server.constant.RoleConstant;
import com.lkty.yeb.server.service.IMenuService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import java.util.Collection;
import java.util.List;


/**
 * 权限控制
 * 根据请求 url 分析请求所需的角色
 */
@Component
public class MenuRolesMetadataSource implements FilterInvocationSecurityMetadataSource {

    private final String URL_FIX = "/api";
    @Autowired
    private IMenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 配置访问 url 需要的角色
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 获取请求的 url
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<MenuEntity> menus = this.menuService.getMenuWithRoles();
        for (MenuEntity menu : menus) {
            // 判断请求url与菜单角色是否匹配
            if (antPathMatcher.match(URL_FIX + menu.getUrl(),  requestUrl)) {
                String[] rolesName = menu.getRoles().stream().map(RoleEntity::getName).toArray(String[]::new);
                return SecurityConfig.createList(rolesName);
            }
        }
        // 没有匹配的 url 默认登录即可访问
        return SecurityConfig.createList(RoleConstant.ROLE_LOGIN);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
