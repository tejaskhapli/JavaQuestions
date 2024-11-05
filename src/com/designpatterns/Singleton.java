package com.designpatterns;


public class Singleton {

}


class SingletonEager {
	private static SingletonEager instance = new SingletonEager();
	
	private SingletonEager() { }
	
	
	public static SingletonEager getInstance() {
        return instance;
	}

}

class SingletonLazy {
	private static SingletonLazy instance;
	
	private SingletonLazy() { }
	
	
	public static SingletonLazy getInstance() {
		if(instance != null) {
			instance = new SingletonLazy();
		}
        return instance;
	}

}

/**
 * Thread Safe Singleton: A thread safe singleton is created so that singleton property 
 * is maintained even in multithreaded environment. 
 * To make a singleton class thread safe, getInstance() method is made synchronized 
 * so that multiple threads can’t access it simultaneously.
 * 
 * Con: 
 * getInstance() method is synchronized so it causes slow performance as multiple threads 
 * can’t access it simultaneously.
 */
class SingletonSynchronized {
	private static SingletonSynchronized instance;
	
	private SingletonSynchronized() { }

	synchronized public static SingletonSynchronized getInstance() {
        if (instance == null) {
            instance = new SingletonSynchronized();
        }
        return instance;
	}
}




/**
 *  In this mechanism, we overcome the overhead problem of synchronized code. 
 *  In this method, getInstance is not synchronized but the block which creates 
 *  instance is synchronized so that minimum number of threads have to wait and 
 *  that’s only for first time.
 *  
 * 
*/
class SingletonDoubleCheckLocking {
	
	private static SingletonDoubleCheckLocking instance;
	
	private SingletonDoubleCheckLocking() { }
	
	public static SingletonDoubleCheckLocking getInstance() {
        if (instance == null) {
        	//synchronized block to remove overhead
        	synchronized (SingletonDoubleCheckLocking.class) {
        		if(instance == null) {
        			instance = new SingletonDoubleCheckLocking();	
        		}
			}
            
        }
        return instance;
	}
}


/**
 * When the singleton class is loaded, inner class is not loaded and 
 * hence doesn’t create object when loading the class. 
 * Inner class is created only when getInstance() method is called. 
 * So it may seem like eager initialization but it is lazy initialization. 
 * This is the most widely used approach as it doesn’t use synchronization.
 */
class SingletonBillPugh {

  private SingletonBillPugh()  { }

  // Inner class to provide instance of class
  private static class BillPughSingleton
  {
    private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
  }

  public static SingletonBillPugh getInstance() 
  {
    return BillPughSingleton.INSTANCE;
  }
}
