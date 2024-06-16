package com.self.threads;

import java.util.concurrent.Future;

class WebPageIndexer implements Runnable {
    private String content;




	public WebPageIndexer(String downloadedContent) {
		this.content = downloadedContent;
		// TODO Auto-generated constructor stub
	}




	@Override
    public void run() {
        // Simulate indexing by sleeping for a short duration
        try {
            Thread.sleep(1000); // Simulating a delay of 1 second
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Indexer thread interrupted");
            return;
        }

        // In a real scenario, you would perform actual indexing here
        System.out.println("Indexed content: " + content);
    }
}
