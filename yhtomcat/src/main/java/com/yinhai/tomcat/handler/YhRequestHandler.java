package com.yinhai.tomcat.handler;

import com.yinhai.tomcat.YhTomcatV3;
import com.yinhai.tomcat.http.YhRequest;
import com.yinhai.tomcat.http.YhResponse;
import com.yinhai.tomcat.servlet.YhCalServlet;
import com.yinhai.tomcat.servlet.YhHttpServlet;
import com.yinhai.utils.WebUtils;

import java.io.*;
import java.net.Socket;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class YhRequestHandler extends Thread {
/*
 * 1. HspRequestHandler 对象是一个线程对象
 * 2. 处理一个http请求的
 */
    //定义Socket
    private Socket socket = null;

    public YhRequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        //这里我们可以对客户端/浏览器进行IO编程/交互
        try {
            // //1.使用BIO线程模型，支持多线程
            // InputStream inputStream = socket.getInputStream();
            //
            // // //把inputStream -> BufferedReader -> 方便进行按行读取
            // BufferedReader bufferedReader =
            //         new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            // //
            // // //不同的线程在和浏览器和客户端交互
            // System.out.println("当前线程= " + Thread.currentThread().getName());
            //
            // System.out.println("=========hsptomcatv2 接收到的数据如下=========");
            // String mes = null;
            // // io - 网络 - 线程 - 反射 - 注解 - OOP [都会学会，也会学好]
            // //
            // while ((mes = bufferedReader.readLine()) != null) {
            //     //如果长度为0 ""
            //     if (mes.length() == 0) {
            //         break; //退出
            //     }
            //     System.out.println(mes);
            // }
            //
            // //构建一下http响应头
            // //返回的http的响应体和响应头之间有两个换行 \r\n\r\n
            // String respHeader = "HTTP/1.1 200 OK\r\n" +
            //         "Content-Type: text/html;charset=utf-8\r\n\r\n";
            // String resp = respHeader + "<h1>hi this is ThreadServlet</h1>";
            // System.out.println("========Yhtomcatv2返回的数据是=========");
            // System.out.println(resp);
            // //返回数据给我们的浏览器/客户端-> 封装成http响应
            // OutputStream outputStream = socket.getOutputStream();
            // //resp.getBytes() 是把字符串转成字节数组
            // outputStream.write(resp.getBytes());
            // outputStream.flush();
            // outputStream.close();
            // inputStream.close();
            // socket.close();


            //==================使用resquest接管处理消息工作==========================
            //这里我们先死后活
            // YhRequest yhRequest = new YhRequest(socket.getInputStream());
            // String num1 = yhRequest.getParameter("num1");
            // String num2 = yhRequest.getParameter("num2");
            // System.out.println("请求的参数num1= " + num1);
            // System.out.println("请求的参数num2= " + num2);
            // System.out.println("yhRequest= " + yhRequest);

            // // 这里我们可以同yhResponse对象，返回数据给浏览器/客户端
            // String resp = "<h1>hi this is ThreadServlet and yhResponse</h1>";
            // OutputStream outputStream = yhResponse.getOutputStream();
            // outputStream.write((YhResponse.respHeader + resp).getBytes());

            // 创建HspCalServlet对象-> 一会我们再用反射来构建对象
            // YhResponse yhResponse = new YhResponse(socket.getOutputStream());
            // YhCalServlet yhCalServlet = new YhCalServlet();
            // yhCalServlet.doGet(yhRequest, yhResponse);
            // outputStream.flush();
            // outputStream.close();
            // socket.close();






            //=====================通过反射来实现==========
            // 先说明一把实现思路->【停一下】 -> 如果你自己完成？10min
            // 1. 得到 uri => 就是 servletUrlMapping 的 url-pattern
            YhRequest yhRequest = new YhRequest(socket.getInputStream());
            YhResponse yhResponse = new YhResponse(socket.getOutputStream());
            String uri = yhRequest.getUri();
            // ====================新增业务逻辑===========
            //(1) 判断uri是什么资源 => 工具方法
            //(2) 如果是静态资源,就读取该资源，并返回给浏览器 content-type text/html
            //(3) 因为目前老师并没有起到tomcat, 不是一个标准的web项目
            //(4) 把读取的静态资源放到 target/classes/cal.html
            //过滤，拦截 , 权限等待 => Handler.... => 分发
            if(WebUtils.isHtml(uri)) {//就是静态页面
                String content = WebUtils.readHtml(uri.substring(1));
                content = yhResponse.respHeader + content;
                //得到outputstream , 返回信息(静态页面)给浏览器
                OutputStream outputStream = yhResponse.getOutputStream();
                outputStream.write(content.getBytes());
                outputStream.flush();
                outputStream.close();
                socket.close();
                return;
            }
            //===========================================
            String servletName = YhTomcatV3.servletUrlMapping.get(uri);
            if(servletName == null){
                servletName = "";
            }
            //2. 通过uri->servletName->servlet的实例 , 真正的运行类型是其子类 HspCalServlet
            YhHttpServlet yhHttpServlet =
                    YhTomcatV3.servletMapping.
                            get(servletName);

            //3. 调用service , 通过OOP的动态绑定机制，调用运行类型的 doGet/doPost

            if (yhHttpServlet != null) {//得到
                yhHttpServlet.service(yhRequest, yhResponse);
            } else {
                //没有这个servlet , 返回404的提示信息
                String resp = YhResponse.respHeader + "<h1>404 Not Found</h1>";
                OutputStream outputStream = yhResponse.getOutputStream();
                outputStream.write(resp.getBytes());
                outputStream.flush();
                outputStream.close();
            }


            // String resp = HspResponse.respHeader + "<h1>hspResponse 返回的信息 hi 你好<h1>";
            //
            // OutputStream outputStream = hspResponse.getOutputStream();
            // outputStream.write(resp.getBytes());
            // outputStream.flush();
            // outputStream.close();

            // outputStream.flush();
            // outputStream.close();
            socket.close();



            //有了filter机制，可以理解再调用servlet之前，先匹配filter
            //1. 根据request对象封装的uri
            //2. 到 filterUrlMapping 去匹配
            //3. 如果匹配上就调用 filterMapping 对应的filer对象doFilter()
            //4. 如果没有匹配上，就直接走我们后的servlet/jsp/html.






        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //最后一定确保socket要关闭
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
