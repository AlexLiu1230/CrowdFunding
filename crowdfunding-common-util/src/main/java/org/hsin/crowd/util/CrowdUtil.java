package org.hsin.crowd.util;

import jakarta.servlet.http.HttpServletRequest;
import org.hsin.crowd.constant.CrowdConstant;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ClassName: CrowdUtil
 * Package: org.hsin.crowd.util
 * Description: 通用工具方法類
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

    /**
     * 對明文字符串進行md5加密
     *
     * @param source 傳入的明文字符串
     * @return 加密結果
     */
    public static String md5(String source) {

        //判斷source是否有效
        if (source == null || source.length() == 0) {
            //如果不是有效的字符串就拋出異常
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }
        //獲取MessageDigest(訊息摘要)物件
        String algorithm = "md5";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            byte[] sourceBytes = source.getBytes();
            byte[] digest = messageDigest.digest(sourceBytes);
            int signum = 1;
            BigInteger bigInteger = new BigInteger(signum, digest);
            int radix = 16;
            return bigInteger.toString(radix).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

}
