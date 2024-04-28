public class Main {

    public static void main(String[] args) {
        // Create a server with a name and maximum number of clients
        Server server = new Server("Central Hub", 3);

        // Create some client nodes with IDs and connect them to the server
        Client client1 = new Client("Car 1", server);
        server.addFriend(client1);
        Client client2 = new Client("Car 2", server);
        server.addFriend(client2);
        Client client3 = new Client ("Car 3", server);
        server.addFriend(client3);

        // Simulate messages from clients
        client1.send("Hello everyone! It's Car 1!");
        client2.send("Hey Car 1, nice to hear from you!");
        client3.send("Hi everyone, joining the fun!");
    }
}
