package com.ynwi.ssh.action;

public class waitTest {
	public class ThreadA extends Thread{
	    public ThreadA(String name) {
	        super(name);
	    }
	    public void run() {
//	        synchronized (this) {
//	            System.out.println(Thread.currentThread().getName()+" call notify()");
//	            // 唤醒当前的wait线程
//	            notify();
//	        }
	    	for(int i=0; i<10; i++){
	    		try {
					Thread.sleep(1000);
					System.out.println("i:"+ i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}
	    }
	}
	public class ThreadB extends Thread{
		public ThreadB(String name) {
	        super(name);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		waitTest w = new waitTest();
		ThreadA t1 = w.new ThreadA("t1");
		ThreadB tB = w.new ThreadB("tb"){
			public void run(){
				synchronized (t1) {
		            System.out.println(Thread.currentThread().getName()+" call in tb notify()");
		            // 唤醒当前的wait线程
		            t1.notify();
		        }
			}
		};
	        synchronized(t1) {
	            try {
	                // 启动“线程t1”
	                System.out.println(Thread.currentThread().getName()+" start t1");
	                t1.start();
	                // 主线程等待t1通过notify()唤醒。
	                Thread.sleep(1000);
	                System.out.println(Thread.currentThread().getName()+" wait()");
	                t1.wait(1000);
	                System.out.println(Thread.currentThread().getName()+" wait() again");
	                Thread.sleep(10000);
	                
	                
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        tB.start();
	        System.out.println(Thread.currentThread().getName()+" continue");
	        
	}

}
