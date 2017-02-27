package com.example.gaetanociccone.app.model;

/**
 * Created by gaetanociccone on 20/02/17.
 */

public class Note {
    public int id;
    public String title;
    public String data_start;
    public String data_edit;
    public String data_end;
    public String body;
    enum status {letto, archiviato};
    private status stato;

    public Note(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Note(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Note(int id, String title, String dataStart, String dataEdit, String dataEnd, String body, status stato) {
        this.id = id;
        this.title = title;
        this.data_start = dataStart;
        this.data_edit = dataEdit;
        this.data_end = dataEnd;
        this.body = body;
        this.stato = status.letto;
    }

    @Override

    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", dataStart='" + data_start + '\'' +
                ", dataEdit='" + data_edit + '\'' +
                ", dataEnd='" + data_end + '\'' +
                ", body='" + body + '\'' +
                ", stato=" + stato +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDataStart() {
        return data_start;
    }

    public void setDataStart(String dataStart) {
        this.data_start = dataStart;
    }

    public String getDataEdit() {
        return data_edit;
    }

    public void setDataEdit(String dataEdit) {
        this.data_edit = dataEdit;
    }

    public String getDataEnd() {
        return data_end;
    }

    public void setDataEnd(String dataEnd) {
        this.data_end = dataEnd;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
