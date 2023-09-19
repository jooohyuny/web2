function check(){
	var j1Input = document.f.j1;
	var j2Input = document.f.j2;
	
	if(isEmpty(j1Input)||isNotNum(j1Input)||lessThan(j1Input,6)
	||isEmpty(j2Input)||isNotNum(j2Input)){
		alert("?")
		return false;
	}
	return true;
}