function searchCity() {

	var htp = new XMLHttpRequest();

	var stateDetails = document.getElementById("stateDetails");
	var cityDetails = document.getElementById("cityDetails");

	htp.onreadystatechange = function() {

		if (htp.readyState == 4) {

			var jsn = JSON.parse(htp.responseText)

			var div = '';

			cityDetails.innerHTML = '';

			var opt = document.createElement("option");
			opt.text = 'Select City';
			opt.value = '';

			cityDetails.options.add(opt);

			for (var i = 0; i < jsn.length; i++) {

				var opt = document.createElement("option");
				opt.text = jsn[i].cityName;
				opt.value = jsn[i].cityId;

				cityDetails.options.add(opt);

			}
		}
	}
	htp.open("get", "searchCityByState?id=" + stateDetails.value, true);
	htp.send();
}

function searchData() {
	var stateDetails = document.getElementById("stateDetails");
	var cityDetails = document.getElementById("cityDetails");
	var airlineDetails = document.getElementById("airlineDetails");

	var query = '?';

	if (stateDetails && stateDetails.value !== '') {
		query = query + '&stateId=' + stateDetails.value;
	}
	if (cityDetails && cityDetails.value !== '') {
		query = query + '&cityId=' + cityDetails.value;
	}
	if (airlineDetails && airlineDetails.value !== '') {
		query = query + '&airlineId=' + airlineDetails.value;
	}
	var htp = new XMLHttpRequest();
	htp.onreadystatechange = function() {

		if (htp.readyState == 4) {

			var jsn = JSON.parse(htp.responseText)

			var div = '';

			$('#flightList').html('');
			for (var i = 0; i < jsn.length; i++) {
				div = div
						+ '<div class="hotel-item style-10 bg-white">'
						+ '<div class="table-view">'
						+ '<div class="radius-top cell-view">'
						+ '	<img src="/userResources/image/flight.jpg" alt="">'
						+ '</div>'
						+ '<div class="title hotel-middle cell-view">'
						+ '	<h4>'
						+ '		<b>'
						+ jsn[i].departureCity.cityName
						+ ' -> '
						+ jsn[i].arrivalCity.cityName
						+ '</b>'
						+ '	</h4>'
						+ '	<div class="fi_block grid-hidden row row10">'
						+ '		<div class="flight-icon col-xs-6 col10">'
						+ '			<img class="fi_icon" src="/userResources/image/flight_icon_2.png" alt="">'
						+ '			<div class="fi_content">'
						+ '				<div class="fi_title color-dark-2">take off</div>'
						+ '				<div class="fi_text color-grey">'
						+ jsn[i].departureTime
						+ '</div>'
						+ '			</div>'
						+ '		</div>'
						+ '		<div class="flight-icon col-xs-6 col10">'
						+ '			<img class="fi_icon" src="/userResources/image/flight_icon_1.png" alt="">'
						+ '			<div class="fi_content">'
						+ '				<div class="fi_title color-dark-2">Landing</div>'
						+ '				<div class="fi_text color-grey">'
						+ jsn[i].arrivalTime
						+ '</div>'
						+ '			</div>'
						+ '		</div>'
						+ '	</div>'
						+ '	<a href="#" class="c-button b-40 bg-red-3 hv-red-3-o" '
						+ ' onclick="predictFlight(\''
						+ jsn[i].departureState.stateName
						+ '\', \''
						+ jsn[i].arrivalState.stateName
						+ '\','
						+ '\''
						+ jsn[i].departureCity.cityName
						+ '\','
						+ '\''
						+ jsn[i].arrivalCity.cityName
						+ '\','
						+ '\''
						+ jsn[i].departureAirport.airportName
						+ '\','
						+ '\''
						+ jsn[i].arrivalAirport.airportName
						+ '\','
						+ '\''
						+ jsn[i].airtime
						+ '\','
						+ '\''
						+ jsn[i].airlineVO.airlineName
						+ '\','
						+ '\''
						+ jsn[i].flightNumber
						+ '\','
						+ '\''
						+ jsn[i].departureTime
						+ '\','
						+ '\''
						+ jsn[i].arrivalTime
						+ '\','
						+ '\''
						+ jsn[i].price
						+ '\','
						+ '\''
						+ jsn[i].weekDays
						+ '\''
						+ ')">Predict</a>'
						+ '</div>'
						+ '<div class="title hotel-right clearfix cell-view grid-hidden">'
						+ '	<div class="hotel-right-text color-dark-2"><strong class="color-red-3">'
						+ jsn[i].price
						+ '</strong></div>'
						+ '	<div class="hotel-right-text color-dark-2">per person</div>'
						+ '</div>' + '	</div>' + '</div>';
			}
			$('#flightList').html(div);
		}
	}
	htp.open("get", "searchFlightForUser" + query, true);
	htp.send();

}

function predictFlight(departureState, arrivalState, departureCity,
		arrivalCity, deptAirportName, arrivalAirport, airTime, airlineName,
		flightNumber, deptTime, arrTime, price, weekDays) {

	var query = '';

	query = query + '?depStateName=' + departureState;
	query = query + '&arrStateName=' + arrivalState;
	query = query + '&depCityName=' + departureCity;
	query = query + '&arrCityName=' + arrivalCity;
	query = query + '&depAirportName=' + deptAirportName;
	query = query + '&arrAirportName=' + arrivalAirport;
	query = query + '&airTime=' + airTime;
	query = query + '&airlineName=' + airlineName;
	query = query + '&flightNumber=' + flightNumber;
	query = query + '&schedDepTime=' + deptTime;
	query = query + '&schedArrTime=' + arrTime;

	console.log(query);

	var weekdaysData = '';
	var data = weekDays.split(",");

	for (var index = 0; index < data.length; index++) {

		if (data[index] === '1') {
			weekdaysData = weekdaysData + 'Monday, ';
		} else if (data[index] === '2') {
			weekdaysData = weekdaysData + 'Tuesday, ';
		} else if (data[index] === '3') {
			weekdaysData = weekdaysData + 'Wednesday, ';
		} else if (data[index] === '4') {
			weekdaysData = weekdaysData + 'Thursday, ';
		} else if (data[index] === '5') {
			weekdaysData = weekdaysData + 'Friday, ';
		} else if (data[index] === '6') {
			weekdaysData = weekdaysData + 'Saturday, ';
		} else if (data[index] === '7') {
			weekdaysData = weekdaysData + 'Sunday';
		}

	}

	var htp = new XMLHttpRequest();
	htp.onreadystatechange = function() {

		if (htp.readyState == 4) {
			var jsn = JSON.parse(htp.responseText);
			$('#modalAirlineName').html(airlineName);
			$('#modalFlightNamber').html(flightNumber);
			$('#modalWeekDays').html(weekdaysData);
			$('#modalFormState').html(departureState);
			$('#modalFormCity').html(departureCity);
			$('#modalFormAirport').html(deptAirportName);
			$('#modalDepartureTime').html(deptTime);
			$('#modalToState').html(arrivalState);
			$('#modalToCity').html(arrivalCity);
			$('#modalToAirport').html(arrivalAirport);
			$('#modalArrivalTime').html(arrTime);
			$('#modalPrice').html(price);
			$("#modalPrediction").html(jsn['departure_delay']);
			$('#exampleModal-4').modal('show');
		}
	}
	htp.open("get", "http://127.0.0.1:5678/" + query, true);
	htp.send();

}