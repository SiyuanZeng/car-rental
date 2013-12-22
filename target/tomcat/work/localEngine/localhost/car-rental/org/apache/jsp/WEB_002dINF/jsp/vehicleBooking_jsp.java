package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class vehicleBooking_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Vehicle rental ---- Vehicle booking</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("function fnGetCategory(category){\r\n");
      out.write("\r\n");
      out.write("\t\tvar cat=category.options[category.selectedIndex].value;\r\n");
      out.write("\t\tvar Url=\"getRegNo.action?category=\"+cat;\r\n");
      out.write("\t\tvar xhr;\r\n");
      out.write("\t\r\n");
      out.write("\t\txhr=new XMLHttpRequest();\r\n");
      out.write("\t\t//alert(cat); \r\n");
      out.write("\t\r\n");
      out.write("\t\txhr.open(\"GET\",Url,true);\r\n");
      out.write("\t\txhr.send(null);\r\n");
      out.write("\t\txhr.onreadystatechange=function(){\r\n");
      out.write("  \t\tif(xhr.readyState==4){\r\n");
      out.write("  \t  \t\t//alert(xhr.responseText);\r\n");
      out.write("  \t  \t\tdocument.getElementById(\"reg\").innerHTML=xhr.responseText;\r\n");
      out.write("  \t\t}\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("function fnGetTotalRent(f){\r\n");
      out.write("  var sDate=f.booked_from.value;\r\n");
      out.write("  var eDate=f.booked_to.value;\r\n");
      out.write("  alert(f.reg_no);\r\n");
      out.write("  var reg=f.reg_no.options[f.reg_no.selectedIndex].value;\r\n");
      out.write(" \r\n");
      out.write("  var day=sDate.split(\"-\")[0];\r\n");
      out.write("  var month=sDate.split(\"-\")[1];\r\n");
      out.write("  var year=sDate.split(\"-\")[2];\r\n");
      out.write("\r\n");
      out.write("  var day1=eDate.split(\"-\")[0];\r\n");
      out.write("  var month1=eDate.split(\"-\")[1];\r\n");
      out.write("  var year1=eDate.split(\"-\")[2];\r\n");
      out.write("\r\n");
      out.write("  var date1 = new Date(year-1900, month-1, day);\r\n");
      out.write("  var date2 = new Date(year1-1900, month1-1, day1);\r\n");
      out.write("\r\n");
      out.write("  var diff=date2.getTime()-date1.getTime();\r\n");
      out.write("  diff=diff/(1000*60*60*24);\r\n");
      out.write("\r\n");
      out.write("  //alert(\"diff=\"+diff);\r\n");
      out.write("  \r\n");
      out.write("  var days=day1-day;\r\n");
      out.write("  if(day<days && month==month1 && year==year1){\r\n");
      out.write("\t   days=day1-day; \r\n");
      out.write("  }\r\n");
      out.write("  else{\r\n");
      out.write("\t  if(month>month1 || day>day1 ){\r\n");
      out.write("\t\t   if(year>year1){\r\n");
      out.write("\t\t\t   alert(\"booked from/start date should be less then booked to/end date\");\r\n");
      out.write("\t\t\t   return false;   \r\n");
      out.write("\t\t   }\r\n");
      out.write("\t\t   \r\n");
      out.write("\t  }\r\n");
      out.write("\t  else{\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  days=30*(month1-month);\r\n");
      out.write("\t  }\r\n");
      out.write("\t  \r\n");
      out.write("  }\r\n");
      out.write("  calculateRent(diff,reg);\r\n");
      out.write("}\r\n");
      out.write("function calculateRent(days,r){\r\n");
      out.write("\turl=\"getRent.action?r=\"+r+\"&days=\"+days;\r\n");
      out.write("\tvar xhr;\r\n");
      out.write("\t\r\n");
      out.write("\txhr=new XMLHttpRequest();\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\txhr.open(\"GET\",url,true);\r\n");
      out.write("\txhr.send(null);\r\n");
      out.write("\txhr.onreadystatechange=function(){\r\n");
      out.write("\t\tif(xhr.readyState==4){\r\n");
      out.write("\t  \t\talert(xhr.responseText);\r\n");
      out.write("\t  \t\tdocument.getElementById(\"total_rent\").value=xhr.responseText;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("    };\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<center>\r\n");
      out.write("<h1>Vehicle Rental Application ---- Vehicle booking</h1>\r\n");
      out.write("</center>\r\n");
      out.write("<hr />\r\n");
      out.write("\r\n");
      out.write("<form action=\"bookVehicleForm.action\" method=\"post\">\r\n");
      out.write("<table>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>Customer Name</td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"customer_name\"></input></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>Category</td>\r\n");
      out.write("\t\t<td><select name=\"category\" onchange=\"fnGetCategory(this)\">\r\n");
      out.write("\t\t\t<option>Select category</option>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</select></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>Vehicle Registration Number</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<div id=\"reg\"><select name=\"reg_no\">\r\n");
      out.write("\t\t\t<option>Select</option>\r\n");
      out.write("\t\t</select></div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>Booked From</td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"booked_from\"></input></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>Booked To</td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"booked_to\"  onblur=\"fnGetTotalRent(this.form)\"></input></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>Total Rent</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<div id=\"rent\"><input type=\"text\" name=\"total_rent\"\r\n");
      out.write("\t\t\tid=\"total_rent\"></input></div>\r\n");
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>Payment Rec</td>\r\n");
      out.write("\t\t<td><input type=\"checkbox\" name=\"payment\" value=\"paid\"></input></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td><input type=\"submit\" value=\"Save\"></input></td>\r\n");
      out.write("\t\t<td><input type=\"button\" value=\"Cancel\"\r\n");
      out.write("\t\t\tonclick=\"javascript:window.location='index.jsp'\" /></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsp/vehicleBooking.jsp(110,3) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.v}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/vehicleBooking.jsp(110,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("v");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${v.category}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${v.category}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
