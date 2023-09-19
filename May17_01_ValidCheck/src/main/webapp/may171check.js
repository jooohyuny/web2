function check(){
	var idField = document.f.id;
	var pwField = document.f.pw;
	var pwCheckField = document.f.pwCheck;
	var ageField = document.f.age;
	var photoField = document.f.photo;
	
	if (isEmpty(idField)|| lessWord(idField,5)||containsHS(idField)){
		alert("ID를 입력하세요");
		idField.value = "";
		idField.focus();
		return false;
	}
	if (isEmpty(pwField)||lessWord(pwField,5)
		|| notEquals(pwField,pwCheckField)
		|| notContains(pwField,"1234567890")
		|| notContains(pwField,"abcd")){
		alert("PW를 조건에 맞게 입력하세요");
		pwField.value = "";
		pwCheckField.value = "";
		pwField.focus();
		return false;
	}
	if(isEmpty(ageField)||isNotNum(ageField)){
		alert("나이를 입력하세요");
		ageField.value = "";
		ageField.focus();
		return false;
	}
	// 필수
	// png나 gif나 jpg만
	if(isEmpty(photoField)
	||(isNotType(photoField,"png")
	&& isNotType(photoField,"gif")
	&& isNotType(photoField,"jpg"))){
		alert("사진을 선택하세요");
		photoField.value = "";
		return false;
	}
	return true;
	
}









