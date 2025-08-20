/**
 * 
 */
function sendDeletePerson(aadhaar) {
	let userInput = window.confirm("Are you sure that you want to delete the person ?");
	if (userInput) {
		let xhttp = new XMLHttpRequest();
		xhttp.open("POST", "PersonServlet", true);
		xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState === 4 && xhttp.status === 200) {
				document.getElementById("deletedMessage").hidden = false;
				document.getElementById("deletedMessage").innerHTML = xhttp.responseText;
				document.getElementById("deleteButton").setAttribute("disabled", "true");
				document.getElementsByClassName("deletable").item(0).setAttribute("hidden", "true");
			}
		};
		xhttp.send("deleteRequest=true&aadhaar=" + encodeURIComponent(aadhaar));
	}
}