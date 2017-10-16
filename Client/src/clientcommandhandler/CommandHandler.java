package clientcommandhandler;

/**
 * Handles the executing of the user's commands.
 * 
 * @author Daniel Lovegrove
 */
public class CommandHandler {
    
    private final userinterface.StandardIO console;
    private client.Client myClient;
    
    
    /**
     * Creates an instance with an associated user interface and client.
     * @param console The console user interface
     * @param client The client
     */
    public CommandHandler(userinterface.StandardIO console, client.Client client) {
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
                console.log("WIP: User wants to connect.");
                break;
            case "disconnect":
                console.log("WIP: User wants to disconnect.");
                break;
            case "quit":
                console.log("Exiting...");
                System.exit(0);
                break;
            case "time":
                console.log("WIP: User wants the time.");
                break;
            case "":
                break;
            default:
                console.log("\"" + cmd + "\" is not recognized.");
                break;
        }
    }
}
