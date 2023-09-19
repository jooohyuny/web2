function may172check() {
	var lenField = document.i.len;
	var sizeField = document.i.size;
	var tempField = document.i.temp;
	var spdField = document.i.spd;

	if (isEmpty(lenField) || isNotNum(lenField)) {
		alert("값을 입력하세요");
		xField.value = "";
		yField.value = "";
		xField.focus();
		return false;
	}
	return true;

}