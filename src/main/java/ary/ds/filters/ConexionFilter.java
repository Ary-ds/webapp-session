package ary.ds.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import ary.ds.anotacion.MySqlCom;
import ary.ds.services.ServiceJdbcException;
import jakarta.inject.Inject;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class ConexionFilter implements Filter {
	
////inyectamos la conexion 
//	@Inject
////	@Named("conn")
//	@MySqlCom
//	private Connection conn;
	
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

//        try (Connection conn = ConexionBaseDatosDS.getConnection()) {
//        try (Connection connRequest = this.conn) {
//        	try {
//        		Connection connRequest = this.conn;
//
//            if (connRequest.getAutoCommit()) {
//            	connRequest.setAutoCommit(false);
//            }

            try {
//                request.setAttribute("conn", connRequest);
                chain.doFilter(request, response);
//                connRequest.commit();
//            } catch (SQLException | ServiceJdbcException e) {
            } catch (ServiceJdbcException e) {
//            	connRequest.rollback();
                ((HttpServletResponse)response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }
}
