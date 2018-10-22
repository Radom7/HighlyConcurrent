package com.haiyu.threadLocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Title: ThreadLocalController
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/22 16:00
 */
@Controller
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    @RequestMapping("test")
    @ResponseBody
    public long test(){
        return RequestHolder.getId();
    }
}
