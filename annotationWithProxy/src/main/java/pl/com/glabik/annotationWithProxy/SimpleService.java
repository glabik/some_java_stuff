package pl.com.glabik.annotationWithProxy;


import java.lang.reflect.Method;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

public class SimpleService {

	
	public static SimpleService getInstance() {
		try {
			ProxyFactory factory = new ProxyFactory();
			factory.setSuperclass(SimpleService.class);
			Class<?> aClass = factory.createClass();
			final SimpleService newInstance = (SimpleService) aClass.newInstance();
			MethodHandler methodHandler = new MethodHandler() {
			    public Object invoke(Object self, Method overridden, Method proceed, Object[] args) throws Throwable {
			    	AnnotationExecutor execTimeAE = new ExecTimeAnnotationExecutor(overridden);
			    	execTimeAE.doBefore();
			        Object result = proceed.invoke(newInstance, args);
			        execTimeAE.doAfter();
			        return result;
			    }
			};
			((ProxyObject)newInstance).setHandler(methodHandler);
			return newInstance;
		}catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("error of getting SimpleService instance");
		}
	}
	
	@ExecTime
	public void doSomething() throws InterruptedException {
		System.out.print("start doing something...  ");
		Thread.sleep(5000);
		System.out.println("done");
	}
}
