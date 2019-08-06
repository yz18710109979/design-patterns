package com.example.design;

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
//================懒汉模式+synchronize=============================================================	
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

/**
 * <strong>
 * 	使用synchronized同步锁,保证多线程情况下<a>Singleton01</a>
 *  只能创建一个对象，但是执行效率低下</strong>
 * @author Administrator
 *
 */
class Singleton02{
	//
	private Singleton02() {}
	//
	private static Singleton02 singleton02 = null;
	//
	public static Singleton02 getInstance() {
		synchronized (Singleton02.class) {
			//注意：里面的判断是一定要加的，否则出现线程安全
			if(null == singleton02) {
				singleton02 = new Singleton02();
			}
			return singleton02;
		}
	}
}
/**
 * <strong>
 * 	优化上
 * @author Administrator
 *
 */
class Singleton03{
	//
	private Singleton03() {}
	//
	private static Singleton03 singleton03 = null;
	
	//双重检查
	public static Singleton03 getInstance() {
		if(null == singleton03) {
			synchronized (Singleton03.class) {
				if(null == singleton03) {
					singleton03 = new Singleton03();
				}
			}
		}
		return singleton03;
	}
}
/**
 * 静态内部类
 * <strong>
 * 静态内部类虽然保证了单例在多线程并发下的线程安全性，
 * 但是在遇到序列化对象时，默认的方式运行得到的结果就是多例的。
 * 这种情况不多做说明了，使用时请注意。</strong>
 * @author Administrator
 *
 */
class Singleton04{
	private Singleton04() {}
	
	//静态内部类
	private static class Inner{
		private static Singleton04 singleton04 = new Singleton04();
	} 
	public static Singleton04 getInstance() {
		return Inner.singleton04;
	}
}

/**
 * <strong>static静态代码块实现</strong>
 * @author Administrator
 *
 */
class Singleton05{
	private Singleton05() {}
	private static Singleton05 singleton05 = null;
	static {
		singleton05 = new Singleton05();
	}
	public static Singleton05 getInstance() {
		return singleton05;
	}
}
/** 内部枚举类实现*/