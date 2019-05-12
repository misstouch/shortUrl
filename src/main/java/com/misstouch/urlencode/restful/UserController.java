package com.misstouch.urlencode.restful;

import com.misstouch.urlencode.common.Result;
import com.misstouch.urlencode.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hechao
 * @date create in 17:43 2019/5/11/011
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    IUserService userServiceImpl;

    @PostMapping("/send")
    public Result<String> sendMessage(@RequestParam("url") String url){
        log.info("the long url is " + url);
        String res = userServiceImpl.sendMessage(url);
        return new Result<>("0","SUCCESS",res);
    }

}
