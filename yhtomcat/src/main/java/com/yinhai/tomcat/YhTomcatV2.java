package com.yinhai.tomcat;

import com.yinhai.tomcat.handler.YhRequestHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class YhTomcatV2 {
    public static void main(String[] args) throws IOException {
        //在8080端口监听
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("=======hsptomcatV2 在8080监听=======");
        //只要 serverSocket没有关闭，就一直等待浏览器/客户端的连接
        while (!serverSocket.isClosed()) {
            //1. 接收到浏览器的连接后，如果成功，就会得到socket
            //2. 这个socket 就是 服务器和 浏览器的数据通道
            Socket socket = serverSocket.accept();
            //3. 创建一个线程对象，并且把socket给该线程
            //  这个是java线程基础
            YhRequestHandler hspRequestHandler =
                    new YhRequestHandler(socket);
            new Thread(hspRequestHandler).start();
        }
    }
}
