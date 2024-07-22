package com.boss.qqtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author 郑炆杰
 */
public class Client {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        // 服务器地址
        int serverPort = 12345;
        // 服务器端口号

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // 读取用户输入的客户端名字
            System.out.print("请输入客户端名字: ");
            String clientName = userInput.readLine();

            System.out.println("已连接到服务器");

            String message;
            while (true) {
                System.out.print("请输入消息 (输入 'exit' 退出): ");
                message = userInput.readLine();
                out.println(clientName + ": " + message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            socket.close();
            System.out.println("已断开连接");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


