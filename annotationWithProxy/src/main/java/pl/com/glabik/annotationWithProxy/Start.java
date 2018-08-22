package pl.com.glabik.annotationWithProxy;

public class Start {
	
	public static void main( String[] args ) throws InterruptedException{
        SimpleService simpleService = SimpleService.getInstance();
        simpleService.doSomething();
    }
	
}
