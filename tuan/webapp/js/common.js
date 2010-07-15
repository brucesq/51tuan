/*
��;����������ַ����Ƿ������������ʽ
���룺
	s���ַ���
���أ�
	���ͨ����֤����true,���򷵻�false	
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
��;����������ַ����Ƿ������������ʽ
���룺
	s���ַ���
	len:�ַ�����󳤶�
���أ�
	���ͨ����֤����true,���򷵻�false	
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
��;����������ַ����Ƿ���Ϊ����,�ɴ�С��������ָ�ʽ,�����Ǹ���
���룺
	s���ַ���
���أ�
	���ͨ����֤����true,���򷵻�false	
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
��;����������ַ����Ƿ�ֻ��Ӣ����ĸ���������
���룺
	s���ַ���
���أ�
	���ͨ����֤����true,���򷵻�false	
*/
function isNumberOrLetter( s ){    //�ж��Ƿ������ֻ���ĸ
	var regu = "^[0-9a-zA-Z]+$";
	var re = new RegExp(regu);
	if (re.test(s)) {
	  return true;
	}else{
	  return false;
	}
}

/*
��;��ȡ��ĳ��ĳ�µ�����
���룺
	year�����
	month���·�
���أ�
	ȡ��ĳ��ĳ�µ�����	
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
��;���������ĵ绰�����ʽ�Ƿ���ȷ
���룺
	strPhone���ַ���
���أ�
	���ͨ����֤����true,���򷵻�false	
*/

function checkPhone(strPhone) { 
	var p1=/^(\d{3}-\d{8}|\d{4}-\d{8}|\d{4}-\d{7}|\d{3}-\d{7})(-\d{2,8})?$/
	 var me = false;
     if (p1.test(strPhone))
		 me=true;
	 if (!me){
		showMessage("�Բ���������ĵ绰�����д���!");
		return false;
	 }else{
		return true; 
	 }
}

/*
��;�����������ֻ������ʽ�Ƿ���ȷ
���룺
	strMobile���ַ���
���أ�
	���ͨ����֤����true,���򷵻�false	
*/

function checkMobile(strMobile) { 
	var p1=/^\d{11}$/
	 var me = false;
     if (p1.test(strMobile))
		 me=true;
	 if (!me){
		showMessage("�Բ�����������ֻ������д���!");
		return false;
	 }else{
		return true; 
	 }
}
/*
��;�����������ֻ�������ߵ绰��ʽ�Ƿ���ȷ
���룺
	value���ַ���
���أ�
	���ͨ����֤����true,���򷵻�false	
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
��;�����yyyymmdd��ʽ�������Ƿ���ȷ
���룺
	value��yyyymmdd��ʽ������
���أ�
	�Ƿ���ȷ	
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
��;�����yyyy-mm-dd��ʽ�������Ƿ���ȷ
���룺
	value��yyyy-mm-dd��ʽ������
���أ�
	�Ƿ���ȷ	
*/	
function checkDate2( value ) {
	var pattern=/^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$/;
	return pattern.test(value);
}

/*
��;�����yyyy-mm��ʽ�������Ƿ���ȷ
���룺
	value��yyyy-mm��ʽ������
���أ�
	�Ƿ���ȷ	
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
��;������������ֹ�����Ƿ���ȷ������Ϊ�������ڵĸ�ʽ��ȷ��Ϊ��
	�ҽ�������>=��ʼ����
���룺
	startDate����ʼ���ڣ��ַ���
	endDate��  �������ڣ��ַ���
���أ�
	���ͨ����֤����true,���򷵻�false	
*/
function checkPeriod( startDate,endDate ) {
	if((startDate.length >0 && endDate.length ==0)||(startDate.length ==0 && endDate.length >0)){
		showMessage("�Բ�����������ֹ���ڣ�") ;
		return false ;
	}
	if( startDate > endDate ) {
		showMessage("�Բ�����ʼ���ڲ��ܴ�����ֹ���ڣ�");
		return false;
	}
	return true;
}

/*
��;�����֤�����Ƿ���ȷ
���룺
	num�����֤����
���أ�
	���ͨ����֤����true,���򷵻�false	
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
        error = "�Բ����������֤���볤�Ȳ��ԣ�";
        showMessage(error);
        return false;
    }    
    // check and set value
    for(i=0;i<intStrLen;i++) {
        varArray[i] = idNumber.charAt(i);
        if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
            error = "�Բ��𣬴�������֤���룡";
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
            error = "�Բ������֤��������Ϣ����ȷ��";
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
            showMessage("�Բ������֤Ч��λ����");
            return false;
        }
    } 
    else{        //length is 15
        //check date
        var date6 = idNumber.substring(6,12);
        if (checkDate3(date6) == false) {
            showMessage("�Բ������֤������Ϣ����");
            return false;
        }
    }
    return true;
}

/*
��;��У�������Ϣ��ѯ������
���룺
	sfz�����֤����
	xm:  ����
	hjdbm:�����ر���
	csrq:��������
���أ�
	���ͨ����֤����true,���򷵻�false	
	
*/
function checkQueryCase(sfz,xm,hjdbm,csrq){
	if(sfz.length!=0){
		if(!checkIDCard(sfz)){
			return false ;
		}
		return true ;
	}else{
		if(xm.length==0){
			showMessage("�Բ��������������������֤���룡") ;
			return false ;
		}
		if(hjdbm.length==0){
			showMessage("�Բ��������뻧���ػ������֤���룡") ;
			return false ;
		}
		if(csrq.length==0){
			showMessage("�Բ���������������ڻ������֤���룡") ;
			return false ;
		}
		return true ;
	}
}
/*
��;��У������Ƿ�Ϊ��,ͬʱ�Լ����������Ϣ
���룺
	obj:Ҫ��֤�Ķ���
���أ�
	���ͨ����֤����true,���򷵻�false	

*/
function notNull(obj){
		if(obj.value.length==0){
			var messager = obj.title ;
			showMessage(obj.title+"����Ϊ�գ�") ;
			return false ;
		}
		return true ;
	}
/**
*��֤����
*@param {String} number ����֤����ֵ
*@param {Number} forLength �������ֵĳ���(������"-"�ź�С����)
*@param {Number} forDecimalDigits С�����ĳ���
*@pram {String} isPositive  ��ʾ�Ƿ�Ҫ����������У�飬���ΪY��ʾҪΪ���������ΪN��ʾҪΪ����
*@return {Boolean} �Ƿ�ɹ�
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
	
	//У�鸺��,����û����
	if((isPositive.toUpperCase()=="N" && number.indexOf("-")<0)|| (isPositive.toUpperCase()=="Y" && number.indexOf("-")>0))
	{
		return false;
	}
	//С����λ��
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
	//�ж����峤��
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
	//������С��ʵ�ʳ���
	if(forLength<allNumLen)
	{
	    return false;
	}

	 //��������������
	 var maxLen=forLength-forDecimalDigits;
	 //��������ʵ�ʳ���
	 var numLen=allNumLen-dotLength;
	 if(numLen>maxLen)
	 {
		 return false;
	 }

	return true;
}
/**
*��֤�Ƿ�����
*@param {String} value ����֤����ֵ
*@return {Boolean} �Ƿ�ɹ�
*/
function isChinese(value){  
	var pattern=/^\u4E00-\u9FA5+$/;
	return pattern.test(value);
}
/**
*��֤�Ƿ�Email
*@param {String} value ����֤��ֵ
*@return {Boolean} �Ƿ�ɹ�
*/
function isEmail(value){  
	var pattern=/^[\w\.\-]+@([\w\-]+\.)+[a-zA-Z]+$/;
	return pattern.test(value);
}

/**
*��֤�Ƿ��ʱ�
*@param {String} value ����֤��ֵ
*@return {Boolean} �Ƿ�ɹ�
*/
function isPostCode(value){  
	var pattern=/^[0-9]{6}$/;
	return pattern.test(value);
}
/**
*��֤���պ����֤�Ƿ����
*@param {String} id ���֤��
*@param {String} birthday ����
*@return {Boolean} �Ƿ�ɹ�
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
*��֤��֯��������
*@param {String} value ��֯��������
*@return {Boolean} �Ƿ�ɹ�
*/
function checkOrgCode(value)
{
	var pattern=/^[A-Z|0-9]{8}[-][0-9|X]$/
	if(!pattern.test(value))
	{
		return false;
	}
	//��ȡ����
	var baseCode=value.substring(0,8);
	//��ȡУ��λ��
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
	//����
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
	//У��ͨ��
	if(validateCode==checkCode)
	{
		return true;
	}
	return false;
}

/**
*��֤ʱ���ʽ(hh:mm:ss)
*@param {String} value ʱ��
*@return {Boolean} �Ƿ�ɹ�
*/
function checkTime(value)
{
	var pattern=/^(([0-1]\d{1})|([2][0-3]))[:]([0-5]\d)[:]([0-5]\d)$/
	return pattern.test(value);
}
/**
*��֤����ʱ���ʽ(yyyy-MM-dd hh:mm:ss)
*@param {String} value ����ʱ���ʽ
*@return {Boolean} �Ƿ�ɹ�
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
*�Ƿ�Ϊ�ջ�ո�
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
*У�����룺ֻ������4-16����ĸ�����֡��»���
*/
function isPasswd(s) { 
	var patrn=/^(\w){4,16}$/; 
	if (!patrn.exec(s)) 
		return false; 
	return true; 
}