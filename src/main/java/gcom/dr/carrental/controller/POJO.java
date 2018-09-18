package gcom.dr.carrental.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gcom.dr.carrental.model.JsonRequest;

public class POJO implements JsonRequest {

    public String name;

    @JsonCreator
    public POJO(@JsonProperty("name") String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}