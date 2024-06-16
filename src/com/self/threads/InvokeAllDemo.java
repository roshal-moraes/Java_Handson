package com.self.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/*
 * We create three tasks (each calculating the square of a number) and add them to the tasks list.
We use executor.invokeAll(tasks) to submit all tasks and wait for their completion.
The results are obtained from the Future objects returned by invokeAll.
 * */
public class InvokeAllDemo {
	public static void main(String[] args) {
		// Create an executor service with a fixed thread pool
		ExecutorService executor = Executors.newFixedThreadPool(3);

		// Create a list of Callable tasks
		List<Callable<Integer>> tasks = new ArrayList<>();
		tasks.add(() -> computeSquare(5));
		tasks.add(() -> computeSquare(10));
		tasks.add(() -> computeSquare(7));

		try {
			// Invoke all tasks and get a list of Future objects
			List<Future<Integer>> futures = executor.invokeAll(tasks);

			// Process the results
			for (Future<Integer> future : futures) {
				int result = future.get();
				System.out.println("Result: " + result);
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			// Shutdown the executor
			executor.shutdown();
		}
	}

	private static int computeSquare(int num) {
		return num * num;
	}
}
