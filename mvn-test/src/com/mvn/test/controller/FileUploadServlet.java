package com.mvn.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUpload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/user/* 의 get 요청이 오면 여기를 거친다");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memSize = 1024*1024*5;
		int totalSize = 1024*1024*50;
		int fileSize =1024*1024*10;
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		System.out.println("fileuploadd의 dfif 값 입니다"+dfif);
		dfif.setSizeThreshold(memSize);
		File file = new File(System.getProperty("java.io.tmpdir"));
		System.out.println("fileuploadd의 file 값 입니다"+file);
		dfif.setRepository(file);
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		sfu.setFileSizeMax(fileSize);
		sfu.setSizeMax(totalSize);
		System.out.println("fileuploadd의 ServletFileUpload.isMultipartContent(request) 값 입니다"+ ServletFileUpload.isMultipartContent(request));
		if(ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> fList= sfu.parseRequest(request);
				for(FileItem fi:fList) {
					String key = fi.getFieldName();
					
					if(fi.isFormField()) {
						String value = fi.getString("utf-8");
						System.out.println(key+":"+value);
					}else {
						String path ="C:\\Users\\Administrator\\git\\repository\\mvn-test\\WebContent\\uploadimg";
						String fileName = fi.getName();
						File targetFile = new File(path+"\\"+fileName);
						fi.write(targetFile);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			throw new ServletException("파일 형식이 잘못되었습니까/");
		}
	}

}
