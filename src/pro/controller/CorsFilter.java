package pro.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter implements Filter {
  
  @Override
  public void init( FilterConfig filterConfig ) {
  
  }
  
  @Override
  public void doFilter( ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain ) {
    /*HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
    httpResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    httpResponse.setHeader("Access-Control-Allow-Methods", "GET, PUT, DELETE, POST");
    filterChain.doFilter(servletRequest, servletResponse);*/
  }
  
  @Override
  public void destroy() {
  
  }
}
