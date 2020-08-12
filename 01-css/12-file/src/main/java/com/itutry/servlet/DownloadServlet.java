package com.itutry.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String downloadFileName = "4.jpeg";
        ServletContext servletContext = getServletContext();

        // 获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println("下载的文件类型是：" + mimeType);
        resp.setContentType(mimeType);
        // Content-Disposition：表示收到的数据怎么处理
        // attachment：表示附件，表示下载使用
        // filename: 表示指定下载的文件名,可以随意指定
        // url编码是把汉字转换成%xx%xx的格式
//        resp.setHeader("Content-Disposition", "attachment;filename=" + downloadFileName);
//        resp.setHeader("Content-Disposition", "attachment;filename=头像.jpeg");

        if(req.getHeader("User-Agent").contains("Chrome")) {
            String encodedFileName = new BASE64Encoder().encode("头像.jpeg".getBytes("UTF-8"));
            resp.setHeader("Content-Disposition", "attachment;filename==?UTF-8?B?" + encodedFileName + "?=");
        } else {
            String encodedFileName =  URLEncoder.encode("头像.jpeg", "UTF-8");
            resp.setHeader("Content-Disposition", "attachment;filename*=UTF-8''" + encodedFileName);
        }

        InputStream is = servletContext.getResourceAsStream("/file/" + downloadFileName);
        ServletOutputStream os = resp.getOutputStream();

        IOUtils.copy(is, os);
    }
}
