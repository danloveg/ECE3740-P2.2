package client;

import java.net.*;

/**
 * 
 * 
 * @author Daniel Lovegrove
 */
public class Client implements Runnable {
    int portNumber;
    Socket clientSocket = null;
    userinterface.StandardIO console;
    boolean threadStopped = false;
    
    public Client(int portNumber, userinterface.StandardIO ui) {
        this.portNumber = 5555;
        this.console = ui;
    }
    
    
    @Override
    public void run() {
        while (true) {
            if (false == threadStopped) {
                // Do something
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {}
            }
        }
    }
}
