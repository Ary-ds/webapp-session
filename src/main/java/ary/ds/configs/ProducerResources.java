package ary.ds.configs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.sql.DataSource;

import ary.ds.anotacion.MySqlCom;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProducerResources {
	
	@Inject
	private  Logger log;
	
//	substitue el codigo de abajo para simplificarlo 
	@Resource(name="jdbc/mysqlDB")
	private DataSource ds;
	
	@Produces
	@RequestScoped
//	@Named("conn")
	@MySqlCom
	private Connection beanConnection() throws NamingException, SQLException {
//	        Context initContext = null;
//	        initContext = new InitialContext();
//	        Context envContext = (Context) initContext.lookup("java:/comp/env");
//	        DataSource ds = (DataSource) envContext.lookup("jdbc/mysqlDB");
	        return ds.getConnection();
	}
	
//	metodo para ver la informacion de la clase
	@Produces
	private Logger beanLogger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
	
//	metodo para cerrar la conexion 
	public void close( @Disposes @MySqlCom Connection connection) throws SQLException {
		connection.close();
//		System.out.println("cerando la conexion a la db ");
		log.info("cerando la conexion a la db ");
	}

}
