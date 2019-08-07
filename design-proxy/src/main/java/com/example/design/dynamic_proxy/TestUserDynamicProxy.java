package com.example.design.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.example.design.User;
import com.example.design.UserImpl;
/**
 * dk动态代理的缺点就是必须基于接口，没有接口就无法实现代理，而cglib则是使用继承的方式去生成代理类，使用范围更广
 * @author 
 *
 */
public class TestUserDynamicProxy{
	public static void main(String[] args) {
		User user = new UserImpl();
		InvocationHandler h = new DynamicProxy(user);
		/*
         * 使用Proxy的静态方法是生成代理类的核心。
         * 一共有三个参数：
         * 1、第一个参数是被代理类的类加载器，通过此类加载器将代理类加载入jvm中；
         * 2、第二个参数则是被代理类所实现的所有接口，需要所有的接口的目的是创建新的代理类实现被代理类的所有接口，保证被代理类所有方法都能够
         * 被代理。其实代理的核心就是新创建一个类并实例化对象，去集成被代理对象所有功能的同时，再加入某些特性化的功能；
         * 3、第三个参数则是真正的扩展，使用动态代理的主要目的就是能够对原方法进行扩展，尤其是对于大部分方法都具有的重复方法(例如记录日志)，
         * 可以理解为面向切面编程中的增强.
         */
		User proxy = (User) Proxy.newProxyInstance(User.class.getClassLoader(), user.getClass().getInterfaces(), h);
		/*
         * 在调用生成的代理类对象后，调用原方法后，该method对象以及参数等会被传入到InvocationHandler的invoke方法中，由InvocationHandler的
         * invoke方法对被代理类对象进行增强。
         */
        proxy.work("敲代码");
	}

}
class DynamicProxy implements InvocationHandler{

	private User user;
	
	public DynamicProxy(User user) {
		this.user = user;
	}
	/*
     * jdk动态代理基于接口，其中proxy好像没啥卵用、method代表当前被代理对象的实际调用方法、args则代表方法参数
     * 由invoke方法对被代理对象进行相关的增强
     */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("执行前...");
		method.invoke(user, args);
		System.out.println("执行后...");
		return null;
	}
	
}
