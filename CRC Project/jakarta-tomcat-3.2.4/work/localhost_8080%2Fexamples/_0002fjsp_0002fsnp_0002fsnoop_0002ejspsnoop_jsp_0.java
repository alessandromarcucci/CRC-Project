package jsp.snp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Vector;
import org.apache.jasper.runtime.*;
import java.beans.*;
import org.apache.jasper.JasperException;


public class _0002fjsp_0002fsnp_0002fsnoop_0002ejspsnoop_jsp_0 extends HttpJspBase {


    static {
    }
    public _0002fjsp_0002fsnp_0002fsnoop_0002ejspsnoop_jsp_0( ) {
    }

    private static boolean _jspx_inited = false;

    public final void _jspx_init() throws JasperException {
    }

    public void _jspService(HttpServletRequest request, HttpServletResponse  response)
        throws IOException, ServletException {

        JspFactory _jspxFactory = null;
        PageContext pageContext = null;
        HttpSession session = null;
        ServletContext application = null;
        ServletConfig config = null;
        JspWriter out = null;
        Object page = this;
        String  _value = null;
        try {

            if (_jspx_inited == false) {
                _jspx_init();
                _jspx_inited = true;
            }
            _jspxFactory = JspFactory.getDefaultFactory();
            response.setContentType("text/html;charset=ISO-8859-1");
            pageContext = _jspxFactory.getPageContext(this, request, response,
			"", true, 8192, true);

            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();

            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(0,0);to=(9,20)]
                out.write("<html>\r\n<!--\r\n  Copyright (c) 1999 The Apache Software Foundation.  All rights \r\n  reserved.\r\n-->\r\n\r\n<body bgcolor=\"white\">\r\n<h1> Request Information </h1>\r\n<font size=\"4\">\r\nJSP Request Method: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(9,23);to=(9,44)]
                out.print( request.getMethod() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(9,46);to=(11,13)]
                out.write("\r\n<br>\r\nRequest URI: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(11,16);to=(11,41)]
                out.print( request.getRequestURI() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(11,43);to=(13,18)]
                out.write("\r\n<br>\r\nRequest Protocol: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(13,21);to=(13,44)]
                out.print( request.getProtocol() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(13,46);to=(15,14)]
                out.write("\r\n<br>\r\nServlet path: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(15,17);to=(15,43)]
                out.print( request.getServletPath() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(15,45);to=(17,11)]
                out.write("\r\n<br>\r\nPath info: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(17,14);to=(17,37)]
                out.print( request.getPathInfo() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(17,39);to=(19,17)]
                out.write("\r\n<br>\r\nPath translated: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(19,20);to=(19,49)]
                out.print( request.getPathTranslated() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(19,51);to=(21,14)]
                out.write("\r\n<br>\r\nQuery string: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(21,17);to=(21,43)]
                out.print( request.getQueryString() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(21,45);to=(23,16)]
                out.write("\r\n<br>\r\nContent length: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(23,19);to=(23,47)]
                out.print( request.getContentLength() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(23,49);to=(25,14)]
                out.write("\r\n<br>\r\nContent type: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(25,17);to=(25,43)]
                out.print( request.getContentType() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(25,45);to=(27,13)]
                out.write("\r\n<br>\r\nServer name: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(27,16);to=(27,41)]
                out.print( request.getServerName() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(27,43);to=(29,13)]
                out.write("\r\n<br>\r\nServer port: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(29,16);to=(29,41)]
                out.print( request.getServerPort() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(29,43);to=(31,13)]
                out.write("\r\n<br>\r\nRemote user: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(31,16);to=(31,41)]
                out.print( request.getRemoteUser() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(31,43);to=(33,16)]
                out.write("\r\n<br>\r\nRemote address: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(33,19);to=(33,44)]
                out.print( request.getRemoteAddr() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(33,46);to=(35,13)]
                out.write("\r\n<br>\r\nRemote host: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(35,16);to=(35,41)]
                out.print( request.getRemoteHost() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(35,43);to=(37,22)]
                out.write("\r\n<br>\r\nAuthorization scheme: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(37,25);to=(37,48)]
                out.print( request.getAuthType() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(37,50);to=(39,8)]
                out.write(" \r\n<br>\r\nLocale: ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(39,11);to=(39,32)]
                out.print( request.getLocale() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(39,34);to=(41,29)]
                out.write("\r\n<hr>\r\nThe browser you are using is ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(41,32);to=(41,65)]
                out.print( request.getHeader("User-Agent") );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\snp\\snoop.jsp";from=(41,67);to=(46,0)]
                out.write("\r\n<hr>\r\n</font>\r\n</body>\r\n</html>\r\n");
            // end

        } catch (Exception ex) {
            if (out != null && out.getBufferSize() != 0)
                out.clearBuffer();
            if (pageContext != null) pageContext.handlePageException(ex);
        } finally {
            if (out != null) out.flush();
            if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);
        }
    }
}
