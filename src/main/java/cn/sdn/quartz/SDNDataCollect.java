package cn.sdn.quartz;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by L on 2017/10/15.
 */
@Configuration
@Component //交给spring管理
@EnableScheduling //未知注解
public class SDNDataCollect {
    private static final Logger LOGGER = LoggerFactory.getLogger(SDNDataCollect.class);

    public void uploadSDNData() {
        LOGGER.debug("开始获取数据！时间：" + new Date().getTime());
        //生成本地文件
        //调用接口
        System.out.println("调用接口！！  拼接数据！！！");

        LOGGER.debug("数据收集完毕！时间：" + new Date().getTime());

        LOGGER.debug("开始上传数据！ 时间：" + new Date().getTime());

        System.out.println("上传FTP服务器");

        LOGGER.debug("数上传完成！ 时间：" + new Date());


    }

    public void uploadSDNData2() {
        LOGGER.debug("开始获取数据！时间：" + new Date().getTime());
        //生成本地文件
        //调用接口
        System.out.println("调用接口！！  拼接数据！！！");

        LOGGER.debug("数据收集完毕！时间：" + new Date().getTime());

        LOGGER.debug("开始上传数据！ 时间：" + new Date().getTime());

        System.out.println("上传FTP服务器");

        LOGGER.debug("数上传完成！ 时间：" + new Date());


    }


}
