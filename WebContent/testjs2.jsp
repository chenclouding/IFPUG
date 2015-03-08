
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html>

<head>

<title>I think - Interactive DHTML art-demos</title>

<meta name="Author" content="Gerard Ferrandez at http://www.dhteumeuleu.com">

<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style type="text/css">

	html {

		font:"微软雅黑";

		overflow: hidden;

	}

	body {

		font:"微软雅黑";

		margin: 0px;

		padding: 0px;

		background:url(2.jpg);

		background-repeat:no-repeat;

		position: absolute;

		width: 100%;

		height: 100%;

		cursor: crosshair;

	}

	#canvas {

		font:"微软雅黑";

		position:absolute;

		left: 0%;

		top: 0%;

		width: 100%;

		height: 100%;

		 

		background-repeat: no-repeat;

		overflow: hidden;

	}

	#canvas span {

		font:"微软雅黑";

		position: absolute;

		color:    #FFF;

		font-family: arial, helvetica, verdana, sans-serif;

		white-space: nowrap;

		font-size: 0.8em;

	}

	#menu {

		font:"微软雅黑";

		display: none;

	}

	

	span#meg{

		font-size:16px;

		color: #FF0; 

		font-weight:600;

		position:absolute;

		display:block;

		font-family:"微软雅黑;"

	}

	

	span#megg{

		font-size:32px;

		color:   #994D00; 

		font-weight:600;

		position:absolute;

		display:block;

		font-family:"微软雅黑;"

	}

</style>



<script type="text/javascript" src="svgvml.js"></script>





<script type="text/javascript">

// =================================================================

//           =====  SVG/VML vector menu  =====

// script written by Gerard Ferrandez - Ge-1-doot - June 28, 2006

// http://www.dhteumeuleu.com

// =================================================================



document.onselectstart = new Function("return false;");



function resize() {

	var s = document.getElementById("canvas");

	nw = s.offsetWidth;

	nh = s.offsetHeight;

}

onresize = resize;



document.onmousemove = function(e) {

	if (window.event) e=window.event;

	xm = (e.x || e.clientX);

	ym = (e.y || e.clientY);

}



//////////////////////////////////////////////////////////



m = {

	O : [],

	svg : 0,

	xm : 0,

	ym : 0,

	nw : 0,

	nh : 0,

	X : 0,

	Y : 0,

	X0 : 0,

	Y0 : 0,

	ox : 0,

	oy : 0,

	drag : false,

	Odraged : 0,

	ks : 0,

	////////////////////////////////////////////

	FR : 2,       // friction

	vL : 300,     // default length

	vR : 1.80,    // reduction ratio

	cC : "#69F ",  // 要展开的圈的颜色

	cP : "#3CF",  // default  node

	cE : " #FF0",  // 展开后的圆

	cL : "#36F",  // lines

	sT : "#000",  // stroke

	sS : "#3C3",  // 圈圈的颜色

	tX : "#CCC",  // text

	tS : "#C90",  // text selected

	sP : 15,      // dot size

	rS : .002,    // rotation speed

	////////////////////////////////////////////



	CreateNode : function (parent, label, col, link, title ) {

		/* ==== init variables ==== */

		this.title=title;

		this.link = link;

		this.col = col;

		this.pR = 0;

		this.len = 0;

		this.len_ini = 0;

		this.lex = 0;

		this.angle = 0;

		this.angle_ini = 0;

		this.expanded = false;

		this.children = [];

		this.parent = parent;

		this.parent_ini = parent;

		this.visible = false;

		this.x = 0;

		this.y = 0;

		

		if (parent != "") {

			/* ==== push child ==== */

			parent.children.push(this);

			/* ==== calculate lengths & angles ==== */

			var a = (2 * Math.PI) / parent.children.length;

			var b = (parent != "") ? Math.random():0;

			for (var i in parent.children) {

				with (parent.children[i]) {

					angle = angle_ini = Math.PI / 2 + a * i + b;

					if(title=="-")

					{

						len_ini =len = parent.len_ini / (m.vR-0.7);

					}

					else

					{

						len = len_ini = parent.len_ini / m.vR;

					}

				}

			}

		} else {

			/* ==== root ==== */

			this.visible = true;

			this.len_ini = m.vL * m.vR;	

		}

	

		/* ==== create line & text elements ==== */

		this.line = m.svg.createLine(2, m.cL);

		this.text = document.createElement("span"); 

		this.text.onmousedown = function() { return false; };

		this.text.appendChild(document.createTextNode(label));

		this.text.style.color = m.tX;

		document.getElementById("canvas").appendChild(this.text);



		/* ==== main animation loop ==== */

		this.run = function () {

			with (this) {   

				if (visible) {

					/* ==== parent coordinates ==== */

					xp = parent ? parent.x : m.X;

					yp = parent ? parent.y : m.Y;

					/* ==== trigonometry ==== */

					var a = Math.atan2((y + Math.sin(angle + m.ks) * m.FR) - yp, (x + Math.cos(angle + m.ks) * m.FR) - xp);

					if (lex < len) lex += (len - lex) * .1;

					x = xp + Math.cos(a) * lex;

					y = yp + Math.sin(a) * lex;

					/* ==== screen limits ==== */

					if (x < pR) x = pR; else if (x > nw - pR) x = nw - pR;

					if (y < pR) y = pR; else if (y > nh - pR) y = nh - pR;

					/* ==== move elements ==== */

					line.move(x, y, xp, yp);

					plot.move(x, y, pR);

					text.style.left = Math.round(x + pR + 5) + "px";

					text.style.top = Math.round(y - pR / 1.8) + "px";

				}

			}

		}

	

		/* ==== collapse node ==== */

		this.collapse = function () {

			with (this) {

				expanded = false;

				text.style.color = m.tX;

				plot.fill_color((children.length) ? m.cC : col);

				for (var i=0; i<children.length; i++) {

					with (children[i]) {

						visible = false;

						lex = 0;

						line.move(-1, -1, -1, -2);

						plot.move(-1000, -1, 0);

						text.style.left = "-1000px";

						expanded = false;

						collapse();

					}

				}

			}

		}

		

		/* ==== expand node ==== */

		this.expand = function () {

			with (this) {

				/* ==== close all other branchs ==== */

				if (parent_ini != "")

					for (var i=0; i<parent_ini.children.length; i++)

						parent_ini.children[i].collapse();

				/* ==== expand ==== */

				expanded = true;

				text.style.color = m.tS;

				plot.fill_color(m.cE);

				for (var i=0; i<children.length; i++) {

					children[i].visible = true;

					children[i].lex = 0;

				}

			}

		}

	},



	/* ==== mouse down event ==== */

	mousedown : function() {

		var o = this.obj;

		/* ==== cursor ==== */

		o.plot.style.cursor = "move";

		document.body.style.cursor = "move";

		/* ==== offset mouse ==== */

		m.ox = xm - o.x;

		m.oy = ym - o.y;

		m.X0 = xm;

		m.Y0 = ym;

		if (!m.drag) {

			m.drag = true;

			/* ==== change root ==== */

			if (m.Odraged != o) {

				/* ==== reset ==== */

				for (var i in m.O) {

					with (m.O[i]) {

						parent = parent_ini;

						len    = len_ini;

						lex    = len_ini;

						angle  = angle_ini;

					}

				}

				/* ==== search for root path ==== */

				var oc = [];

				var ow = o;

				oc.push(ow);

				while(ow.parent != "") {

					ow = ow.parent;

					oc.push(ow);

				}

				/* ==== inverse vectors ==== */

				for (var i=1; i<oc.length; i++) {

					oc[i].lex    = oc[i-1].len_ini;

					oc[i].len    = oc[i-1].len_ini;

					oc[i].angle  = oc[i-1].angle_ini - Math.PI;

					oc[i].parent = oc[i-1];

				}

				/* ==== switch root ==== */

				o.parent = "";

				o.len = 0;

				o.lex = 0;

				o.angle = 0;

				m.Odraged.plot.stroke_color(m.sT);

				m.Odraged.plot.stroke_weight(1);

				m.Odraged = o;

			}

			return false;

		}

	},



	/* ==== mouse up event ==== */

	mouseup : function() {

		m.drag = false;

		/* ==== cursor ==== */

		m.Odraged.plot.style.cursor = "pointer";

		document.body.style.cursor = "crosshair";

		/* ==== click ==== */

		if (Math.abs(m.X + m.ox - m.X0) < 5 && Math.abs(m.Y + m.oy - m.Y0) < 5) {

			if (this.obj.link) {

				/* ==== open hyperlink ==== */

				window.open(this.obj.link, "_blank");

			} else {

				/* ==== expand / collapse ==== */

				if (this.obj.expanded) this.obj.collapse(); else this.obj.expand();

			}

		}

		return false;

	},



	/* ==== mouse over event ==== */

	mouseover : function() {

		this.stroke_color(m.sS);

		this.stroke_weight(Math.round(Math.max(2, this.obj.pR / 3)));

		var imf=document.createElement("span");

		imf.id="meg";

		var tt=document.createTextNode(this.obj.title);

		imf.appendChild(tt);

		document.getElementById("canvas").appendChild(imf);

		if(window.event) e=window.event;

		xx=(e.x||e.clentX);

		yy=(e.y||e.clientY);

		imf.style.left=xx+"px";

		imf.style.top=yy+"px";

		

		//alert(xx);

		return false;

	},



	/* ==== mouse out event ==== */

	mouseout : function() {

		if (this.obj != m.Odraged) {

			this.stroke_color(m.sT);

			this.stroke_weight(1);

		}

		var li=document.getElementById("meg");

		document.getElementById("canvas").removeChild(li);

		

		

		return false;

	},



	/* ==== motion thread ==== */

	run : function () {

		if (m.drag) m.X = xm - m.ox, m.Y = ym - m.oy;

		m.ks += m.rS;

		for (var i in m.O) m.O[i].run();

	},



	/* ==== parse menu DOM ==== */

	setMenuTree : function (theNode, parent) {

		if (theNode.tagName == "DIV" || theNode.tagName == "A") {

			/* ==== Node Label ==== */

			var s = theNode.innerHTML;

			var d = s.toUpperCase().indexOf("<DIV");

			if (d > 0) s = s.substring(0, d);

			d = s.toUpperCase().indexOf("<A");

			if (d > 0) s = s.substring(0, d);

			/* ==== create Node ==== */

			if(theNode.style.color != "") m.cP = theNode.style.color;

			parent = new m.CreateNode(parent, s, m.cP, theNode.href,theNode.title);

			/* ==== push Node ==== */

			m.O.push(parent);

		}

		/* ==== recursive call ==== */

		for (var i = 0; i < theNode.childNodes.length; i++)

			m.setMenuTree(theNode.childNodes[i], parent);

	},



	/* ==== init menu ==== */

	init : function() {

		m.vL = nh / 4;

		m.X = nw / 2;

		m.Y = nh / 2;

		m.setMenuTree(document.getElementById("menu"), "");

	

		/* ==== create plots (no z-index in SVG!) ==== */

		for (var i in m.O) {

			m.O[i].pR = Math.round(Math.max(5, m.sP * m.O[i].len_ini / 200));

			m.O[i].plot = m.svg.createOval(m.O[i].pR * 2, true);

			m.O[i].plot.stroke_color(m.sT);

			m.O[i].plot.stroke_weight(1);

			m.O[i].plot.obj = m.O[i];

			m.O[i].plot.onmousedown = m.mousedown;

			m.O[i].plot.onmouseup = m.mouseup;

			m.O[i].plot.onmouseover = m.mouseover;

			m.O[i].plot.onmouseout = m.mouseout;

			m.O[i].plot.onclick = function() { return false; };

			m.O[i].text.style.fontSize = (4 + m.O[i].pR) + "px";

		}

	

		/* ==== expand 1st Node ==== */

		m.Odraged = m.O[0];

		m.O[0].collapse();

		m.O[0].expand();

	}

}



onload = function() {



	/* ==== initial size ==== */

	resize();

	/* ==== create SVGVML container ==== */

	m.svg = new vectorGraphics(document.getElementById("canvas"), false);

	if (m.svg) {

		/* ==== init menu ==== */

		m.init();

		setInterval(m.run, 16);

	}

	

	var imff=document.createElement("span");

		imff.id="megg";

		var ttt=document.createTextNode("欢迎光临人大经济论坛");

		imff.appendChild(ttt);

		document.getElementById("canvas").appendChild(imff);



		imff.style.left=50+"px";

		imff.style.top=50+"px";



}



</script>



</head>



<body  >

<div id="canvas"  > </div>



<div id="menu" style="color: #00FF40" >评谷

			

			<a  href="http://bbs.pinggu.org" title="国内最大的经管类在线学习与讨论网站"   >人大经济论坛</a>

			<a  href="http://www.pinggu.name"  title="经管人的网络社交平台"    >三人行</a>

			<a href="http://www.pinggu.com"  title="中高端网络社交平台"    >评谷俱乐部</a>

			<a href="http://zhaopin.pinggu.org"    >求职招聘</a>

        <div title="-" style="color:  #F00">论坛培训

			<a href="http://baoming.pinggu.org"   >统计软件培训</a>

            <a href="http://www.jinduoduo.org"   >金融培训</a>

            <a href="http://kaoyan.pinggu.org/baoming"   >考研培训</a>

            <a href="http://zhukuai.pinggu.org"   >注会培训</a>

		</div>

        <a href="http://i.pinggu.org"   style="color: #00FF40">经管微博</a>

        	 <a href="http://www.goodfor.com.cn"  title="欢迎商家合作入驻"  style="color: #00FF40">论坛商城</a>

       		 <a href="http://prj.pinggu.org"   style="color: #00FF40" >项目交易</a>

        <div title="-" style="color:  #F00">论坛产品

			<a href="http://product.pinggu.org"   >经管期刊信息大全</a>

            <a href="http://anli.pinggu.org"   >案例库</a>

		</div>

        <a href="http://wiki.pinggu.org"   style="color: #00FF40">经管百科</a>

        <a href="http://qikan.pinggu.org"  style="color: #00FF40" >经管期刊网</a>	

        	<a href="http://news.pinggu.org"  style="color: #00FF40" >热点财经新闻评论</a>

        <div title="-" style="color:  #F00">论坛服务

        

        	<a href="http://check.pinggu.org"   >论文检测</a>

			<a href="http://bbs.pinggu.org/z_chuli.php"   >数据处理与分析</a>

            <a href="http://bbs.pinggu.org/z_baoming.php"   >数据定制</a>

            <a href="http://bbs.pinggu.org/z_vip.php"   >VIP服务 </a>

            <a href="http://bbs.pinggu.org/buy.php"   >贵宾服务</a>

            <a href="http://product.pinggu.org/service_guanggao.html"   >广告宣传</a>

            <a href="http://product.pinggu.org/service_wangluojianshe.html"   >网络建设 </a>

		</div>

        	<a href="http://dayi.pinggu.org"   style="color: #00FF40" >有偿答疑</a>

        	<a href="http://bbs.pinggu.org/forumdisplay.php?fid=73&filter=type&typeid=1113" style="color: #00FF40"  >学习系统</a>

            <a href="http://v.pinggu.org"  style="color: #00FF40" >经管视频</a>

        <div title="-"  style="color:  #F00">评价系统

			<a href="http://bbs.pinggu.org/z_zixun_qikan.php" >期刊</a>

            <a href="http://bbs.pinggu.org/z_zixun_gaoxiao.php" >高校</a>

            <a href="http://bbs.pinggu.org/z_zixun_zhengshu.php" >证书</a>

            <a href="http://bbs.pinggu.org/z_zixun_huiyi.php" >会议</a>

            <a href="http://bbs.pinggu.org/z_zixun_tiku.php" >题库</a>

            <a href="http://bbs.pinggu.org/z_zixun_shijian.php" >大事记</a>

            <a href="http://bbs.pinggu.org/z_zixun_jiaoshi.php" >教师</a>

            <a href="http://bbs.pinggu.org/z_daohang.php" >网址</a>

            <a href="http://bbs.pinggu.org/z_zixun_danwei.php" >就业单位</a>

            <a href="http://bbs.pinggu.org/z_wenxian.php" >经典文献</a>

            <a href="http://bbs.pinggu.org/z_soft.php" >经管软件</a>

            <a href="http://bbs.pinggu.org/z_jiangzuo.php" >学术讲座</a>

            <a href="http://bbs.pinggu.org/z_keti.php" >基金课题</a>

		</div>

       

</div>

</body>

</html>
