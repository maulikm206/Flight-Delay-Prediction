/*#######################################################
###################### Add State ######################
#######################################################*/
function addState() {

	if ($('#stateName').val().trim() === '') {
		$('#stateName').focus()
		showErrorToast('Please Enter State Name')
		return false;

	} else if ($('#stateName').val().length < 3) {
		$('#stateName').focus()
		showErrorToast('Please Enter Valid State Name')
		return false;

	} else if ($('#stateDescription').val().trim() === '') {
		$('#stateDescription').focus()
		showErrorToast('Please Enter State Description')
		return false;

	} else {
		return true;
	}
}

/*#######################################################
###################### Add City ######################
#######################################################*/

function addCity() {

	if ($('#stateName').val() == "none") {
		$('#stateName').focus()
		showErrorToast('Please Select City')
		return false;
	} else if ($('#cityName').val().trim() === '') {
		$('#cityName').focus()
		showErrorToast('Please Enter City Name')
		return false;
	} else if ($('#cityDescription').val().trim() === '') {
		$('#cityDescription').focus()
		showErrorToast('Please Enter City Description')
		return false;
	} else {
		return true;
	}
}

/*#######################################################
###################### Add Airline ######################
#######################################################*/

function addAirline() {

	if ($('#airlineName').val().trim() === '') {
		$('#airlineName').focus()
		showErrorToast('Please Enter Airline Name')
		return false;

	} else if ($('#airlineName').val().length < 3) {
		$('#airlineName').focus()
		showErrorToast('Please Enter Valid Airline Name')
		return false;

	} else if ($('#airlineDescription').val().trim() === '') {
		$('#airlineDescription').focus()
		showErrorToast('Please Enter Airline Description')
		return false;

	} else {
		return true;
	}
}

/*#######################################################
###################### Add Airport ######################
#######################################################*/

function addAirport() {

	if ($('#stateName').val() == "none") {
		$('#stateName').focus()
		showErrorToast('Please Select State')
		return false;
	} else if ($('#cityName').val() == "none") {
		$('#cityName').focus()
		showErrorToast('Please Select City')
		return false;
	} else if ($('#airportName').val().trim() === '') {
		$('#airportName').focus()
		showErrorToast('Please Enter Airport Name')
		return false;
	} else if ($('#airportDescription').val().trim() === '') {
		$('#airportDescription').focus()
		showErrorToast('Please Enter Airport Description')
		return false;
	}
	else {
		return true;
	}

}

/*#######################################################
###################### Add Dataset ######################
#######################################################*/

function addAirport() {

	if ($('#DatasetName').val() == "") {
		$('#DatasetName').focus()
		showErrorToast('Please Enter Dataset Name')
		return false;
	} else if ($('#DatasetDescription').val() == "") {
		$('#DatasetDescription').focus()
		showErrorToast('Please Enter Dataset Description')
		return false;
	} else if ($('#uploadDataset').val() == "") {
		$('#uploadDataset').focus()
		showErrorToast('Please Enter Upload Dataset')
		return false;
	} 
	else {
		return true;
	}
}

/*#######################################################
################### Flight Schedule #####################
#######################################################*/

function flightSchedule() {
	if ($('#airlineName').val() == "none") {
		$('#airlineName').focus()
		showErrorToast('Please Enter Airline Name')
		return false;
	} else if ($('#flightNumber').val() == "") {
		$('#flightNumber').focus()
		showErrorToast('Please Enter Flight Number')
		return false;
	} else if ($('#fromCityName').val() == "none") {
		$('#fromCityName').focus()
		showErrorToast('Please Enter From City Name')
		return false;
	} else if ($('#fromAirportName').val() == "none") {
		$('#fromAirportName').focus()
		showErrorToast('Please Enter From Airport Name')
		return false;
	} else if ($('#departureTime').val() == "") {
		$('#departureTime').focus()
		showErrorToast('Please Enter Departure Time')
		return false;
	} else if ($('#toStateName').val() == "none") {
		$('#toStateName').focus()
		showErrorToast('Please Enter To State Name')
		return false;
	} else if ($('#toCityName').val() == "none") {
		$('#toCityName').focus()
		showErrorToast('Please Enter To City Name')
		return false;
	} else if ($('#toAirportName').val() == "none") {
		$('#toAirportName').focus()
		showErrorToast('Please Enter To Airport Name')
		return false;
	} else if ($('#arrivalTime').val() == "") {
		$('#arrivalTime').focus()
		showErrorToast('Please Enter To Arrival Time')
		return false;
	} else if ($('#price').val() == "") {
		$('#price').focus()
		showErrorToast('Please Enter Price')
		return false;
	}
	else {
		return true;
	}
}

