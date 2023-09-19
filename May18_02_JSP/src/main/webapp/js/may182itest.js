function may182check() {
	var trField = document.i.transNum;

	if (isEmpty(trField) || isNotNum(trField)) {
		alert("값을 입력하세요");
		trField.value = "";
		trField.focus();
		return false;
	}
	return true;

}