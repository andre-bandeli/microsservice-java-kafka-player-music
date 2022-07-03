package com.br.kafkaspotfy.customersaveservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerJson {

    @javax.persistence.Id
    @Column(name = "id", nullable = false)
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

