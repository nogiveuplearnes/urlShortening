package com.nvgl.UrlShortner.Repo;

import com.nvgl.UrlShortner.Entity.UrlStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlShortnerRepo extends JpaRepository<UrlStore, Long> {
   @Query("select longUrl from UrlStore e where e.tinyUrl=:tinyUrl ")
    String  find(@Param("tinyUrl") String tinyUrl);

}
