package com.example.listenermusicservice.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MusicJson {

    private String uuid;

    private String path;

    private long size;

    public MusicJson(String uuid, String path, long size) {
        this.uuid = uuid;
        this.path = path;
        this.size = size;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
