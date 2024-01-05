package com.trangduc.fatbooks.domain;

public class NewDomain {
    private String text_new;
    private String img_new;

    public NewDomain(String text_new, String img_new) {
        this.text_new = text_new;
        this.img_new = img_new;
    }

    public String getText_new() {
        return text_new;
    }

    public void setText_new(String text_new) {
        this.text_new = text_new;
    }

    public String getImg_new() {
        return img_new;
    }

    public void setImg_new(String img_new) {
        this.img_new = img_new;
    }
}
