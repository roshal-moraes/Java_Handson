package main.com.self.interfaces;

class Book extends Item implements AdvancedShareable {
    // Implementation of abstract method in Item class
    void processItem() {
        System.out.println("Processing book...");
    }

    // Implementation of additional feature in AdvancedShareable
    public void additionalFeature() {
        System.out.println("Book has additional features...");
    }
}
