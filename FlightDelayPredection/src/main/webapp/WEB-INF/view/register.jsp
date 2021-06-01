
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no" />

<link rel="shortcut icon" href="favicon.ico" />
<link href="userResources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="userResources/css/jquery-ui.structure.min.css"
	rel="stylesheet" type="text/css" />
<link href="userResources/css/jquery-ui.min.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href="userResources/css/style.css" rel="stylesheet"
	type="text/css" />
<title>Register</title>
</head>
<body data-color="theme-1">

	<img class="center-image" src="userResources/image/bg-1.jpg" alt="">

	<div class="container">
		<div class="login-fullpage">
			<div class="row">
				<div class="login-logo">
					<img class="center-image" src="userResources/image/login.jpg"
						alt="">
				</div>


				<div class="col-xs-12 col-sm-7">
					<div class="f-login-content">
						<div class="f-login-header">
							<div class="f-login-title color-dr-blue-2">Register
								Yourself</div>
						</div>
						<%@taglib prefix="f"
							uri="http://www.springframework.org/tags/form"%>

						<f:form class="f-login-form" action="saveUserDetails"
							modelAttribute="RegisterVO" method="post">
							<div class="input-style-1 b-50 type-2 color-5">
								<f:input type="text" placeholder="Enter your First Name"
									path="firstName" />
							</div>

							<div class="input-style-1 b-50 type-2 color-5">
								<f:input type="text" placeholder="Enter your Last Name"
									path="lastName" />
							</div>

							<div class="input-style-1 b-50 type-2 color-5">
								<f:input type="text" placeholder="Enter your User Name"
									path="loginVO.username" />
							</div>

							<div class="input-style-1 b-50 type-2 color-5">
								<f:input type="password" placeholder="Enter your password."
									path="loginVO.password" />
							</div>

							<input type="submit" style="margin-top: 10px"
								class="login-btn c-button full b-60 bg-dr-blue-2 hv-dr-blue-2-o"
								value="LOGIN TO YOUR ACCOUNT">
						</f:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="userResources/js/jquery-2.1.4.min.js"></script>
	<script src="userResources/js/bootstrap.min.js"></script>
	<script src="userResources/js/jquery-ui.min.js"></script>
	<script src="userResources/js/idangerous.swiper.min.js"></script>
	<script src="userResources/js/jquery.viewportchecker.min.js"></script>
	<script src="userResource.
	0s/js/isotope.pkgd.min.js"></script>
	<script src="userResources/js/jquery.mousewheel.min.js"></script>
	<script src="userResources/js/jquery.circliful.min.js"></script>
	<script src="userResources/js/all.js"></script>
</body>
</html>
