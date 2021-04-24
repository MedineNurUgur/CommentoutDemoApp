package com.example.commentoutmobiledemoapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class NewsModel implements Serializable {

    private String uuid;
    private String title;
    private String summary;
    private String content;
    private ImageModel main_image;
    private  String share_url;

    public NewsModel(String uuid, String title, String summary, String content, ImageModel main_image, String share_url) {
        this.uuid = uuid;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.main_image = main_image;
        this.share_url = share_url;
    }



    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ImageModel getMain_image() {
        return main_image;
    }

    public void setMain_image(ImageModel main_image) {
        this.main_image = main_image;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String shared_url) {
        this.share_url = shared_url;
    }

}
