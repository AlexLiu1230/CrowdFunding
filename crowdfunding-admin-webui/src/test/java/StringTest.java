import org.hsin.crowd.util.CrowdUtil;
import org.junit.jupiter.api.Test;

/**
 * ClassName: StringTest
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author YuHsin Liu
 * @Create 2023/8/1 12:17 PM
 * @Version 1.0
 */
public class StringTest {

    @Test
    public void md5Test() {
        String source = "testPwd";
        String encoded = CrowdUtil.md5(source);
        System.out.println(encoded);
    }

}
