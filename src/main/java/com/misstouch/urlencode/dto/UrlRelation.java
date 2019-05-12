package com.misstouch.urlencode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author hechao
 * @date create in 22:46 2019/5/11/011
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlRelation {

    @Id
    private String baseUrl;

    private String shortUrl;

}
