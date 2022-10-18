package com.company.entity;

import java.util.ArrayList;

public class Journal {
    private String title;
    private ArrayList<Contact> contacts;
    private ArrayList<Article> articles;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "title='" + title + '\'' +
                ", contacts=" + contacts +
                ", articles=" + articles +
                '}';
    }
}
