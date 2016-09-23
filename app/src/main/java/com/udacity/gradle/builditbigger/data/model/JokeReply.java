package com.udacity.gradle.builditbigger.data.model;

/**
 * Created by lusifer on 23/09/16.
 */
public class JokeReply {

    private String data;
    private String kind;
    private String etag;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }


}
