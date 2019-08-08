package com.example.design.simple;

public class TestSimpleFactory {

	public static void main(String[] args) {
		SimpleFactory simpleFactory = new SimpleFactory();
		Car car = simpleFactory.product("BMW");
		String name = car.getName();
		System.out.println("name:"+name);
	}
}
