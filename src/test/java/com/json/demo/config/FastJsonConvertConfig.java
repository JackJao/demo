package com.json.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author Gao
 * @Date 2018/4/27 15:58
 */
@Configuration
public class FastJsonConvertConfig implements WebMvcConfigurer {

    /**
     * 利用fastjson替换掉jackson，且解决中文乱码问题
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //漂亮的格式，会处理null属性，返回结果不包含null属性
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,SerializerFeature.WriteDateUseDateFormat);
        //处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        MediaType html = new MediaType(MediaType.TEXT_HTML, Charset.defaultCharset());
        fastMediaTypes.add(html);
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        //设置日期格式，配置了SerializerFeature.WriteDateUseDateFormat,默认"yyyy-MM-dd HH:mm:ss"
        //未配置的时候默认是时间戳
       fastJsonConfig.setDateFormat("yyyy-MM-dd");
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }

}