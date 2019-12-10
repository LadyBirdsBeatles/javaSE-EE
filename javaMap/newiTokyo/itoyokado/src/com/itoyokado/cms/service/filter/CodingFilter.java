package com.itoyokado.cms.service.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

/**
 * 拦截器 处理编码问题
 */
@WebFilter("/*")
public class CodingFilter implements Filter {
    private static String encoding;
//    private static final String DEFAULT_CHARSET="UTF-8";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取init-param值
             encoding=filterConfig.getInitParameter("encoding");
          if (null==encoding||"".equals(encoding)){
              encoding="UTF-8";
          }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        if("GET".equals(request.getMethod())){
            MyRequest myRequest=new MyRequest(request,encoding);
            filterChain.doFilter(myRequest,response);
        }else {
            request.setCharacterEncoding(encoding);
            response.setContentType("text/html;charset="+encoding);
            filterChain.doFilter(request,response);
        }

    }
    //装饰者模式 自定义增强类
    private class MyRequest extends HttpServletRequestWrapper {
        private HttpServletRequest request;
        public MyRequest(HttpServletRequest request, String encoding) {
            super(request);
            this.request = request;
        }
        //对于获取参数方法增强
        @Override
        public String getParameter(String name) {
            String value = request.getParameter(name);
            if (null==value||value.trim().length()==0||"".equals(value)){
                return null;
            }
            try {
                value=new String(value.getBytes("ISO-8859-1"),encoding);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return  super.getParameter(name);
        }
    }
    @Override
    public void destroy() {
    }

}

