package com.kuhniverse.web;
 
public class DoMagicHandler {
	public String getDoMagic() {
		int a=0;
		try{
			System.out.println("DoMagicHandler thread: " + Thread.currentThread().getId());
			this.doMagic();
			Thread.sleep(1000);
			this.doMagic1();
			Thread.sleep(1000);
			this.doMagic2();
			Thread.sleep(1000);
			this.doMagic3();
			Thread.sleep(1000);
			this.doMagic();
		}
		catch(InterruptedException e){
			System.out.println("DoMagicHandler thread interrupted");
		}
		return "Do Magic";
	}

	private void doMagic(){
		System.out.println("doMagic");
	}

	private void doMagic1(){
		System.out.println("doMagic1");
	}

	private void doMagic2(){
		System.out.println("doMagic2");
	}

	private void doMagic3(){
		System.out.println("doMagic3");
	}
}
