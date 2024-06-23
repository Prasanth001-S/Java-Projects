package com.learning_singleton;


// In java we can break Singleton design pattern in 2 ways
/*
 * 1> by using Reflection. we can access private constructor using Reflections. To avaoid this we have to throw 
 * Exception inside private Constructor. Like if (instance != null){ throw new IllegalStateException("Singleton instance already exists. Use getInstance() method to access it.") };
 * 
 * 2> By using Serializeble Concept we can break Singleton approach. if we want to prevent we have to override one method in singleTon class. the method is readResolve();
 */

public class Singleton {
	
	public static Singleton singleTon = null;
	
	private Singleton() {
		
	}
	
	public static Singleton getCurrentInstance() {
		
		if(singleTon==null)
		{    // for thread safe purpose we are using synchronized block
			synchronized (Singleton.class){
				if(singleTon==null) {
					singleTon = new Singleton();
				}
			}
		}
		return singleTon;
	}

}
