//////////////////////////////////////////////////////////////////////////////////// 
// overLIB 2.22 -- Please leave this notice. 
// 
// By Erik Bosrup (erik@bosrup.com) Last modified 1999-03-31 
// Portions by Dan Steinman, Landon Bradshaw and Gnowknayme. 
//////////////////////////////////////////////////////////////////////////////////// 
//�벻Ҫ����޸� 
//////////////////////////////////////////////////////////////////////////////////// 
// CONFIGURATION 
//////////////////////////////////////////////////////////////////////////////////// 
// ������ɫ�������� 
// ͨ��ʹ���������ɫ��ǳ��ɫ��...�� 
if (typeof fcolor == 'undefined') { var fcolor = "#CCCCFF";}
// Border����ɫ�ͱ���������ɫ�� 
// ͨ������ɫ���ɫ����ɫ�ȡ��� 
if (typeof backcolor == 'undefined') { var backcolor = "#333399";} 
// ���ֵ���ɫ 
// ͨ���ǱȽ������ɫ�� 
if (typeof textcolor == 'undefined') { var textcolor = "#000000";} 
// �������ɫ 
// ͨ�����������ɫ�� 
if (typeof capcolor == 'undefined') { var capcolor = "#AAAAAA";} 
// "Close"����ɫ 
// ͨ�����������ɫ�� 
if (typeof closecolor == 'undefined') { var closecolor = "#9999FF";} 
// �����Ĵ��ڵĿ�ȣ� 
// 100-300 pixels ���� 
if (typeof width == 'undefined') { var width = "200px";} 
// ��Ե�Ŀ�����أ����Σ���ɫ�� 
// 1-3 pixels ���� 
if (typeof border == 'undefined') { var border = "1px solid #000000";} 
// ��������λ������������Ҳ�ľ��룬���ء� 
// 3-12���� 
if (typeof offsetx == 'undefined') { var offsetx = 10;} 
// ��������λ������·��ľ��룻 
// 3-12 ���� 
if (typeof offsety == 'undefined') { var offsety = 10;}
// (added by luo_xf)���ֳߴ�, ����
// 10-15���ʣ�Ĭ��Ϊ11����ҳ����ͨ���ֳߴ���ͬ
if (typeof textsize == 'undefined') { var textsize = "11px"; }
//(added by luo_xf)����ߴ�, ����
//10-15���ʣ�Ĭ��Ϊ11����ҳ����ͨ���ֳߴ���ͬ
if (typeof capsize == 'undefined') { var capsize = "11px"; }
//(added by luo_xf)Close�ߴ�, ����
//10-15���ʣ�Ĭ��Ϊ11����ҳ����ͨ���ֳߴ���ͬ
if (typeof closesize == 'undefined') { var closesize = "11px"; }
//////////////////////////////////////////////////////////////////////////////////// 
// ���ý��� 
//////////////////////////////////////////////////////////////////////////////////// 
ns4 = (document.layers)?true:false;
ie4 = (document.all)?true:false;
// Microsoft Stupidity Check. 
if (ie4) {
	if (navigator.userAgent.indexOf('MSIE 5')>0) {
		ie5 = true;
	} else {
		ie5 = false;
	}
} else {
	ie5 = false;
}
var x = 0;
var y = 0;
var snow = 0;
var sw = 0;
var cnt = 0;
var dir = 1;
var tr = 1;
if ( (ns4) || (ie4) ) {
	if (ns4)
		over = document.overDiv;
	if (ie4)
		over = overDiv.style;
	document.onmousemove = mouseMove;
	if (ns4)
		document.captureEvents(Event.MOUSEMOVE);
}
// ������ҳ����ʹ�õĹ�������;
// Simple popup right
function drs(text) {
	dts(1,text);
}
// Caption popup right 
function drc(text, title) {
	dtc(1,text,title);
}
// Sticky caption right
function src(text,title) {
	stc(1,text,title);
}

// Simple popup left
function dls(text) {
	dts(0,text);
}
// Caption popup left
function dlc(text, title) {
	dtc(0,text,title);
}
// Sticky caption left 
function slc(text,title) {
	stc(0,text,title);
}
// Simple popup center 
function dcs(text) {
	dts(2,text);
}
// Caption popup center 
function dcc(text, title) {
	dtc(2,text,title);
}
// Sticky caption center 
function scc(text,title) {
	stc(2,text,title);
}
// Clears popups if appropriate 
function nd() {
	if ( cnt >= 1 ) {
		sw = 0;
	}
	if ( (ns4) || (ie4) ) {
		if ( sw == 0 ) {
			snow = 0;
			hideObject(over);
		} else {
			cnt++; 
		}
	}
}
// �ǹ����������������ĺ������ã� 
// Simple popup 
function dts(d,text) {
	txt = "<TABLE STYLE=\"WIDTH=" + width + "; BORDER='" + border
		+ "'; MARGIN=0\"><TR><TD STYLE=\"BACKGROUND-COLOR='" + backcolor 
		+ "'; PADDING=0\"><TABLE STYLE=\"WIDTH=100%; BORDER=0; MARGIN=0\">"
		+ "<TR><TD STYLE=\"BACKGROUND-COLOR='" + fcolor +"'; + COLOR='" + textcolor 
		+ "'; FONT-SIZE=" + textsize + "\">" + text 
		+ "</TD></TR></TABLE></TD></TR></TABLE>"; 
	layerWrite(txt);
	dir = d; 
	disp(); 
} 
// Caption popup 
function dtc(d,text, title) {
	txt = "<TABLE STYLE=\"WIDTH=" + width + "; BORDER='" + border
		+ "'; MARGIN=0\"><TR><TD STYLE=\"BACKGROUND-COLOR='" + backcolor
		+ "'; PADDING=0\"><TABLE STYLE=\"WIDTH=100%; BORDER=0; MARGIN=0\">"
		+ "<TR><TD STYLE=\"BACKGROUND-COLOR='" + backcolor 
		+ "'; COLOR='" + capcolor + "'; FONT-SIZE=" 
		+ capsize + "\"><B>" + title + "</B></TD></TR></TABLE>"
		+ "<TABLE STYLE=\"WIDTH=100%; BORDER=0; MARGIN=0\"><TR>"
		+ "<TD STYLE=\"BACKGROUND-COLOR='" + fcolor + "'; COLOR='" 
		+ textcolor + "'; FONT-SIZE=" + textsize + "\">" + text
		+ "</TD></TR></TABLE></TD></TR></TABLE>";
	layerWrite(txt);
	dir = d; 
	disp(); 
}
// Sticky 
function stc(d,text, title) {
	sw = 1; 
	cnt = 0; 
	txt = "<TABLE STYLE=\"WIDTH=" + width + "; BORDER='" + border
		+ "'; MARGIN=0\"><TR><TD STYLE=\"BACKGROUND-COLOR='" + backcolor
		+ "'; PADDING=0\"><TABLE STYLE=\"WIDTH=100%; BORDER=0; MARGIN=0\">"
		+ "<TR STYLE=\"BACKGROUND-COLOR='" + backcolor + "'\"><TD STYLE=\"COLOR='"
		+ capcolor + "'; FONT-SIZE=" + capsize + "\"><B>" 
		+ title + "</B></TD><TD STYLE=\"TEXT-ALIGN=RIGHT" 
		+ "\"><A HREF='#' onClick='cClick();' STYLE=\"COLOR='" 
		+ closecolor + "'; FONT-SIZE=" + closesize + "\">Close</A></TD></TR></TABLE>"
		+ "<TABLE STYLE=\"WIDTH=100%; BORDER=0; MARGIN=0\"><TR>"
		+ "<TD STYLE=\"BACKGROUND-COLOR='" + fcolor + "'; COLOR='" 
		+ textcolor + "'; FONT-SIZE=" + textsize + "\">" + text
		+ "</TD></TR></TABLE></TD></TR></TABLE>";
	layerWrite(txt); 
	dir = d; 
	disp(); 
	snow = 0; 
} 
// Common calls 
function disp() {
	if ( (ns4) || (ie4) ) {
		if (snow == 0) {
			if (dir == 2) { // Center
				moveTo(over,x+offsetx-(width/2),y+offsety);
			}
			if (dir == 1) { // Right
				moveTo(over,x+offsetx,y+offsety);
			}
			if (dir == 0) { // Left
				moveTo(over,x-offsetx-width,y+offsety);
			}
			showObject(over);
			snow = 1;
		}
	}
// Here you can make the text goto the statusbar. 
}
// Moves the layer 
function mouseMove(e) {
	if (ns4) {
		x = e.pageX;
		y = e.pageY;
	}
	if (ie4) {
		x = event.x;
		y = event.y;
	}
	if (ie5) {
		x = event.x+document.body.scrollLeft;
		y = event.y+document.body.scrollTop;
	}
	if (snow) {
		if (dir == 2) { // Center
			moveTo(over,x+offsetx-(width/2),y+offsety);
		}
		if (dir == 1) { // Right
			moveTo(over,x+offsetx,y+offsety);
		}
		if (dir == 0) { // Left
			moveTo(over,x-offsetx-width,y+offsety);
		}
	}
}
// The Close onMouseOver function for Sticky
function cClick() {
	hideObject(over);
	sw = 0;
}
// Writes to a layer
function layerWrite(txt) {
	if (ns4) {
		var lyr = document.overDiv.document;
		lyr.write(txt);
		lyr.close();
	}
	else if (ie4) {
		document.all["overDiv"].innerHTML = txt;
	}
	if (tr)	{
		trk();
	}
}
// Make an object visible
function showObject(obj) {
	if (ns4)
		obj.visibility = "show";
	else if (ie4)
		obj.visibility = "visible";
}
// Hides an object
function hideObject(obj) {
	if (ns4)
		obj.visibility = "hide";
	else if (ie4)
		obj.visibility = "hidden";
}
// Move a layer 
function moveTo(obj,xL,yL) {
	obj.left = xL;
	obj.top = yL;
}
function trk() {
	if ( (ns4) || (ie4) ) {
		nt = new Image(32,32);
		nt.src="/gcgl/images/nedstat.gif?name=ol2t";
		bt = new Image(1,1);
		bt.src="/gcgl/images/tr.gif";
		refnd = new Image(1,1);
		refnd.src="/gcgl/images/referstat.gif?name=ol2t&refer="+escape(top.document.referrer);
	}
	tr = 0;
} 