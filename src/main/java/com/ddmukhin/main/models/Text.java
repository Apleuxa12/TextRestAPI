package com.ddmukhin.main.models;

import javax.persistence.*;

@Entity
public class Text {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String theme;

    private String value;

    public Text(){

    }

    public Text(String theme, String value){
        this.theme = theme;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
