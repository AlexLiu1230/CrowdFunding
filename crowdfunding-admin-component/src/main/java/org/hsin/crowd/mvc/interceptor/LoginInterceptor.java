package org.hsin.crowd.mvc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hsin.crowd.constant.CrowdConstant;
import org.hsin.crowd.entity.Admin;
import org.hsin.crowd.exception.AccessForbiddenException;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * ClassName: LoginInterceptor
 * Package: org.hsin.crowd.mvc.interceptor
 * Description:
 *
 * @Author YuHsin Liu
 * @Create 2023/8/15 12:31 PM
 * @Version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 通過request物件得到session
        HttpSession session = request.getSession();

        // 嘗試從session域中得到Admin物件
        Admin admin = (Admin) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN);

        // 判斷Admin是否為空
        if (admin == null) {
            // 拋出異常
            throw new AccessForbiddenException(CrowdConstant.MESSAGE_ACCESS_FORBIDDEN);
        }

        // 不為null返回true
        return true;
    }
}
