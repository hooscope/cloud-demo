package cn.itcast.user.config;

import com.shands.log.filter.LogFilter;
import com.shands.log.interceptor.FeignTraceInterceptor;
import com.shands.log.util.LogConstants;
import feign.RequestInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wuhao
 * @Date 2023/4/21 14:06
 */
@Component
public class LogConfig {

    @Bean
    public FilterRegistrationBean<LogFilter> logFilterFilterRegistrationBean() {
        FilterRegistrationBean<LogFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new LogFilter());
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        bean.setUrlPatterns(Arrays.asList("/*"));

        Map<String, String> params = new HashMap<>();
        //是否输出客户端IP
        params.put(LogConstants.CONFIG_LOG_IP, "true");
        //是否输出请求参数和报文
        params.put(LogConstants.CONFIG_LOG_REQUEST, "false");
        //是否输出响应报文
        params.put(LogConstants.CONFIG_LOG_RESPONSE, "false");
        //当TRACE-ID为空时，是否创建TRACE-ID
        params.put(LogConstants.CONFIG_CREATE_TRACE_ID, "true");
        bean.setInitParameters(params);
        return bean;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignTraceInterceptor();
    }
}
