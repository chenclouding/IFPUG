var yicunzai="已存在"

/*************************************************************************************************/
			function Add(leftsel,rightsel,stroe) {
			   //alert('add');
  				allRoles = document.getElementById(leftsel);
  				selectids = document.getElementById(stroe);
  				selectRoles = document.getElementById(rightsel);
  				for(var i =0;i<allRoles.options.length;i++){
  					if(allRoles.options[i].selected==true){
  						var ifExit = false;
  						for(var n =0;n<selectRoles.options.length;n++){
  							if(selectRoles.options[n].value == allRoles.options[i].value){
  								ifExit = true;
  							}
  						}
  						if(ifExit == false){
  							selectRoles.add( new Option(allRoles.options[i].text,allRoles.options[i].value));
  						}else{
  							alert(yicunzai);
  						}
  						allRoles.remove(i);
  						i--;
  					}
  				}
  				id="";
  				for(var m =0;m<selectRoles.options.length;m++){
  					id+=selectRoles.options[m].value +",";
  				}
  				selectids.value=id;
			}
			function Remove(leftsel,rightsel,stroe) {
			    //alert('remove');
				selectids = document.getElementById(stroe);
  				allRoles = document.getElementById(leftsel);
  				selectRoles = document.getElementById(rightsel);
  				for(var i =0;i<selectRoles.options.length;i++){
  					if(selectRoles.options[i].selected==true){
  						allRoles.add( new Option(selectRoles.options[i].text,selectRoles.options[i].value));
  						selectRoles.remove(i);
  						i--;
  					}
  				}
  				id="";
  				for(var m =0;m<selectRoles.options.length;m++){
  					id+=selectRoles.options[m].value +",";
  				}
  				selectids.value=id;
			}
		
		/**************************/
		
   function loadselect(all,old,store){

                var all = document.getElementById(all);
  				var old = document.getElementById(old);
  				
  				for(var i =0;i<all.options.length;i++){
  				 
  				  var item=all.options[i].value;
  				
  				     for(var m =0;m<old.options.length;m++){
  					
  					   if(item==old.options[m].value){
  					     all.remove(i);
  					     i--;
  					   }				
  				     }
  				} 
  				
  				var stor=document.getElementById(store);
  				var id="";
  			    for(var j =0;j<old.options.length;j++){
  					id+=old.options[j].value +",";
  				}
  				stor.value=id;
 											
}	

		 
/*************************************************************************************************/

function addCaseStep(sTable){
   // alert('aa');
   
    var insertBtn =document.getElementById("insertprocessbtn");
    var editBtn = document.getElementById("editprocessbtn");
    var delBtn = document.getElementById("delprocessbtn");
    insertBtn.style.display = "none";
     editBtn.style.display = "none";
      delBtn.style.display = "none";
      
      showStrutBtn('1');
	var oTable=document.getElementById(sTable);
	if (!oTable)
	  return -1;
	 // alert(oTable.rows.length);	

	
	var oTr=oTable.insertRow(oTable.rows.length);
	//alert(oTable.rows.length);
	//oTr.setAttribute("width","5%");
	oTr.setAttribute("align","center");

    var rowindex = oTable.rows.length-1;
    var index=rowindex-1;
    var  stepnum=index+1;
    oTr.setAttribute("number",rowindex);
	oTr.id="casestep"+stepnum;
   // alert(stepnum);
    
	//
	var oTd0 = oTr.insertCell(0);
	oTd0.setAttribute("width","5%");
	oTd0.setAttribute("align","center");
	oTd0.innerHTML="<input type=\"checkbox\" onclick=\"getSelectRow(event.srcElement,document.all.selectrow)\"  value=\""+stepnum+"\" name=\"selprocess"+index+"\" id=\"selprocess\"  >  "+"<input  type=\"hidden\" name=\"stepForm["+index+"].stepnum\" value=\"\">" +"<INPUT  type=\"hidden\" name=\"stepForm["+index+"].id\" value=\"\" >";
	//
	var oTd1 = oTr.insertCell(1);
    oTd1.setAttribute("width","5%");
	oTd1.innerHTML=stepnum;
	
	//	
	var oTd2 = oTr.insertCell(2);
    oTd2.setAttribute("width","27%");
	oTd2.innerHTML="<TEXTAREA name=\"stepForm["+index+"].teststep\" maxlength=\"1024\" style=\"behavior:url(../htc/maxlength.htc)\" onchange=\"limitarea(this,1024)\" ></TEXTAREA>";
	
	//
		var oTd3 = oTr.insertCell(3);
oTd3.setAttribute("width","23%");
oTd3.setAttribute("align","center");
	oTd3.innerHTML="<TEXTAREA name=\"stepForm["+index+"].condition\" maxlength=\"332\" style=\"behavior:url(../htc/maxlength.htc)\"  onchange=\"limitarea(this,332)\" ></TEXTAREA>";
	
			var oTd4 = oTr.insertCell(4);
oTd4.setAttribute("width","26%");
oTd4.setAttribute("align","center");
	oTd4.innerHTML="<TEXTAREA name=\"stepForm["+index+"].resuexpect\" maxlength=\"332\" style=\"behavior:url(../htc/maxlength.htc)\" onchange=\"limitarea(this,332)\" ></TEXTAREA>";
	
				var oTd5 = oTr.insertCell(5);
oTd5.setAttribute("width","14%");
oTd5.setAttribute("align","center");
	oTd5.innerHTML="<input style=\"width:50\" type=\"button\" onclick=\"deleteCaseStepClient('processelisttable',event.srcElement)\"  class=btn_mouseout onmouseover=\"this.className='btn_mouseover'\" onmouseout=\"this.className='btn_mouseout'\" value=\"取消\" name=\"delbtn\" >";
	
}
function editCaseStep(sForm){




var objForm=document.forms[sForm];
if(!objForm){
return false;
}

var num=0;
var  elt ;
for (var fld = 0; fld < objForm.elements.length; fld++) {
 elt = objForm.elements[fld];
 if (elt.type == "checkbox"){
   if(elt.checked){
     // alert(elt.value);
     num++;

   }
 }
}

if(num==0){
   alert("请选择步骤");
   
   return false;
}
var operator=document.getElementById("operator");
operator.value="edit";

for (var fld = 0; fld < objForm.elements.length; fld++) {
 elt = objForm.elements[fld];
 if (elt.type == "checkbox"){
   if(elt.checked){
     // alert(elt.value);
      var index =elt.value-1;
      var  elenstep="stepForm["+index+"].teststep";
      var  elencondition="stepForm["+index+"].condition";
      var  elenresu="stepForm["+index+"].resuexpect";
      var  step=document.getElementById(elenstep);
      step.disabled="";
      var  condition=document.getElementById(elencondition);
      condition.disabled="";
      var  result=document.getElementById(elenresu);
      result.disabled="";
   }
 }
}


    var insertBtn =document.getElementById("insertprocessbtn");
    var addBtn = document.getElementById("addprocessbtn");
    var delBtn = document.getElementById("delprocessbtn");
    insertBtn.style.display = "none";
     addBtn.style.display = "none";
      delBtn.style.display = "none";
      
      showStrutBtn(sForm);

}



function insertCaseStep(sForm,sTable){



  var num=0; //????CHECKBOX???
  var insertnum; //??????
  var objForm=document.forms[sForm];
  if(!objForm){
      return false;
  }
  var  elt ;
  for (var fld = 0; fld < objForm.elements.length; fld++) {
    elt = objForm.elements[fld];
    if (elt.type == "checkbox"){
      if(elt.checked){
         num++;
         insertnum = elt.value;
         elt.value =parseInt(elt.value)+1; //???????
   }
 }
}
if(num>1){

  alert("只能请选择一个步骤");
			
			return false;
}
if(num==0){

  alert("  请选择步骤 ");
			
			return false;
}
    var editBtn =document.getElementById("editprocessbtn");
    var addBtn = document.getElementById("addprocessbtn");
    var delBtn = document.getElementById("delprocessbtn");
    editBtn.style.display = "none";
     addBtn.style.display = "none";
      delBtn.style.display = "none";
      
      showStrutBtn(sForm);
//alert(insertnum);
var oTable=document.getElementById(sTable);
var oldlength=oTable.rows.length;
insertRowInTable(sTable,insertnum);

var operator=document.getElementById("operator");

operator.value="insert";


var length = oTable.rows.length;
for(var iNum =parseInt(insertnum);iNum<oldlength;iNum++){
       //alert('casestep'+iNum);
    	var oTr=oTable.rows[iNum+1]; 
          oTr.cells[1].innerHTML=iNum+1;
          var index=iNum-1;


}

}



function insertRowInTable(sTable,iNum){
	var oTable=document.getElementById(sTable);
	if (!oTable)
	  return -1;
	  
	var oTr=oTable.insertRow(iNum);

	oTr.setAttribute("align","center");

    var rowindex = oTable.rows.length-1;
    var index=rowindex-1;
    var  stepnum=index+1;
    oTr.setAttribute("number",rowindex);
	oTr.id="casestep"+stepnum;
   
    
	//
	var oTd0 = oTr.insertCell(0);
	oTd0.setAttribute("width","5%");
	oTd0.setAttribute("align","center");
	oTd0.innerHTML="<input onclick=\"getSelectRow(event.srcElement,document.all.selectrow)\" type=\"checkbox\" value=\""+iNum+"\" name=\"selprocess"+index+"\" id=\"selprocess\"  >  "+"<input  type=\"hidden\" name=\"stepForm["+index+"].stepnum\" value=\""+iNum+"\">" +"<INPUT  type=\"hidden\" name=\"stepForm["+index+"].id\" value=\"\" >";
	//
	var oTd1 = oTr.insertCell(1);
    oTd1.setAttribute("width","5%");
	oTd1.innerHTML=iNum;
	
	//	
	var oTd2 = oTr.insertCell(2);
    oTd2.setAttribute("width","27%");
	oTd2.innerHTML="<TEXTAREA name=\"stepForm["+index+"].teststep\" maxlength=\"1024\" style=\"behavior:url(../htc/maxlength.htc)\"  onchange=\"limitarea(this,1024)\" ></TEXTAREA>";
	
	//
	var oTd3 = oTr.insertCell(3);
    oTd3.setAttribute("width","23%");
    oTd3.setAttribute("align","center");
	oTd3.innerHTML="<TEXTAREA name=\"stepForm["+index+"].condition\" maxlength=\"332\" style=\"behavior:url(../htc/maxlength.htc)\"  onchange=\"limitarea(this,332)\" ></TEXTAREA>";
	
	var oTd4 = oTr.insertCell(4);
    oTd4.setAttribute("width","26%");
    oTd4.setAttribute("align","center");
	oTd4.innerHTML="<TEXTAREA name=\"stepForm["+index+"].resuexpect\" maxlength=\"332\" style=\"behavior:url(../htc/maxlength.htc)\"  onchange=\"limitarea(this,332)\" ></TEXTAREA>";
	
	var oTd5 = oTr.insertCell(5);
    oTd5.setAttribute("width","14%");
   oTd5.setAttribute("align","center");
//	oTd5.innerHTML="<img border=\"0\" src=\"../images/delete.gif\" width=\"18\" height=\"18\"  onclick=\"deleteCaseStepClient('processelisttable',event.srcElement)\">";
	oTd5.innerHTML="<input style=\"width:50\" type=\"button\" onclick=\"deleteCaseStepClient('processelisttable',event.srcElement)\"  class=btn_mouseout onmouseover=\"this.className='btn_mouseover'\" onmouseout=\"this.className='btn_mouseout'\" value=\"取消\" name=\"delbtn\" >";


}

function deleteCaseStepClient(sTable,obj){


var oTable=document.getElementById(sTable);
if (!oTable)
 return -1;

 var delnum=obj.parentNode.parentElement.sectionRowIndex;
 oTable.deleteRow(delnum);
 var length = oTable.rows.length;
 for(var iNum =parseInt(delnum);iNum<length;iNum++){
    	var oTr=oTable.rows[iNum]; 
        oTr.cells[1].innerHTML=iNum;
}
}

function  deleteCaseStep(sTable,sForm,action){


  var num=0; //????CHECKBOX???
  var stepids=""; //??????
  var objForm=document.forms[sForm];
  if(!objForm){
      return false;
  }
  var  elt ;
  for (var fld = 0; fld < objForm.elements.length; fld++) {
    elt = objForm.elements[fld];
    if (elt.type == "checkbox"){
      if(elt.checked){
         num++;
         var iDel = parseInt(elt.value)-1;
         var oName = "stepForm["+iDel+"].id";
         var oStepid= document.getElementById(oName);
         stepids = stepids+oStepid.value+",";
        
   }
 }
}

if(num==0){

  alert("  请选择步骤 ");
			
			return false;
}
    var editBtn =document.getElementById("editprocessbtn");
    var addBtn = document.getElementById("addprocessbtn");
    var insertBtn = document.getElementById("insertprocessbtn");
    editBtn.style.display = "none";
     addBtn.style.display = "none";
      insertBtn.style.display = "none";
      
      showStrutBtn(sForm);
   //alert(stepids);
   document.forms[0].action=action+"&stepids="+stepids;
   document.forms[0].submit();


}


function saveCaseStep(sForm){

var objForm=document.forms[sForm];
if(!objForm){
return false;
}
//alert('submit');
document.forms[sForm].submit();
}

function showStrutBtn(sForm){

  	var objForm=document.forms[sForm];
    if(!objForm){
    return false;
    }
    
    var  elt ;
    for (var fld = 0; fld < objForm.elements.length; fld++) {
       elt = objForm.elements[fld];
      if (elt.type == "submit"){

            elt.style.display="";
 }
}
    
}

/*************************************************************************************************/
function checkNull(theObj)
{
	if(typeof(theObj.value)!="undefined"&&theObj.value!="")
	{
		
		return true;
	}
	return false;
}
/*************************************************************************************************/
function checkCasepoint(name){

var theForm = document.forms[name];

var importance= document.getElementById("importance");
var level= document.getElementById("level");
var attribute= document.getElementById("attribute");
var  userrole = document.getElementById("userrole"); 
var  testdevice  = document.getElementById("testcircument");
var  productcircu  = document.getElementById("productcircu");
var  testdescr   = document.getElementById("testdescr");
var  condiprefix = document.getElementById("condiprefix");
var  testdata = document.getElementById("testdata");
var  resuexpect = document.getElementById("resuexpect");
var  infodeal = document.getElementById("infodeal");
var  descr = document.getElementById("descr");
var  testpath= document.getElementById("testpath");

		if((!checkNull(importance))||(!checkNull(level))||(!checkNull(attribute))||(!checkNull(userrole)) || (!checkNull(testdevice)) || (!checkNull(productcircu)) ||(!checkNull(testdescr))  ||(!checkNull(condiprefix))  || (!checkNull(testdata)) || (!checkNull(resuexpect)) ||(!checkNull(testpath)))
		{
			//alert("please set caseinfo before add proeccss ?");
			
			return false;
		}
	
		//Pub.submitAction('Form1','addcase.do');
		
		document.forms[0].submit();
		

}
/*************************************************************************************************/
function checkInsertCasepoint(name,value){

var theForm = document.forms[name];

var importance= document.getElementById("importance");
var level= document.getElementById("level");
var attribute= document.getElementById("attribute");
var  userrole = document.getElementById("userrole"); 
var  testdevice  = document.getElementById("testcircument");
var  productcircu  = document.getElementById("productcircu");
var  testdescr   = document.getElementById("testdescr");
var  condiprefix = document.getElementById("condiprefix");
var  testdata = document.getElementById("testdata");
var  resuexpect = document.getElementById("resuexpect");
var  infodeal = document.getElementById("infodeal");
var  descr = document.getElementById("descr");
var  testpath= document.getElementById("testpath");

		if((!checkNull(importance))||(!checkNull(level))||(!checkNull(attribute))||(!checkNull(userrole)) || (!checkNull(testdevice)) || (!checkNull(productcircu)) ||(!checkNull(testdescr))  ||(!checkNull(condiprefix))  || (!checkNull(testdata)) || (!checkNull(resuexpect)) ||(!checkNull(testpath)))
		{
			//alert("please set caseinfo before add proeccss ?");
			
			return false;
		}
	
		document.forms[0].action="insertcase.do?caseid="+value;
		document.forms[0].submit();
}

/*************************************************************************************************/
function getObjArray( obj ) {
 var arrRtn = new Array();
 if ( typeof eval( obj ) == "object" ) {
  if ( typeof eval( obj + ".length" ) == "number" ) {
   for ( var i = 0 ; i < eval( obj ).length ; i++ ) {
    arrRtn[ arrRtn.length ] = eval( obj )[ i ];
   }
  } else {
   arrRtn[ 0 ] = eval( obj );
  }
 }
 return arrRtn;
}

function getSelectRow(obj){


//alert(obj.parentNode.parentElement.sectionRowIndex);

obj.value=obj.parentNode.parentElement.sectionRowIndex;

}

/*****************************************************************************************************/
//open sized window
function openWindow(sHref,strWidth,strHeight) {
  var strLeft=(screen.availWidth-strWidth)/2;
  var strTop=(screen.availHeight-strHeight)/2;
  var strRef="";
  strRef=strRef+"width="+strWidth+"px,height="+strHeight+"px,";
  strRef=strRef+"left="+strLeft+"px,top="+strTop+"px,";
  strRef=strRef+"resizable=no,scrollbars=yes,status=yes,toolbar=no,systemmenu=no,location=no,borderSize=thin";//channelmode,fullscreen
 
  var openerobj= window.open(sHref,'newwin',strRef,false);
  openerobj.focus();
}

function  openWindowWithName(sHref,strWidth,strHeight,sName){

  var strLeft=(screen.availWidth-strWidth)/2;
  var strTop=(screen.availHeight-strHeight)/2;
  var strRef="";
  strRef=strRef+"width="+strWidth+"px,height="+strHeight+"px,";
  strRef=strRef+"left="+strLeft+"px,top="+strTop+"px,";
  strRef=strRef+"resizable=no,scrollbars=yes,status=yes,toolbar=no,systemmenu=no,location=no,borderSize=thin";//channelmode,fullscreen

  window.open(sHref,sName,strRef,false);
  
}
function refreshOpener(sHref){

    opener.location.href=sHref;
    window.close ();
}










































