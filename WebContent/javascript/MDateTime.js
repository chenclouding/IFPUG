////////////////////////////////////////////////////////////////////////////////////////////////////
///// MDateTime.js
///// created by Eric 2006-08-23
/////


////////////////////////////////////////////////////////////////////////////////////////////////////
///// 由加载该 JavaScript 的页面调用
/////
///// 传入参数：页面上的一个可以显示文本的控件（可以有初始时间）
///// 返回结果: 用选择的日期时间，设置显示控件的文本
/////
function SetMDateTime(sText)
{
		// 显示页面及相关设置
		var sPath = "/gcgl/VER/MDateTimePage.html";
		var strFeatures = "dialogWidth=206px;dialogHeight=245px;center=yes;help=no;status=No;";
		
		// 传入的初始化日期时间
		var strDateTimeInput = sText.value;                     // 得到初始化的时间(由页面得到当前时间)
		strDateTimeInput = FormatDateTime(strDateTimeInput);    // 转化成 yyyy/mm/dd 的格式
		
		// 调出页面，得到选择的日期和时间
		var mDateTimeSelected = showModalDialog(sPath, strDateTimeInput, strFeatures);
															//
															// showModalDialog 可以认为是 JavaScript 的一个系统调用
															// 利用其弹出另外的显示框
															// 信息参见 study-info 下的文档
															//
		sText.value = GetDateTime(mDateTimeSelected);   // 将日期时间转化为字符串
		
}
////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////
///// 将初始化日期时间的格式转化为一定的格式
///// yyyy-mm-dd ??? ----->  yyyy/mm/dd ???
/////
function FormatDateTime(strInput)
{
		var str = strInput;
		var strPart = str.split('-');
		var strResult = "";
		
		for (var i=0; i < strPart.length; ++i)
		{
				strResult += strPart[i];
				
				if (i < (strPart.length - 1))
				{
						// 非最后一个，加上 /
						strResult += " / ";
						
				}
				
		}  // end for
		
		return strResult;
		
}
////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////
///// 将日期时间转化为字符串
///// 最后的格式 : yyyy-mm-dd hh:mm:ss
/////
function GetDateTime(dtGet)
{
		var strResult = "";
		
		var nDate = new Date(dtGet);
		if (nDate == "NaN")
		{
				// 转化失败，返回空串
				return strResult;
				
		}
		
		// 得到日期、时间的各个数值
		var iYear = nDate.getFullYear();
		var iMonth = nDate.getMonth() + 1;     // 特殊
		// var iDay = nDate.getDay();          // 星期中的第几天, Sunday --- 0 , Monday --- 1 , ...
		var iDay = nDate.getDate();            // 注意 Day 与 Date 的区别 !!!
		var iHour = nDate.getHours();
		var iMinutes = nDate.getMinutes();     // Date 的信息，参考 study-info 下的 JavaScript-Date对象
	//	var iSecond = nDate.getSeconds();
		
		// 两位对齐
		iMonth = (iMonth.toString().length == 1) ? ("0"+ iMonth) : iMonth;
		iDay = (iDay.toString().length == 1) ? ("0"+ iDay) : iDay;
		iHour = (iHour.toString().length == 1) ? ("0"+ iHour) : iHour;
		iMinutes = (iMinutes.toString().length == 1) ? ("0"+ iMinutes) : iMinutes;
	//	iSecond = (iSecond.toString().length == 1) ? ("0"+ iSecond) : iSecond;
		
	//	strResult = iYear + "-" + iMonth + "-" + iDay + " " + iHour + ":" + iMinutes + ":" + iSecond;
		strResult = iYear + "-" + iMonth + "-" + iDay + " " + iHour + ":" + iMinutes;
		
		return strResult;
		
		
		// 另一种方式
		// obj.value = nDate.toString();
		// 结果类似 : Wed Aug 23 21:56:11 UTC+0800 2006
		// 不是希望的格式
		// 当然，也可以在这个串的基础上进行字符串解析，来得到所需的格式数据，有兴趣可以试试
		//
		
}
