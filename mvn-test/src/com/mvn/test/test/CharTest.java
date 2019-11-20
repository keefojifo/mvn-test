package com.mvn.test.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CharTest {
	public static void main(String[] args) {
	String sPath ="c:\\test.txt";
	String tPath ="c:\\test1.txt";
	try {
		FileInputStream fis = new FileInputStream(sPath);
		//파일을 입력 받음
		InputStreamReader isr = new InputStreamReader(fis,"utf-8");
		BufferedReader br = new BufferedReader(isr);
		String str =null;
		String string="";
		while((str=br.readLine())!=null) {
		System.out.println(str);
		string += str;
		}
		FileOutputStream fos = new FileOutputStream(tPath);
		System.out.println(fos+"여기에 저장");
		OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
		System.out.println(osw);
		BufferedWriter bw = new BufferedWriter(osw);
		System.out.println(bw);
		bw.write(string);
		bw.flush();
		
		}
	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
