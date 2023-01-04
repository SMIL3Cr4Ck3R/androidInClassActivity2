package edu.bzu.inclassactivity.secondinclassactivity.models;

public class Book {

    private String booksTitle;
    private String authName;
    private int pages;
    private boolean available;

    public Book(String booksTitle, String authName, int pages, boolean available) {
        this.booksTitle = booksTitle;
        this.authName = authName;
        this.pages = pages;
        this.available = available;
    }

    public String getBooksTitle() {
        return booksTitle;
    }

    public void setBooksTitle(String booksTitle) {
        this.booksTitle = booksTitle;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book [" +
                "booksTitle:" + booksTitle +
                "\nauthName:" + authName +
                "\npages:" + pages +
                "\navailable:" + available +
                ']';
    }
}
