package com.json.demo.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明：
 1、判断JSON这个类文件是否存在，存在才会创建配置。
 2、我看官方文档说的1.2.10以后，会有两个方法支持HttpMessageconvert，
 一个是FastJsonHttpMessageConverter，支持4.2以下的版本，
 一个是FastJsonHttpMessageConverter4支持4.2以上的版本，
 具体有什么区别暂时没有深入研究。
 不好使用----============出现乱码
 * @Author Gao
 * @Date 2018/4/27 14:56
 */
@Configuration
@ConditionalOnClass(value = {JSON.class})
public class FastJsonHttpMessageConvertersConfiguration{

    @Bean
    public HttpMessageConverter fastJsonHttpMessageConverters(){
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        /**
         * 1.设置
         * <value>text/html;charset=UTF-8</value>
         * <value>application/json;charset=UTF-8</value>
         */
        List<MediaType> mediaTypes = new ArrayList<MediaType>(2);
        MediaType textHtmlUtf8 = new MediaType(MediaType.TEXT_HTML, Charset.defaultCharset());
        mediaTypes.add(textHtmlUtf8);
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(mediaTypes);

        /**
         * 2.配置config
         * <property name="fastJsonConfig">
         <bean class="com.alibaba.fastjson.support.config.FastJsonConfig">
         <property name="dateFormat" value="yyyy-MM-dd HH:mm:ss"/>
         <property name="serializerFeatures">
         <array>
         *此配置用于将Date类型转化为dateFormat对应的格式
         <value>WriteDateUseDateFormat</value>
         </array>
         </property>
         </bean>
         </property>
         */
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastConverter.setFastJsonConfig(fastJsonConfig);
        return fastConverter;
    }
}
