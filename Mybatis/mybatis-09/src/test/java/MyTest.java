import com.zz.dao.UserMapper;
import com.zz.pojo.User;
import com.zz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void test(){
        SqlSession session = MybatisUtils.getSession();
        SqlSession session2 = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        session.close();
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);

        session2.close();

    }
}
