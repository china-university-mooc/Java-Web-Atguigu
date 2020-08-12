package com.itutry.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("文件收到了");
//        System.out.println(req.getParameter("username"));
//        System.out.println(req.getParameter("photo"));
//
//        ServletInputStream is = req.getInputStream();
//        byte[] buff = new byte[1024 * 100];
//        int len = is.read(buff);
//        System.out.println(new String(buff, 0, len));

        if (ServletFileUpload.isMultipartContent(req)) {
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> items = servletFileUpload.parseRequest(req);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        System.out.println("表单项的name：" + item.getFieldName());
                        System.out.println("表单项的value：" + item.getString("UTF-8"));
                    } else {
                        System.out.println("表单项的name：" + item.getFieldName());
                        System.out.println("上传的文件名：" + item.getName());
                        File file = new File("/Users/zhaozhang/Documents/Course/" + item.getName());
                        item.write(file);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
