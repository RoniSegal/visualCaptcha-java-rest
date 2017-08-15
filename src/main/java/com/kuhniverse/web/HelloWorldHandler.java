package com.kuhniverse.web;
 
public class HelloWorldHandler {
	public String getHello() {
		int a=0;
		try{
			for (int i=0; i < 20; i++) {
				System.out.println("HelloWorldHandler thread: " + Thread.currentThread().getId());
				Thread.sleep(500);
			}
		}
		catch(InterruptedException e){
			System.out.println("HelloWorldHandler thread interrupted");
		}
		return "Hello World";
	}
}
