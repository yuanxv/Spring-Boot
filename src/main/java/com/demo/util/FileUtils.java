package com.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class FileUtils {
	
	 private static String URL_PATH = "http://192.168.70.65:8080/myhttp/pro.png";//服务器下
	 
	public FileUtils() {
	    }
//	 已有文件输入流，在本地创建文件，将流写入
	    public static void  saveImageToDisk(String srcPath,String desPath) {
	        InputStream inputStream = getInputStream(srcPath);
	        byte[] data = new byte[1024];
	        int len = 0;
	        FileOutputStream fileOutputStream = null;
	        try {
//	        	根据头像名称 拼接路径
	        	File desFile=new File(desPath);
	        	if(!desFile.exists())    
	        	{    
	        	    try {    
	        	    	desFile.createNewFile();    
	        	    } catch (IOException e) {    
	        	        // TODO Auto-generated catch block    
	        	        e.printStackTrace();    
	        	    }    
	        	}  
	            fileOutputStream = new FileOutputStream(desFile);
	            while ((len=inputStream.read(data) )!= -1) {
	                fileOutputStream.write(data, 0, len);
	            }
	        } catch (IOException ex) {
	            Logger.getLogger(FileUtils.class.getName()).log(Level.ERROR, null, ex);
	        } finally {
	            if (inputStream != null) {
	                try {
	                    inputStream.close();
	                } catch (IOException ex) {
	    	            Logger.getLogger(FileUtils.class.getName()).log(Level.ERROR, null, ex);
	                }
	            }
	            if (fileOutputStream != null) {
	                try {
	                    fileOutputStream.close();
	                } catch (IOException ex) {
	    	            Logger.getLogger(FileUtils.class.getName()).log(Level.ERROR, null, ex);
	                }
	            }
	        }
	    }
	 
	    public static InputStream getInputStream() {

	        InputStream inputStream = null;
	        HttpURLConnection httpURLConnection = null;
	        try {
	            URL url = new URL(URL_PATH);
	            if (url != null) {
	                httpURLConnection = (HttpURLConnection) url.openConnection();
	                //设置连接网络的超时时间
	                httpURLConnection.setConnectTimeout(3000);
	                httpURLConnection.setDoInput(true);
	                //设置本次http请求使用get请求方式
	                httpURLConnection.setRequestMethod("GET");
	                int responsecode = httpURLConnection.getResponseCode();
	                if (responsecode == 200) {
	                    //从服务器获得一个输入流
	                    inputStream = httpURLConnection.getInputStream();
	                }
	            }
	        } catch (IOException ex) {
	            Logger.getLogger(FileUtils.class.getName()).log(Level.ERROR, null, ex);
	        }
	        return inputStream;
	    }
//	    根据路径获取文件流
	    public static InputStream getInputStream(String srcPath){
	    	InputStream inputStream =null;
	    	try {
				 inputStream = new FileInputStream(new File(srcPath));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return inputStream;
	    }
	    
}


//1.拿磁盘文件，以对象方法输出------根据文件路径创建文件对象，返回对象
//2.拿磁盘文件，以流方式输出-------根据文件路径创建输入流，返回
//3.拿到文件对象，存到本地磁盘---------根据文件对象，创建本地文件，创建输入输出流，读取写入，即可。
//4.拿到流、文件名，存到本地磁盘--------根据文件名路径创建输出流，输入流读取，输出流写入，即可。