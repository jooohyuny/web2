function may182check() {
	var trField = document.i.transNum;

	if (isEmpty(trField) || isNotNum(trField)) {
		alert("���� �Է��ϼ���");
		trField.value = "";
		trField.focus();
		return false;
	}
	return true;

}