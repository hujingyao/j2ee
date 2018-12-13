import java.io.IOException;
import java.util.Date;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class HelloServlet extends HttpServlet{
 
	/**
     * 请求校验(确认请求来自微信服务器).
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
	
	
//	
//	
//	 public void doGet(HttpServletRequest request, HttpServletResponse response){
//         
//	        try {
//	            response.getWriter().println("<h1>Hello Servlet!</h1>");
//	            response.getWriter().println(new Date().toLocaleString());
//	        } catch (IOException e) {
//	            // TODO Auto-generated catch block
//	            e.printStackTrace();
//	        }
//	    }
//	
	
	
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=======开始请求校验888888======");

        // 微信加密签名.
       String signature = request.getParameter("signature");
        System.out.println("signature====" + signature);
        // 时间戳.
        String timestamp = request.getParameter("timestamp");
        System.out.println("timestamp====" + timestamp);
        // 随机数.
        String nonce = request.getParameter("nonce");
        System.out.println("nonce====" + nonce);
       // 随机字符串.
        String echostr = request.getParameter("echostr");
        System.out.println("echostr====" + echostr);

        PrintWriter out = response.getWriter();

        // 请求校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败.
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            System.out.println("=======请求校验成功======" + echostr);
            out.print(echostr);
        }

        out.close();
        out = null;
    }

    
    
    
    
    
    
    
    
    
    
    
    /**
     * 处理微信服务器发来的消息.
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）

    }

}