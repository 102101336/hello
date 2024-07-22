package com.boss.qqtest;

import com.boss.qqtest.Client;
import com.boss.qqtest.Server;

/**
 * @author 郑炆杰
 */

public class Test {
    public static void main(String[] args) {
        // 启动服务器
        Thread serverThread = new Thread(() -> {
            Server.main(new String[]{});
            // 运行服务器端
        });
        serverThread.start();

        // 等待一段时间确保服务器启动完成
        try {
            Thread.sleep(1000);
            // 等待1秒钟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 运行客户端
        Thread clientThread = new Thread(() -> {
            Client.main(new String[]{});
            // 运行客户端
        });
        clientThread.start();
    }
}
