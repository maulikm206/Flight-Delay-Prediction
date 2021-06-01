function flightDtails() {
	var cityName = document.getElementById("cityName");
	var flightTable = document.getElementById("flightTable");

	var modalAirlineName = document.getElementById("modalAirlineName");
	var modalFlightNumber = document.getElementById("modalFlightNamber");
	var modalWeekDays = document.getElementById("modalWeekDays");
	var modalFormState = document.getElementById("modalFormState");
	var modalFormCity = document.getElementById("modalFormCity");
	var modalFormAirport = document.getElementById("modalFormAirport");
	var modalDepartureTime = document.getElementById("modalDepartureTime");

	var modalToState = document.getElementById("modalToState");

	var modalToCity = document.getElementById("modalToCity");
	var modalToAirport = document.getElementById("modalToAirport");
	var modalArrivalTime = document.getElementById("modalArrivalTime");
	var modalPrice = document.getElementById("modalPrice");

	var htp = new XMLHttpRequest();

	htp.onreadystatechange = function() {

		if (htp.readyState == 4) {

			var jsn = JSON.parse(htp.responseText);

			var divisionData = '';

			for (var i = 0; i < jsn.length; i++) {

				var flightId = jsn[i].flightNumber;
				var data = jsn[i];
				var price = jsn[i].price;

				var airlineNumber = jsn[i].airlineVO.airlineName;
				var flightNumber = jsn[i].flightNumber;
				var weekdays = jsn[i].weekDays;

				var fromState = jsn[i].arrivalState.stateName;
				var fromCity = jsn[i].arrivalCity.cityName;
				var fromAirport = jsn[i].arrivalAirport.airportName;
				var fromDepartureTime = jsn[i].departureTime;

				var toState = jsn[i].departureState.stateName;
				var toCity = jsn[i].departureCity.cityName;
				var toAirport = jsn[i].departureAirport.airportName;
				var toArrivalTime = jsn[i].arrivalTime;

				divisionData = divisionData
						+ '<tr>'
						+ '<td>'
						+ (i + 1)
						+ '</td>'
						+ '<td>'
						+ jsn[i].airlineVO.airlineName
						+ ' ( '
						+ jsn[i].flightNumber
						+ ' ) '
						+ '</td>'
						+ '<td><i class="mdi mdi-pencil-box" style="font-size:20px;"></i><i class="mdi mdi-delete" style="font-size:20px;margin-left:15px;color:red"></i></td>'
						+ '<td><i onclick="getFlightInfo(\''+ airlineNumber +'\','
						+ '\''+ flightNumber+'\','
						+ '\''+ weekdays +'\','
						+ '\''+ fromState+'\','
						+ '\''+ fromCity+'\','
						+ '\''+ fromAirport+'\','
						+ '\''+ fromDepartureTime+'\','
						+ '\''+ toState+'\','
						+ '\''+ toCity+'\','
						+ '\''+ toAirport+'\','
						+ '\''+ toArrivalTime+'\','
						+ '\''+ price+'\''
						+ ')" class="mdi mdi-information-outline" style="cursor:pointer;font-size:25px; color:#5e2572;" data-toggle="modal" data-target="#exampleModal-4" data-whatever="@mdo"></i></td>'
						+ '</tr>';
			}

			flightTable.innerHTML = '';
			flightTable.innerHTML = divisionData;

			console.log(jsn);
		}
	}
	htp.open("get", "getFlightSheduleByCity?id=" + cityName.value, true);
	htp.send();

}

function getFlightInfo(airlineNumber, flightNumber, weekdays, fromState,
		fromCity, fromAirport, fromDepartureTime, toState, toCity, toAirport,
		toArrivalTime, price) {

	var weekdaysData = '';
	var data = weekdays.split(",");

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

	console.log(weekdaysData);

	$('#modalAirlineName').html(airlineNumber);
	$('#modalFlightNamber').html(flightNumber);
	$('#modalWeekDays').html(weekdaysData);
	$('#modalFormState').html(fromState);
	$('#modalFormCity').html(fromCity);
	$('#modalFormAirport').html(fromAirport);
	$('#modalDepartureTime').html(fromDepartureTime);
	$('#modalToState').html(toState);
	$('#modalToCity').html(toCity);
	$('#modalToAirport').html(toAirport);
	$('#modalArrivalTime').html(toArrivalTime);
	$('#modalPrice').html(price);

}
