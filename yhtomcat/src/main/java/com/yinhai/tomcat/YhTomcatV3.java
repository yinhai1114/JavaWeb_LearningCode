package com.yinhai.tomcat;

import com.yinhai.tomcat.handler.YhRequestHandler;
import com.yinhai.tomcat.servlet.YhHttpServlet;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 * 第3版的Tomcat, 实现通过xml+反射来初始化容器
 */
public class YhTomcatV3 {
    //1. 存放容器 servletMapping
    // -ConcurrentHashMap
    // -HashMap
    // key            - value
    // ServletName    对应的实例
    public static final ConcurrentHashMap<String, YhHttpServlet>
            servletMapping = new ConcurrentHashMap<>();


    //2容器 servletUrlMapping
    // -ConcurrentHashMap
    // -HashMap
    // key                    - value
    // url-pattern       ServletName

    public static final ConcurrentHashMap<String, String>
            servletUrlMapping = new ConcurrentHashMap<>();


    public static void main(String[] args) throws MalformedURLException, DocumentException {
        YhTomcatV3 yhTomcatV3 = new YhTomcatV3();
        yhTomcatV3.init();
        //启动hsptomcat容器
        yhTomcatV3.startTomcatV3();
    }


    //启动HspTomcatV3容器
    public void startTomcatV3() {

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("=====hsptomcatv3在8080监听======");
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                YhRequestHandler yhRequestHandler =
                        new YhRequestHandler(socket);
                new Thread(yhRequestHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //直接对两个容器进行初始化
    @Test
    public void init() throws MalformedURLException, DocumentException {
        //读取web.xml => dom4j =>
        //得到web.xml文件的路径 => 拷贝一份.
        String path = YhTomcatV3.class.getResource("/").getPath();
        System.out.println("path= " + path);
        //使用dom4j技术完成读取
        SAXReader saxReader = new SAXReader();
        //困难->真的掌握
        try {
            Document document = saxReader.read(new File(path + "web.xml"));
            System.out.println("document= " + document);
            //得到根元素
            Element rootElement = document.getRootElement();
            //得到根元素下面的所有元素
            List<Element> elements = rootElement.elements();
            //遍历并过滤到 servlet servlet-mapping
            for (Element element : elements) {
                if ("servlet".equalsIgnoreCase(element.getName())) {
                    //这是一个servlet配置
                    //System.out.println("发现 servlet");
                    //使用反射将该servlet实例放入到servletMapping
                    Element servletName = element.element("servlet-name");
                    Element servletClass = element.element("servlet-class");
                    servletMapping.put(servletName.getText(),
                            (YhHttpServlet) Class.forName(servletClass.getText().trim()).newInstance());
                } else if ("servlet-mapping".equalsIgnoreCase(element.getName())) {
                    //这是一个servlet-mapping
                    //System.out.println("发现 servlet-mapping");
                    Element servletName = element.element("servlet-name");
                    Element urlPatter = element.element("url-pattern");
                    servletUrlMapping.put(urlPatter.getText(), servletName.getText());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //老韩验证，这两个容器是否初始化成功
        System.out.println("servletMapping= " + servletMapping);
        System.out.println("servletUrlMapping= " + servletUrlMapping);
    }
}
