package com.br.kafka.spring.boot.addmusic.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class CustomerJson {

    private String uid;

    @NotEmpty
    @NotNull
    private String name;

    @NotEmpty
    @NotNull
    private String country;

    @NotEmpty
    @NotNull
    private String musicStyle;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMusicStyle() {
        return musicStyle;
    }

    public void setMusicStyle(String musicStyle) {
        this.musicStyle = musicStyle;
    }
}
