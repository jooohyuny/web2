function printKaka() {
	alert("ㅋㅋㅋ");
}
function arrayTest() {
	// int[] ar = {123,54,24}
	var ar = [123, 54, 24];

	for (var i = 0; i < ar.length; i++) {
		alert(ar[i]);
	}
}
function objTest() {
	// Dog d = new Dog();
	// d.setName("후추");
	// d.setAge("3");
	// syso(d);
	// syso(d.getName()); 캡슐화
	// syso(d.age);
	var d = { name: "후추", age: 3 };
	alert(d.name);
	alert(d.age);
}

function aoTest() {
	// Dog[] dogs;
	// ArrayList<Dog> dogs;

	var dogs = [
		{ name: "후추", age: 3 },
		{ name: "준하", age: 50 },
		{ name: "주원", age: 26 },
		{ name: "현욱", age: 25 }
	];
	for (var i = 0; i < dogs.length; i++) {
		alert(dogs[i].name + ":" + dogs[i].age);
	}
	//alert(dogs);
	//alert(dogs[0]);
	//alert(dogs[0].name);
	//alert(dogs[0].age);

}