package com.hnjd.news.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
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
@WebServlet("/FileUploadServlet")
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File("D:"+File.separator+"MyFile");
		if(!file.exists()){
			file.mkdirs();
		}
		
		File temp = new File(getServletContext().getRealPath("/temp"));
		if(!temp.exists()){
			temp.mkdirs();
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		factory.setSizeThreshold(100);
		
		factory.setRepository(temp);
		
		ServletFileUpload sfu = new ServletFileUpload(factory);
		
		sfu.setSizeMax(1024*1024*20);
		
		sfu.setHeaderEncoding("utf-8");
		
		List<FileItem> list=null;
		Iterator<FileItem> iterator=null;
		String NotFile="";
		String YesFile="";
		 FileItem fileItem=null;
		try {
			 list = sfu.parseRequest(request);
			  iterator = list.iterator();
			 while(iterator.hasNext()){
				  fileItem = iterator.next();
				 if(fileItem.isFormField()){
					 NotFile=fileItem.getString();
					 NotFile=new String (NotFile.getBytes("iso-8859-1"),"utf-8");
					 System.out.println("====普通文本"+NotFile);
				 }else{
					 YesFile = fileItem.getName();
					 long size = fileItem.getSize();
					 System.out.println("====文件名"+YesFile+"文件大小"+size);
				 }
				 if(YesFile==null){
					 continue;
				 }else{
				 File a = new File(file,YesFile);
				 
				 fileItem.write(a);
				 }
				
			 }
			 fileItem.delete();
			 
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
