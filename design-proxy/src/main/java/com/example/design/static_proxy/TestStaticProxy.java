package com.example.design.static_proxy;

import com.example.design.User;
import com.example.design.UserImpl;

public class TestStaticProxy {
	
	public static void main(String[] args) {
		StaticProxy staticProxy = new StaticProxy(new UserImpl());
		staticProxy.work("Java");
	}
	
}
class StaticProxy implements User{
	private User user;
	public StaticProxy(User user) {
		this.user = user;
	}
	public void work(String workName) {
		System.out.println("执行前...");
		user.work(workName);
		System.out.println("执行后...");
	}
}
