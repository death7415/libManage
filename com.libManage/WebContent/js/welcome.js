function myFunc(methodtype){
	document.getElementById('test').action="../Logout";
    document.getElementById('test').method=methodtype;
		document.getElementById('test').submit();
}
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}

