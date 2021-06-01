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

	<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

	<!-- INNER-BANNER -->
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
							<li><a class="link-blue-2" href="#">Complain</a> /</li>
						</ul>
						<h2 class="color-white">Complain</h2>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- BLOG -->
	<div class="detail-wrapper">
		<div class="container">
			<div class="row padd-90">
				<div class="col-xs-12 col-md-12">
					<div class="additional-block">
						<h4 class="additional-title">Post Complain</h4>
						<f:form action="saveComplain" modelAttribute="ComplainVO"
							method="post" enctype="multipart/form-data">
							<div class="row">
								<div class="col-xs-12 col-sm-6">
									<div class="form-block type-2 clearfix">
										<div class="input-style-1 b-50 brd-0 type-2 color-3">
											<f:input type="text" placeholder="Enter Complain Subject"
												path="complainSubject" id="complainSubject"></f:input>
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-6">
									<div class="form-block type-2 clearfix">
										<div class="input-style-1 b-50 brd-0 type-2 color-3">
											<input type="file" name="file"
												style="padding: 13px 20px 0px 21px" path="">
										</div>
									</div>
								</div>
								<div class="col-xs-12">
									<div class="form-block type-2 clearfix">
										<f:textarea class="area-style-1 type-2 color-3"
											path="complainDescription" id="complainDescription"
											placeholder="Write Your Complain..."></f:textarea>
									</div>
									<f:hidden path="complainId" />
									<input type="submit"
										class="c-button b-40 fr bg-dr-blue-2 hv-dr-blue-2-o"
										value="post Complain" style="float: left;">
								</div>

							</div>
						</f:form>

						<h4 class="additional-title" style="margin-top: 15vh;">View
							Complain</h4>

						<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

						<c:forEach items="${complaintList}" var="i">
							<ul class="comments-block">
								<li class="comment-entry clearfix"><img
									class="commnent-img"
									src="<%=request.getContextPath()%>/userResources/image/comment_1.jpg"
									alt="">
									<div class="comment-content clearfix">
										<div class="tour-info-line" style="padding: 0px">
											<div class="tour-info" style="margin-top: -20px">
												<img src="img/people_icon_grey.png" alt=""> <span
													class="font-style-2 color-dark-2"><h5>${i.loginVO.username}</h5></span>
											</div>


											<div class="tour-info">
												<span class="font-style-2"><a href="<%=request.getContextPath()%>/docs/complaint/${i.fileName}" download ><i class="fa fa-paperclip" style="font-size: 20px"></i></a></span>
											</div>

											<div class="tour-info" style="float: right;">
												<img src="img/calendar_icon_grey.png" alt=""> <span
													class="font-style-2 color-dark-2">${i.complainDate}</span>

											</div>

										</div>

										<div class="comment-text color-grey">
											<b>Subject :</b> ${i.complainSubject}
										</div>
										<div class="comment-text color-grey">
											<b>Description :</b> ${i.complainDescription}
										</div>


									</div>
									<ul class="comments-block">
										<li class="comment-entry clearfix"><img
											class="commnent-img"
											src="<%=request.getContextPath()%>/userResources/image/comment_2.jpg"
											alt="">
											<div class="comment-content clearfix">
												<div class="tour-info-line" style="padding: 0px">

													<div class="tour-info" style="margin-top: -20px">
														<img src="img/people_icon_grey.png" alt=""> <span
															class="font-style-2 color-dark-2"><h5>Admin</h5></span>
													</div>


													<div class="tour-info" style="float: right;">
														<img
															src="<%=request.getContextPath()%>/userResources/img/calendar_icon_grey.png"
															alt=""> <span class="font-style-2 color-dark-2">${i.replyDate}</span>
													</div>

												</div>
												<div class="comment-text color-grey">
													<b>Reply : </b>${i.complainReply}.</div>
											</div></li>
									</ul></li>
							</ul>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- FOOTER -->


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
		src="<%=request.getContextPath()%>/userResources/js/jquery.circliful.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/userResources/js/jquery.mousewheel.min.js"></script>
	<script src="<%=request.getContextPath()%>/userResources/js/all.js"></script>
</body>
</html>
