package com.desigining.urlShortner.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "url_shortner")
public class UrlShortnerDTO {
    @Id
    @Column(name = "tiny_url")
    private String tinyUrl;

    @Column(name = "original_url")
    private String originalUrl;

    @Column(name = "created_date")
    private String createdDate;
}
