package com.mikolaj_oszczedlowski.spring_first_project.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mikolaj_oszczedlowski.spring_first_project.models.Wydatek;

public interface WydatkiRepository extends JpaRepository<Wydatek, Long>{
    
}
