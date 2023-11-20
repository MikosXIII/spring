package com.mikolaj_oszczedlowski.spring_first_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Wydatek {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String naco;

    private Long ilosc;

    private Double kwota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaco() {
        return naco;
    }

    public void setNaco(String naco) {
        this.naco = naco;
    }

    public Long getIlosc() {
        return ilosc;
    }

    public void setIlosc(Long ilosc) {
        this.ilosc = ilosc;
    }

    public Double getKwota() {
        return kwota;
    }

    public void setKwota(Double kwota) {
        this.kwota = kwota;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", na co poszlo=" + naco + ", ilosc=" + ilosc + ", kwota=" + kwota + "]";
    }
}