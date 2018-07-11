package com.sbt.javaschool.homeworks.sockets;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
    private static final int PORT = 2019;

    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))
        ) {
            while (socket.isConnected()) {
                String line = reader.readLine();
                // System.out.println("readed: " + line);
                if (line.startsWith("Login")) {
                    System.out.print("Login: ");
                    writer.write(keyboard.readLine());
                    writer.newLine();
                    writer.flush();
                } else if (line.startsWith("Accepted")) {
                    System.out.println("Login Accepted");
                    break;
                }
            }
            while (socket.isConnected()) {
                System.out.print("Enter a message: ");
                String message = keyboard.readLine();
                writer.write(message);
                writer.newLine();
                writer.flush();
                String line = reader.readLine();
                if (line != null) {
                    System.out.println(line.substring(8));
                }
                if ("\\q".equalsIgnoreCase(message)) {
                    System.out.println("Exit!");
                    Thread.sleep(1000);
                    break;
                }
            }
        } catch (UnknownHostException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
