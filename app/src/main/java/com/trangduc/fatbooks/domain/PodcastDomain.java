package com.trangduc.fatbooks.domain;

public class PodcastDomain {
    private String text_pod;
    private String img_pod;

    public PodcastDomain(String text_pod, String img_pod) {
        this.text_pod = text_pod;
        this.img_pod = img_pod;
    }

    public String getText_pod() {
        return text_pod;
    }

    public void setText_pod(String text_pod) {
        this.text_pod = text_pod;
    }

    public String getImg_pod() {
        return img_pod;
    }

    public void setImg_pod(String img_pod) {
        this.img_pod = img_pod;
    }
}
