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
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href="<%=request.getContextPath()%>/userResources/css/style.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/userResources/css/font-awesome.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/userResources/css/star.css"
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
							<li><a class="link-blue-2" href="#">feedback</a></li>
						</ul>
						<h2 class="color-white">FeedBack</h2>
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
					<h4 class="additional-title">Post FeedBack</h4>
					<f:form action="saveFeedback" modelAttribute="FeedbackVO"
						method="post">
						<div class="row">
							<div class="col-xs-12">

								<div class="form-block type-2 clearfix">
									<fieldset class="rating">
										<f:radiobutton id="star5" name="rating" value="5"
											path="feedbackRating"></f:radiobutton>
										<label class="full" for="star5" title="Awesome - 5 stars"></label>
										<f:radiobutton id="star4" name="rating" value="4"
											path="feedbackRating"></f:radiobutton>
										<label class="full" for="star4" title="Pretty good - 4 stars"></label>
										<f:radiobutton id="star3" name="rating" value="3"
											path="feedbackRating"></f:radiobutton>
										<label class="full" for="star3" title="Meh - 3 stars"></label>
										<f:radiobutton id="star2" name="rating" value="2"
											path="feedbackRating"></f:radiobutton>
										<label class="full" for="star2" title="Kinda bad - 2 stars"></label>
										<f:radiobutton id="star1" name="rating" value="1"
											path="feedbackRating"></f:radiobutton>
										<label class="full" for="star1"
											title="Sucks big time - 1 star"></label>
									</fieldset>
									<br> <br>

									<div class="form-block type-2 clearfix">
										<f:textarea class="area-style-1 type-2 color-3"
											placeholder="Write a comment..." path="feedback"
											id="feedback"></f:textarea>
									</div>
									<f:hidden path="feedbackId" />
									<input type="submit"
										class="c-button b-40 fr bg-dr-blue-2 hv-dr-blue-2-o"
										value="Post FeedBack" style="float: left;">
								</div>
							</div>
						</div>
					</f:form>

					<div class="additional-block">
						<h4 class="additional-title" style="margin-top: 7rem;">User
							FeedBack</h4>
						<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>


						<ul class="comments-block">
							<c:forEach items="${feedbackList}" var="i">

								<li class="comment-entry clearfix"><img
									class="commnent-img"
									src="<%=request.getContextPath()%>/adminResources/image/avatar.png"
									alt="">
									<div class="comment-content clearfix">
										<div class="tour-info-line">
											<div class="tour-info">
												<img src="img/people_icon_grey.png" alt="">
												<c:forEach begin="1" end="${i.feedbackRating}">
													<span class="font-style-2 color-dark-2"> <i
														class="fa fa-star"></i>
													</span>
												</c:forEach>
											</div>
										</div>
										<div class="comment-text color-grey">${i.feedback}</div>
									</div></li>
							</c:forEach>
							<!-- ################ For Loop End Here ############## -->

						</ul>
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
