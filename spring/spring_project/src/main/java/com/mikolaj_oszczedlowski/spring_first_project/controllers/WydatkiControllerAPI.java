package com.mikolaj_oszczedlowski.spring_first_project.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.mikolaj_oszczedlowski.spring_first_project.models.Wydatek;
import com.mikolaj_oszczedlowski.spring_first_project.data.WydatkiRepository;

@RestController
@RequestMapping("/wydatki/api")
public class WydatkiControllerAPI {

    //@Autowired
    private WydatkiRepository wydatkiData;

    public WydatkiControllerAPI(WydatkiRepository repo) {
        super();
        wydatkiData = repo;
    }

    @GetMapping(value = "/list")
    public List<Wydatek> wydatki() {
        List<Wydatek> allWydatki = wydatkiData.findAll();
        return allWydatki;
    }

    @PostMapping(value = "/save")
    public Wydatek save(@RequestBody Wydatek wydatek) {
        if (wydatek != null) {
            wydatkiData.save(wydatek);
        }
        return wydatek;
    }

    @GetMapping(value = "/edit/{id}")
    public Wydatek editWydatek(@PathVariable long id) {
        Optional<Wydatek> wydatek = wydatkiData.findById(id);

        if (wydatek.isPresent()) {
            return wydatek.get();
        } else {
            return null;
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean deleteWydatek(@PathVariable long id) {
        Optional<Wydatek> wydatek = wydatkiData.findById(id);

        if (wydatek.isPresent()) {
            wydatkiData.delete(wydatek.get());
            return true;
        }

        return false;
    }
}
