package com.self.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class WebPageIndexerWithTimer implements Runnable {
	private String webLink;
	private Future<String> future;
	private long timeLimit;

	public WebPageIndexerWithTimer(String webLink, Future<String> future, long timeLimit) {
		this.webLink = webLink;
		this.future = future;
		this.timeLimit = timeLimit;
	}

	/*
	 * Calculate the endTime by adding the timeLimit to the current system time
	 * (measured in nanoseconds). Calculate the timeLeft as the difference between
	 * endTime and the current system time. Call future.get(timeLeft,
	 * TimeUnit.NANOSECONDS) to retrieve the downloaded content. If the result is
	 * obtained within the specified time limit, process the content. If the
	 * download task exceeds the time limit (throws a TimeoutException), cancel the
	 * task and print a message indicating the cancellation.
	 */
	@Override
	public void run() {
		try {
			long endTime = System.nanoTime() + timeLimit;
			long timeLeft = endTime - System.nanoTime();

			String content = future.get(timeLeft, TimeUnit.NANOSECONDS);

			// In a real scenario, you would perform actual indexing here
			System.out.println("Indexed content: " + content);

			// Process the content...
		} catch (TimeoutException e) {
			System.out.println("Task for web link " + webLink + " is canceled due to timeout.");
			future.cancel(true);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
