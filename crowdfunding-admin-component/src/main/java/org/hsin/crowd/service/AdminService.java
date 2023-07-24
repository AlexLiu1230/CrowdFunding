package org.hsin.crowd.service;

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
}
