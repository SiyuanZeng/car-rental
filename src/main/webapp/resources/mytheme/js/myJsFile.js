function back() {
	alert("Go Back");
	window.location.href = "/home.jsp";
}

function validateUserInput(frm) {
	var msg = "";
	var valid = true;
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var address = frm.email.value;
	var ssn = frm.ssn.value;
	var pattern = /\d{9}/;

	if ((!ssn.match(pattern))) {
		valid = false;
		msg += "Please input valid ssn</br>";
	}
	if (reg.test(address) == false) {
		msg += "Please input valid email address";
		alert('Invalid Email Address');
		valid = false;
	}

	if (!valid) {
		document.getElementById("errorDiv").innerHTML = msg;
	}
	return valid;
}
