package org.hsin.crowd.mvc.config;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hsin.crowd.constant.CrowdConstant;
import org.hsin.crowd.util.CrowdUtil;
import org.hsin.crowd.util.ResultEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * ClassName: CrowdExceptionResolver
 * Package: org.hsin.crowd.mvc.config
 * Description:
 *
 * @Author YuHsin Liu
 * @Create 2023/7/27 12:42 PM
 * @Version 1.0
 */

//ControllerAdvice表示當前類是一個基於註解的異常處理類
@ControllerAdvice
public class CrowdExceptionResolver {

    //ExceptionHandler將具體的異常類型和方法關聯起來
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolveNullPointerException(NullPointerException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return commonResolve("system-error", exception, request, response);
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView resolveMathException(ArithmeticException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return commonResolve("system-error", exception, request, response);
    }

    private ModelAndView commonResolve(String viewName, Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean isAjaxRequest = CrowdUtil.isAjaxRequest(request);
        if (isAjaxRequest) {
            ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());
            //轉json
            Gson gson = new Gson();
            String json = gson.toJson(resultEntity);
            //將json字符串作為響應體返回
            response.getWriter().write(json);
            //上面已經透過response返回響應了，所以不返回ModelAndView物件
            return null;
        }
        //若不是Ajax請求
        ModelAndView modelAndView = new ModelAndView();
        //將exception物件存入模型
        modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION, exception);
        //設定對應的視圖名稱
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

}
