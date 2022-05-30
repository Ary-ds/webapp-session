package ary.ds.interceptors;

import java.sql.Connection;
import java.util.logging.Logger;

import ary.ds.anotacion.MySqlCom;
import ary.ds.services.ServiceJdbcException;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@TransacionalJDBC
@Interceptor
public class TranscionalInterceptor {
	
	@Inject
	private Logger log;
	
	@Inject
	@MySqlCom
	private Connection conn;
	
//	creamos el metodo para invocar la intercepcion 
	@AroundInvoke
	public Object transactional(InvocationContext invocationContext) throws Exception {
		
//		si es true se la pone a false
		if (conn.getAutoCommit()) {
			conn.setAutoCommit(false);
		}
		
		try {
			
			log.info(" ************* inicializado transaciones "
					+ invocationContext.getMethod().getName()
					+ " de la clase "
					+ invocationContext.getMethod().getDeclaringClass());
			
//		llamada da la invocacion del metodo 
			Object resultado = invocationContext.proceed();
			conn.commit();
			
			log.info(" =========== realizando commit y finalizando transaccion "
					+ invocationContext.getMethod().getName()
					+ " de la clase "
					+ invocationContext.getMethod().getDeclaringClass());
			
			return resultado;
		} catch (ServiceJdbcException e) {
			conn.rollback();
			throw e;
			
		}
		
	}
}
