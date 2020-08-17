import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.zz.dao.TeacherMapper;
import com.zz.pojo.Teacher;
import com.zz.utils.MybatisUtils;

import java.util.List;

public class MyTest {
    @Test
    public void test01(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher);

        session.close();
    }
}
