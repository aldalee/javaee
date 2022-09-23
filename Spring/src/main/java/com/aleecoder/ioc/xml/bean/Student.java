package com.aleecoder.ioc.xml.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author HuanyuLee
 * @date 2022/3/30
 */
public class Student {
    private String[] books;
    private Set<String> bookSet;
    private List<String> bookList;
    private Map<String,String> bookMap;
    private List<Book> bookLists;

    public Student() {
    }

    public Student(String[] books, Set<String> bookSet, List<String> bookList, Map<String, String> bookMap, List<Book> bookLists) {
        this.books = books;
        this.bookSet = bookSet;
        this.bookList = bookList;
        this.bookMap = bookMap;
        this.bookLists = bookLists;
    }

    public String[] getBooks() {
        return books;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public Set<String> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<String> bookSet) {
        this.bookSet = bookSet;
    }

    public List<String> getBookList() {
        return bookList;
    }

    public void setBookList(List<String> bookList) {
        this.bookList = bookList;
    }

    public Map<String, String> getBookMap() {
        return bookMap;
    }

    public void setBookMap(Map<String, String> bookMap) {
        this.bookMap = bookMap;
    }

    public List<Book> getBookLists() {
        return bookLists;
    }

    public void setBookLists(List<Book> bookLists) {
        this.bookLists = bookLists;
    }

    @Override
    public String toString() {
        return "Student{" +
                "books=" + Arrays.toString(books) +
                ", bookSet=" + bookSet +
                ", bookList=" + bookList +
                ", bookMap=" + bookMap +
                ", bookList2=" + bookLists +
                '}';
    }
}
