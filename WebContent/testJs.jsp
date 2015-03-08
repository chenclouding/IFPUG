<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.*" %>
<%@ page import="hibernate.IFPUG.*" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
<html xmlns="http://www.w3.org/1999/xhtml">  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
<title>����</title>  
<script type="text/javascript" language="javascript" src="raphael.js"></script>
<script type="text/javascript" language="javascript" src="jquery-1.4.2.js"></script>
  
<script type="text/javascript" language="javascript">  
    //���������߷���  
    Raphael.fn.connection = function (obj1, obj2, line, bg) {  
        if (obj1.line && obj1.from && obj1.to) {  
            line = obj1;  
            obj1 = line.from;  
            obj2 = line.to;  
        }  
        var bb1 = obj1.getBBox(),  
            bb2 = obj2.getBBox(),  
            p = [{x: bb1.x + bb1.width / 2, y: bb1.y - 1},  
            {x: bb1.x + bb1.width / 2, y: bb1.y + bb1.height + 1},  
            {x: bb1.x - 1, y: bb1.y + bb1.height / 2},  
            {x: bb1.x + bb1.width + 1, y: bb1.y + bb1.height / 2},  
            {x: bb2.x + bb2.width / 2, y: bb2.y - 1},  
            {x: bb2.x + bb2.width / 2, y: bb2.y + bb2.height + 1},  
            {x: bb2.x - 1, y: bb2.y + bb2.height / 2},  
            {x: bb2.x + bb2.width + 1, y: bb2.y + bb2.height / 2}],  
            d = {}, dis = [];  
        for (var i = 0; i < 4; i++) {  
            for (var j = 4; j < 8; j++) {  
                var dx = Math.abs(p[i].x - p[j].x),  
                    dy = Math.abs(p[i].y - p[j].y);  
                if ((i == j - 4) || (((i != 3 && j != 6) || p[i].x < p[j].x) && ((i != 2 && j != 7) || p[i].x > p[j].x) && ((i != 0 && j != 5) || p[i].y > p[j].y) && ((i != 1 && j != 4) || p[i].y < p[j].y))) {  
                    dis.push(dx + dy);  
                    d[dis[dis.length - 1]] = [i, j];  
                }  
            }  
        }  
        if (dis.length == 0) {  
            var res = [0, 4];  
        } else {  
            res = d[Math.min.apply(Math, dis)];  
        }  
        var x1 = p[res[0]].x,  
            y1 = p[res[0]].y,  
            x4 = p[res[1]].x,  
            y4 = p[res[1]].y;  
        dx = Math.max(Math.abs(x1 - x4) / 2, 10);  
        dy = Math.max(Math.abs(y1 - y4) / 2, 10);  
        var x2 = [x1, x1, x1 - dx, x1 + dx][res[0]].toFixed(3),  
            y2 = [y1 - dy, y1 + dy, y1, y1][res[0]].toFixed(3),  
            x3 = [0, 0, 0, 0, x4, x4, x4 - dx, x4 + dx][res[1]].toFixed(3),  
            y3 = [0, 0, 0, 0, y1 + dy, y1 - dy, y4, y4][res[1]].toFixed(3);  
        var path = ["M", x1.toFixed(3), y1.toFixed(3), "C", x2, y2, x3, y3, x4.toFixed(3), y4.toFixed(3)].join(",");  
        if (line && line.line) {  
            line.bg && line.bg.attr({path: path});  
            line.line.attr({path: path});  
        } else {  
            var color = typeof line == "string" ? line : "#000";  
            return {  
                bg: bg && bg.split && this.path(path).attr({stroke: bg.split("|")[0], fill: "none", "stroke-width": bg.split("|")[1] || 3}),  
                line: this.path(path).attr({stroke: color, fill: "none"}),  
                from: obj1,  
                to: obj2  
            };  
        }  
    }; 
    //�����ݿ����ӻ�ȡ����Դ���趨���� 
    Raphael.fn.drawNodes = function(){
    	   	
    	for( var i = 0; i < length; i ++) {    	    	    	
    		Raphael.fn.createShape(i);    	
    	}   	
    	Raphael.fn.connectLine();
    };
    
    
    //����ÿ����ε���״����3�㣩��Σ�type
    Raphael.fn.createShape = function(i){
    		var w_en = 120, h_en = 50;    		
    		var width, height;
    		if (type[i].valueOf() == "0") //��һ��,width����һ��ĵڼ���
    		{
    			width = 80 + w_en * level1;
    			height = 40;
    			level1 ++;   			
    		}
    		else if(type[i].valueOf() == "1"){ //�ڶ���
    			width = 80 + w_en * level2;
    			height = 80 + h_en * 1;
    			level2 ++;
    		}
    		else { //������
    			width = 80 + w_en * level3;
    			height = 160 + h_en * 2;
    			level3 ++;    			
    		}
    		nodes[i] = paper.circle(width,height,20);  
        	nodes[i].attr({fill: "#99CC33",stroke: "none"});  
        	nodeName = paper.text(width,height,"A" + (i + 1)); //��ͼ������ʾ���� ��availableAttrs�������С��
        	//�������
       		nodes[i].hover(function (event) {
       			text = paper.text(45 + width,60 + height,"���ƣ�"+name[i]+"\nL:3  M:12  H:13");
       			this.attr({fill: "red"});
       		}, function (event) {
       			this.attr({fill: "#99CC33"});
       			text.hide();
       		});    	
    };
    
    	//��������ͼ��֮�������    
     Raphael.fn.connectLine = function(){
     	//��һ������洢����ͼ�ζ���������ʹ��connection����������Ҫ���ӵ�ͼ������������
     	var j = 0;
     	for (var i = 0; i < 3; i ++)
     	{
     		paper.connection(nodes[i], nodes[3], "#000");
     		paper.connection(nodes[i], nodes[4], "#000");
     		paper.connection(nodes[i], nodes[5], "#000");
     	}
     	for (var i = 3; i < 6; i ++)
     	{
     		paper.connection(nodes[i], nodes[6], "#000");
     		paper.connection(nodes[i], nodes[7], "#000");
     		paper.connection(nodes[i], nodes[8], "#000");
     	}
     };
    
  
    //����  
    var paper; 
    var nodes = new Array(["����ԭ��1","0"],["����ԭ��2","0"],["����ԭ��3","0"],["���1","1"],["���2","1"],["���3","1"],["�Ľ�1","2"],["�Ľ�2","2"],["�Ľ�3","2"]); //����ڵ���� 
    var length = 9;
    var nodeName;
    var connection;//���� 
    var text; 
    
    var name = new Array(); //�ڵ�����
    var type = new Array(); 
    var level1 = 0, level2 = 0, level3 = 0; //����Ŀǰ���ڼ���ĵڼ����ڵ�
  
    //��ʼ������   
    window.onload = function(){  
        paper = Raphael("canvasDiv", 659, 400);  //���ȡ����
        for(var i = 0; i < length; i ++) {   
        	name.push(nodes[i][0]);
        	type.push(nodes[i][1]);
        }      
        //alert(name.toString());
        //alert(type.valueOf());
        paper.drawNodes();
    }  
   
</script>  
<style type="text/css">  
<!--  
#canvasDiv {  
    position:absolute;  
    left:200px;  
    top:102px;  
    width:659px;  
    height:400px;  
    z-index:1;  
    background-color: white;   //���屳����ɫ
}  
  
-->  
</style>  
</head>  
  
<body>  
<div>
<h1>ͼ��</h1>
</div> 
<div id="canvasDiv"></div> 
</body>  
</html>  