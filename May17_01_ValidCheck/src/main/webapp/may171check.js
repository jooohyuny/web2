function check(){
	var idField = document.f.id;
	var pwField = document.f.pw;
	var pwCheckField = document.f.pwCheck;
	var ageField = document.f.age;
	var photoField = document.f.photo;
	
	if (isEmpty(idField)|| lessWord(idField,5)||containsHS(idField)){
		alert("ID�� �Է��ϼ���");
		idField.value = "";
		idField.focus();
		return false;
	}
	if (isEmpty(pwField)||lessWord(pwField,5)
		|| notEquals(pwField,pwCheckField)
		|| notContains(pwField,"1234567890")
		|| notContains(pwField,"abcd")){
		alert("PW�� ���ǿ� �°� �Է��ϼ���");
		pwField.value = "";
		pwCheckField.value = "";
		pwField.focus();
		return false;
	}
	if(isEmpty(ageField)||isNotNum(ageField)){
		alert("���̸� �Է��ϼ���");
		ageField.value = "";
		ageField.focus();
		return false;
	}
	// �ʼ�
	// png�� gif�� jpg��
	if(isEmpty(photoField)
	||(isNotType(photoField,"png")
	&& isNotType(photoField,"gif")
	&& isNotType(photoField,"jpg"))){
		alert("������ �����ϼ���");
		photoField.value = "";
		return false;
	}
	return true;
	
}









