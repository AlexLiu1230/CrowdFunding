package org.hsin.crowd.util;

import jakarta.servlet.http.HttpServletRequest;

/**
 * ClassName: CrowdUtil
 * Package: org.hsin.crowd.util
 * Description:
 *
 * @Author YuHsin Liu
 * @Create 2023/7/27 11:56 AM
 * @Version 1.0
 */
public class CrowdUtil {

    /**
     * 判斷當前請求是否為Ajax請求
     *
     * @param request 請求對象
     * @return true 當前請求是Ajax請求
     * false 當前請求不是Ajax請求
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {

        //獲取請求訊息頭
        String acceptHeader = request.getHeader("Accept");
        String xRequestHeader = request.getHeader("X-Requested-With");

        //判斷
        return (acceptHeader != null && acceptHeader.contains("application/json")) || (xRequestHeader != null && xRequestHeader.equals("XMLHttpRequest"));
    }

}
