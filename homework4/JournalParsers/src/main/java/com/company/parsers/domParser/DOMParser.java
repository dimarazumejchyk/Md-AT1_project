package com.company.parsers.domParser;

import com.company.entity.Article;
import com.company.entity.Contact;
import com.company.entity.Journal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMParser {
    private static final String XML_PATH = "journal.xml";
    private static List<Journal> journals = new ArrayList<>();
    private static ArrayList<Article> articles = new ArrayList<>();
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Article setArticleWithChildNodes(Article article, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {
            case "title":
                article.setTitle(content);
                break;
            case "author":
                article.setAuthor(content);
                break;
            case "url":
                article.setUrl(content);
                break;
        }
        return article;
    }
    private static void setArticle(NodeList nodeList) {
        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            ArrayList<String> hotkeys = new ArrayList<>();
            if (node instanceof Element) {
                Article article = new Article();
                article.setId(node.getAttributes().getNamedItem("ID").getNodeValue());
                articles.add(article);

                NodeList childNodes = node.getChildNodes();
                DOMParserUtils.getNodeListStream(childNodes).forEach(childNode -> {
                    if (childNode instanceof Element) {
                        setArticleWithChildNodes(article, childNode);
                    }
                });

                Node hotkeysNode = childNodes.item(7);

                NodeList hotkeysNodeList = hotkeysNode.getChildNodes();
                DOMParserUtils.getNodeListStream(hotkeysNodeList).forEach(childNode1 -> {
                    if (childNode1 instanceof Element) {
                        hotkeys.add(childNode1.getTextContent());
                        article.setHotkeys(hotkeys);
                    }
                });
            }
        });
    }
    private static void setContact(NodeList nodeList) {
        Contact contact = new Contact();
        for (int i = 0; i < nodeList.getLength(); i++) {
            String content = nodeList
                    .item(i)
                    .getTextContent()
                    .trim();
            switch (nodeList.item(i).getNodeName()) {
                case "address":
                    contact.setAddress(content);
                    break;
                case "tel":
                    contact.setTel(content);
                    break;
                case "email":
                    contact.setEmail(content);
                    break;
                case "url":
                    contact.setUrl(content);
                    break;
            }
        }
        contacts.add(contact);
    }
    private static void setJournal(NodeList nodeList) {
        Journal journal = new Journal();
        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            if (node instanceof Element) {
                journal.setTitle(nodeList.item(1).getTextContent());
                journal.setContacts(contacts);
                journal.setArticles(articles);
            }
        });
        journals.add(journal);
    }
    public static void main(String[] args) {
        Document document = DOMParserUtils.parseXMLDocument(XML_PATH);
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        NodeList contactsNodeList = nodeList.item(3).getChildNodes();
        setContact(contactsNodeList);
        NodeList articlesNodeList = nodeList.item(5).getChildNodes();
        setArticle(articlesNodeList);
        setJournal(nodeList);
        System.out.println(journals.toString());
    }
}
