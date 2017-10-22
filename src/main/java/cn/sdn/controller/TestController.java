package cn.sdn.controller;

import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther: lixiang
 * @Description:
 * @Date: Created in 17:05 2017/10/22
 * @Modified By:
 */
@Controller
@RequestMapping("/api/test")
public class TestController {
    @ResponseBody
    @RequestMapping
    public String show(
            @ApiParam(required=true, name="name", value="姓名")
            @RequestParam(name = "name", required=true) String stuName){
        return "success";
    }

}
