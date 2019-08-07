package com.example.design.dynamic_proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TestCglibProxy {

	public static void main(String[] args) {
		/**
		 * 创建字节码增强器
		 */
		Enhancer enhancer = new Enhancer();
		/**
		 * 被代理类设置为字节码增强器父类，cglib使用的是继承方式去创建代理类
		 */
		enhancer.setSuperclass(PersonImpl.class);
		/**
		 * 设置字节码增强器回调方法，
		 * 对于代理类上所有方法的回调。都会调用CallBack，而CallBack则需要实现intercept()方法进行拦截
		 */
		enhancer.setCallback(new CglibProxy());
		//创建代理实例
		PersonImpl personImpl = (PersonImpl) enhancer.create();
		personImpl.eat("banana");
	}
}
class CglibProxy implements MethodInterceptor{

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("before ...");
		proxy.invokeSuper(obj, args);
		System.out.println("after ...");
		return null;
	}
}
