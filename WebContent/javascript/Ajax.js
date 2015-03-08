// Ajax.js for implement of Multiple combo

/**
 * ajax无刷新二级联动下拉菜单
 *
 * @author      leehon and arcow <arcow@126.com>
 * @version     1.0
 * @lastupdate  2005-12-29
 *
 */
 
 var http_request = false;
 
 //初始化、指定处理函数、发送请求的函数
 function send_request(url,method) {
 
  http_request = false;
  
  //开始初始化XMLHttpRequest对象
  if(window.XMLHttpRequest) { //Mozilla 浏览器
   http_request = new XMLHttpRequest();
   if (http_request.overrideMimeType) {//设置MiME类别
    http_request.overrideMimeType('text/xml');
   }
  }
  else if (window.ActiveXObject) { // IE浏览器
   try {
    http_request = new ActiveXObject("Msxml2.XMLHTTP");
   } catch (e) {
    try {
     http_request = new ActiveXObject("Microsoft.XMLHTTP");
    } catch (e) {}
   }
  }
  if (!http_request) { // 异常，创建对象实例失败
   window.alert("The database is empty.");
   return false;
  }
 
  switch(method){
  case 1: http_request.onreadystatechange = processRequestQuery;break;//选择操作函数
  case 2: http_request.onreadystatechange = processRequestAct;break;
  case 3: http_request.onreadystatechange = processRequestTar;break;
  case 4: http_request.onreadystatechange = processRequestTarCont;break;
  }
  // 确定发送请求的方式和URL以及是否同步执行下段代码
  http_request.open("GET", url, false);
  http_request.send(null);
 }
 
 // 处理返回信息的函数
 function processRequestQuery() {//操作函数
 	if (http_request.readyState == 4) { // 判断对象状态
 		if (http_request.status == 200) { // 信息已经成功返回，开始处理信息
  			document.getElementById("statusTxt").innerHTML="";
  			addOptionGroup("values",http_request.responseText);
           } else { //页面不正常
           	alert("您所请求的页面有异常。");
           }
       	}else {//只要未读取完成
    document.getElementById("statusTxt").innerHTML="In Process……";
  }
 }
 
 // 处理返回信息的函数
 function processRequestAct() {//操作函数
 	if (http_request.readyState == 4) { // 判断对象状态
 		if (http_request.status == 200) { // 信息已经成功返回，开始处理信息
  			document.getElementById("statusTxt").innerHTML="";
  			addOptionGroup("tri",http_request.responseText);
           } else { //页面不正常
           	alert("您所请求的页面有异常。");
           }
       	}else {//只要未读取完成
    document.getElementById("statusTxt").innerHTML="In Process……";
  }
 }
 
 // 处理返回信息的函数
 function processRequestTar() {//操作函数
 	if (http_request.readyState == 4) { // 判断对象状态
 		if (http_request.status == 200) { // 信息已经成功返回，开始处理信息
  			document.getElementById("statusTxt").innerHTML="";
  			addOptionGroup("deft",http_request.responseText);
           } else { //页面不正常
           	alert("您所请求的页面有异常。");
           }
       	}else {//只要未读取完成
    document.getElementById("statusTxt").innerHTML="In Process……";
  }
 }  
 
 // 处理返回信息的函数
 function processRequestTarCont() {//操作函数
 	if (http_request.readyState == 4) { // 判断对象状态
 		if (http_request.status == 200) { // 信息已经成功返回，开始处理信息
  			document.getElementById("statusTxt").innerHTML="";
  			addOptionGroup("cont",http_request.responseText);
           } else { //页面不正常
           	alert("您所请求的页面有异常。");
           }
       	}else {//只要未读取完成
    document.getElementById("statusTxt").innerHTML="In Process……";
  }
 } 
 
 //	载入值
 function loadValues(typeString,valueString) {
	var con = typeString;
	var conVal = valueString;
	
 	send_request("ComboProcess?type="+con+"&id="+conVal,1);//服务端处理程序,操作函数
 	
 }
 
 //	载入值
 function loadTriggers(typeString,valueString) {
	var act = typeString;
	var actVal = valueString;
	
 	send_request("ComboProcess?type="+act+"&id="+actVal,2);//服务端处理程序,操作函数
 	
 }
 
 //	载入值
 function loadDeftype(typeString,valueString) {
	var tar = typeString;
	var cont = typeString + "cont";
	var tarVal = valueString;
	
 	send_request("ComboProcess?type="+tar+"&id="+tarVal,3);//服务端处理程序,操作函数
 	send_request("ComboProcess?type="+cont+"&id="+tarVal,4);
 }
 
 //	载入值
 function loadContype(typeString,valueString) {
	var tar = typeString;
	var cont = typeString + "cont";
	var tarVal = valueString;
	
 	//send_request("ComboProcess?type="+tar+"&id="+tarVal,3);//服务端处理程序,操作函数
 	send_request("ComboProcess?type="+cont+"&id="+tarVal,4);
 } 
 
 //	添加单个option
 function addOption(objSelectNow,txt,val)
 {
  /// 使用W3C标准语法为SELECT添加Option
  var objOption = document.createElement("OPTION");
  objOption.text= txt;
  objOption.value=val;
  objSelectNow.options.add(objOption);
 }
 
 // 添加组
 function addOptionGroup(selectId,optGroupString)
 {
  var optGroup = optGroupString.split("-");

  var objSelect = document.getElementsByTagName("SELECT");
  var objSelectNow = objSelect[selectId];
  objSelectNow.length = 0;
  //objSelectNow.option.remove(0);
  //objSelectNow.options[objSelectNow.selectedIndex].selected=false;
  /// 成组添加Options
  for (i=0; i<(optGroup.length-1)/2; i++)
  {
   addOption(objSelectNow, optGroup[2*i], optGroup[2*i+1]);
  }
 }
 

 
