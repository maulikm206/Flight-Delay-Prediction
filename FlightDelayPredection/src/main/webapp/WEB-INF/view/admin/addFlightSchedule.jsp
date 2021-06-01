<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin | Add Flight Schedule</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- Plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/jquery.toast.min.css">
<!-- endinject -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/adminResources/image/favicon.png" />
<style type="text/css">
.dayspace {
	margin-left: 55px;
}
</style>
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
			<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row grid-margin">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<h4>Flight Schedule</h4>

									<f:form class="cmxform" id="commentForm" method="post" onsubmit="return flightSchedule()"
										action="saveFlightSchedule" modelAttribute="FlightScheduleVO">
										<fieldset>

											<div class="form-group row">
												<label for="exampleInputUsername2"
													class="col-sm-3 col-form-label">Airline Name</label>
												<div class="col-sm-9">
													<f:select class="form-control form-control-sm"
														name="airlineName" id="airlineName"
														path="airlineVO.airlineId">
														<option selected="selected" value="none">Select Airline Name</option>
														
														<c:forEach items="${airlineList}" var="i">
															<option value="${i.airlineId}">${i.airlineName}</option>
														</c:forEach>
													</f:select>
												</div>
											</div>

											<div class="form-group row">
												<label for="exampleInputUsername2"
													class="col-sm-3 col-form-label">flight no.</label>
												<div class="col-sm-9">
													<f:input type="text" class="form-control" id="flightNumber"
														path="flightNumber" />
												</div>
											</div>

											<div class="form-group row" style="margin-left: 3rem">
												<div class="dayspace">
													<div class="form-check form-check-primary">
														<label class="form-check-label"> <input
															name="weekDays" type="checkbox" class="form-check-input"
															value="1"> Monday <i class="input-helper"></i></label>
													</div>
												</div>
												<div class="dayspace">
													<div class="form-check form-check-primary">
														<label class="form-check-label"> <input
															name="weekDays" type="checkbox" class="form-check-input"
															value="2"> Tuesday <i class="input-helper"></i></label>
													</div>
												</div>
												<div class="dayspace">
													<div class="form-check form-check-primary">
														<label class="form-check-label"> <input
															name="weekDays" type="checkbox" class="form-check-input"
															value="3"> Wednesday <i class="input-helper"></i></label>
													</div>
												</div>

												<div class="dayspace">
													<div class="form-check form-check-primary">
														<label class="form-check-label"> <input
															name="weekDays" type="checkbox" class="form-check-input"
															value="4"> Thursday <i class="input-helper"></i></label>
													</div>
												</div>
												<div class="dayspace">
													<div class="form-check form-check-primary">
														<label class="form-check-label"> <input
															name="weekDays" type="checkbox" class="form-check-input"
															value="5"> Friday <i class="input-helper"></i></label>
													</div>
												</div>
												<div class="dayspace">
													<div class="form-check form-check-primary">
														<label class="form-check-label"> <input
															name="weekDays" type="checkbox" class="form-check-input"
															value="6"> Saturday <i class="input-helper"></i></label>
													</div>
												</div>


												<div class="dayspace">
													<div class="form-check form-check-primary">
														<label class="form-check-label"> <input
															name="weekDays" type="checkbox" class="form-check-input"
															value="7"> Sunday <i class="input-helper"></i></label>
													</div>
												</div>


											</div>

											<div class="form-group row">
												<div class="col-md-6">
													<h4 class="card-title"
														style="text-align: center; font-weight: bold;">FROM</h4>
													<div class="form-group row">
														<label for="exampleInputUsername2"
															class="col-sm-3 col-form-label">State</label>
														<div class="col-sm-9">
															<f:select class="form-control form-control-sm"
																name="stateName" id="fromStateName"
																path="departureState.stateId">
																<option selected="selected" value="none">Select State</option>
																<c:forEach items="${stateList}" var="i">
																	<option value="${i.stateId}">${i.stateName}</option>
																</c:forEach>
															</f:select>
														</div>
													</div>

													<div class="form-group row">

														<label for="exampleInputUsername2"
															class="col-sm-3 col-form-label">City</label>
														<div class="col-sm-9">
															<f:select class="form-control form-control-sm"
																name="cityName" id="fromCityName"
																path="departureCity.cityId">
																<option selected="selected" value="none">Select City</option>
																<c:forEach items="${cityList}" var="i">
																	<option value="${i.cityId}">${i.cityName}</option>
																</c:forEach>
															</f:select>
														</div>
													</div>
													<div class="form-group row">

														<label for="exampleInputUsername2"
															class="col-sm-3 col-form-label">Airport</label>
														<div class="col-sm-9">
															<f:select class="form-control form-control-sm"
																name="airportName" id="fromAirportName"
																path="departureAirport.airportId">
																<option selected="selected" value="none">Select Airport</option>
																<c:forEach items="${airportList}" var="i">
																	<option value="${i.airportId}">${i.airportName}</option>
																</c:forEach>
															</f:select>

														</div>

													</div>

													<div class="form-group row">
														<label for="exampleInputUsername2"
															class="col-sm-3 col-form-label">Departure Time:</label>
														<div class="col-sm-9">
															<f:input type="time" class="form-control"
																id="departureTime" path="departureTime" />
														</div>
													</div>
												</div>
												<div class="col-md-6">
													<h4 class="card-title"
														style="text-align: center; font-weight: bold;">TO</h4>
													<div class="form-group row">
														<label for="exampleInputUsername2"
															class="col-sm-3 col-form-label">State</label>
														<div class="col-sm-9">
															<f:select class="form-control form-control-sm"
																name="stateName" id="toStateName"
																path="arrivalState.stateId">
																<option selected="selected" value="none">Select State</option>
																<c:forEach items="${stateList}" var="i">
																	<option value="${i.stateId}">${i.stateName}</option>
																</c:forEach>
															</f:select>
														</div>
													</div>

													<div class="form-group row">

														<label for="exampleInputUsername2"
															class="col-sm-3 col-form-label">City</label>
														<div class="col-sm-9">
															<f:select class="form-control form-control-sm"
																name="cityName" id="toCityName" path="arrivalCity.cityId">
																<option selected="selected" value="none">Select City</option>
																<c:forEach items="${cityList}" var="i">
																	<option value="${i.cityId}">${i.cityName}</option>
																</c:forEach>
															</f:select>

														</div>
													</div>
													<div class="form-group row">

														<label for="exampleInputUsername2"
															class="col-sm-3 col-form-label">Airport</label>
														<div class="col-sm-9">
															<f:select class="form-control form-control-sm"
																name="airportName" id="toAirportName"
																path="arrivalAirport.airportId">
																<option selected="selected" value="none">Select Airport</option>
																<c:forEach items="${airportList}" var="i">
																	<option value="${i.airportId}">${i.airportName}</option>
																</c:forEach>
															</f:select>

														</div>
													</div>

													<div class="form-group row">
														<label for="exampleInputUsername2"
															class="col-sm-3 col-form-label">Arrival Time:</label>
														<div class="col-sm-9">
															<f:input type="time" class="form-control"
																id="arrivalTime" path="arrivalTime" />
														</div>
													</div>
												</div>
											</div>

											<div class="form-group row">
												<label for="exampleInputUsername2"
													class="col-sm-1 col-form-label">Price</label>
												<div class="col-sm-10">
													<f:input type="text" class="form-control"
														style="margin-left: 3rem" id="price" path="price" />
												</div>
											</div>

											<f:hidden path="flightScheduleId" />
											<button type="submit" style="margin-left: 30rem"
												class="btn btn-primary mr-2">Submit</button>
										</fieldset>
									</f:form>
								</div>
							</div>
						</div>
					</div>
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
	<!-- Plugin js for this page -->

	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.validate.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.toast.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/bootstrap-maxlength.min.js"></script>
	<!-- End plugin js for this page -->
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
		src="<%=request.getContextPath()%>/adminResources/js/form-validation.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/bt-maxLength.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/toaster.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/customValidtaion.js"></script>
	<!-- End custom js for this page-->
</body>

</html>
