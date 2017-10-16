package clientcommandhandler;

/**
 * Handles the executing of the user's commands.
 * 
 * @author Daniel Lovegrove
 */
public class ClientCommandHandler {
    
    private final userinterface.StandardIO console;
    private client.Client myClient;
    
    
    /**
     * Creates an instance with an associated user interface and client.
     * @param console The console user interface
     * @param client The client
     */
    public ClientCommandHandler(userinterface.StandardIO console, client.Client client) {
        this.console = console;
        this.myClient = client;
    }
    
    
    /**
     * Parses the user's command and executes the appropriate task.
     * @param userCommand The string the user entered
     */
    public void execute(String userCommand) {
        // First, trim any whitespace
        String cmd = userCommand.trim();

        switch (cmd) {
            case "connect":
                if (false == myClient.isConnected()) {
                    console.log("Attempting connection...");
                    myClient.connectToServer();
                    Thread clientThread = new Thread(myClient);
                    clientThread.start();
                    console.log("Connected to server.");
                } else {
                    console.log("Already connected!");
                }
                break;
            case "disconnect":
                if (myClient.isConnected()) {
                    console.log("Disconnecting from server...");
                    myClient.sendMessageToServer((byte) 'd');
                    myClient.disconnectFromServer();
                    console.log("Disconnected.");
                } else {
                    console.log("No connected server.");
                }
                break;
            case "quit":
                console.log("Quitting...");
                if (myClient.isConnected()) {
                    myClient.sendMessageToServer((byte) 'q');
                    myClient.disconnectFromServer();
                }
                System.exit(0);
                break;
            case "time":
                if (myClient.isConnected()) {
                    myClient.sendMessageToServer((byte) 't');
                } else {
                    console.log("No connected server.");
                }
                break;
            case "":
                break;
            default:
                console.log("\"" + cmd + "\" is not recognized.");
                break;
        }
    }
}
