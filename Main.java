public class Main {
    public static void main(String[] args) {
        // Create server node
        ServerNode server = new ServerNode();

        // Create client nodes
        ClientNode client1 = new ClientNode("Angie Eazy");
        ClientNode client2 = new ClientNode("Ruvarashe");
        ClientNode client3 = new ClientNode("Thandeka");

        // Add client nodes to the server
        server.addClient(client1);
        server.addClient(client2);
        server.addClient(client3);

        // Send messages from clients
        client1.send("Hello", server);
        client2.send("Ndeip", server);
        client3.send("Unjani", server);

        //        RLE algorithm

        String originalMessage = "Message1";
        StringBuilder compressedText;
        compressedText = CompressionTwo.rleCompression(originalMessage);
        client4.send(compressedText.toString(), server);


//        LZW algorithm

        String originalMessage2 = "Message2";
        List<Integer> compressed = Compression.encode(originalMessage2);
        client4.send(compressed.toString(), server);
    }
}