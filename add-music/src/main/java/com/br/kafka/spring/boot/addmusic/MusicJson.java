package com.br.kafka.spring.boot.addmusic;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MusicJson {

    private String uid;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String uidCustomer;

    private String path;
    private Long size;

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

    public String getUidCustomer() {
        return uidCustomer;
    }

    public void setUidCustomer(String uidCustomer) {
        this.uidCustomer = uidCustomer;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
