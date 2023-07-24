package org.hsin.crowd.mvc.handler;

import org.hsin.crowd.entity.Admin;
import org.hsin.crowd.entity.Student;
import org.hsin.crowd.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * ClassName: TestHandler
 * Package: org.hsin.crowd.mvc.handler
 * Description:
 *
 * @Author YuHsin Liu
 * @Create 2023/7/19 12:18 PM
 * @Version 1.0
 */

@Controller
public class TestHandler {

    @Autowired
    private AdminService adminService;
    private static final Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @RequestMapping("/test/ssm.html")
    public String testSsm(ModelMap modelMap) {

        List<Admin> adminList = adminService.getAll();
        modelMap.addAttribute("AdminList", adminList);

        return "target";
    }

    @ResponseBody
    @RequestMapping("/send/array/one.html")
    public String testReceiveArrayOne(@RequestParam("array[]") List<Integer> array) {
        for (Integer number : array) {
            System.out.println("number=" + number);
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/send/array/two.html")
    public String testReceiveArrayTwo(@RequestBody List<Integer> array) {
        for (Integer number : array) {
            logger.info("number=" + number);
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/send/array/complex/object.html")
    public String testReceiveComposeObject(@RequestBody Student student) {
        logger.info(student.toString());
        return "success";
    }

}
