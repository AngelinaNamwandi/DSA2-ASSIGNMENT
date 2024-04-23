public class ClientNode {
    private String id;

    public ClientNode(String id) {
        this.id = id;
    }

    public void send(String message, ServerNode server) {
        server.brokerMessage(message, this);
    }

    public void receiveMessage(String message, ClientNode sender) {
        System.out.println(id + " received message from " + sender.getId() + ": " + message);
    }

    public String getId() {
        return id;
    }

    
}

