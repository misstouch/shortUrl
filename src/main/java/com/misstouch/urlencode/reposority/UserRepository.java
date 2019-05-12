package com.misstouch.urlencode.reposority;

import com.misstouch.urlencode.dto.UrlRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author hechao
 * @date create in 18:05 2019/5/11/011
 */
@Repository
public interface UserRepository extends JpaRepository<UrlRelation, Integer> {

    /**
     * get long url by short url
     * @param shortUrl
     * @return
     */
    Optional<UrlRelation> findByShortUrl(String shortUrl);

}
