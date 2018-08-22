package pl.com.glabik.annotationWithProxy;

public class Start {
	
	public static void main( String[] args ) throws InstantiationException, IllegalAccessException, InterruptedException{
        SimpleService simpleService = SimpleService.getInstance();
        simpleService.doSomething();
    }
	
}
