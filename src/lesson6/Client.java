package lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {

    private Socket clientSocket = null;
    private Scanner scanner = null;
    private Scanner in = null;
    private PrintWriter out = null;
    boolean stop;

    void initialize() {
        final int PORT = 8189;
        final String IP_ADDRESS = "localhost";
        stop = false;

        try {
            clientSocket = new Socket(IP_ADDRESS, PORT);
            System.out.println("Клиент запущен!");
            scanner = new Scanner(System.in);

            in = new Scanner(clientSocket.getInputStream());
            out = new PrintWriter(clientSocket.getOutputStream(),true);

            Thread t1 = new Thread(() -> {
                while (!stop) {
                    String toServer = scanner.nextLine();
                    out.println(toServer);
                    System.out.println("Клиент: " + toServer);
                    if (toServer.equals("/end")) {
                        stop = true;
                        break;
                    }
                }
            });

            t1.setDaemon(true);
            t1.start();

            while (!stop) {
                try {
                    String fromServer = in.nextLine();
                    System.out.println("Сервер: " + fromServer);
                    if (fromServer.equals("/end")) {
                        stop = true;
                        break;
                    }
                } catch (NoSuchElementException e) {
                    stop = true;
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //scanner.close(); ???
            in.close();
            out.close();
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

