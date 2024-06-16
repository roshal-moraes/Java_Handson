package com.ing.nested_class;

/*Static member classes, like nonstatic member classes, 
 * are classes nested within another class. 
 * The key distinction is that static member classes do not require an instance of the enclosing class 
 * for instantiation. 
 * */
public class StaticNestedClassDemo {
	// Static member class representing the status of a network connection
	public int num = 10;
	public static int num2 = 50;
    public static class ConnectionStatus {
        private boolean isConnected;
        private String statusMessage;

        public ConnectionStatus(boolean isConnected, String statusMessage) {
            this.isConnected = isConnected;
            this.statusMessage = statusMessage;
        }

        public boolean isConnected() {
        	//cannot access non staticmembers
        	//System.out.println(num);
        	//Static members are accessible
        	System.out.println(num2);
            return isConnected;
        }

        public String getStatusMessage() {
            return statusMessage;
        }
    }

    // Method to check the network connection and return the status
    public ConnectionStatus checkConnection() {
        // Logic to check network connection
        boolean isConnected = true; // Assume the connection is successful for this example
        String statusMessage = "Connected to the network successfully.";

        // Return a new instance of the ConnectionStatus static member class
        return new ConnectionStatus(isConnected, statusMessage);
    }

    public static void main(String[] args) {
        // Create an instance of StaticNestedClassDemo
        StaticNestedClassDemo networkManager = new StaticNestedClassDemo();

        // Check the network connection
        ConnectionStatus status = networkManager.checkConnection();

        // Display the connection status
        System.out.println("Connection Status: " + status.isConnected());
        System.out.println("Status Message: " + status.getStatusMessage());
    }
}
