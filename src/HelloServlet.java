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
     * ����У��(ȷ����������΢�ŷ�����).
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
        System.out.println("=======��ʼ����У��888888======");

        // ΢�ż���ǩ��.
       String signature = request.getParameter("signature");
        System.out.println("signature====" + signature);
        // ʱ���.
        String timestamp = request.getParameter("timestamp");
        System.out.println("timestamp====" + timestamp);
        // �����.
        String nonce = request.getParameter("nonce");
        System.out.println("nonce====" + nonce);
       // ����ַ���.
        String echostr = request.getParameter("echostr");
        System.out.println("echostr====" + echostr);

        PrintWriter out = response.getWriter();

        // ����У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��.
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            System.out.println("=======����У��ɹ�======" + echostr);
            out.print(echostr);
        }

        out.close();
        out = null;
    }

    
    
    
    
    
    
    
    
    
    
    
    /**
     * ����΢�ŷ�������������Ϣ.
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ��������Ӧ�ı��������ΪUTF-8����ֹ�������룩

    }

}