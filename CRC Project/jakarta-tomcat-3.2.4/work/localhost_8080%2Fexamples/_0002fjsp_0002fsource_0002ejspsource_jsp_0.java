package jsp;

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


public class _0002fjsp_0002fsource_0002ejspsource_jsp_0 extends HttpJspBase {


    static {
    }
    public _0002fjsp_0002fsource_0002ejspsource_jsp_0( ) {
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

            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\source.jsp";from=(0,77);to=(2,0)]
                out.write("\r\n\r\n");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\source.jsp";from=(2,0);to=(2,58)]
                /* ----  eg:ShowSource ---- */
                examples.ShowSource _jspx_th_eg_ShowSource_0 = new examples.ShowSource();
                _jspx_th_eg_ShowSource_0.setPageContext(pageContext);
                _jspx_th_eg_ShowSource_0.setParent(null);
                _jspx_th_eg_ShowSource_0.setJspFile( request.getQueryString() );
                try {
                    int _jspx_eval_eg_ShowSource_0 = _jspx_th_eg_ShowSource_0.doStartTag();
                    if (_jspx_eval_eg_ShowSource_0 == BodyTag.EVAL_BODY_TAG)
                        throw new JspTagException("Since tag handler class examples.ShowSource does not implement BodyTag, it can't return BodyTag.EVAL_BODY_TAG");
                    if (_jspx_eval_eg_ShowSource_0 != Tag.SKIP_BODY) {
                        do {
                        // end
                        // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\source.jsp";from=(2,0);to=(2,58)]
                        } while (false);
                    }
                    if (_jspx_th_eg_ShowSource_0.doEndTag() == Tag.SKIP_PAGE)
                        return;
                } finally {
                    _jspx_th_eg_ShowSource_0.release();
                }
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
