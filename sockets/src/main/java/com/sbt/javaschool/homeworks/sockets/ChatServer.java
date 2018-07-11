package com.sbt.javaschool.homeworks.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    private static final int PORT = 2019;
    private static ExecutorService pool = Executors.newFixedThreadPool(10);
    private static volatile Set<String> names = new HashSet<>();
    private static volatile Set<BufferedWriter> writers = new HashSet<>();

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println(String.format("Application started, and listening port: %d", PORT));
            System.out.println("Wait connect...");
            while (true) {
                //new Handler(server.accept()).run();
                pool.execute(new Handler(server.accept()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler implements Runnable {
        private String name;
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
            System.out.println("Connected " + this.socket.getInetAddress() + " " + this.socket.getPort());
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
            ) {
                while (true) {
                    writer.write("Login");
                    writer.newLine();
                    writer.flush();
                    name = reader.readLine();
                    System.out.println("Login for check: " + name);
                    if (name == null || name.length() <= 2) {
                        return;
                    }
                    if (!names.contains(name)) {
                        names.add(name);
                        break;
                    }
                }
                writer.write("Accepted");
                writer.newLine();
                writer.flush();

                writers.add(writer);

                while (true) {
                    String input = reader.readLine();
                    if (input == null) {
                        return;
                    }
                    for (BufferedWriter wr : writers) {
                        wr.write("MESSAGE " + name + " >> " + input);
                        wr.newLine();
                        wr.flush();
                    }
                    if ("\\q".equalsIgnoreCase(input)){
                        if (name != null) {
                            names.remove(name);
                        }
                        if (writer != null) {
                            writers.remove(writer);
                        }
                    }
                }
            } catch (SocketException e) {
                names.remove(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
