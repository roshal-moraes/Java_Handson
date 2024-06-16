package main.com.self.interfaces;

//Since both Shareable and ComparableItem have method with same name, this must be resolved
interface AdvancedShareable extends Shareable, ComparableItem {
    void additionalFeature();

	@Override
	default void concreteMethod() {
		// TODO Auto-generated method stub
		ComparableItem.super.concreteMethod();
		//For shareable, can hence, call both one by one or only one
		Shareable.super.concreteMethod();
	}
    
}
