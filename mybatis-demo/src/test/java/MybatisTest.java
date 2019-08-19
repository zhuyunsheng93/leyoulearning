import java.io.InputStream;
import org.apache.ibatis.io.Resources;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/8/19 19:39
 */
public class MybatisTest {
String resource = "/config/mybatis-config.xml";
InputStream inputStream = Resources.getResourceAsStream(resource);
}
