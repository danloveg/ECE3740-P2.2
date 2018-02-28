# Multithreaded Java TCP/IP Server and Client
### ECE 3740 Fall 2017 Project 2.2

## Overview
Given a generic Java TCP/IP server, we are to create a multithreaded client in Java to communicate with it. Communications are sent as raw characters over TCP/IP, as such these applications are not secure. The Test Plan and Procedure document (TPP) provides a more detailed testing procedure than outlined below.

## Running the Code
We used the Netbeans IDE throughout the course to run our code. You can use whatever you like to run the java code, but Netbeans is recommended since the Server and Client folders are Netbeans projects. If you do not know how to run projects in Netbeans, please refer to the TPP PDF document.

Both server and client should be run on the same machine. Both programs are very simple, they just serve to exemplify socket communications in Java.

### Server
When the server is running, it will prompt the user for input. You will want to enter `6` to start the server socket, then make it listen to connections by entering `2`.

### Client
After the server is listening to connections, you can connect to it with the Client project. Run it, and enter `connect` to connect to the server. If everything worked, it should say `Connected to server`. Now that you are connected, you can request the time from the server using the `time` or you can diconnect or quit.
