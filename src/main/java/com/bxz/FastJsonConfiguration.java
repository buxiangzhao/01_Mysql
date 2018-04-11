package com.bxz;


import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SQ_BXZ on 2018-04-11.
 */
@Configuration
public class FastJsonConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// 调用父类配置
		super.configureMessageConverters(converters);
		// 创建fastJson 消息转换器
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		// 创建配置类
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		// 修改配置返回内容的过滤
		fastJsonConfig.setSerializerFeatures(
				SerializerFeature.WriteNullListAsEmpty, // List字段为null 输出[]
				SerializerFeature.WriteNullStringAsEmpty , // 字符类型字段如果为null,输出为"",而非null
				SerializerFeature.WriteNullBooleanAsFalse , // Boolean字段如果为null,输出为false,而非null
				SerializerFeature.DisableCircularReferenceDetect, // 消除对统一对象循环引用的问题，默认false
				SerializerFeature.WriteMapNullValue  // 是否输出值为null的字段。默认false
		);
		// 处理中文乱码 问题
		List<MediaType> fastMediaTypes = new ArrayList<>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		// 将fastJson添加到视图消息转换器列表内
		converters.add(fastJsonHttpMessageConverter);
	}
}
