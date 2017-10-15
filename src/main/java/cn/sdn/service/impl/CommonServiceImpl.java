package cn.sdn.service.impl;


import cn.sdn.entity.User;
import cn.sdn.service.ICommonService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;


/**
 * Created by L on 2017/10/15.
 */
//@WebService(serviceName = "ICommonService", //与接口中指定的name一致
//                targetNamespace = "http://service.sdn.cn/",//与接口命名空间一致，一般是接口包名倒写
//                endpointInterface = "cn.sdn.service.ICommonService" //接口地址
//
//)
//
//@Component
@WebService(serviceName = "CommonService", // 与接口中指定的name一致
        targetNamespace = "http://service.sdn.cn/", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "cn.sdn.service.ICommonService"// 接口地址
)
@Component
public class CommonServiceImpl implements ICommonService {

    @Override
    public User sayHello(String userName) {
        User u = new User();
        u.setUserName(userName);


        return u;
    }
}
