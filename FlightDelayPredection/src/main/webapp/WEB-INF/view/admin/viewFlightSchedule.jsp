<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin | View FlightSchedule</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- Plugin css for this page -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/dataTables.bootstrap4.css">
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/style.css">
<!-- endinject -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/adminResources/image/favicon.png" />
</head>

<body class="sidebar-light">
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->

		<jsp:include page="header.jsp"></jsp:include>


		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->


			<jsp:include page="menu.jsp"></jsp:include>
			<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>


			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">

					<div class="row grid-margin">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<h4>View Flight Schedule</h4>

									<form class="cmxform" id="commentForm" method="post"
										action="saveFlightSchedule">
										<fieldset>

											<div class="form-group row">

												<div class="col-sm-4">


													<select class="form-control" name="airlineName"
														id="airlineName">
														<option selected="selected" disabled="disabled">Select Airline</option>
														
														<c:forEach items="${airlineList}" var="i">
															
															<option value="${i.airlineId}">${i.airlineName}</option>
															
														</c:forEach>
													</select>
												</div>

												<div class="col-sm-4">


													<select class="form-control" name="stateName"
														id="stateName" onChange="searchCity()">
														<option selected="selected" disabled="disabled">Select State</option>

														<c:forEach items="${stateList}" var="i">
															<option value="${i.stateId}">${i.stateName}</option>
														</c:forEach>
													</select>
												</div>

												<div class="col-sm-4">


													<select class="form-control" name="stateName" id="cityName"
														onchange="flightDtails()">

														<option selected="selected" disabled="disabled">Select City</option>

													</select> 
												</div>
											</div>
										</fieldset>
									</form>
								</div>
							</div>
						</div>
					</div>


					<div class="card">
						<div class="card-body">
							<h4 class="card-title">View FlightSchedule</h4>

							<div class="row">
								<div class="col-12">
									<div class="table-responsive">
										<table class="table">
											<thead>
												<tr>
													<th>No.</th>
													<th>Airline Number</th>
													<th>Action</th>
													<th>More Info.</th>
												</tr>
											</thead>
											<tbody id="flightTable">

											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>


					<!-- ####################### Modal Start ########################3 -->

					<div class="modal fade" id="exampleModal-4" tabindex="-1"
						role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="ModalLabel">Airline Details</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<form>
										<div class="row">
											<div class="col-6">
												<div class="form-group m-0">
													<label for="recipient-name" class=" m-0 col-form-label"><strong>Airline
															Name :</strong> <u id="modalAirlineName"></u></label>
												</div>
											</div>
											<div class="col-6">
												<div class="form-group m-0">
													<label for="message-text" class="col-form-label"><strong>Flight
															Number:</strong> <u id="modalFlightNamber"></u></label>
												</div>
											</div>
										</div>

										<div class="form-group">
											<label for="message-text" class="col-form-label"><strong
												class="mr-3">Week Days :</strong><u id="modalWeekDays"></u></label>
										</div>

										<div class="row">
											
											<div class="col-6">
												<h4>From</h4>
												<div class="form-group m-0">
													<label for="recipient-name" class=" m-0 col-form-label"><strong>State
															:</strong> <u id="modalToState"></u></label>
												</div>
												<div class="form-group m-0">
													<label for="message-text" class="m-0 col-form-label"><strong>City
															:</strong> <u id="modalToCity"></u></label>
												</div>
												<div class="form-group m-0">
													<label for="message-text" class="m-0 col-form-label"><strong>AirPort
															:</strong> <u id="modalToAirport"></u></label>
												</div>
												<div class="form-group m-0">
													<label for="message-text" class="m-0 col-form-label"><strong>Arrival
															Time :</strong> <u id="modalArrivalTime"></u></label>
												</div>
											</div>
											<div class="col-6">
												<h4>To</h4>
												<div class="form-group m-0">
													<label for="recipient-name" class=" m-0 col-form-label"><strong>State
															:</strong> <u id="modalFormState"></u></label>
												</div>
												<div class="form-group m-0">
													<label for="message-text" class="m-0 col-form-label"><strong>City
															:</strong> <u id="modalFormCity"></u></label>
												</div>
												<div class="form-group m-0">
													<label for="message-text" class="m-0 col-form-label"><strong>AirPort
															:</strong> <u id="modalFormAirport"></u></label>
												</div>
												<div class="form-group m-0">
													<label for="message-text" class="m-0 col-form-label"><strong>Departure
															Time :</strong> <u id="modalDepartureTime"></u></label>
												</div>
											</div>
										</div>

										<div class="form-group m-0" style="text-align: center">
											<label style="font-size: 20px" class="m-0 col-form-label"><strong>
													Price :<i class="mdi mdi-currency-inr"></i>
											</strong><u id="modalPrice"></u></label>
										</div>

									</form>
								</div>
							</div>
						</div>
					</div>

					<!-- ####################### Modal End ########################3 -->

				</div>
				<!-- content-wrapper ends -->
				<!-- partial:../../partials/_footer.html -->



				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page-->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.dataTables.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/dataTables.bootstrap4.js"></script>
	<!-- End plugin js for this page-->
	<!-- inject:js -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/off-canvas.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/hoverable-collapse.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/template.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/settings.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/data-table.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/custom/Citydetails.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/custom/FlightSchedule.js"></script>
	<!-- End custom js for this page-->
</body>

</html>
