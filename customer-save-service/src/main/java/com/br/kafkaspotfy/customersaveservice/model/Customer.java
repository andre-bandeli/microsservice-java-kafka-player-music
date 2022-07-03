package com.br.kafkaspotfy.customersaveservice.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Table
public class Customer {

    @Id()
    private UUID id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String musicStyle;

    public Customer() {
    }

    public Customer(UUID id, String name, String musicStyle) {
        this.id = id;
        this.name = name;
        this.musicStyle = musicStyle;
    }

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

    public String getMusicStyle() {
        return musicStyle;
    }

    public void setMusicStyle(String musicStyle) {
        this.musicStyle = musicStyle;
    }
}
