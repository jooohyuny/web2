function bye() {
	var really = prompt("Ż���Ϸ��� ������ �Է�");
	if (really == "����") {
		location.href = "ByeController";
	}
}
function deleteSNSMsg(no) {
	if (confirm("����?")) {
		location.href = "SNSDeleteController?no=" + no;
	}
}
function deleteSNSReply(no) {
	if (confirm("?")) {
		location.href = "SNSReplyDeleteController?no=" + no;
	}
}

function updateSNSMsg(no, txt) {
	txt = prompt("������ ����", txt);
	if (txt != null & txt.length < 251) {
		location.href = "SNSUpdateController?no=" + no + "&txt=" + txt;
	}
}

function deleteCWMsg(no) {
	if (confirm("����?")) {
		location.href = "CWDeleteController?no=" + no;
	}
}

function updateCWMsg(no, txt) {
	txt = prompt("������ ����", txt);
	if (txt != null & txt.length < 251) {
		location.href = "CWUpdateController?no=" + no + "&txt=" + txt;
	}
}
