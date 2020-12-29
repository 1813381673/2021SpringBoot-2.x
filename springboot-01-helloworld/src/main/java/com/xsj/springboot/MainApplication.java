package com.xsj.springboot;


import ch.qos.logback.core.db.DBHelper;
import com.xsj.springboot.bean.Pet;
import com.xsj.springboot.bean.User;
import com.xsj.springboot.config.Myconfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author TT
 * @Date 2020/12/29 19:50
 */
//@SpringBootApplication
@SpringBootConfiguration // 代表就是一个核心配置类
@ComponentScan(
        excludeFilters = {@ComponentScan.Filter(
                type = FilterType.CUSTOM,
                classes = {TypeExcludeFilter.class}
        ), @ComponentScan.Filter(
                type = FilterType.CUSTOM,
                classes = {AutoConfigurationExcludeFilter.class}
        )}
)
@EnableAutoConfiguration // 这个最重要
/**
 * 点进去之后在上面标注的注解
 * @AutoConfigurationPackage
 *      其上面标注的注解
 *      @Import({Registrar.class})
 *         利用Registrar 给容器中导入一系列组件
 *         将制定的一个包下的所有组件导入进来  MainApplication所在包
 *
 * @Import({AutoConfigurationImportSelector.class})
 *
 */
public class MainApplication {
    public static void main(String[] args) {
        //1 返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2 查看容器内的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        //3 从容器中获取组件 获取的是组件名是方法名  默认是单实例的
//        Pet tomcat1 = run.getBean("tomcatdd", Pet.class);
//        Pet tomcat2 = run.getBean("tomcatdd", Pet.class);
//        System.out.println("组件： "+(tomcat1 == tomcat2));
//
//        //4 这个获取的是代理对象
//        Myconfig bean = run.getBean(Myconfig.class);
//        System.out.println("配置类组件"+bean);
//
//        // 如果@Configuration(proxyBeanMethods = true)代理对象调用方法
//        // springboot总会在容器中检查是否已经创建该实例  保证是单实例
//        User user = bean.user01();
//        User user1 = bean.user01();
//        System.out.println("配置类组件调用两次方法获取对象: "+ (user == user1));
//
//        User user01 = run.getBean("user01",User.class);
//        Pet tomcatdd = run.getBean("tomcatdd", Pet.class);
//        System.out.println("用户的宠物: " + (user01.getPet() == tomcatdd));
//        //5 获取组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//        System.out.println(run.getBean(DBHelper.class));

        boolean tomcatdd = run.containsBean("tomcatdd");
        System.out.println("容器中Tomcat组件："+tomcatdd);
        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件:"+user01);

        boolean haha = run.containsBean("haha");
        System.out.println("容器中haha组件：" + haha);
        boolean hehe = run.containsBean("hehe");
        System.out.println("容器中hehe组件:" + hehe);
    }
}
