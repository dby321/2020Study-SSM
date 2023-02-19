import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: 2020Study-SSM
 * @BelongsPackage: PACKAGE_NAME
 * @Author: Dong Binyu
 * @CreateTime: 2022-05-26 18:25
 * @Description:
 */
public class MyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ();
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory ();
        // beanFactory.registerScope (  );
    }
}
