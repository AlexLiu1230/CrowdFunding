package org.hsin.crowd.mvc.handler;

import com.github.pagehelper.PageInfo;
import jakarta.servlet.http.HttpSession;
import org.hsin.crowd.constant.CrowdConstant;
import org.hsin.crowd.entity.Admin;
import org.hsin.crowd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: AdminHandler
 * Package: org.hsin.crowd.mvc.handler
 * Description:
 *
 * @Author YuHsin Liu
 * @Create 2023/8/10 12:36 PM
 * @Version 1.0
 */

@Controller
public class AdminHandler {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin/do/login.html")
    public String doLogin(@RequestParam("loginAcc") String loginAcc, @RequestParam("loginPwd") String loginPwd,
                          HttpSession session) {
        //調用adminService執行登入檢查
        //若有返回則為成功，否則拋出異常
        Admin admin = adminService.getAdminByLoginAcc(loginAcc, loginPwd);

        //將登入成功的資料存入session
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);

        //用重定向避免重新整理時重複提交表單
        return "redirect:/admin/to/main/page.html";
    }

    @RequestMapping("/admin/do/logout.html")
    public String doLogout(HttpSession session) {

        //強制session失效
        session.invalidate();

        return "redirect:/admin/to/login/page.html";
    }

    /**
     * @param keyword  查詢關鍵字，預設空白
     * @param pageNum  當前顯示第幾頁，預設第一頁
     * @param pageSize 每頁顯示數量，預設5
     * @param modelMap
     * @return
     */
    @RequestMapping("/admin/get/page.html")
    public String getPageInfo(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                              ModelMap modelMap) {

        // 調用Service方法得到PageInfo物件
        PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);

        // 將PageInfo物件存入模型
        modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);

        return "admin-page";
    }
}
