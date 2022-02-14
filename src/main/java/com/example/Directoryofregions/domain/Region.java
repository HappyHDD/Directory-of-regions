package com.example.Directoryofregions.domain;

public class Region {

    public Long id;
    public String name;
    public String shortname;

    public Region(Long id, String name, String shortname) {
        this.id = id;
        this.name = name;
        this.shortname = shortname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortname='" + shortname + '\'' +
                '}';
    }
}
