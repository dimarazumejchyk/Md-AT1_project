package com.company.parsers.staxParser;

import com.company.entity.Article;
import com.company.entity.Contact;
import com.company.entity.Journal;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StaxParser {
    public static void main(String[] args) throws XMLStreamException {

        List<Journal> journalList = new ArrayList<>();
        ArrayList<Contact> contacts = new ArrayList<>();
        ArrayList<Article> articles = null;
        ArrayList<String> hk = null;

        Article article = null;
        Journal journal = new Journal();
        Contact contact = new Contact();
        contacts.add(contact);
        journal.setContacts(contacts);
        journalList.add(journal);

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader =
                factory.createXMLStreamReader(
                        ClassLoader.getSystemResourceAsStream("journal1.xml"));
        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {

                case XMLStreamConstants.START_ELEMENT:
                    if ("articles".equals(reader.getLocalName())) {
                        articles = new ArrayList<>();
                    }
                    if ("article".equals(reader.getLocalName())) {
                        article = new Article();
                        article.setId(reader.getAttributeValue(0));
                        articles.add(article);
                        journal.setArticles(articles);
                    }
                    switch (reader.getLocalName()) {
                        case "title1":
                            journal.setTitle(reader.getElementText());
                            break;
                        case "address":
                            contact.setAddress(reader.getElementText());
                            break;
                        case "tel":
                            contact.setTel(reader.getElementText());
                            break;
                        case "email":
                            contact.setEmail(reader.getElementText());
                            break;
                        case "url1":
                            contact.setUrl(reader.getElementText());
                            break;
                        case "title":
                            article.setTitle(reader.getElementText());
                            break;
                        case "author":
                            article.setAuthor(reader.getElementText());
                            break;
                        case "url":
                            article.setUrl(reader.getElementText());
                            break;
                        case "hotkeys":
                            hk = new ArrayList<>();
                            break;
                        case "hotkey":
                            hk.add(reader.getElementText());
                            article.setHotkeys(hk);
                            break;
                    }
                    break;
            }
        }
        System.out.println(journalList.toString());
    }
}
