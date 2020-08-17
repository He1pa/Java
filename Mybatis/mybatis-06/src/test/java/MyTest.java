import com.zz.dao.StudentMapper;
import com.zz.pojo.Student;
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
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        session.close();

    }
    @Test
    public void test02(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
        session.close();
    }

    @Test
    public void test03(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent2();
        for (Student student : studentList) {
            System.out.println(student);
        }
        session.close();
    }
}