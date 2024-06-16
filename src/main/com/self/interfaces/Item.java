package main.com.self.interfaces;

//Must resolve diamond problem here as well
abstract class Item implements Shareable, ComparableItem {
    // Constant variable in interface
    public static final int MAX_LIMIT = 100;

    // Abstract method implementation from Shareable interface
    public void getItemData() {
        System.out.println("Getting item data...");
    }
    //Note: Default methods are only allowed in interfaces
    @Override
	public void concreteMethod() {
		// TODO Auto-generated method stub
		ComparableItem.super.concreteMethod();
		//For shareable, can hence, call both one by one or only one
		Shareable.super.concreteMethod();
	}
    

    // Abstract method implementation from ComparableItem interface
    public int compareTo(Object obj) {
        System.out.println("Comparing items...");
        return 0;
    }

    // Abstract method specific to Item class
    abstract void processItem();
}
