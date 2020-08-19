import com.zz.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //对象现在都在spring中管理了，要使用直接取就可以了

        Hello hello = (Hello)context.getBean("hello");
        System.out.println(hello.toString());
    }
}
