function printKaka() {
	alert("������");
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
	// d.setName("����");
	// d.setAge("3");
	// syso(d);
	// syso(d.getName()); ĸ��ȭ
	// syso(d.age);
	var d = { name: "����", age: 3 };
	alert(d.name);
	alert(d.age);
}

function aoTest() {
	// Dog[] dogs;
	// ArrayList<Dog> dogs;

	var dogs = [
		{ name: "����", age: 3 },
		{ name: "����", age: 50 },
		{ name: "�ֿ�", age: 26 },
		{ name: "����", age: 25 }
	];
	for (var i = 0; i < dogs.length; i++) {
		alert(dogs[i].name + ":" + dogs[i].age);
	}
	//alert(dogs);
	//alert(dogs[0]);
	//alert(dogs[0].name);
	//alert(dogs[0].age);

}