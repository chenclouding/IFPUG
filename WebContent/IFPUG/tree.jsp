<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<html>
	<head>
		<title></title>
		<link rel="StyleSheet" href="../javascript/dtree.css" type="text/css" />
		<script type="text/javascript" src="../javascript/dtree.js"></script>
		<style>
body{
	font-family: "宋体"; 
	font-size: 12px; 
	font-weight: normal;}
a{
	font-family: "宋体"; 
	font-size: 12px; 
	color: #000000; 
	font-weight: normal; 
}
</style>
	</head>
	<body bgcolor="#e7f3f8">
	<%String projectId = "";
	projectId =  (String)session.getAttribute("projectId");
	//Variables used for FSM
	String productId = (String)request.getAttribute("productId");  %>
		<div class="dtree">
			<script type="text/javascript">
		<!--
		d = new dTree('d');
        d.add(0,-1,'规模估算');
		 d.add(60,0,'IFPUG功能点','welcomeIfpug.jsp');
		 d.add(61,60,'需求分解');
		    d.add(62,61,'添加产品','requirement/productList.jsp');
		    d.add(63,61,'添加功能模块','requirement/addFunction.jsp');
		    d.add(64,61,'添加基本流程','requirement/addElementaryProcess.jsp');
			d.add(65,61,'查看需求分解树','requirement/viewRequirementTree.jsp');

        d.add(66,60,'估算数据功能点');
            d.add(67,66,'添加数据功能','dataFunction/addDataFunction.jsp');
		    d.add(69,66,'添加记录元素','dataFunction/addRet.jsp');
		    d.add(70,66,'添加数据元素','dataFunction/addDet.jsp');
		    d.add(71,66,'查看数据功能点树','dataFunction/viewDataFunctionTree.jsp');
        d.add(72,60,'估算事务功能点');
        	d.add(73,72,'估算事务功能点','transaction/selectFunction.jsp');
			d.add(74,72,'查看事务功能点树','transaction/viewTransactionTree.jsp');
        d.add(17,60,'估算NESMA功能点总数','nesma/nesmaSelectPro.jsp');
        d.add(27,60,'估算调整后功能点总数','selectProduct.jsp');  
		
	    d.add(47,60,'导出度量','selectProductToMeasure.jsp');
	        	 d.config.target = "contentFrame";
		       document.write(d);		
	</script>
		</div>
		<p>
			<a href="javascript: d.openAll();">展开目录</a> | <a href="javascript: d.closeAll();">收起目录</a>
		</p>

	</body>

</html>
