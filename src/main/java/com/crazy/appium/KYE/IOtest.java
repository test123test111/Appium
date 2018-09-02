package com.crazy.appium.KYE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOtest {

	public static void main(String args[]){
		   
		   try{
			   int[]  bWrite = {11,21,3,40,5};
			   OutputStream os = new FileOutputStream("test.txt");
			   for(int x=0; x < bWrite.length ; x++){
				   os.write( bWrite[x] ); // writes the bytes
				   }
			   os.close();
			   InputStream is = new FileInputStream("test.txt");
//			   int size = is.available();
			   int size = is.available();
			   
			   for(int i=0; i<size; i++){
				   System.out.print(is.read() + ",");
				   }
			   is.close();
			   }catch(IOException e){
				   System.out.print("Exception");
				   }
		   
		   String name = "E:/test/test";
		   File dir = new File(name);
		   dir.mkdir();
		   
		   
		   String dirName = "E:/test/test";
		   File f1 = new File(dirName);
		   if(f1.isDirectory()) {
			   System.out.println("directory of"+dirName);
			   String[] s = f1.list();
			   
		   }
		   
		   
		   } 
		      }

