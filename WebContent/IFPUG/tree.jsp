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
	font-family: "����"; 
	font-size: 12px; 
	font-weight: normal;}
a{
	font-family: "����"; 
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
        d.add(0,-1,'��ģ����');
		 d.add(60,0,'IFPUG���ܵ�','welcomeIfpug.jsp');
		 d.add(61,60,'����ֽ�');
		    d.add(62,61,'��Ӳ�Ʒ','requirement/productList.jsp');
		    d.add(63,61,'��ӹ���ģ��','requirement/addFunction.jsp');
		    d.add(64,61,'��ӻ�������','requirement/addElementaryProcess.jsp');
			d.add(65,61,'�鿴����ֽ���','requirement/viewRequirementTree.jsp');

        d.add(66,60,'�������ݹ��ܵ�');
            d.add(67,66,'������ݹ���','dataFunction/addDataFunction.jsp');
		    d.add(69,66,'��Ӽ�¼Ԫ��','dataFunction/addRet.jsp');
		    d.add(70,66,'�������Ԫ��','dataFunction/addDet.jsp');
		    d.add(71,66,'�鿴���ݹ��ܵ���','dataFunction/viewDataFunctionTree.jsp');
        d.add(72,60,'���������ܵ�');
        	d.add(73,72,'���������ܵ�','transaction/selectFunction.jsp');
			d.add(74,72,'�鿴�����ܵ���','transaction/viewTransactionTree.jsp');
        d.add(17,60,'����NESMA���ܵ�����','nesma/nesmaSelectPro.jsp');
        d.add(27,60,'����������ܵ�����','selectProduct.jsp');  
		
	    d.add(47,60,'��������','selectProductToMeasure.jsp');
	        	 d.config.target = "contentFrame";
		       document.write(d);		
	</script>
		</div>
		<p>
			<a href="javascript: d.openAll();">չ��Ŀ¼</a> | <a href="javascript: d.closeAll();">����Ŀ¼</a>
		</p>

	</body>

</html>
