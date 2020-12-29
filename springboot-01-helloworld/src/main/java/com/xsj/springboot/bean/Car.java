package com.xsj.springboot.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author TT
 * @Date 2020/12/29 21:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 要么在配置类中开启EnableConfigurationProperties 要么 在bena上标注@Comment
 * @Component // 只有在容器中的组件 才会拥有SpringBoot提供的强大功能
 * @ConfigurationProperties(prefix = "mycar") // 配置绑定 与配置文件中的信息进行绑定
 */
@ConfigurationProperties(prefix = "mycar") // 绑定信息的前缀
public class Car {

    private String brand; // 品牌
    private Integer price;
}
