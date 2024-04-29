import java.util.ArrayList;

public class ServerNode {
    private ArrayList<ClientNode> clients;
    private String[] dataValues;

    public ServerNode() {
        clients = new ArrayList<>();
        dataValues = new String[2]; // Space for at least two data values
    }

    public void addClient(ClientNode client) {
        clients.add(client);
    }

    public void brokerMessage(String message, ClientNode sender) {
        for (ClientNode client : clients) {
            if (!client.equals(sender)) { // Avoid sending message back to sender
                client.receiveMessage(message, sender);
            }
        }
    }

    public void setDataValues(String[] dataValues) {
        this.dataValues = dataValues;
    }

    public String[] getDataValues() {
        return dataValues;
    }

    
    
}
