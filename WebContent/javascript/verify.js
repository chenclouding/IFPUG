/**
*判断输入是否为空
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
*判断输入是否含有非法字符
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
*判断是否是七个数字
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
*判断是否是三个数字
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
*判断是否是四个数字
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
*判断是否是润年
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
*判断是否是正确的日期格式
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
*判断结束时间是否早于开始时间
**/

function Datecheck(str2,str1)
{
	if(str1<str2)
		return true;
	else
		return false;
}
/**
*判断是否是几点几分的格式
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
*判断是否是浮点型数字
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
*判断是否是浮点型数字
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
