package com.nvgl.UrlShortner.Service;

import com.nvgl.UrlShortner.Entity.UrlStore;
import com.nvgl.UrlShortner.Repo.UrlShortnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;

@Service
public class UrlShortnerService {

    @Autowired
    UrlShortnerRepo repo;

    public String getTinyUrl(String tinyUrl){
        return  repo.find(tinyUrl);
    }

    public UrlStore createTinyUrl(String longUrl){

        UrlStore uStore=new UrlStore();

        HashCode md5 = Hashing.md5().hashString(longUrl, Charsets.UTF_8);

        uStore.setLongUrl(longUrl);
        uStore.setTinyUrl(md5.toString().substring(0,6));
        repo.save(uStore);

        return uStore;
    }


}
