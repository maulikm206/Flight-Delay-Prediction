
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
<title>Login</title>
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
							<div class="f-login-title color-dr-blue-2">Welcome back!</div>
							<div class="f-login-desc color-grey">Please login to your
								account</div>
						</div>
						<form class="f-login-form" action="/j_spring_security_check"
							method="post">
							<div class="input-style-1 b-50 type-2 color-5">
								<input type="text" placeholder="Enter your email or username"
									name="username" required>
							</div>
							<div class="input-style-1 b-50 type-2 color-5">
								<input placeholder="Enter your password" name="password"
									type="password" required>
							</div>
							<input type="submit" style="margin-top: 10px"
								class="login-btn c-button full b-60 bg-dr-blue-2 hv-dr-blue-2-o"
								value="LOGIN TO YOUR ACCOUNT">
						</form>
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
	<script src="userResources/js/isotope.pkgd.min.js"></script>
	<script src="userResources/js/jquery.mousewheel.min.js"></script>
	<script src="userResources/js/jquery.circliful.min.js"></script>
	<script src="userResources/js/all.js"></script>
</body>
</html>
