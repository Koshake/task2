package lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Server {
    final int PORT = 8189;
    ServerSocket server = null;
    Socket socket = null;
    Scanner in = null;
    Scanner scanner = new Scanner(System.in);
    PrintWriter out = null;
    boolean stop = false;

    void startServer() {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");

            socket = server.accept();
            System.out.println("Клиент подключился");

            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(),true);

            Thread t1 = new Thread (() -> {
                while (!stop) {
                    String toClient = scanner.nextLine();
                    System.out.println("Сервер: " + toClient);
                    out.println(toClient);
                    if (toClient.equals("/end")) {
                        stop = true;
                        break;
                    }
                }
            });

            t1.setDaemon(true);
            t1.start();

            while (!stop) {
                try {
                    String str = in.nextLine();
                    if(str.equals("/end")) {
                        stop = true;
                        //out.println("/end");
                        break;
                    }
                    System.out.println("Клиент: " + str);
                } catch (NoSuchElementException e) {
                    stop = true;
                    break;
                }
            };

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //scanner.close(); ???
            in.close();
            out.close();
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
