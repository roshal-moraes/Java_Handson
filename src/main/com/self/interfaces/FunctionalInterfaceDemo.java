package main.com.self.interfaces;

public class FunctionalInterfaceDemo {
	
	public static void main(String [] args) {
		MyFunctionalInterface myfunc = new MyFunctionalInterface() {
			
			@Override
			public void test() {
				// TODO Auto-generated method stub
				System.out.println("FI 1");
				
			}
			
		};
		MyFunctionalInterface myfunc3 = () -> {System.out.println("FI 3");};
		MyFunctionalInterface myfunc2 = () -> System.out.println("FI 2");
		myfunc.test();
		myfunc2.test();
		
		
		FunctionalInterfaceArgs fun1 = (a,b)->{System.out.println(a + b);};
		
		fun1.test(34, 354);
	}

}
