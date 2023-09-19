function check(){
	var xField = document.f.x;
	var yField = document.f.y;
	if (isEmpty(xField)||isNotNum(xField)
	||isEmpty(yField)||isNotNum(yField)){
		alert("값을 입력하세요");
		xField.value = "";
		xField.focus();
		return false;
	}
	return true;
}