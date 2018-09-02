package com.crazy.appium.KYE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InstanceCounter {
	
	int x;
	public InstanceCounter(int a,int b) {
		int c = a+b;
		System.out.println(c);
	}
	
	public InstanceCounter() {
		x = 10;
//		System.out.println(x);
	}
	
	public static void printMax(double...numbers) {
		if(numbers.length ==0) {
			System.out.println("无可用参数传递");
			return;
		}
		
		double result = numbers[0];
		
		for(int i = 1;i<numbers.length;i++) {
			if (numbers[i]>result) {
				result = numbers[i];
				System.out.println("最大值应该是："+result);
			}
		}
		
	}
	
	public static  void ReadFile() throws IOException{
		InputStream fileInputStream = new FileInputStream("C:/Users/Administrator/Desktop/file.txt");
		int get = fileInputStream.available();
		System.out.println(get);
		fileInputStream.close();
	}
	
	public static void OtherFile() throws IOException {
		File file = new File("C:/Users/Administrator/Desktop/file.txt");
		InputStream inputStream = new FileInputStream(file);
		int get = inputStream.available();
		System.out.println(get);
		inputStream.close();
	}
	
	
	public static int returnResult(int num1,int num2) {
		int result;
		if(num1>num2) {
			result = num1;
		}else {
			result = num2;
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception{
		
		InstanceCounter instanceCounter = new InstanceCounter();
		
		System.out.println(instanceCounter.x);
		
		
		printMax(new double[] {315.1,884.4,5.2,6.8});
		printMax(3,55,51,9,52);
		
		
//		char c = 0;
//		String str = null;
//		
//		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(inputStreamReader);
//		System.out.println("输入字符,'q'进行退出");
//		do {
//			c = (char)br.read();
//		} while (c != 'z');
//		while( c != 'z') {
//			c = (char)br.read();
//		}
		
//		while(!str.equals("end")) {
//			str = br.readLine();
//		}
		
//		do {
//			str = br.readLine();
//		} while (!str.equals("end"));
		ReadFile();
		OtherFile();
	}
	      
	
	
}