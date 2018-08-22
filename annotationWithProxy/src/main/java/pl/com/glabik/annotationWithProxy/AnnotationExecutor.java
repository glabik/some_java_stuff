package pl.com.glabik.annotationWithProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public abstract class AnnotationExecutor {

	protected boolean annotationExist;
	
	public AnnotationExecutor(Method m) {
		super();

		annotationExist = m.isAnnotationPresent(getAnnotationClass());
	}
	
	protected void doBefore() {
		if(annotationExist)
			doBeforeImpl();
	}

	protected void doAfter() {
		if(annotationExist)
			doAfterImpl();
	}
	
	protected abstract Class<? extends Annotation> getAnnotationClass();
	protected abstract void doBeforeImpl();
	protected abstract void doAfterImpl();
	
	
}
