public class Client {
    // My own unique nickname!
    private String myId;
    // The server I'm connected to play with others
    private Server myServer;

    public Client(String id, Server server) {
        this.myId = id;
        this.myServer = server;
    }

    public String getId() {
        return myId;
    }

    public void send(String message) {
        // Ask the server to send the message for me
        myServer.sendMessage(message, this);
    }

    public void receive(String message, String senderId) {
        System.out.println("Hey " + myId + "! " + senderId + " says: " + message);
    }
}
