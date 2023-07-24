import org.hsin.crowd.entity.Admin;
import org.hsin.crowd.mapper.AdminMapper;
import org.hsin.crowd.service.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * ClassName: CrowdTest
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author YuHsin Liu
 * @Create 2023/7/10 10:15 PM
 * @Version 1.0
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml"})
public class CrowdTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    //測試log
    @Test
    public void testLog() {
        //得到logger物件，參數是當前打印log的類
        Logger logger = LoggerFactory.getLogger(CrowdTest.class);
        logger.debug("It's a debug log!");
        logger.info("It's an info log!");
        logger.warn("It's a warn log!");
        logger.error("It's an error log!");
    }

    //測試聲明式事務
    @Test
    public void testTx() {
        Admin admin = new Admin(null, "testTx", "testPwd", "testTxName", "textTxEmail@gmail.com", null);
        adminService.saveAdmin(admin);
    }

    //測試資料庫連接
    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    //測試插入資料進t_admin
    @Test
    public void testInsertAdmin() {
        Admin admin = new Admin(null, "testAcc", "testPwd", "testName", "testEmail@gmail.com", null);
        int count = adminMapper.insert(admin);
        System.out.println("受影響的行數 : " + count);
    }
}
