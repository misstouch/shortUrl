package com.misstouch.urlencode.service;

/**
 * @author hechao
 * @date create in 17:46 2019/5/11/011
 */
public interface IUserService {

    /**
     * send message by long url
     * @param url long url
     * @return success or falid
     */
    String sendMessage(String url);

}
