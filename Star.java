import java.util.ArrayList;

public class Star {
    private ServerNode serverNode;
    private ArrayList<ClientNode> clientNodes;

    public Star() {
        serverNode = new ServerNode();
        clientNodes = new ArrayList<>();
    }

    // Method to insert a client node to the star network
    public void insertNode(String id) {
        ClientNode clientNode = new ClientNode(id);
        serverNode.addClient(clientNode);
        clientNodes.add(clientNode);
    }

    // Method to delete a client node from the star network
    public void deleteNode(String id) {
        ClientNode nodeToRemove = null;
        for (ClientNode clientNode : clientNodes) {
            if (clientNode.getId().equals(id)) {
                nodeToRemove = clientNode;
                break;
            }
        }
        if (nodeToRemove != null) {
            clientNodes.remove(nodeToRemove);
        }
    }
}
