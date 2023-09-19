function calcCheck() {
	var xInput = document.calcForm.x;
	var yInput = document.calcForm.y;

	if (isEmpty(xInput) || isNotNum(xInput)
		|| isEmpty(yInput) || isNotNum(yInput)) {
		alert("?")
		return false;
	}
	return true;
}