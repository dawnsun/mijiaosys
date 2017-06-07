package com.mijiaokj.sys.web.security;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.domain.ResControl;
import com.mijiaokj.sys.domain.SysRole;
import com.mijiaokj.sys.service.ResControlService;
import com.mijiaokj.sys.service.SysRoleService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

/**
 * Created by sunchenguang on 2017/6/6.
 */
@Service("mijiaoInvocationSecurityMetadataSource")
public class MijiaoInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Resource(name = "sysRoleService")
    private SysRoleService sysRoleService;

    @Resource(name = "resControlService")
    private ResControlService resControlService;

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<ConfigAttribute>();
    }

    // 根据URL，找到相关的权限配置。
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        // object 是一个URL，被用户请求的url。
        FilterInvocation filterInvocation = (FilterInvocation) object;
        if (resourceMap == null) {
            loadResourceDefine();
        }
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
            if(requestMatcher.matches(filterInvocation.getHttpRequest())) {
                return resourceMap.get(resURL);
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

    //被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行,init()方法之前执行。
    @PostConstruct
    private void loadResourceDefine() {
        //应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        Result<List<SysRole>> roleRes = sysRoleService.getAllRole();
        //查询资源操作
        Result<List<ResControl>> resRes = resControlService.getAllResControl();

        if(roleRes.isSuccess() && !roleRes.getData().isEmpty()){
            for (SysRole role : roleRes.getData()){
                ConfigAttribute ca = new SecurityConfig(role.getRoleName());
                //通过角色id查询该角色下的所有资源

                if(resRes.isSuccess() && !resRes.getData().isEmpty()){
                    for (ResControl resMethed : resRes.getData()){
                        if (resourceMap.containsKey(resMethed.getControlUrl())) {

                            Collection<ConfigAttribute> value = resourceMap.get(resMethed.getControlUrl());
                            value.add(ca);
                            resourceMap.put(resMethed.getControlUrl(), value);
                        } else {
                            Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                            atts.add(ca);
                            resourceMap.put(resMethed.getControlUrl(), atts);
                        }
                    }
                }
            }
        }
    }
}
