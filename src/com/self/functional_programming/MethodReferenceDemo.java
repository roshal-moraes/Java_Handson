package com.self.functional_programming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodReferenceDemo {
	
	public static Document removeStopwords(Document doc) {
        // Implementation to remove stopwords from the content
        // For simplicity, let's just return the document as is
        return doc; // Return the processed document
    }

    public static void main(String[] args) {
        // Initializing 'documents' with some Document instances
        List<Document> documents = List.of(
                new Document(60, "Java is a programming language"),
                new Document(40, "This is a test document"),
                new Document(80, "Java and Python are popular languages")
        );
        //Static method reference
        Function<Document, Document> transform = MethodReferenceDemo::removeStopwords;

        Consumer<Document> printDocument = System.out::println;

        // Corrected Function to check for a reference within a Document's content
        Function<Document, Boolean> containsReference = doc -> doc.getContent().contains("Java");

        List<Document> targetDocuments = documents.stream()
                .filter(doc -> doc.getSize() > 50)
                .map(transform)
                .collect(Collectors.toList());

        targetDocuments.forEach(printDocument);

        // Check if any Document contains the keyword "Java"
        boolean containsKeyword = targetDocuments.stream()
                .anyMatch(containsReference::apply); //instance reference.
        System.out.println("Contains 'Java': " + containsKeyword);
    }

}
