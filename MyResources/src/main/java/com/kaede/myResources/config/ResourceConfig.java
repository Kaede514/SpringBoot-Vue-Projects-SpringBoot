package com.kaede.myResources.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author kaede
 * @create 2022-09-01 20:33
 */

@Configuration
public class ResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //访问xx下的所有请求都会到xx下进行匹配
        /*
        * 由于服务器对静态资源的保护，本地服务器无法对外暴露真实的资源路径，因此会发现一个
        * 奇特的现象，每次重启服务器后才会访问以前上传的文件，而刚上传的文件却访问不到，原因
        * 是重启服务器后会将上传的资源编译到target目录中，故重启后可以访问到，这时采取的方法：
        * 1、上传的路径直接改成传到target文件夹里面，但target文件夹里面的东西是跟着编译走的，
        *    我们本身项目没有保存图片，如果项目clean重新打包，那么这个target里面的图片就会丢失
        * 2、把文件上传路径设置成专门的文件存储路径，然后配置该路径可访问，可行（Linux服务器中这么做简单直接）
        * 3、把文件上传路径设置成专门的文件存储路径，配置资源访问路径隐射的方式，即以下
         */
        registry.addResourceHandler("/static/UserResources/**").
                addResourceLocations("file:E:/WebSiteResources/");
    }

}
