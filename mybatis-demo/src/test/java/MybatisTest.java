import com.mybatis.pojo.User;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/8/19 19:39
 */
public class MybatisTest {

  public static void main(String[] args) throws IOException {
    String resource = "config/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      User user = sqlSession.selectOne("MyMapper.selectUser",1);
      System.out.println(user);
    } catch (Exception e) {
      System.out.println(e.fillInStackTrace()); ;
    }
  }

}
