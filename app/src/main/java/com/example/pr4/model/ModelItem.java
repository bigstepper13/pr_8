package com.example.pr4.model;

public class ModelItem {
    private int imageField;
    private String textField;
    public ModelItem(String textField, int imageField) {
        this.textField = textField;
        this.imageField = imageField;
    }

    public String getTextfield() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }
    public Integer getImagefield() {return imageField;}
    public void setImageField(Integer imageField) {this.imageField = imageField;}
}