import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 * 这是我们自己写的web服务 可以返回hello.html给浏览器
 */
public class MyTomcat {
    public static void main(String[] args) throws IOException {
        //1.在9999端口监听
        ServerSocket serverSocket = new ServerSocket(9999 );
        int i = 0;
        //如果serverSocket没有关闭就循环监听反复
        while (!serverSocket.isClosed()) {

            //2.等待客户端连接得到socket
            //http://localhost:9999表示浏览器向localhost(127.0.0.1)表示本机的9999端口发出请求
            System.out.println("程序在这句话" + ++i);
            Socket socket = serverSocket.accept();

            //3.得到输出流
            OutputStream outputStream = socket.getOutputStream();
            // outputStream.write("hello,i am mytomcat".getBytes());

            //4.读取hello.html文件返回即可
            BufferedReader bufferedReader = new BufferedReader(new FileReader("tomcat/src/hello.html"));
            String buf = "";
            while((buf = bufferedReader.readLine() )!= null){
                outputStream.write(buf.getBytes());
            }
            outputStream.close();
            socket.close();
        }
        serverSocket.close();
        //如果不使用while循环 查询当把信息返回去之后就马上关闭了 所以不能这么干
    }
}
