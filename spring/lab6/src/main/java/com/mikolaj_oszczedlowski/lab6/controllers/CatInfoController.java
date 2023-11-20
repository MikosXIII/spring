package com.mikolaj_oszczedlowski.lab6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.mikolaj_oszczedlowski.lab6.models.CatInfo;

@Controller
@RequestMapping("/")
public class CatInfoController {

    @RequestMapping("/catInfo")
    public ModelAndView CatInfo(){

        String uri = "https://catfact.ninja/fact";
        RestTemplate restTemplate = new RestTemplate();

        CatInfo catInfo = restTemplate.getForObject(uri, CatInfo.class);

        return new ModelAndView("catInfo", "catInfo", catInfo);
    }
    
}
