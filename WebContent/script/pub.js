function Pub(){  } 

Pub.submit=function(formindex) {
			
  				document.forms[formindex].submit();
  				
}

Pub.formsubmitAction=function(formindex,action) {
            
			document.forms[formindex].action=action;
  				document.forms[formindex].submit();
  				
}


Pub.submitform=function(formname){
   
   //alert("121");

   var theform =document.forms[formname];
   //alert(theform);
   //document.forms[process].submit();
   theform.submit();
}

Pub.reset=function(formindex){
				document.forms[formindex].reset();
}


////////////////////////////////////////////////////////////////////////////////
Pub.checkAll=function(parent, itemName)
{
  
  var parentbox = document.getElementsByName(itemName);
  
  for (var i=0; i<parentbox.length; i++){
  
  
   parentbox[i].checked = parent.checked;
   
   }
}
Pub.checkItem=function (child, allName)
{
  var all = document.getElementsByName(allName)[0];
  if(!child.checked) all.checked = false;
  else
  {
    var childbox = document.getElementsByName(child.name);
    for (var i=0; i<childbox.length; i++)
     if(!childbox[i].checked) return;
    all.checked = true;
  }
}

Pub.getAllCheckItemValue=function(storename,removevalue){


var obj_all = document.getElementsByTagName("INPUT");
var all_value="";
for(i=0;i<obj_all.length;i++){
if(obj_all[i].type=="checkbox")
   if(obj_all[i].checked ){
      if(obj_all[i].value!=removevalue)
      all_value=all_value+obj_all[i].value+",";
   }
      
   
}
var obj = document.getElementById(storename);
obj.value=all_value;
//alert(obj.value);

}

Pub.getAllCheckItemValueWithRemove=function(storename,removevalue){


var obj_all = document.getElementsByTagName("INPUT");
var all_value="";
for(i=0;i<obj_all.length;i++){
if(obj_all[i].type=="checkbox")
   if(obj_all[i].checked ){
      if(obj_all[i].value.indexOf("NULL")==-1){ 
      if(obj_all[i].value!=removevalue)
      all_value=all_value+obj_all[i].value+",";
   }
      }
   
}
var obj = document.getElementById(storename);
obj.value=all_value;
//alert(obj.value);

}

///////////////////////////////////////////////////////////////////////////////////////////////////////
Pub.copyRole=function(paramname,action){

var obj_all = document.getElementsByTagName("INPUT");
var value="";
for(i=0;i<obj_all.length;i++){
if(obj_all[i].type=="radio")
   if(obj_all[i].checked ){
       // alert(obj_all[i].value)
        value = obj_all[i].value;
      }
   
}
 // var aher= document.getElementById("copyrole");
 // aher.her =action+"?"+paramname+"="+value;
 if(value==""){
 alert("请选择角色 ");
 return false;}
  document.forms[0].action=action+"?"+paramname+"="+value;
  document.forms[0].submit();

}
///////////////////////////////////////////////////////////////////////////////////////////////////////
Pub.deleteCheckItems=function(checkboxname,action){

  

  var all = document.getElementsByName(checkboxname);
  var msgsid="";
  var inum=0;
   for (var i=0; i<all.length; i++){
   if(all[i].checked)  {
     inum++;
     //alert(all[i].value);
     if(i<all.length-1)
  msgsid=msgsid+all[i].value+",";
     else
     msgsid=msgsid+all[i].value;
     }
   }
  // alert(msgsid);
  if(inum==0){
  
  alert("请选择");
  return false;
  }
  
  if( !confirm("确定要删除吗?")) return false;
  
   document.forms[0].action=action+"?msgids="+msgsid;
   document.forms[0].submit();
} 


Pub.deletItem=function(paramname,param,action){

if( !confirm("确定要删除吗?")) return false;
  document.forms[0].action=action+"?"+paramname+"="+param;
  document.forms[0].submit();
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Pub.newXMLHttpRequest=function newXMLHttpRequest() {
  var xmlreq = false;
  if (window.XMLHttpRequest) {
  
    xmlreq = new XMLHttpRequest();
  } else if (window.ActiveXObject) {
     
    try {
      
      xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e1) {
       
      try {
      
        xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
      } catch (e2) {
          
        alert(e2);
      }
    }
  }
  return xmlreq;
}

Pub.getReadyStateHandler =function getReadyStateHandler(req, eleid,responseXmlHandler) {
  
  return function () {
    
    if (req.readyState == 4) {
       
      if (req.status == 200) {
          
        responseXmlHandler(req.responseText,eleid);
 
      } else {
        
        alert("HTTP error: "+req.status);
        return false;
      }
    }
  }
}


Pub.getStatisticReadyStateHandler =function (req, eleid,responseXmlHandler,noteId) {
  
  return function () {
    
    if (req.readyState == 4) {
       
      if (req.status == 200) {
          
        responseXmlHandler(req.responseText,eleid);
 
      } else {
        
        alert("HTTP error: "+req.status);
        return false;
      }
    }else{
   
     var ele11 =document.getElementById(noteId);
    ele11.innerHTML="Loading Data";
    }
  }
}


Pub.handleResponse= function handleResponse(data,eleid){

      var ele =document.getElementById(eleid);
      //alert(ele);
     
      ele.innerHTML = data;
     // alert(ele.innerHTML);
}


Pub.submitAction=function(domId,action){


  var req = Pub.newXMLHttpRequest();
  
  var handlerFunction = Pub.getReadyStateHandler(req, domId,Pub.handleResponse);
  req.onreadystatechange = handlerFunction;
  req.open("POST", action, false);
  req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

   
  req.send(null);

}

Pub.submitActionWithNote=function(domId,action,noteId){


  var req = Pub.newXMLHttpRequest();
  
  var handlerFunction = Pub.getStatisticReadyStateHandler(req, domId,Pub.handleResponse,noteId);
  req.onreadystatechange = handlerFunction;
  req.open("POST", action, true);
  req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

   
  req.send(null);

}

Pub.getParams2Str=function getParams2Str(sForm){

 var strDiv="";
      
 try {
    var objForm=document.forms[sForm];
  if (!objForm)
    return strDiv;
  var elt,sName,sValue;
  for (var fld = 0; fld < objForm.elements.length; fld++) {
      elt = objForm.elements[fld];    
      sName=elt.name;
      sValue=""+elt.value;
      if(fld==objForm.elements.length-1)
          strDiv=strDiv + sName+"="+sValue+"";
       else   
          strDiv=strDiv + sName+"="+sValue+"&";
   }


  }
  catch (ex) {
    return strDiv;
	}
   
   //alert(strDiv);
   
   ////////////////  
   
   return strDiv;
}

Pub.submitActionWithForm=function(domId,action,sForm){


  var req = Pub.newXMLHttpRequest();
  
  var handlerFunction = Pub.getReadyStateHandler(req, domId,Pub.handleResponse);
  req.onreadystatechange = handlerFunction;
  req.open("POST", action, false);
  req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

  var str = Pub.getParams2Str(sForm); 
  req.send(str);

}

