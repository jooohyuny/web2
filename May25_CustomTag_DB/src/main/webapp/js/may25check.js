function numCheck() {
	var xInput = document.numForm1.xx;
	var yInput = document.numForm1.yy;

	if (isEmpty(xInput) || isNotNum(xInput)
		|| isEmpty(yInput) || isNotNum(yInput)) {
		alert("?")
		return false;
	}
	return true;
}