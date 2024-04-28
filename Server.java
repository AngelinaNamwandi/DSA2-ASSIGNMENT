public  class Server {

    // My server has a cool name!

        private String myName;

        // I can have a bunch of friends (client nodes) connected
        private Client[] myFriends;
        // How many friends are currently connected?
        private int friendCount;

    public Server(String name, int maxFriends){
            this.myName = name;
            // Make space for all my potential friends!
            myFriends = new Client[maxFriends];
            // No friends yet!
            friendCount = 0;
        }

        public void addFriend (Client friend){
            // Check if I have space for another friend
            if (friendCount < myFriends.length) {
                // Add the new friend to my list
                myFriends[friendCount++] = friend;
                System.out.println("Yay! " + friend.getId() + " joined the party!");
            } else {
                // I'm too popular! Can't add more friends!
                System.out.println("Sorry, " + friend.getId() + " server is full!");
            }
        }

        public void sendMessage (String message, Client sender){
            // Loop through all my friends
            for (int i = 0; i < friendCount; i++) {
                // Don't tell the sender what they just said!
                if (myFriends[i] != sender) {
                    // Tell my friend the message and who sent it
                    myFriends[i].receive(message, sender.getId());
                }
            }
        }

}

