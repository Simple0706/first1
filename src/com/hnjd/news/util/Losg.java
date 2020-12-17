package com.hnjd.news.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Losg {
public static void  daYin(String a){
	Date date = new Date();
	String format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(date);
	
	PrintStream out=null;
	try {
		FileOutputStream file = new FileOutputStream("D://logs.text",true);
		out = new PrintStream(file);
		out.println("日志打印----打印时间："+format+"内容"+a);
		file.flush();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		out.close();
	}
	
}
public static void main(String[] args) {
	
}
}
