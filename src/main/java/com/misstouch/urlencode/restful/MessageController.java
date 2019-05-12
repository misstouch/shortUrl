package com.misstouch.urlencode.restful;

import com.misstouch.urlencode.service.IJumpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hechao
 * @date create in 23:53 2019/5/11/011
 */
@Controller
@Slf4j
public class MessageController {

    private static final AtomicInteger counter = new AtomicInteger();

    @Autowired
    IJumpService jumpServiceImpl;

    @GetMapping("/{shortUrl}")
    public ModelAndView jumpUrl(@PathVariable("shortUrl") String shortUrl) {
        String longUrl = jumpServiceImpl.getUrl(shortUrl);
        Assert.notNull(longUrl,"can not find long url");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:"+longUrl);
        log.info("the page count is " + counter.incrementAndGet());
        return mv;
    }

}
