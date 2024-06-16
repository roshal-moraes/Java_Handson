package com.self.functional_programming;
class Document {
    private int size;
    private String content; // String field to store document content

    public Document(int size, String content) {
        this.size = size;
        this.content = content;
    }

    public int getSize() {
        return size;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        // Return a string representation of the Document
        return "Document{" +
                "size=" + size +
                ", content='" + content + '\'' +
                '}';
    }
}