package com.desigining.urlShortner.repository;

import com.desigining.urlShortner.models.UrlShortnerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlShortnerRepository extends JpaRepository<UrlShortnerDTO,String> {
}
