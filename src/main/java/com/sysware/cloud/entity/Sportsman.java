package com.sysware.cloud.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name="SPORTS_MAN")
public class Sportsman {

    private String id;
    private String name;
}
