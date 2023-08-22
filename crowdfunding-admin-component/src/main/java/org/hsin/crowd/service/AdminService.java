package org.hsin.crowd.service;

import com.github.pagehelper.PageInfo;
import org.hsin.crowd.entity.Admin;

import java.util.List;

/**
 * ClassName: AdminService
 * Package: org.hsin.crowd.service
 * Description:
 *
 * @Author YuHsin Liu
 * @Create 2023/7/18 11:48 AM
 * @Version 1.0
 */
public interface AdminService {

    void saveAdmin(Admin admin);

    List<Admin> getAll();

    Admin getAdminByLoginAcc(String loginAcc, String loginPwd);

    PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize);
}
