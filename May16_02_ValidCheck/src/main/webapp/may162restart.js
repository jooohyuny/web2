function check(){
	var nameField = document.f.name;
	var ageField = document.f.age;
	var photoField = document.f.photo;
	
	if (isEmpty(nameField)|| lessWord(nameField,1)){
		alert("�̸��� �Է��ϼ���");
		nameField.value = "";
		nameField.focus();
		return false;
	}
	if (isEmpty(ageField)||isNotNum(ageField)){
		alert("������ �Է��ϼ���");
		ageField.value = "";
		ageField.focus();
		return false;
	}
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