<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin | Complain Reply</title>
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

			<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row grid-margin">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<h5>Post Reply</h5>

									<f:form action="saveReply" modelAttribute="ComplainVO"
										method="post">

										<div class="form-group row">
											<div class="col-lg-3">
												<label class="col-form-label">Complain Subject</label>
											</div>
											<div class="col-lg-8">
												<f:input class="form-control" maxlength="25"
													path="complainSubject" id="complainSubject"
													placeholder="Enter Comolain Subject..." />
											</div>
										</div>


										<div class="form-group row">
											<div class="col-lg-3">
												<label class="col-form-label">Complain Description</label>
											</div>
											<div class="col-lg-8">
												<f:textarea id="complainDescription" class="form-control"
													maxlength="100" rows="2" path="complainDescription"
													placeholder="Enter Complain Description..."></f:textarea>
											</div>
										</div>

										<div class="form-group row">
											<div class="col-lg-3">
												<label class="col-form-label">Complain Reply</label>
											</div>
											<div class="col-lg-8">
												<f:textarea id="complainReply" class="form-control"
													maxlength="100" rows="2" path="complainReply"
													placeholder="Enter Complain Reply..."></f:textarea>

											</div>
										</div>

										<f:hidden path="complainId" />
										<f:hidden path="complainDate" />
										<f:hidden path="filePath" />
										<f:hidden path="fileName" />
										<f:hidden path="status" />
										<f:hidden path="loginVO.loginId" />
										
										<input class="btn btn-primary" type="submit" value="Submit">
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
	<!-- End custom js for this page-->
</body>

</html>
