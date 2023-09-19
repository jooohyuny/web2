// back-end개발자 : 안보이는 부분 -> java
// front-end개발자 : 보이는 부분 -> javascript
// full-stack개발자 : 둘 다

// Model
//		JavaScript : front-end개발자
function check(){
	var xField = document.f.x;
	var yField = document.f.y;
	if (isEmpty(xField)||isNotNum(xField)
	||isEmpty(yField)||isNotNum(yField)){
		alert("?");
		xField.value = "";
		xField.focus();
		return false;
	}
	return true;
}