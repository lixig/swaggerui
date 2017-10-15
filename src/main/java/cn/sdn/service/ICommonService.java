package cn.sdn.service;

import cn.sdn.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by L on 2017/10/15.
 */
//
//@WebService(name="ICommonService" //暴露服务名称
//                ,targetNamespace = "http://service.sdn.cn/" //命名空间，一般是包名的倒写
//)
@WebService(name = "CommonService", // 暴露服务名称
        targetNamespace = "http://service.sdn.cn/"// 命名空间,一般是接口的包名倒序
)
public interface ICommonService {

    //    @WebMethod
//    @WebResult(name = "String" , targetNamespace = "")
    @WebMethod
    @WebResult(name = "User", targetNamespace = "")
    public User sayHello(@WebParam(name = "userName") String name);
}
