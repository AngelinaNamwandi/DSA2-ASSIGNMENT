import java.util.ArrayList;
import java.util.Scanner;

class Node {
    private ArrayList<Node> connections;
    private ArrayList<Object> data;

    public Node() {
        connections = new ArrayList<>();
        data = new ArrayList<>();
    }

    public ArrayList<Node> getConnections() {
        return connections;
    }

    public ArrayList<Object> getData() {
        return data;
    }
}

public class Star {
    private Node centralNode;
    private ArrayList<Node> peripheralNodes;
    private Scanner scanner;

    public Star() {
        centralNode = new Node();
        peripheralNodes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void insertNode() {
        System.out.print("Enter data for the node 0 and then 1: ");
        String dataInput = scanner.nextLine();
        Node newNode = new Node();
        newNode.getData().add(dataInput);
        peripheralNodes.add(newNode);
    }

    public void deleteNode(int index) {
        if (index >= 0 && index < peripheralNodes.size()) {
            peripheralNodes.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void visualizeNetwork() {
        // Visualize central node
        System.out.println("Central Node:");
        System.out.println(" * Central Node");

        // Visualize peripheral nodes
        System.out.println("Peripheral Nodes:");
        for (int i = 0; i < peripheralNodes.size(); i++) {
            Node node = peripheralNodes.get(i);
            System.out.print(" * Peripheral Node " + i);
            ArrayList<Object> nodeData = node.getData();
            if (!nodeData.isEmpty()) {
                System.out.print(" (Data: ");
                for (Object data : nodeData) {
                    System.out.print(data + ", ");
                }
                System.out.print("\b\b)"); // Remove the last comma and space
            }
            System.out.println();
        }

        // Visualize connections
        System.out.println("Connections:");
        for (int i = 0; i < peripheralNodes.size(); i++) {
            System.out.println(" * Central Node -> Peripheral Node " + i);
        }
    }

    public static void main(String[] args) {
        Star starNetwork = new Star();
        starNetwork.insertNode();
        starNetwork.insertNode();
        starNetwork.visualizeNetwork();
        starNetwork.deleteNode(1);
        starNetwork.visualizeNetwork();
    }
}
