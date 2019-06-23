function open() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm(methodtype) {
  document.getElementById('test').action="../Logout";
    document.getElementById('test').method=methodtype;
		document.getElementById('test').submit();
}