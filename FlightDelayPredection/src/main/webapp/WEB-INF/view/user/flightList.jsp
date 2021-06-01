<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no" />

<link rel="shortcut icon" href="favicon.ico" />
<link
	href="<%=request.getContextPath()%>/userResources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/userResources/css/jquery-ui.structure.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/userResources/css/jquery-ui.min.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/userResources/css/font-awesome.min.css">
<link href="<%=request.getContextPath()%>/userResources/css/style.css"
	rel="stylesheet" type="text/css" />
<title>Let's Travel</title>
</head>
<body data-color="theme-1">


	<!-- HEADER -->
	<jsp:include page="header.jsp"></jsp:include>

	<div class="inner-banner style-6">
		<img class="center-image"
			src="<%=request.getContextPath()%>/userResources/image/bg_3.jpg"
			alt="">
		<div class="vertical-align">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 col-md-8 col-md-offset-2">
						<ul class="banner-breadcrumb color-white clearfix">
							<li><a class="link-blue-2" href="#">home</a> /</li>
							<li><a class="link-blue-2" href="#">Flights</a></li>
						</ul>
						<h2 class="color-white">Flights</h2>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="list-wrapper bg-grey-2">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-4 col-md-3">
					<div class="sidebar bg-white clearfix">
						<div class="sidebar-block">
							<h4 class="sidebar-title color-dark-2">search</h4>
							<div class="search-inputs">
								<div class="drop-wrap drop-wrap-s-4 color-4 list-sort">
									<div class="drop">
										<select id="stateDetails" onchange="searchCity()">
											<option selected="selected" value="">Select State</option>
											<c:forEach items="${stateList}" var="i">
												<option value="${i.stateId}">${i.stateName}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="drop-wrap drop-wrap-s-4 color-4 list-sort">
									<div class="drop">
										<select id="cityDetails">
											<option selected="selected" value="">Select City</option>
										</select>
									</div>
								</div>

								<div class="drop-wrap drop-wrap-s-4 color-4 list-sort">
									<div class="drop">

										<select id="airlineDetails">
											<option selected="selected" value="">Select Airline</option>
											<c:forEach items="${airlineList}" var="i">
												<option value="${i.airlineId}">${i.airlineName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
						</div>

						<div class="sidebar-block" style="margin-top: 150px;">
							<h4 class="sidebar-title color-dark-2">Week Days</h4>
							<div class="sidebar-rating" style="padding-left: 20px">
								<div class="input-entry color-7">
									<input class="checkbox-form" id="text-1" type="checkbox"
										name="checkbox" value="climat control"> <label
										class="clearfix" for="text-1"> <span class="sp-check"><i
											class="fa fa-check"></i></span> <span class="checkbox-text">Monday</span>
									</label>
								</div>
								<div class="input-entry color-7">
									<input class="checkbox-form" id="text-2" type="checkbox"
										name="checkbox" value="climat control"> <label
										class="clearfix" for="text-2"> <span class="sp-check"><i
											class="fa fa-check"></i></span> <span class="checkbox-text">Tue</span>
									</label>
								</div>
								<div class="input-entry color-7">
									<input class="checkbox-form" id="text-3" type="checkbox"
										name="checkbox" value="climat control"> <label
										class="clearfix" for="text-3"> <span class="sp-check"><i
											class="fa fa-check"></i></span> <span class="checkbox-text">wed</span>
									</label>
								</div>
								<div class="input-entry color-7">
									<input class="checkbox-form" id="text-4" type="checkbox"
										name="checkbox" value="climat control"> <label
										class="clearfix" for="text-4"> <span class="sp-check"><i
											class="fa fa-check"></i></span> <span class="checkbox-text">Thu</span>
									</label>
								</div>
								<div class="input-entry color-7">
									<input class="checkbox-form" id="text-5" type="checkbox"
										name="checkbox" value="climat control"> <label
										class="clearfix" for="text-5"> <span class="sp-check"><i
											class="fa fa-check"></i></span> <span class="checkbox-text">Fri</span>
									</label>
								</div>
								<div class="input-entry color-7">
									<input class="checkbox-form" id="text-6" type="checkbox"
										name="checkbox" value="climat control"> <label
										class="clearfix" for="text-6"> <span class="sp-check"><i
											class="fa fa-check"></i></span> <span class="checkbox-text">Sat</span>
									</label>
								</div>
								<div class="input-entry color-7">
									<input class="checkbox-form" id="text-7" type="checkbox"
										name="checkbox" value="climat control"> <label
										class="clearfix" for="text-7"> <span class="sp-check"><i
											class="fa fa-check"></i></span> <span class="checkbox-text">Sun</span>
									</label>
								</div>
							</div>
							<input type="submit" class="c-button b-40 bg-red-3 hv-red-3-o"
								value="search" onclick="searchData()">
						</div>

					</div>
				</div>
				<div class="col-xs-12 col-sm-8 col-md-9">
					<div class="list-header clearfix">

						<div class="list-view-change">
							<div class="change-grid color-4 fr">
								<i class="fa fa-th"></i>
							</div>
							<div class="change-list color-4 fr active">
								<i class="fa fa-bars"></i>
							</div>
							<div class="change-to-label fr color-grey-8">View:</div>
						</div>
					</div>
					<div class="list-content clearfix">
						<div class="list-item-entry" id="flightList">
						</div>
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
											<div class="col-6">
												<h4>To</h4>
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
										</div>

										<div class="form-group m-0" style="text-align: center">
											<label style="font-size: 20px" class="m-0 col-form-label"><strong>
													Price :<i class="mdi mdi-currency-inr"></i>
											</strong><u id="modalPrice"></u></label>
										</div>
										<div class="form-group m-0" style="text-align: center">
											<label style="font-size: 20px" class="m-0 col-form-label"><strong>
													Prediction :<i class="mdi mdi-currency-inr"></i>
											</strong><u id="modalPrediction"></u></label>
										</div>

									</form>
								</div>
							</div>
						</div>
					</div>

	<jsp:include page="footer.jsp"></jsp:include>

	<script
		src="<%=request.getContextPath()%>/userResources/js/jquery-2.1.4.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/userResources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/userResources/js/jquery-ui.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/userResources/js/idangerous.swiper.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/userResources/js/jquery.viewportchecker.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/userResources/js/isotope.pkgd.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/userResources/js/jquery.mousewheel.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/userResources/js/custom/Citydetail.js"></script>
	<script src="<%=request.getContextPath()%>/userResources/js/all.js"></script>
</body>
</html>
