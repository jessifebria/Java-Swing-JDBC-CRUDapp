/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author JESSI
 */
public class Country {

    private String id, name, rname;
    private int region;

    public String getId() {
        return id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Country(String id, String name, int region, String rname) {
        this.id = id;
        this.name = name;
        this.rname = rname;
        this.region = region;
    }

    public Country(String id, String name, int region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

}
