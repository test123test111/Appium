package com.crazy.appium.KYE;

public class KYECase {
	
	int pupyyage;
	
	final double PI = 3.14;
	
	
	public  KYECase(String name) {
		System.out.println("output name is:  "+name);
		
		
	}
	
	public void setage(int age) {
		pupyyage = age;
	}
	
	
	public int getage() {
		System.out.println("puppy's age is:"+pupyyage);
		return pupyyage;
	}
	
	public static void main(String[] args) {
		KYECase kyeCase = new KYECase("duan hao");
		
		kyeCase.setage(10);
		
		kyeCase.getage();
		
		System.out.println(kyeCase.pupyyage);
		
		System.out.println(Float.MAX_VALUE);
		
	}

}
