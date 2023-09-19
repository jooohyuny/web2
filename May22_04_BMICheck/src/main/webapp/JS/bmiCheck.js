function bcCheck(){
	var nameField = document.bmiForm.n;
	var heightField = document.bmiForm.h;
	var weightField = document.bmiForm.w;
	var photoField = document.bmiForm.p;
	if (isEmpty(nameField)){
		alert("이름?")
		return false;
	}	
	if(isEmpty(heightField)||isNotNum(heightField)
	||heightField.value>3){
		alert("키?")
		return false;
	}	
	if(isEmpty(weightField)||isNotNum(weightField)){
		alert("몸무게?")
		return false;
	}	
	if (isEmpty(photoField)||(isNotType(photoField,"png")&&isNotType(photoField,"jpg"))){
		alert("사진?");
		return false;
	}
	return true;
}