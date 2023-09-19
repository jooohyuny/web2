function goBBSDetail(no) {
	location.href = "BBSDetailController?no=" + no;
}
function deleteBBSMsg(no) {
	var really = confirm("real?");
	if (really) {
		location.href = "BBSDeleteController?no="+no;
	}
}
function goDRDetail(no) {
	location.href = "DRDetailController?no=" + no;
}

function deleteDRFile(no) {
	var really = confirm("real?");
	if (really) {
		location.href = "DRDeleteController?no="+no;
	}
}