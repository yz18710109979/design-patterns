package com.example.design.simple;

public class SimpleFactory {

	public Car product(String name) {
		if("Benz".equals(name)) {
			System.out.println("Benz");
			return new Benz();
		}else if("BMW".equals(name)) {
			System.out.println("BMW");
			return new BMW();
		}else {
			System.out.println("这个汽车没法生产!!!");
			return null;
		}
	}
}
