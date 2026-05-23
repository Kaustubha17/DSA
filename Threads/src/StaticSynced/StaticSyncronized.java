package StaticSynced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Test{

	synchronized static void print(String threadName) {
		System.out.println("static syncronized "+threadName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	  synchronized static void ab(String threadName) {
	   System.out.println("just synced "+threadName); 
	  }
	 */


	/*
	  synchronized void ab(String threadName) {
	  System.out.println("just synced "+threadName); }
	 */

	void ab(String threadName) {
		synchronized(this) {
			System.out.println("just synced "+threadName);
		}
	}



}


public class StaticSyncronized {

	public static void main(String[] args) throws IOException  {

		Test t1=new Test();
		Test t2=new Test();

		new Thread(new Runnable() {

			@Override
			public void run() {
				Test.print("t1");

			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				t1.ab("t1");	
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				t2.print("t2");	

			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				t2.ab("t2");	
			}
		}).start();

		List<Integer>list=new ArrayList<>();
		list.add(1);
		list.add(2);
		List<Integer>immutableList=Collections.unmodifiableList(list);
		try {
			immutableList.add(4);
		}
		catch(Exception e) {
			System.out.println("cannot add to immutable list");
		}


		FileOutputStream out=new FileOutputStream("output.txt");
		try (ObjectOutputStream obj = new ObjectOutputStream(out)) {
			obj.writeInt(0);
			obj.writeInt(1);
		}
		FileInputStream input=new FileInputStream("output.txt");
		try (ObjectInputStream inputStream = new ObjectInputStream(input)) {
			int a= inputStream.readInt();
			int b=inputStream.readInt();
			System.out.println(a);
			System.out.println(b);
		}





	}}
