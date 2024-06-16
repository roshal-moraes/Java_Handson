package com.self.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


//ExecutorService extends Executor Interface.
/*The ExecutorService is a powerful interface in Java that simplifies running tasks in an asynchronous mode. It automatically provides a pool of threads and an API for assigning tasks to it. Here are some key points about ExecutorService:

Instantiating ExecutorService:
You can create an ExecutorService using factory methods from the Executors class.

The Executors class in the java.util.concurrent package provides static factory methods to create common types of executors. Some important methods include:
1.	newFixedThreadPool(int n): Creates a fixed-size thread pool with n threads.
2.	newSingleThreadExecutor(): Creates a thread pool with a single active thread.
3.	newCachedThreadPool(): Creates a thread pool that reuses idle threads or creates new ones as needed.
4.	newScheduledThreadPool(int n): Creates a fixed-size thread pool for delayed and periodic task execution.

*/
public class ExecutorServiceDemo {
	    public static void main(String[] args) {
	        // Create an ExecutorService with a fixed thread pool size of 2
	    	
	        ExecutorService executorService = Executors.newFixedThreadPool(2);

	        // Create a list of web links to download
	        String[] webLinks = {"https://www.example.com", "https://www.example.org", "https://www.example.net"};

	        // Submit tasks for downloading and indexing
	        for (String link : webLinks) {
	            WebPageDownloader downloader = new WebPageDownloader(link);
	            //Future stores state and result
	            Future<String> downloadFuture = executorService.submit(downloader);

	            // Submit indexing task only if downloading is successful
	            if (downloadFuture != null) {
	                try {
	       
	                    String downloadedContent = downloadFuture.get(); // Blocking until download is complete
	                    if (downloadedContent != null) {
	                    	
	                        WebPageIndexer indexer = new WebPageIndexer(downloadedContent);
	                        executorService.submit(indexer);
	                    }
	                } catch (InterruptedException | ExecutionException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        // Shutdown the executor once all tasks are submitted
	        executorService.shutdown();

	        try {
	            // Wait for all tasks to complete or until timeout (e.g., 5 seconds)
	            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
	                // If the executor didn't terminate within the specified time, force shutdown
	                executorService.shutdownNow();
	            }
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            e.printStackTrace();
	        }
	    }
	}
