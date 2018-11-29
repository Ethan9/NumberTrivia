package com.example.ethan.numbertrivia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NumberFactItem {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("found")
    @Expose
    private Boolean found;
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * No args constructor for use in serialization
     *
     */
    public NumberFactItem() {
    }
    /**
     *
     * @param text
     * @param number
     * @param type
     * @param found
     */
    public NumberFactItem(String text, Integer number, Boolean found, String type) {
        super();
        this.text = text;
        this.number = number;
        this.found = found;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getFound() {
        return found;
    }

    public void setFound(Boolean found) {
        this.found = found;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}