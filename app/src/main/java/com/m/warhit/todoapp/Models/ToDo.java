package com.m.warhit.todoapp.Models;

import java.util.Date;
import java.util.List;

public class ToDo {

    String title;
    boolean done;
    Date date;
    int priority = 0;
    List<String> comments;

    public ToDo(String title, boolean done, Date date, List<String> comments) {
        this.title = title;
        this.done = done;
        this.date = date;
        this.comments = comments;
    }

    public ToDo(String title, boolean done, Date date, int priority, List<String> comments) {
        this.title = title;
        this.done = done;
        this.date = date;
        this.priority = priority;
        this.comments = comments;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
