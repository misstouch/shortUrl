package com.misstouch.urlencode.service.impl;

import com.misstouch.urlencode.dto.UrlRelation;
import com.misstouch.urlencode.reposority.UserRepository;
import com.misstouch.urlencode.service.IUserService;
import com.misstouch.urlencode.utils.UrlEncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hechao
 * @date create in 17:47 2019/5/11/011
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    private static final String BASE_PATH = "http://localhost:8080/";

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String sendMessage(String url) {
        String shortUrl = UrlEncodeUtil.encodeUrl(url);
        UrlRelation relation = new UrlRelation();
        relation.setBaseUrl(url);
        relation.setShortUrl(shortUrl);
        userRepository.save(relation);

        return BASE_PATH + shortUrl;
    }
}
