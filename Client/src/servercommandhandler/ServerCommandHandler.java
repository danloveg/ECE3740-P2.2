package servercommandhandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;


/**
 * Handle sending and receiving messages to the server.
 * @author Daniel Lovegrove
 */
public class ServerCommandHandler {
    client.Client myClient;
    BufferedReader input;
    OutputStream output;
    userinterface.StandardIO myUI;
    

    /**
     * Create an instance with an associated client, socket, and interface.
     * Throws IOException if it cannot get the client's input and output streams.
     * @param client The client
     * @param clientSocket The socket the client is connected on
     * @param ui The user interface
     * @throws IOException 
     */
    public ServerCommandHandler(client.Client client,
                               Socket clientSocket,
                               userinterface.StandardIO ui) throws IOException {
        this.myClient = client;
        this.myUI = ui;
        this.input = new BufferedReader(
                     new InputStreamReader(clientSocket.getInputStream()));
        this.output = clientSocket.getOutputStream();
    }


    /**
     * Blocking method that reads an 8 character String from the server. Waits
     * to receive 8 bytes until it returns the sequence in the order they were
     * received.
     * @return The byte from the server.
     * @throws IOException 
     */
    public String readFromServer() throws IOException {
        StringBuilder message = new StringBuilder();
        
        while (message.length() < 8) {
            if (input != null && input.ready()) {
                char serverByte = (char) input.read();
                message.append(serverByte);
            }
        }
        
        return message.toString();
    }


    /**
     * Write a message to the connected server.
     * @param message The byte to write to the server.
     * @throws IOException 
     */
    public void sendMessage(byte message) throws IOException {
        if (output != null) {
            output.write(message);
            output.flush();
        }
    }


    /**
     * Close associated input and output streams to avoid memory leaks.
     * @throws IOException
     */
    public void close() throws IOException {
        if (input != null) {
            input.close();
            input = null;
        }
        if (output != null) {
            output.close();
            output = null;
        }
    }
}
