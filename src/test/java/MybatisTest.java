import com.gh.mapper.UserMapper;
import com.gh.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author zhanghai
 * @create 2019/11/27 9:21
 */
public class MybatisTest {

    private SqlSessionFactory factory;

    @Before
    public void createSessionFactory() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void findById(){
        SqlSession session = factory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.findById(1);
        System.out.println(user);
    }

    @Test
    public void add(){
        SqlSession session = factory.openSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("tom4");
        user.setPassword("tom4");
        mapper.add(user);
    }

    @Test
    public void deleteById(){
        SqlSession session = factory.openSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteById(6);
    }

    @Test
    public void update(){
        SqlSession session = factory.openSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setId(5);
        user.setUsername("jack");
        user.setPassword("jack");
        mapper.update(user);
    }

    @Test
    public void findByLikeName(){
        SqlSession session = factory.openSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.findByLikeName("o");
        System.out.println(users);
    }

}
