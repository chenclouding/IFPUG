<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
*{margin:0;padding:0;font-size:12px;}
.wrapper{width:30%;margin:0 auto;}
/*通用样式--容器宽度值*/
.sharp{width:30%;margin:20px auto 0;float:left;margin-right:2%;}
.sharp .content div{padding:10px;text-indent:2em;}
.content{height:20px;}
h3{height:29px;line-height:29px;font-size:12px;text-indent:10px;}
a:link,a:visited{color:#999;font-weight:bold; text-decoration:none;}
a:hover{text-decoration:none; border-bottom:1px orange solid;color:orange;}

/*上圆角框通用设置样式，如果要运用多个不同颜色，以下6句不用重新变化--------------------------------*/
.b1,.b2,.b3,.b4,.b5,.b6,.b7,.b8{height:1px; font-size:1px; overflow:hidden; display:block;}
.b1,.b8{margin:0 5px;}
.b2,.b7{margin:0 3px;border-right:2px solid; border-left:2px solid;}
.b3,.b6{margin:0 2px;border-right:1px solid; border-left:1px solid;}
.b4,.b5{margin:0 1px;border-right:1px solid; border-left:1px solid; height:2px;}
.content {border-right:1px solid;border-left:1px solid;overflow:hidden;}
/*颜色方案一,蓝色边框----------------------------------------*/
/*下面第一、二句决定边框颜色，第三句决定背景颜色*/
/*边框色*/
.color1 .b2,.color1 .b3,.color1 .b4,.color1 .b5,.color1 .b6,.color1 .b7,.color1 .content{border-color:#96C2F1;}
.color1 .b1,.color1 .b8{background:#96C2F1;}
/*背景色*/
.color1 .b2,.color1 .b3,.color1 .b4,.color1 .b5,.color1 .b6,.color1 .b7,.color1 .content{background:#EFF7FF;}
</style>


  </head>
  
  <body>
    <div class="wrapper">
    <!--风格一，只需要变换一个CLASS就可以换一种颜色-->
    <div class="sharp color1">
        <b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b> 
        <div class="content">基本信息 
        </div>
    </div>
</div>

  </body>
</html>
