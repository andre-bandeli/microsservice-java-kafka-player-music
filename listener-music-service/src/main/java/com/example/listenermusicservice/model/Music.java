package com.example.listenermusicservice.model;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Primary;

import javax.persistence.PrimaryKeyJoinColumn;
import java.util.UUID;

@Data
@Builder
public class Music {

    @PrimaryKeyJoinColumn
    private UUID id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String status;

    @NotNull
    @NotEmpty
    private String uuidCustomer;

    private long size;

    private String path;

    public Music(UUID id, String name, String status, String uuidCustomer, long size, String path) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.uuidCustomer = uuidCustomer;
        this.size = size;
        this.path = path;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUuidCustomer() {
        return uuidCustomer;
    }

    public void setUuidCustomer(String uuidCustomer) {
        this.uuidCustomer = uuidCustomer;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
