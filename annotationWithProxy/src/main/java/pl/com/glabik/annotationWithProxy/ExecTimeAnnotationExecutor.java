package pl.com.glabik.annotationWithProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.commons.lang3.time.StopWatch;

public class ExecTimeAnnotationExecutor extends AnnotationExecutor {

	private StopWatch sw;
	
	public ExecTimeAnnotationExecutor(Method m) {
		super(m);
	}

	@Override
	protected Class<? extends Annotation> getAnnotationClass() {
		return ExecTime.class;
	}

	@Override
	protected void doBeforeImpl() {
		sw = new StopWatch();
		sw.start();
		
	}

	@Override
	protected void doAfterImpl() {
		sw.stop();
		System.out.println("execution time: "+sw.getTime());
	}

}
