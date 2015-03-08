////////////////////////////////////////////////////////////////////////////////////////////////////
///// MDateTime.js
///// created by Eric 2006-08-23
/////


////////////////////////////////////////////////////////////////////////////////////////////////////
///// �ɼ��ظ� JavaScript ��ҳ�����
/////
///// ���������ҳ���ϵ�һ��������ʾ�ı��Ŀؼ��������г�ʼʱ�䣩
///// ���ؽ��: ��ѡ�������ʱ�䣬������ʾ�ؼ����ı�
/////
function SetMDateTime(sText)
{
		// ��ʾҳ�漰�������
		var sPath = "/gcgl/VER/MDateTimePage.html";
		var strFeatures = "dialogWidth=206px;dialogHeight=245px;center=yes;help=no;status=No;";
		
		// ����ĳ�ʼ������ʱ��
		var strDateTimeInput = sText.value;                     // �õ���ʼ����ʱ��(��ҳ��õ���ǰʱ��)
		strDateTimeInput = FormatDateTime(strDateTimeInput);    // ת���� yyyy/mm/dd �ĸ�ʽ
		
		// ����ҳ�棬�õ�ѡ������ں�ʱ��
		var mDateTimeSelected = showModalDialog(sPath, strDateTimeInput, strFeatures);
															//
															// showModalDialog ������Ϊ�� JavaScript ��һ��ϵͳ����
															// �����䵯���������ʾ��
															// ��Ϣ�μ� study-info �µ��ĵ�
															//
		sText.value = GetDateTime(mDateTimeSelected);   // ������ʱ��ת��Ϊ�ַ���
		
}
////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////
///// ����ʼ������ʱ��ĸ�ʽת��Ϊһ���ĸ�ʽ
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
						// �����һ�������� /
						strResult += " / ";
						
				}
				
		}  // end for
		
		return strResult;
		
}
////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////
///// ������ʱ��ת��Ϊ�ַ���
///// ���ĸ�ʽ : yyyy-mm-dd hh:mm:ss
/////
function GetDateTime(dtGet)
{
		var strResult = "";
		
		var nDate = new Date(dtGet);
		if (nDate == "NaN")
		{
				// ת��ʧ�ܣ����ؿմ�
				return strResult;
				
		}
		
		// �õ����ڡ�ʱ��ĸ�����ֵ
		var iYear = nDate.getFullYear();
		var iMonth = nDate.getMonth() + 1;     // ����
		// var iDay = nDate.getDay();          // �����еĵڼ���, Sunday --- 0 , Monday --- 1 , ...
		var iDay = nDate.getDate();            // ע�� Day �� Date ������ !!!
		var iHour = nDate.getHours();
		var iMinutes = nDate.getMinutes();     // Date ����Ϣ���ο� study-info �µ� JavaScript-Date����
	//	var iSecond = nDate.getSeconds();
		
		// ��λ����
		iMonth = (iMonth.toString().length == 1) ? ("0"+ iMonth) : iMonth;
		iDay = (iDay.toString().length == 1) ? ("0"+ iDay) : iDay;
		iHour = (iHour.toString().length == 1) ? ("0"+ iHour) : iHour;
		iMinutes = (iMinutes.toString().length == 1) ? ("0"+ iMinutes) : iMinutes;
	//	iSecond = (iSecond.toString().length == 1) ? ("0"+ iSecond) : iSecond;
		
	//	strResult = iYear + "-" + iMonth + "-" + iDay + " " + iHour + ":" + iMinutes + ":" + iSecond;
		strResult = iYear + "-" + iMonth + "-" + iDay + " " + iHour + ":" + iMinutes;
		
		return strResult;
		
		
		// ��һ�ַ�ʽ
		// obj.value = nDate.toString();
		// ������� : Wed Aug 23 21:56:11 UTC+0800 2006
		// ����ϣ���ĸ�ʽ
		// ��Ȼ��Ҳ������������Ļ����Ͻ����ַ������������õ�����ĸ�ʽ���ݣ�����Ȥ��������
		//
		
}
