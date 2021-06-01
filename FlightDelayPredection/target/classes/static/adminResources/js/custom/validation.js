function fn() {
	// ******First Name*******
	var a = document.getElementById("stateName");
	var a1 = document.getElementById("sfn1");
	var a2 = document.getElementById("sfn2");

	if (a.value == "") {
		a.style.border = "1px solid red";
		a1.style.display = "";
		return false;
	} else if (a.value.length < 3) {
		a.style.border = "1px solid red";
		a1.style.display = "none";
		a2.style.display = "";
		return false;
	}

	else {
		a.style = "display none";
		a1.style.display = "none";
		a2.style.display = "none";
	}
	    var b = document.getElementById("stateDescription");
		var b1 = document.getElementById("sln1");
		var b2 = document.getElementById("sln2");	
	    
		if(b.value=="")
		{
			b.style.border="1px solid red";
	        b1.style.display="";
	        return false;
		}
		else if(b.value.length < 3)
		{
	        b.style.border="1px solid red";
			b1.style.display="none";
	        b2.style.display="";
	        return false;
	    }
		
	    else
		{
	        b.style="display none";
			b1.style.display="none";
			b2.style.display="none";
	    }
		
		
}