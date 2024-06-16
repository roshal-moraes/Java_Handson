package com.self.threads;

public class ThreadDemo {
	public static void main(String [] args) {
		
		DataAggregatorTask dataAggregatorTask = new DataAggregatorTask();
		Thread dataAggregator = new Thread(dataAggregatorTask);
		
		EmailCampaignTask emailCampaignTask = new EmailCampaignTask();
		Thread emailCampaign = new Thread(emailCampaignTask);
		
		emailCampaign.setPriority(Thread.MAX_PRIORITY);
		dataAggregator.setPriority(Thread.NORM_PRIORITY);
		
		System.out.println("emailCampaign state: " + emailCampaign.getState());
		System.out.println("dataAggregator state: " + dataAggregator.getState());
		

		dataAggregator.start();
		try {
		    Thread.sleep(5000); // Sleep for 1 second
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		emailCampaign.start();
		emailCampaign.interrupt();

		try {
		    dataAggregator.join(1000); // Main thread waits for Data Aggregator thread for at most 1 second
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}

		
		System.out.println("emailCampaign state: " + emailCampaign.getState());
		System.out.println("dataAggregator state: " + dataAggregator.getState());
		
		emailCampaign.resume();

		System.out.println("emailCampaign state: " + emailCampaign.getState());
		System.out.println("dataAggregator state: " + dataAggregator.getState());
		
		


	}
	

}
