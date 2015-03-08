//Contents for menu 1
var menu1=new Array()
menu1[0]='<a href="/gcgl/PP/pp.jsp" target="_self">项目策划</a>'
menu1[1]='<a href="/gcgl/PMC/pmc.jsp" target="_self">项目监督与控制</a>'
menu1[2]='<a href="/gcgl/IPM/ipm.jsp" target="_self">集成项目管理</a>'
menu1[3]='<a href="/gcgl/QPM/qpm.jsp" target="_self">定量项目管理</a>'
menu1[4]='<a href="/gcgl/SAM/sam.jsp" target="_self">供应商协议管理</a>'
menu1[5]='<a href="/gcgl/RSKM/rskm.jsp" target="_self">风险管理</a>'
 
//Contents for menu 2, and so on
var menu2=new Array()
menu2[0]='<a href="/gcgl/OPD/OPD.jsp" target="_self">组织过程定义</a>'
menu2[1]='<a href="/gcgl/OPP/opp.jsp" target="_self">组织过程性能</a>'
menu2[2]='<a href="/gcgl/OPF/OPF.jsp" target="_self">组织过程焦点</a>'
menu2[3]='<a href="/gcgl/OID/OID.jsp" target="_self">组织革新与部署</a>'
menu2[4]='<a href="/gcgl/OT/ot.jsp" target="_self">组织培训</a>'

var menu3=new Array()
menu3[0]='<a href="/gcgl/REQM/reqm.jsp" target="_self">需求管理</a>'
menu3[1]='<a href="/gcgl/RD/rd.jsp" target="_self">需求开发</a>'
menu3[2]='<a href="/gcgl/TS/ts.jsp" target="_self">技术解决方案</a>'
menu3[3]='<a href="/gcgl/PI/pi.jsp" target="_self">产品集成</a>'
menu3[4]='<a href="/gcgl/VER/ver.jsp" target="_self">验证</a>'	
menu3[5]='<a href="/gcgl/VAL/val.jsp" target="_self">确认</a>'	
	
var menu4=new Array()
menu4[0]='<a href="/gcgl/MA/ma.jsp" target="_self">度量与分析</a>'
menu4[1]='<a href="/gcgl/PPQA/ppqa.jsp" target="_self">过程与产品质量保证</a>'
menu4[2]='<a href="/gcgl/CM/cm.jsp" target="_self">配置管理</a>'
menu4[3]='<a href="/gcgl/DAR/dar.jsp" target="_self">决策分析与解决方案</a>'
menu4[4]='<a href="/gcgl/CAR/car.jsp" target="_self">原因分析与解决方案</a>'
 
 
	
var menuwidth='165px' //default menu width
var menubgcolor=' #e7f3f8'  //menu bgcolor lightyellow #ddffdd
var disappeardelay=250  //menu disappear speed onMouseout (in miliseconds)
var hidemenu_onclick="yes" //hide menu when user clicks within menu?

/////No further editting needed

var ie4=document.all
var ns6=document.getElementById&&!document.all

if (ie4||ns6)
document.write('<div id="dropmenudiv" style="visibility:hidden;width:'+menuwidth+';background-color:'+menubgcolor+'" onMouseover="clearhidemenu()" onMouseout="dynamichide(event)"></div>')

function getposOffset(what, offsettype){
var totaloffset=(offsettype=="left")? what.offsetLeft : what.offsetTop;
var parentEl=what.offsetParent;
while (parentEl!=null){
totaloffset=(offsettype=="left")? totaloffset+parentEl.offsetLeft : totaloffset+parentEl.offsetTop;
parentEl=parentEl.offsetParent;
}
return totaloffset;
}


function showhide(obj, e, visible, hidden, menuwidth){
if (ie4||ns6)
dropmenuobj.style.left=dropmenuobj.style.top="-500px"
if (menuwidth!=""){
dropmenuobj.widthobj=dropmenuobj.style
dropmenuobj.widthobj.width=menuwidth
}
if (e.type=="click" && obj.visibility==hidden || e.type=="mouseover")
obj.visibility=visible
else if (e.type=="click")
obj.visibility=hidden
}

function iecompattest(){
return (document.compatMode && document.compatMode!="BackCompat")? document.documentElement : document.body
}

function clearbrowseredge(obj, whichedge){
var edgeoffset=0
if (whichedge=="rightedge"){
var windowedge=ie4 && !window.opera? iecompattest().scrollLeft+iecompattest().clientWidth-15 : window.pageXOffset+window.innerWidth-15
dropmenuobj.contentmeasure=dropmenuobj.offsetWidth
if (windowedge-dropmenuobj.x < dropmenuobj.contentmeasure)
edgeoffset=dropmenuobj.contentmeasure-obj.offsetWidth
}
else{
var topedge=ie4 && !window.opera? iecompattest().scrollTop : window.pageYOffset
var windowedge=ie4 && !window.opera? iecompattest().scrollTop+iecompattest().clientHeight-15 : window.pageYOffset+window.innerHeight-18
dropmenuobj.contentmeasure=dropmenuobj.offsetHeight
if (windowedge-dropmenuobj.y < dropmenuobj.contentmeasure){ //move up?
edgeoffset=dropmenuobj.contentmeasure+obj.offsetHeight
if ((dropmenuobj.y-topedge)<dropmenuobj.contentmeasure) //up no good either?
edgeoffset=dropmenuobj.y+obj.offsetHeight-topedge
}
}
return edgeoffset
}

function populatemenu(what){
if (ie4||ns6)
dropmenuobj.innerHTML=what.join("")
}


function dropdownmenu(obj, e, menucontents, menuwidth){
if (window.event) event.cancelBubble=true
else if (e.stopPropagation) e.stopPropagation()
clearhidemenu()
dropmenuobj=document.getElementById? document.getElementById("dropmenudiv") : dropmenudiv
populatemenu(menucontents)

if (ie4||ns6){
showhide(dropmenuobj.style, e, "visible", "hidden", menuwidth)
dropmenuobj.x=getposOffset(obj, "left")
dropmenuobj.y=getposOffset(obj, "top")
dropmenuobj.style.left=dropmenuobj.x-clearbrowseredge(obj, "rightedge")+"px"
dropmenuobj.style.top=dropmenuobj.y-clearbrowseredge(obj, "bottomedge")+obj.offsetHeight+"px"
}

return clickreturnvalue()
}

function clickreturnvalue(){
if (ie4||ns6) return false
else return true
}

function contains_ns6(a, b) {
while (b.parentNode)
if ((b = b.parentNode) == a)
return true;
return false;
}

function dynamichide(e){
if (ie4&&!dropmenuobj.contains(e.toElement))
delayhidemenu()
else if (ns6&&e.currentTarget!= e.relatedTarget&& !contains_ns6(e.currentTarget, e.relatedTarget))
delayhidemenu()
}

function hidemenu(e){
if (typeof dropmenuobj!="undefined"){
if (ie4||ns6)
dropmenuobj.style.visibility="hidden"
}
}

function delayhidemenu(){
if (ie4||ns6)
delayhide=setTimeout("hidemenu()",disappeardelay)
}

function clearhidemenu(){
if (typeof delayhide!="undefined")
clearTimeout(delayhide)
}

if (hidemenu_onclick=="yes")
document.onclick=hidemenu


