package com.br.kafkaspotfy.customersaveservice.model;

import lombok.Builder;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Table
@Builder
public class Customer {

    @Id()
    private UUID id;

    @NotNull
    @NotEmpty
    private String name;

    @NotEmpty
    @NotNull
    private String country;

    @NotNull
    @NotEmpty
    private String musicStyle;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
