package com.xsj.springboot.config;


import ch.qos.logback.core.db.DBHelper;
import com.xsj.springboot.bean.Car;
import com.xsj.springboot.bean.Pet;
import com.xsj.springboot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author TT
 * @Date 2020/12/29 20:24
 */
/**
 * 1.配置类使用@Bean标注在方法上给容器注册组件，默认是单实例
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods: 代理bean的方法
 *      true的时候 是单例
 *      解决组件依赖关系
 *      false的时候 就不会检查容器内有无组件  启动的时候就会很快
 * 4. @Import({User.class, DBHelper.class})
 *      给容器中自动创建出这两个类型的组件,默认组件的名字是全类名
 *
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true) // Since spring 5.2  spring boot 2.x 默认是true
@ImportResource("classpath:beans.xml") // 可以继续让原来的spring配置文件生效
@EnableConfigurationProperties(Car.class)
// 1.开启Car配置绑定功能
// 2.把这个Car组件自动注册到容器中
public class Myconfig {
    /**
     * 外部无论对配置类中的组件注册方法调用多少次获取的都是之前注册容器中的单实例
     * @return
     */
    @ConditionalOnBean(name = "tomcatdd") // 加上之后只有IOC容器中有tomcatdd组件时才生效
    @Bean
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        // user组件依赖了pet组件  在true的情况下 这种是成立的
        // 但是在false情况下 是不成立的
        zhangsan.setPet(tomcatdd());
        return zhangsan;
    }
    //@Bean
    public Pet tomcatdd(){
        return new Pet("tomcat");
    }

}
