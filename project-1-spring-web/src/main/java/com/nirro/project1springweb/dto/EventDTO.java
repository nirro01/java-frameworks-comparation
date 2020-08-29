package com.nirro.project1springweb.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class EventDTO {
    @Null
    private String id;
    @NotEmpty
    private String hostname;
    @NotNull
    private Double memFree;
    @NotNull
    private Double storage;
    @NotNull
    private Long timestamp;
}
