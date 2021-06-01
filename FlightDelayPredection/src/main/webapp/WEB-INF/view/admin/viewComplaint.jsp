<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin | View Complaint</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- Plugin css for this page -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/dataTables.bootstrap4.css">
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResources/image/favicon.png" />
</head>

<body class="sidebar-light">
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->

		<jsp:include page="header.jsp"></jsp:include>


		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->


			<jsp:include page="menu.jsp"></jsp:include>


			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="card">
						<div class="card-body">
							<h5>View Complaint</h5>
							<div class="row">
								<div class="col-12">
									<div class="table-responsive">
										<table id="order-listing" class="table">
											<thead>
												<tr>
													<th>No</th>
													<th>Subject</th>
													<th>Description</th>
													<th>User</th>
													<th>Complaint Date</th>
													<th>Reply Date</th>
													<th>Reply</th>
													<th>Status</th>
													<th>File</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${complaintList}" var="i" varStatus="j">
													<tr>
														<td>${j.count}
														<td>${i.complainSubject}</td>
														<td>${i.complainDescription}</td>
														<td>${i.loginVO.username}</td>
														<td>${i.complainDate}</td>
														<td>${i.replyDate}</td>
														<td>${i.complainReply}</td>
														<td>
															<c:if test="${ i.complainStatus eq 'Pending'}">
																<a class="badge badge-warning" href="complainReply?complainId=${i.complainId}">Reply</a>
															</c:if>
															<c:if test="${i.complainStatus eq 'resolved'}">
																<div class="badge badge-success">Resolved</div>
															</c:if>
														</td>
														<td><a
															href="<%=request.getContextPath()%>/docs/complain/${i.fileName}"
															target="blank" download><i class="mdi mdi-attachment"  style="font-size:30px"></i></a></td>
														
														
														<td><a href="deleteComplaint?complainId=${i.complainId}"><i
																style="font-size: 20px; margin-left: 15px; color: #f36262"
																class="mdi mdi-delete"></i></a></td>
													</tr>
												</c:forEach>

											</tbody>
										</table>
									</div>
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
	<script src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page-->
	<script src="<%=request.getContextPath()%>/adminResources/js/jquery.dataTables.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/dataTables.bootstrap4.js"></script>
	<!-- End plugin js for this page-->
	<!-- inject:js -->
	<script src="<%=request.getContextPath()%>/adminResources/js/off-canvas.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/hoverable-collapse.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/template.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/settings.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script src="<%=request.getContextPath()%>/adminResources/js/data-table.js"></script>
	<!-- End custom js for this page-->
</body>

</html>
