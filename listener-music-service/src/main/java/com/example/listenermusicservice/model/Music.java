package com.example.listenermusicservice.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.PrimaryKey;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.util.UUID;

@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Music {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @NotEmpty
    private String name;

    private String path;

    @NotNull
    @NotEmpty
    private String status;

    @NotNull
    @NotEmpty
    private String uuidCustomer;

    private long size;
}