function bcCheck(){
	var nameField = document.bmiForm.n;
	var heightField = document.bmiForm.h;
	var weightField = document.bmiForm.w;
	var photoField = document.bmiForm.p;
	if (isEmpty(nameField)){
		alert("�̸�?")
		return false;
	}	
	if(isEmpty(heightField)||isNotNum(heightField)
	||heightField.value>3){
		alert("Ű?")
		return false;
	}	
	if(isEmpty(weightField)||isNotNum(weightField)){
		alert("������?")
		return false;
	}	
	if (isEmpty(photoField)||(isNotType(photoField,"png")&&isNotType(photoField,"jpg"))){
		alert("����?");
		return false;
	}
	return true;
}