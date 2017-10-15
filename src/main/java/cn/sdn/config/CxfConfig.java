package cn.sdn.config;


import cn.sdn.service.ICommonService;
import cn.sdn.service.impl.CommonServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * Created by L on 2017/10/15.
 */

//@Configuration  //指定该类是一个spring配置类
//public class CxfConfig {

//    @Bean
//    public ServletRegistrationBean cxfServlet(){ return new ServletRegistrationBean(new CXFServlet(),"/sdn/*");}
//
//    @Bean
//    public Bus springBus(){
//        return new SpringBus();
//    }
//
//    @Bean
//    public ICommonService iCommonService(){return new CommonServiceImpl();}
//    /**
//     *JAX-WS
//     */
//    @Bean
//    public Endpoint endpoint(){
//        Endpoint endpoint = new EndpointImpl(springBus(),iCommonService());
//        endpoint.publish("/CommonService");
//        return endpoint;
//    }
//}


@Configuration
public class CxfConfig {
    @Autowired
    private Bus bus;

//    @Autowired
//    ICommonService commonService;

    @Bean
    public ICommonService iCommonService() {
        return new CommonServiceImpl();
    }

    @Bean
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/sdn/*");
    }


    /**
     * JAX-WS
     **/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, iCommonService());
        endpoint.publish("/CommonService");
        return endpoint;
    }
}

