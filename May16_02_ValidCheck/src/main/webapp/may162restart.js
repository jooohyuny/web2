function check(){
	var nameField = document.f.name;
	var ageField = document.f.age;
	var photoField = document.f.photo;
	
	if (isEmpty(nameField)|| lessWord(nameField,1)){
		alert("이름을 입력하세요");
		nameField.value = "";
		nameField.focus();
		return false;
	}
	if (isEmpty(ageField)||isNotNum(ageField)){
		alert("나이을 입력하세요");
		ageField.value = "";
		ageField.focus();
		return false;
	}
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