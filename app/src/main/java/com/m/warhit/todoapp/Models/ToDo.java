package com.m.warhit.todoapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

public class ToDo implements Parcelable{

    String title;
    boolean done;
    String date;
    long priority = 0;
    List<String> comments;

    public ToDo() {}

    public ToDo(String title, boolean done, String date, List<String> comments) {
        this.title = title;
        this.done = done;
        this.date = date;
        this.comments = comments;
    }

    public ToDo(String title, boolean done, String date, long priority, List<String> comments) {
        this.title = title;
        this.done = done;
        this.date = date;
        this.priority = priority;
        this.comments = comments;
    }

    protected ToDo(Parcel in) {
        title = in.readString();
        done = in.readByte() != 0;
        date = in.readString();
        priority = in.readLong();
        comments = in.createStringArrayList();
    }

    public static final Creator<ToDo> CREATOR = new Creator<ToDo>() {
        @Override
        public ToDo createFromParcel(Parcel in) {
            return new ToDo(in);
        }

        @Override
        public ToDo[] newArray(int size) {
            return new ToDo[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeByte((byte) (done ? 1 : 0));
        parcel.writeString(date);
        parcel.writeLong(priority);
        parcel.writeStringList(comments);
    }
}
