/*
用途：检查输入字符串是否符合正整数格式
输入：
	s：字符串
返回：
	如果通过验证返回true,否则返回false	
*/
function isNumber( s ){   
	var regu = "^[0-9]+$";
	var re = new RegExp(regu);
	if (s.search(re) != -1) {
	   return true;
	} else {
	   return false;
	}
}

/*
用途：检查输入字符串是否符合正整数格式
输入：
	s：字符串
	len:字符串最大长度
返回：
	如果通过验证返回true,否则返回false	
*/
function isNumber1( s,len ){  
	
	var regu = "^[0-9]{1,"+len+"}$";
	
	var re = new RegExp(regu);
	if (s.search(re) != -1) {
	   return true;
	} else {
	   return false;
	} 
	
}

/*
用途：检查输入字符串是否是为数字,可带小数点的数字格式,可以是负数
输入：
	s：字符串
返回：
	如果通过验证返回true,否则返回false	
*/
function isDecimal( s ){   
	var regu = "^(-?\\d+)(\\.\\d+)?$";
	var re = new RegExp(regu);
	if (s.search(re) != -1) {
	   return true;
	} else {
	   return false;
	}
}


/*
用途：检查输入字符串是否只由英文字母和数字组成
输入：
	s：字符串
返回：
	如果通过验证返回true,否则返回false	
*/
function isNumberOrLetter( s ){    //判断是否是数字或字母
	var regu = "^[0-9a-zA-Z]+$";
	var re = new RegExp(regu);
	if (re.test(s)) {
	  return true;
	}else{
	  return false;
	}
}

/*
用途：取得某年某月的天数
输入：
	year：年份
	month：月份
返回：
	取得某年某月的天数	
*/
function getMaxDay(year,month) {
	if(month==4||month==6||month==9||month==11)
		return "30";
	if(month==2)
		if(year%4==0&&year%100!=0 || year%400==0)
			return "29";
		else
			return "28";
	return "31";
}


/*
用途：检查输入的电话号码格式是否正确
输入：
	strPhone：字符串
返回：
	如果通过验证返回true,否则返回false	
*/

function checkPhone(strPhone) { 
	var p1=/^(\d{3}-\d{8}|\d{4}-\d{8}|\d{4}-\d{7}|\d{3}-\d{7})(-\d{2,8})?$/
	 var me = false;
     if (p1.test(strPhone))
		 me=true;
	 if (!me){
		showMessage("对不起，您输入的电话号码有错误!");
		return false;
	 }else{
		return true; 
	 }
}

/*
用途：检查输入的手机号码格式是否正确
输入：
	strMobile：字符串
返回：
	如果通过验证返回true,否则返回false	
*/

function checkMobile(strMobile) { 
	var p1=/^\d{11}$/
	 var me = false;
     if (p1.test(strMobile))
		 me=true;
	 if (!me){
		showMessage("对不起，您输入的手机号码有错误!");
		return false;
	 }else{
		return true; 
	 }
}
/*
用途：检查输入的手机号码或者电话格式是否正确
输入：
	value：字符串
返回：
	如果通过验证返回true,否则返回false	
*/
function checkPhone2(value) { 
	var p1=/^(\d{3}-\d{8}|\d{4}-\d{8}|\d{4}-\d{7}|\d{3}-\d{7})(-\d{2,8})?$/
	var p2=/^\d{11}$/
   if(p1.test(value) || p2.test(value))
   {
	   return true;
   }
   return false;

}


/*
用途：检查yyyymmdd格式的日期是否正确
输入：
	value：yyyymmdd格式的日期
返回：
	是否正确	
*/	


function checkDate( value ) {
	if(value=='') return false;
	if(value.length!=8 || !isNumber(value)) return false;  
	var year = value.substring(0,4);
	
	var month = value.substring(4,6);
	if(month>"12" || month< "01") return false;
	
	var day = value.substring(6,8);
	if(day>getMaxDay(year,month) || day< "01") return false;
	
	return true;  
}

function checkDate3( value ) {
	if(value=='') return false;
	if(value.length!=6 || !isNumber(value)) return false;  
	var year = value.substring(0,2);
	
	var month = value.substring(2,4);
	if(month>"12" || month< "01") return false;
	
	var day = value.substring(4,6);
	if(day>getMaxDay(year,month) || day< "01") return false;
	
	return true;  
}

/*
用途：检查yyyy-mm-dd格式的日期是否正确
输入：
	value：yyyy-mm-dd格式的日期
返回：
	是否正确	
*/	
function checkDate2( value ) {
	var pattern=/^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$/;
	return pattern.test(value);
}

/*
用途：检查yyyy-mm格式的日期是否正确
输入：
	value：yyyy-mm格式的日期
返回：
	是否正确	
*/	
function checkYearMonth( value ) {
	if(value=='') return false;
	if(value.length!=7) return false;  
	var year = value.substring(0,4);
	if(!isNumber(year))
	{
		return false;
	}
	var splitChar=value.substring(4,5);
	if(splitChar!="-")
	{
		return false;
	}
	
	var month = value.substring(5,7);
	
	if(Number(month)>12 || Number(month)< 1)
	{
		return false;
	}
	
	return true;  
}


/*
用途：检查输入的起止日期是否正确，规则为两个日期的格式正确或都为空
	且结束日期>=起始日期
输入：
	startDate：起始日期，字符串
	endDate：  结束日期，字符串
返回：
	如果通过验证返回true,否则返回false	
*/
function checkPeriod( startDate,endDate ) {
	if((startDate.length >0 && endDate.length ==0)||(startDate.length ==0 && endDate.length >0)){
		showMessage("对不起，请输入起止日期！") ;
		return false ;
	}
	if( startDate > endDate ) {
		showMessage("对不起，起始日期不能大于终止日期！");
		return false;
	}
	return true;
}

/*
用途：身份证号码是否正确
输入：
	num：身份证号码
返回：
	如果通过验证返回true,否则返回false	
*/

function checkIDCard(num) 
{
    var factorArr = new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2,1);
    var error;
    var varArray = new Array();
    var intValue;
    var lngProduct = 0;
    var intCheckDigit;
    var intStrLen = num.length;
    var idNumber = num;    
    // initialize
    if ((intStrLen != 15) && (intStrLen != 18)) {
        error = "对不起，输入身份证号码长度不对！";
        showMessage(error);
        return false;
    }    
    // check and set value
    for(i=0;i<intStrLen;i++) {
        varArray[i] = idNumber.charAt(i);
        if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
            error = "对不起，错误的身份证号码！";
            showMessage(error);
            return false;
        } else if (i < 17) {
            varArray[i] = varArray[i]*factorArr[i];
        }
    }
    if (intStrLen == 18) {
        //check date
        var date8 = idNumber.substring(6,14);
        if (checkDate(date8) == false) {
            error = "对不起，身份证中日期信息不正确！";
            showMessage(error);
            return false;
        }        
        // calculate the sum of the products
        for(i=0;i<17;i++) {
            lngProduct = lngProduct + varArray[i];
        }        
        // calculate the check digit
        intCheckDigit = 12 - lngProduct % 11;
        switch (intCheckDigit) {
            case 10:
                intCheckDigit = 'X';
                break;
            case 11:
                intCheckDigit = 0;
                break;
            case 12:
                intCheckDigit = 1;
                break;
        }        
        // check last digit
        if (varArray[17].toUpperCase() != intCheckDigit) {
            showMessage("对不起，身份证效验位错误！");
            return false;
        }
    } 
    else{        //length is 15
        //check date
        var date6 = idNumber.substring(6,12);
        if (checkDate3(date6) == false) {
            showMessage("对不起，身份证日期信息有误！");
            return false;
        }
    }
    return true;
}

/*
用途：校验个案信息查询的条件
输入：
	sfz：身份证号码
	xm:  姓名
	hjdbm:户籍地编码
	csrq:出生日期
返回：
	如果通过验证返回true,否则返回false	
	
*/
function checkQueryCase(sfz,xm,hjdbm,csrq){
	if(sfz.length!=0){
		if(!checkIDCard(sfz)){
			return false ;
		}
		return true ;
	}else{
		if(xm.length==0){
			showMessage("对不起，请输入姓名或者身份证号码！") ;
			return false ;
		}
		if(hjdbm.length==0){
			showMessage("对不起，请输入户籍地或者身份证号码！") ;
			return false ;
		}
		if(csrq.length==0){
			showMessage("对不起，请输入出生日期或者身份证号码！") ;
			return false ;
		}
		return true ;
	}
}
/*
用途：校验对象是否为空,同时自己不用输出信息
输入：
	obj:要验证的对象
返回：
	如果通过验证返回true,否则返回false	

*/
function notNull(obj){
		if(obj.value.length==0){
			var messager = obj.title ;
			showMessage(obj.title+"不能为空！") ;
			return false ;
		}
		return true ;
	}
/**
*验证整数
*@param {String} number 待验证的数值
*@param {Number} forLength 整个数字的长度(不包括"-"号和小数点)
*@param {Number} forDecimalDigits 小数点后的长度
*@pram {String} isPositive  表示是否要加入正负的校验，如果为Y表示要为正数，如果为N表示要为负数
*@return {Boolean} 是否成功
*/
function checkNumber(number,forLength,forDecimalDigits,isPositive)
{
	if(isNaN(number))
	{
		return false;
	}
	if(Number(number)==0)
	{
		return true;
	}

	
	if(typeof number=="number")
	{
		number=number.toString();
	}
	
	//校验负数,但是没负号
	if((isPositive.toUpperCase()=="N" && number.indexOf("-")<0)|| (isPositive.toUpperCase()=="Y" && number.indexOf("-")>0))
	{
		return false;
	}
	//小数点位置
	var dotIndex=number.indexOf(".");
	var dotLength;
	if(dotIndex<0)
	{
		dotLength=0;
	}else
	{
		dotLength=number.length-dotIndex-1;
	}
	if(dotLength>forDecimalDigits)
	{
		return false;
	}
	//判断整体长度
	var allNumLen;
	if(isPositive.toUpperCase()=="N")
	{
		 if(dotIndex>=0)
		 {
			 allNumLen=number.length-2;
		 }
		 else if(dotIndex<0)
		 {
			  allNumLen=number.length-1;
		 }
	}
	if(isPositive.toUpperCase()=="Y")
	{
		if(dotIndex>=0)
		 {
			 allNumLen=number.length-1;
		 }
		 else if(dotIndex<0)
		 {
			  allNumLen=number.length;
		 }
	}
	//允许长度小于实际长度
	if(forLength<allNumLen)
	{
	    return false;
	}

	 //整数部分允许长度
	 var maxLen=forLength-forDecimalDigits;
	 //整数部分实际长度
	 var numLen=allNumLen-dotLength;
	 if(numLen>maxLen)
	 {
		 return false;
	 }

	return true;
}
/**
*验证是否中文
*@param {String} value 待验证的数值
*@return {Boolean} 是否成功
*/
function isChinese(value){  
	var pattern=/^\u4E00-\u9FA5+$/;
	return pattern.test(value);
}
/**
*验证是否Email
*@param {String} value 待验证的值
*@return {Boolean} 是否成功
*/
function isEmail(value){  
	var pattern=/^[\w\.\-]+@([\w\-]+\.)+[a-zA-Z]+$/;
	return pattern.test(value);
}

/**
*验证是否邮编
*@param {String} value 待验证的值
*@return {Boolean} 是否成功
*/
function isPostCode(value){  
	var pattern=/^[0-9]{6}$/;
	return pattern.test(value);
}
/**
*验证生日和身份证是否相符
*@param {String} id 身份证号
*@param {String} birthday 生日
*@return {Boolean} 是否成功
*/
function checkIdBirthday(id,birthday)
{

	if(!checkIDCard(id))
	{
		return false;
	}
	if(id.length==18 && id.substring(6,10)==birthday.substring(0,4) && id.substring(10,12)==birthday.substring(5,7) && id.substring(12,14)==birthday.substring(8,10))
	{
		return true;
	}
	
	
	if(id.length==15 && id.substring(6,8)==birthday.substring(2,4) && id.substring(8,10)==birthday.substring(5,7) && id.substring(10,12)==birthday.substring(8,10))
	{
		return true;
	}
	
	return false;
}
/**
*验证组织机构代码
*@param {String} value 组织机构代码
*@return {Boolean} 是否成功
*/
function checkOrgCode(value)
{
	var pattern=/^[A-Z|0-9]{8}[-][0-9|X]$/
	if(!pattern.test(value))
	{
		return false;
	}
	//读取本体
	var baseCode=value.substring(0,8);
	//读取校验位置
	var checkCode=value.charAt(9);
    var codeMap=new Array();
	codeMap['0']=0;
	codeMap['1']=1;
	codeMap['2']=2;
	codeMap['3']=3;
	codeMap['4']=4;
	codeMap['5']=5;
	codeMap['6']=6;
	codeMap['7']=7;
	codeMap['8']=8;
	codeMap['9']=9;
	codeMap['A']=10;
	codeMap['B']=11;
	codeMap['C']=12;
	codeMap['D']=13;
	codeMap['E']=14;
	codeMap['F']=15;
	codeMap['G']=16;
	codeMap['H']=17;
	codeMap['I']=18;
	codeMap['J']=19;
	codeMap['K']=20;
	codeMap['L']=21;
	codeMap['M']=22;
	codeMap['N']=23;
	codeMap['O']=24;
	codeMap['P']=25;
	codeMap['Q']=26;
	codeMap['R']=27;
	codeMap['S']=28;
	codeMap['T']=29;
	codeMap['U']=30;
	codeMap['V']=31;
	codeMap['W']=32;
	codeMap['X']=33;
	codeMap['Y']=34;
	codeMap['Z']=35;
	
	var w=[3,7,9,10,5,8,4,2];
	var sum=0;
	for(var i=0;i<baseCode.length;i++)
	{
	  var char=baseCode.charAt(i);
	  sum+=codeMap[char]*w[i];
	}
	//余数
	var validateKey=11-sum %11;
	var validateCode;
	if(validateKey==10)
	{
		validateCode='X';
	}
	else if(validateKey==0)
	{
		validateCode='0';
	}
	else
	{
		validateCode=validateKey.toString();
	}
	//校验通过
	if(validateCode==checkCode)
	{
		return true;
	}
	return false;
}

/**
*验证时间格式(hh:mm:ss)
*@param {String} value 时间
*@return {Boolean} 是否成功
*/
function checkTime(value)
{
	var pattern=/^(([0-1]\d{1})|([2][0-3]))[:]([0-5]\d)[:]([0-5]\d)$/
	return pattern.test(value);
}
/**
*验证日期时间格式(yyyy-MM-dd hh:mm:ss)
*@param {String} value 日期时间格式
*@return {Boolean} 是否成功
*/
function checkDateTime(value)
{
	var spaceIndex=value.indexOf(" ");
	if(spaceIndex<0)
	{
		return false;
	}
	var date=value.substring(0,spaceIndex);
	var time=value.substring(spaceIndex+1);
	if(checkDate2(date) && checkTime(time))
	{
		return true;
	}
	return false;
}

function trim(value) 
{ 
    return value.replace(/(^\s*)|(\s*$)/g, ""); 
} 

/**
*是否为空或空格
*/
function isBlank(value)
{
	if(trim(value).length==0)
	{		
		return true ;
	}
	return false ;
}

/**
*校验密码：只能输入4-16个字母、数字、下划线
*/
function isPasswd(s) { 
	var patrn=/^(\w){4,16}$/; 
	if (!patrn.exec(s)) 
		return false; 
	return true; 
}