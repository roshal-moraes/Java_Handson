package main.com.self.train;

public class TypesOfFor {
	public static void main(String[] args) {
		int[] arr = { 234, 345, 23, 45, 123, 546 };

		// Initialization statement is optional
		int i = 0;
		for (; i < arr.length; i++) {

			System.out.println(arr[i]);
		}

		// Initialization statement can be multiple.Same for update.
		// Condition can also be multiple, but we need to use logical operator.

		for (int i1 = 0, j = arr.length - 1; j > -1 && i < arr.length; i1++, j--) {

			System.out.println(arr[i1] + " : " + arr[j]);
		}

		// Condition is optional
		for (int i1 = 0, j = arr.length - 1;; i1++, j--) {
			System.out.println(arr[i1] + " : " + arr[j]);
			if (j == 0)
				break;
		}

		// Update is also is optional
		for (int i1 = 0, j = arr.length - 1;;) {
			System.out.println(arr[i1] + " : " + arr[j]);
			i1++;
			j--;
			if (j == 0)
				break;
		}
		//Valid For, but must have a way to exit else the following code becomes unreachable.
		for(;;) {
			i++;
			if(i > 100) {
				break;
			}
		}
		
		//ForEach
		for(int val: arr) {
			System.out.println(val);
		}

	}

}
