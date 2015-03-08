// Ajax.js for implement of Multiple combo

/**
 * ajax��ˢ�¶������������˵�
 *
 * @author      leehon and arcow <arcow@126.com>
 * @version     1.0
 * @lastupdate  2005-12-29
 *
 */
 
 var http_request = false;
 
 //��ʼ����ָ������������������ĺ���
 function send_request(url,method) {
 
  http_request = false;
  
  //��ʼ��ʼ��XMLHttpRequest����
  if(window.XMLHttpRequest) { //Mozilla �����
   http_request = new XMLHttpRequest();
   if (http_request.overrideMimeType) {//����MiME���
    http_request.overrideMimeType('text/xml');
   }
  }
  else if (window.ActiveXObject) { // IE�����
   try {
    http_request = new ActiveXObject("Msxml2.XMLHTTP");
   } catch (e) {
    try {
     http_request = new ActiveXObject("Microsoft.XMLHTTP");
    } catch (e) {}
   }
  }
  if (!http_request) { // �쳣����������ʵ��ʧ��
   window.alert("The database is empty.");
   return false;
  }
 
  switch(method){
  case 1: http_request.onreadystatechange = processRequestQuery;break;//ѡ���������
  case 2: http_request.onreadystatechange = processRequestAct;break;
  case 3: http_request.onreadystatechange = processRequestTar;break;
  case 4: http_request.onreadystatechange = processRequestTarCont;break;
  }
  // ȷ����������ķ�ʽ��URL�Լ��Ƿ�ͬ��ִ���¶δ���
  http_request.open("GET", url, false);
  http_request.send(null);
 }
 
 // ��������Ϣ�ĺ���
 function processRequestQuery() {//��������
 	if (http_request.readyState == 4) { // �ж϶���״̬
 		if (http_request.status == 200) { // ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
  			document.getElementById("statusTxt").innerHTML="";
  			addOptionGroup("values",http_request.responseText);
           } else { //ҳ�治����
           	alert("���������ҳ�����쳣��");
           }
       	}else {//ֻҪδ��ȡ���
    document.getElementById("statusTxt").innerHTML="In Process����";
  }
 }
 
 // ��������Ϣ�ĺ���
 function processRequestAct() {//��������
 	if (http_request.readyState == 4) { // �ж϶���״̬
 		if (http_request.status == 200) { // ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
  			document.getElementById("statusTxt").innerHTML="";
  			addOptionGroup("tri",http_request.responseText);
           } else { //ҳ�治����
           	alert("���������ҳ�����쳣��");
           }
       	}else {//ֻҪδ��ȡ���
    document.getElementById("statusTxt").innerHTML="In Process����";
  }
 }
 
 // ��������Ϣ�ĺ���
 function processRequestTar() {//��������
 	if (http_request.readyState == 4) { // �ж϶���״̬
 		if (http_request.status == 200) { // ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
  			document.getElementById("statusTxt").innerHTML="";
  			addOptionGroup("deft",http_request.responseText);
           } else { //ҳ�治����
           	alert("���������ҳ�����쳣��");
           }
       	}else {//ֻҪδ��ȡ���
    document.getElementById("statusTxt").innerHTML="In Process����";
  }
 }  
 
 // ��������Ϣ�ĺ���
 function processRequestTarCont() {//��������
 	if (http_request.readyState == 4) { // �ж϶���״̬
 		if (http_request.status == 200) { // ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
  			document.getElementById("statusTxt").innerHTML="";
  			addOptionGroup("cont",http_request.responseText);
           } else { //ҳ�治����
           	alert("���������ҳ�����쳣��");
           }
       	}else {//ֻҪδ��ȡ���
    document.getElementById("statusTxt").innerHTML="In Process����";
  }
 } 
 
 //	����ֵ
 function loadValues(typeString,valueString) {
	var con = typeString;
	var conVal = valueString;
	
 	send_request("ComboProcess?type="+con+"&id="+conVal,1);//����˴������,��������
 	
 }
 
 //	����ֵ
 function loadTriggers(typeString,valueString) {
	var act = typeString;
	var actVal = valueString;
	
 	send_request("ComboProcess?type="+act+"&id="+actVal,2);//����˴������,��������
 	
 }
 
 //	����ֵ
 function loadDeftype(typeString,valueString) {
	var tar = typeString;
	var cont = typeString + "cont";
	var tarVal = valueString;
	
 	send_request("ComboProcess?type="+tar+"&id="+tarVal,3);//����˴������,��������
 	send_request("ComboProcess?type="+cont+"&id="+tarVal,4);
 }
 
 //	����ֵ
 function loadContype(typeString,valueString) {
	var tar = typeString;
	var cont = typeString + "cont";
	var tarVal = valueString;
	
 	//send_request("ComboProcess?type="+tar+"&id="+tarVal,3);//����˴������,��������
 	send_request("ComboProcess?type="+cont+"&id="+tarVal,4);
 } 
 
 //	��ӵ���option
 function addOption(objSelectNow,txt,val)
 {
  /// ʹ��W3C��׼�﷨ΪSELECT���Option
  var objOption = document.createElement("OPTION");
  objOption.text= txt;
  objOption.value=val;
  objSelectNow.options.add(objOption);
 }
 
 // �����
 function addOptionGroup(selectId,optGroupString)
 {
  var optGroup = optGroupString.split("-");

  var objSelect = document.getElementsByTagName("SELECT");
  var objSelectNow = objSelect[selectId];
  objSelectNow.length = 0;
  //objSelectNow.option.remove(0);
  //objSelectNow.options[objSelectNow.selectedIndex].selected=false;
  /// �������Options
  for (i=0; i<(optGroup.length-1)/2; i++)
  {
   addOption(objSelectNow, optGroup[2*i], optGroup[2*i+1]);
  }
 }
 

 
