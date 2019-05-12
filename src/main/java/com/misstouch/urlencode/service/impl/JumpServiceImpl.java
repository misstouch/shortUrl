package com.misstouch.urlencode.service.impl;

import com.misstouch.urlencode.dto.UrlRelation;
import com.misstouch.urlencode.reposority.UserRepository;
import com.misstouch.urlencode.service.IJumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author hechao
 * @date create in 23:57 2019/5/11/011
 */
@Service
public class JumpServiceImpl implements IJumpService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String getUrl(String shortUrl) {
        Optional<UrlRelation> relation = userRepository.findByShortUrl(shortUrl);
        if (relation.isPresent()) {
            return relation.get().getBaseUrl();
        }
        return null;
    }
}
