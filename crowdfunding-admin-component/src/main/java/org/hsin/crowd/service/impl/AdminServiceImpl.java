package org.hsin.crowd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hsin.crowd.constant.CrowdConstant;
import org.hsin.crowd.entity.Admin;
import org.hsin.crowd.entity.AdminExample;
import org.hsin.crowd.exception.LoginFailedException;
import org.hsin.crowd.mapper.AdminMapper;
import org.hsin.crowd.service.AdminService;
import org.hsin.crowd.util.CrowdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * ClassName: AdminServiceImpl
 * Package: org.hsin.crowd.service.impl
 * Description:
 *
 * @Author YuHsin Liu
 * @Create 2023/7/18 11:47 AM
 * @Version 1.0
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());
    }

    @Override
    public Admin getAdminByLoginAcc(String loginAcc, String loginPwd) {

        // 根據登入帳號查詢Admin物件
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andLoginAccEqualTo(loginAcc);
        List<Admin> admins = adminMapper.selectByExample(adminExample);

        // 判斷Admins是否為null
        if (admins == null || admins.size() == 0) {
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        // 若Admin物件為null，則拋出異常
        Admin admin = admins.get(0);
        if (admin == null) {
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        // 若不為null，取出DB中對應的Admin物件
        String userPwdDB = admin.getUserPwd();

        // 將表單提交的密碼加密
        String userPwdForm = CrowdUtil.md5(loginPwd);

        // 比較兩個密碼
        if (!Objects.equals(userPwdDB, userPwdForm)) {
            // 若不一致，則拋出異常
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        // 一致則返回Admin物件
        return admin;
    }

    @Override
    public PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {

        //調用PageHelper靜態方法
        PageHelper.startPage(pageNum, pageSize);

        //查詢
        List<Admin> list = adminMapper.selectAdminByKeyword(keyword);

        //封裝到pageInfo物件中
        return new PageInfo<>(list);
    }
}
