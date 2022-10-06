package com.example.listenermusicapi.gatweay;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
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

    public String getPath() {
        return path;
    }

    public long getSize() {
        return size;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
