package com.yinhai.servlet;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yinhai.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
@WebServlet(name = "FileUploadServlet",urlPatterns = "/fileUpload")
public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("be invoked...");

        //1.判断是不是文件表单(enctype=“multipart/form-data”)
        if(ServletFileUpload.isMultipartContent(request)){
            System.out.println("OK! this is fileUpload!!!");
            //2. 创建 DiskFileItemFactory 对象, 用于构建一个解析上传数据的工具对象
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //3. 创建一个解析上传数据的工具对象
            /**
             *     表单提交的数据就是 input 元素
             *     <input type="file" name="pic" id="" value="2xxx.jpg" onchange="prev(this)"/>
             *     家居名: <input type="text" name="name"><br/>
             *     <input type="submit" value="上传"/>
             */
            ServletFileUpload servletFileUpload =
                    new ServletFileUpload(diskFileItemFactory);
            //解决接收到文件名是中文乱码问题
            servletFileUpload.setHeaderEncoding("utf-8");

            //4. 关键的地方, servletFileUpload 对象可以把表单提交的数据text/文件
            //   将其封装到 FileItem 文件项中
            //   如果我们不知道一个对象是什么结构[1.输出 2.debug 3. 底层自动看到]
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                System.out.println("list" + list);
                /*
                list[name=MIKU.jpg,StoreLocation=C:\Users\64301\Desktop\JAVA\apache-tomcat-8.0.50\temp\ upload_32df8824_18ca62f4c87__7f5a_00000000.tmp,
                size=294099bytes, isFormField=false, FieldName=pic,
                name=null,StoreLocation=C:\Users\64301\Desktop\JAVA\apache-tomcat-8.0.50\temp\ upload_32df8824_18ca62f4c87__7f5a_00000001.tmp,
                size=0bytes, isFormField=true, FieldName=name]

                 */
                //遍历并分别处理
                for (FileItem fileItem : list) {
                    //System.out.println("fileItem=" + fileItem);
                    //判断是不是一个文本=> 你是OOP程序员
                    if (fileItem.isFormField()) {//如果是true就是文本 input text
                        String name = fileItem.getString("utf-8");
                        // String name = fileItem.getName();
                        System.out.println("输入的名字=" + name);
                    } else {//是一个文件
                        //用一个方法
                        //获取上传的文件的名字
                        String name = fileItem.getName();
                        System.out.println("上传的文件名=" + name);

                        //把这个上传到 服务器的 temp下的文件保存到你指定的目录
                        //1.指定一个目录 , 就是我们网站工作目录下
                        String filePath = "/upload/";
                        //2.获取到完整目录
                        //C:\Users\64301\Desktop\JAVA\code\JavaWeb_LearningCode\out\artifacts\fileupdown_war_exploded\ upload\
                        String fileRealPath = request.getServletContext().getRealPath(filePath) + WebUtils.getYearMonthDay();
                        System.out.println(fileRealPath);
                        //3. 创建这个上传的目录=> 创建目录 => Java基础
                        // 一个工具类，可以返回 /2024-11-11/ 字符串
                        File fileRealPathDirectory = new File(fileRealPath);
                        if(!fileRealPathDirectory.exists()){//不存在就创建
                            boolean mkdirs = fileRealPathDirectory.mkdirs();
                            System.out.println("创建文件夹" + mkdirs);
                        }
                        //4. 将文件拷贝到fileRealPathDirectory目录
                        //   构建一个上传文件的完整路径 ：目录+文件名
                        //   对上传的文件名进行处理, 前面增加一个前缀，保证是唯一即可, 不错
                        name = UUID.randomUUID().toString() + "_" +System.currentTimeMillis() + "_" + name;
                        String fileFullPath = fileRealPathDirectory + "/" +name;
                        fileItem.write(new File(fileFullPath));

                        //5. 提示信息
                        response.setContentType("text/html;charset=utf-8");
                        response.getWriter().write("上传成功~");

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            System.out.println("Dont fileUpload...");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
