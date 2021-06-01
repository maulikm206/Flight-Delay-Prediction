function searchCity() {
	var stateName = document.getElementById("stateName");
	var cityName = document.getElementById("cityName");
	var htp = new XMLHttpRequest();

	htp.onreadystatechange = function() {
		/*
		There are five readyState of AJAX
		    
		    0=request not initialized
		    1=request initialized 
		    2=process
		    3=send
		    4=response
		    
		 */
		if (htp.readyState == 4) {

			var jsn = JSON.parse(htp.responseText)

			cityName.innerHTML = "";
			var opt = document.createElement("option");
			opt.text = 'Select City';
			cityName.options.add(opt);
			
			for (var i = 0; i < jsn.length; i++) {
				var opt = document.createElement("option");
				opt.value = jsn[i].cityId;
				opt.text = jsn[i].cityName;
				cityName.options.add(opt);

			}
		}
	}
	htp.open("get", "searchCityByState?id=" + stateName.value, true);
	htp.send();
}