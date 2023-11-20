package com.mikolaj_oszczedlowski.spring_first_project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mikolaj_oszczedlowski.spring_first_project.data.WydatkiRepository;
import com.mikolaj_oszczedlowski.spring_first_project.models.Wydatek;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@Controller
@RequestMapping("/wydatki")
public class WydatkiController {
    
    @Autowired
    private WydatkiRepository wydatkiData;

    @RequestMapping(value = "/addNew", method = RequestMethod.GET)
    public ModelAndView addNewWydatek() {

        Wydatek wydatek = new Wydatek();
        return new ModelAndView("newWydatek", "form", wydatek);

    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView wydatki() {
        List<Wydatek> allWydatki = wydatkiData.findAll();
        return new ModelAndView("allWydatki", "wydatki", allWydatki);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteWydatek(@PathVariable Long id) {
        Optional<Wydatek> wydatek = wydatkiData.findById(id);

        if(wydatek!=null)
        {
            wydatkiData.delete(wydatek.get());
        }

        return ("redirect:/wydatki/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editWydatek(@PathVariable long id) {
        Optional<Wydatek> wydatek = wydatkiData.findById(id);

        if(wydatek!=null)
        {
            return new ModelAndView("editWydatek", "form", wydatek.get());
        }
        else
        {
        return wydatki();
        }
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Wydatek wydatek) {
        if(wydatek!=null)
        {
            wydatkiData.save(wydatek);
        }
        return ("redirect:/wydatki/list");
    }
}
