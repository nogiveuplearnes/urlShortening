package com.nvgl.UrlShortner.Controller;

import com.nvgl.UrlShortner.Entity.UrlStore;
import com.nvgl.UrlShortner.Repo.UrlShortnerRepo;
import com.nvgl.UrlShortner.Service.UrlShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UrlShortnerController {


    @Autowired
    UrlShortnerService service;

    @GetMapping("/tinyUrl")
    @ResponseBody
    public String getUrl(String tinyUrl) {
        return service.getTinyUrl(tinyUrl);
    }


    @PostMapping("/longUrl")
    public UrlStore saveUrl(String longUrl) {
        return service.createTinyUrl(longUrl);
    }


}
