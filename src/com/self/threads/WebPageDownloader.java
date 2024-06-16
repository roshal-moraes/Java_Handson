package com.self.threads;

import java.util.concurrent.Callable;

//Use Callable instead of Runnable to return calue and store in Future object
class WebPageDownloader implements Callable<String> {
    private String url;

    public WebPageDownloader(String url) {
        this.url = url;
    }

    @Override
    public String call() {
        // Simulate downloading by sleeping for a short duration
        try {
            Thread.sleep(2000); // Simulating a delay of 2 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Downloader thread interrupted");
            return null;
        }

        // In a real scenario, you would perform actual downloading here
        System.out.println("Downloaded content from: " + url);
        return "Content of " + url;
    }
}
