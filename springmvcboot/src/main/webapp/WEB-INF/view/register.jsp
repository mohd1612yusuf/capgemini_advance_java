<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>User Register Page</title>

<style>
body {
	font-family: Arial, sans-serif;
	background: linear-gradient(to right, #4facfe, #00f2fe);
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.register-container {
	background-color: white;
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
	width: 350px;
}

h2 {
	text-align: center;
	margin-bottom: 20px;
	color: #333;
}

.form-group {
	margin-bottom: 15px;
}

label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
	color: #555;
}

/* ✅ Apply style to text, email AND password */
input[type="text"],
input[type="email"],
input[type="password"] {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 5px;
	outline: none;
	transition: 0.3s;
}

/* ✅ Focus effect */
input[type="text"]:focus,
input[type="email"]:focus,
input[type="password"]:focus {
	border-color: #4facfe;
	box-shadow: 0 0 5px rgba(79, 172, 254, 0.5);
}

input[type="submit"] {
	width: 100%;
	padding: 10px;
	border: none;
	border-radius: 5px;
	background-color: #4facfe;
	color: white;
	font-size: 16px;
	cursor: pointer;
	transition: 0.3s;
}

input[type="submit"]:hover {
	background-color: #00c6ff;
}
</style>

</head>

<body>
	<div class="register-container">
		<h2>User Registration</h2>

		<form action="create-account" method="post">
			<div class="form-group">
				<label>Name</label>
				<input type="text" name="name" required>
			</div>

			<div class="form-group">
				<label>Email</label>
				<input type="email" name="email" required>
			</div>

			<div class="form-group">
				<label>Password</label>
				<input type="password" name="password" required>
			</div>

			<div class="form-group">
				<label>Contact</label>
				<input type="text" name="contact" required>
			</div>

			<input type="submit" value="Register">
		</form>
	</div>
</body>
</html>