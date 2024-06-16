package com.self.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureTimedDemo {
	public static void main(String[] args) {
		// Create an ExecutorService with a fixed thread pool size of 2

		ExecutorService downloaderExecutor = Executors.newFixedThreadPool(2);
		ExecutorService indexerExecutor = Executors.newFixedThreadPool(2);

		// Create a list of web links to download
		String[] webLinks = { "https://www.example.com", "https://www.example.org", "https://www.example.net" };

		// Submit tasks for downloading and indexing
		// . The TimedGet method, the last method in the Future interface, allows us to
		// wait for at most a specified amount of time for a task to complete. If the
		// task doesn’t complete within the specified time, a timeout exception is
		// thrown.
		
		WebPageIndexerWithTimer wpit;
		for (String webLink : webLinks) {
			Future<String> future = downloaderExecutor.submit(new WebPageDownloader(webLink));
			 wpit = new WebPageIndexerWithTimer(webLink, future, TimeUnit.SECONDS.toNanos(2));
			indexerExecutor.submit(wpit);
		}

		// Shutdown the executor once all tasks are submitted
		downloaderExecutor.shutdown();
		indexerExecutor.shutdown();
	}

}
