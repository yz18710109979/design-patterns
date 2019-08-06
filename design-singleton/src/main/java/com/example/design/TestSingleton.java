package com.example.design;

import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestSingleton {

	public static final ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS,
			new LinkedBlockingQueue<Runnable>());

	public static void main(String[] args) throws Exception {
//		try {
//			// 初始化计数器为1
//			final CountDownLatch countDownLatch = new CountDownLatch(1);
//
//			for (int i = 0; i < 100; i++) {
//				new Thread(new Runnable() {
//					
//					public void run() {
//						try {
//							countDownLatch.await();
//							System.out.println(Singleton.getInstance());
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//				}).start();
//			}
//
//			// 启动多个线程
//			countDownLatch.countDown();
//
//		} catch (Exception e) {
//			System.out.println("Exception: " + e);
//		}
//================反射获取单例=============================================================
//		Class clz = Class.forName("com.example.design.Singleton");
//		clz = Singleton.class;
	}
		
}

/**
 * <strong>饿汉式</strong>
 * 
 * @author Administrator
 *
 */
class Singleton {
	// 私有化构造函数
	private Singleton() {
	}

	// 私有化该实例的引用
	private static Singleton singleton = new Singleton();

	// 公共的静态工厂方法
	public static Singleton getInstance() {
		return singleton;
	}
}

/**
 * <strong>懒汉式</strong>
 * 
 * @author Administrator
 *
 */
class Singleton01 {
	// 私有化构造函数
	private Singleton01() {}

	// 私有化该实例的引用
	private static Singleton01 singleton01 = null;

	// 公共的静态工厂方法
	public static Singleton01 getInstance() {
		if (null == singleton01) {
			singleton01 = new Singleton01();
		}
		return singleton01;
	}
}
