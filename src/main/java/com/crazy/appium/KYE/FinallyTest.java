package com.crazy.appium.KYE;



public class FinallyTest {
	

	
	
	public static void main(String[] args) {
		String[] strings = new String[3];
		strings[0] = "a";
		strings[1] = "b";
		strings[2] = "c";
		
		int[] kye = new int[3];
		kye[0] = 2;
		kye[1] = 3;
		kye[2] = 8;
		
		try {
			//strings[3] = "10";
			int a = 2/1;
			System.out.println(a);
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			System.out.println("数组赋值失败");
			
		}finally {
			System.out.println("0000");
			int b = 10/2;
			System.out.println(b);
			
		}
	}
	
	
	

}
