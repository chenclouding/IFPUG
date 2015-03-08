/**
*�ж������Ƿ�Ϊ��
**/
function isEmpty(txtval)
{
  	var i=0;
  	if (txtval.length==0)
     	return true;
  	while (i<txtval.length)
	 {
     	if (txtval.substring(i,i+1) != ' ')
		{
			return false;
		}
     	i=i+1;
	}
  	return true;
}

/**
*�ж������Ƿ��зǷ��ַ�
**/
function isNotCorrect(str)
{
    var reg =/w+$/; 
   var r = str.match(reg); 
   if(r==null)
   		return true; 
	else
	    return false;
}

/**
*�ж��Ƿ����߸�����
**/
function isnotSevenNum(str)
{
   var reg =/^\d{7}$/; 
   var r = str.match(reg); 
   if(r==null)
   		return true; 
	else
	    return false;
}
/**
*�ж��Ƿ�����������
**/
function isnotThreeNum(str)
{
   var reg =/^\d{3}$/; 
   var r = str.match(reg); 
   if(r==null)
   		return true; 
	else
	    return false;
}
/**
*�ж��Ƿ����ĸ�����
**/
function isnotFourNum(str)
{
   var reg =/^\d{4}$/; 
   var r = str.match(reg); 
   if(r==null)
   		return true; 
	else
	    return false;
}
/**
*�ж��Ƿ�������
**/
function isLeapYear(year) 
{ 
 if((year%4==0&&year%100!=0)||(year%400==0)) 
 { 
 return true; 
 }  
 return false; 
} 
/**
*�ж��Ƿ�����ȷ�����ڸ�ʽ
**/
function isnotDate(datetime){
var year,month,day;
var reg =/^\d{4}-\d{2}-\d{2}$/; 
var r = datetime.match(reg); 
if(r==null){
   	return true; 
    }else{
	 year=datetime.substring(0,4);
     month=datetime.substring(5,7);
     day=datetime.substring(8,10);
  
     if(month<1||month>12) { 
       return true; 
       } 
     if(day<1||day>31){ 
		return true; 
        }
     if(month==2){  
        if(isLeapYear(year)&&day>29){ 
           return true; 
           }       
        if(!isLeapYear(year)&&day>28){ 
           return true; 
           } 
        } 
     if((month==4||month==6||month==9||month==11)&&(day>30)){ 
        return true; 
        } 
	 return false;
     }
}

/**
*�жϽ���ʱ���Ƿ����ڿ�ʼʱ��
**/

function Datecheck(str2,str1)
{
	if(str1<str2)
		return true;
	else
		return false;
}
/**
*�ж��Ƿ��Ǽ��㼸�ֵĸ�ʽ
**/
function isCorrectTime(str)
{
   var reg =/^\d{1,2}:\d{1,2}$/; 
   var r = str.match(reg); 
  
   if(r==null)
   		return true; 
	else
	    return false;
 }
 
function Timecheck(str1,str2,str4,str3)
{
	if(str1!=str2)
		return false;
	else
		{
			if(str3<str4)
				return true;
			else 
				return false;
		}
}
/**
*�ж��Ƿ��Ǹ���������
**/
function isNotDigit(str)
{
var reg=/^\d+(\.\d+)?$/; 
var r=str.match(reg);
if(r==null)
     return true;
else 
      return false;
}
/**
*�ж��Ƿ��Ǹ���������
**/
function isPositiveDigit(str)
{
var reg="^[0-9]*[1-9][0-9]*$"; 
var r=str.match(reg);
if(r==null)
     return true;
else 
      return false;
}

function isForbiddenCharacter(str)
{
	var pattern =/[!|#|$|%|&|(|)|*|`|+|\-|,| |"|'|.|/|:|;|<|=|>|?|@|~|{|}|\[|\]|^|\\]/i;
	return (pattern.test(str));

}
