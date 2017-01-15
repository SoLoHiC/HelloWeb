package mybatis;

import java.io.InputStream;
import java.util.Properties;
import mybatis.model.StockOutOrder;
import mybatis.persist.StockOutOrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author chuck
 * @since 15/01/2017
 */
public class HelloMybatis {

  public static void main(String[] args) throws Exception {
    String resource = "mybatis/mybatis-config.xml";
    InputStream configResource = Resources.getResourceAsStream(resource);

    resource = "properties/mybatis-persist.properties";
    InputStream propertiesResource = Resources.getResourceAsStream(resource);
    Properties properties = new Properties();
    properties.load(propertiesResource);
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(configResource, properties);

    try (SqlSession sqlSession = factory.openSession()) {
      StockOutOrderMapper mapper = sqlSession.getMapper(StockOutOrderMapper.class);
      StockOutOrder order = mapper.findById(95);
      System.out.println(order);
    }
  }
}
