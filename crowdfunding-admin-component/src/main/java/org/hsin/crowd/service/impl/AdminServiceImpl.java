package org.hsin.crowd.service.impl;

import org.hsin.crowd.entity.Admin;
import org.hsin.crowd.entity.AdminExample;
import org.hsin.crowd.mapper.AdminMapper;
import org.hsin.crowd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
