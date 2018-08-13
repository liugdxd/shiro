package com.sitech.auth.shiro.shiro.config;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.util.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
/**
 * session管理
* @ClassName:：MySessionManager 
* @Description： TODO
* @author ：liugd
* @date ：2018年8月13日 下午11:24:19 
*
 */
public class MySessionManager extends DefaultWebSessionManager {
	  private static final String AUTHORIZATION = "Authorization";
	  
	    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";
	 
	    public MySessionManager() {
	        super();
	    }
	 
	    @Override
	    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
	        String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
	        //如果请求头中有 Authorization 则其值为sessionId
	        if (!StringUtils.isEmpty(id)) {
	            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
	            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
	            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
	            return id;
	        } else {
	            //否则按默认规则从cookie取sessionId
	            return super.getSessionId(request, response);
	        }
	    }
}
