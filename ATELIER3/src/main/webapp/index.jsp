<%--
  Created by IntelliJ IDEA.
  User: yasse
  Date: 3/3/2023
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration</title>
    <link rel="icon" href="static/images/ensalogo.png" type="image/x-icon">
    <link rel="stylesheet" href="static/css/stylesheet.css">
</head>
<body>
<img src="static/images/ensalogo.png" id="ensalogo"/>
<h2>Students Registration</h2>
<form method="post" action="register">
    <div class="field-group">
        <input type="text" id="firstname" name="firstname" class="input-field" placeholder="First Name" autocomplete="off" required>
        <label for="firstname" class="input-label">First Name</label>
    </div>
    <div class="field-group">
        <input type="text" id="lastname" name="lastname" class="input-field" placeholder="Last Name" autocomplete="off" required>
        <label for="lastname" class="input-label">Last Name</label>
    </div>
    <div class="field-group">
        <input type="text" id="email" name="email" class="input-field" placeholder="Email" autocomplete="off" required>
        <label for="email" class="input-label">Email</label>
    </div>
    <div class="field-group">
        <input type="date" id="birthdate" name="birthdate" class="input-field" placeholder="Birth Date" autocomplete="off" required>
        <label for="birthdate" class="input-label">Birth Date</label>
    </div>
    <div class="field-group">
        <input type="text" id="CIN" name="CIN" class="input-field" placeholder="CIN" autocomplete="off" required>
        <label for="CIN" class="input-label" >CIN</label>
    </div>
    <div class="field-group">
        <input type="text" id="Phone Number" name="Phone Number" class="input-field" placeholder="Phone Number" autocomplete="off" pattern="[0-9]{10}" required>
        <label for="Phone Number" class="input-label">Phone Number</label>
    </div>
    <button type="submit" value="Submit" id="submit" class="btn">Submit</button>
</form>
<div class="error-msg" id="error-msg">Please fill all the filleds.</div>
<script src="static/js/app.js"></script>
</body>
</html>
