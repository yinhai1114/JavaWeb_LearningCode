package com.yinhai.tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 * 第一个版本的tomcat，可以完成对浏览器的请求并返回信息
 */
public class YhTomcatV1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("======yhtomcat 在8080端口监听");
        while (!serverSocket.isClosed()){
            //等待连接
            //如果有连接来，就创建一个socket
            //这socket就是服务端和浏觉器端的连接/通道
            Socket socket = serverSocket.accept();

            //先接受浏览器发来的数据
            //字节流
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(inputStream,"utf-8"));
            String mes = null;
            System.out.println("=====接受到浏览器发送的数据======");
            while ((mes = bufferedReader.readLine()) != null){
                if(mes.length() == 0){//读到空字符串
                    break;
                }
                System.out.println(mes);
            }
            //我们的tomcat会送-http响应方式
            OutputStream outputStream = socket.getOutputStream();
            //构建一个http响应的头
            //\r\n 表示回车换行
            //http响应体，需要前面有两个换行 \r\n\r\n
            String respHeader = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html;charset=utf-8\r\n\r\n";
            String resp = respHeader + "<h1>hi, 这是模拟Tomcat</h1>";

            System.out.println("========我们的tomcat 给浏览器会送的数据======");
            System.out.println(resp);
            outputStream.write(resp.getBytes());//将resp字符串以byte[] 方式返回

            outputStream.flush();
            outputStream.close();
            inputStream.close();
            socket.close();

        }
    }
}
