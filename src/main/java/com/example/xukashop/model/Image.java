package com.example.xukashop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @URL
    private String url;

    @Lob
    private String deleteToken;
}
