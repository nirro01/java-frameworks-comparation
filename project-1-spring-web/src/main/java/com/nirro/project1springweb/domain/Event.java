package com.nirro.project1springweb.domain;

import lombok.Data;

@Data
public class Event {
    private String hostname;
    private double memFree;
    private double storage;
    private long timestamp;
}
