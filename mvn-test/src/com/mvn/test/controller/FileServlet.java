package com.mvn.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.mvn.test.service.FileTestService;
import com.mvn.test.service.impl.FileTestServiceImpl;


/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/File")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileTestService fts = new FileTestServiceImpl();
	private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		System.out.println("/File 의 get 요청이 오면 여기를 거친다");
		String json ="";
		json = gson.toJson(fts.getUserList(null));
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 어떤 파일을 올리는 거
		// 기억하고 있던것을 라이트 메모리 기억하고 있으니까.
		//
		int memSize = 1024 * 1024 * 5;// 5MB
		int totalSize = 1024 * 1024 * 50; // 50MB
		int fileSize = 1024 * 1024 * 10; // 10MB
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		dfif.setSizeThreshold(memSize);
		// 메모리에 5MB 저장하고 tmp 디렉터리에 저장
		dfif.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		sfu.setFileSizeMax(fileSize);
		// 각각의 파일 제한
		sfu.setSizeMax(totalSize);
		// 파일의 총량 제한
		if (ServletFileUpload.isMultipartContent(request)) {

			try {
				List<FileItem>fList = sfu.parseRequest(request);
				Map<String,Object> param = new HashMap<>();
				
				System.out.println(fList);
				for (FileItem fi : fList) {
					String key = fi.getFieldName();
					String dd = fi.getName();
					System.out.println(dd);
					//FormField 폼에 속해 있는 것들 예) text file 타입을 제외하고 나머지
					if(fi.isFormField()) {
						String value =fi.getString("utf-8");
						System.out.println(key+":"+value);
						param.put(key,value);
					}else {
						param.put(key, fi);
					}
				}
				System.out.println(param);
				fts.insertFileTest(param);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new ServletException("파일 형식이 잘못되었습니다.");
		}
	}
	public static void main(String[] args) {
		String tmp = System.getProperty("java.io.tmpdir");
		System.out.println(tmp);
	}
}
