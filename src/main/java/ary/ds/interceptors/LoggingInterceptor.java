package ary.ds.interceptors;

import java.util.logging.Logger;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Logging
@Interceptor
public class LoggingInterceptor {
	
	@Inject
	private Logger log;
	
//	creamos el metodo para invocar la intercepcion 
	@AroundInvoke
	public Object logging(InvocationContext invocationContext) throws Exception {
		
		log.info(" =========== entrando antes de invocar el metodo "
				+ invocationContext.getMethod().getName()
				+ " de la clase "
				+ invocationContext.getMethod().getDeclaringClass());
		
//		llamada da la invocacion del metodo 
		Object resultado = invocationContext.proceed();
		
		log.info(" =========== saliendo  de la invocacion del metodo "
				+ invocationContext.getMethod().getName()
				+ " de la clase "
				+ invocationContext.getMethod().getDeclaringClass());
		
		return resultado;
	}

}
