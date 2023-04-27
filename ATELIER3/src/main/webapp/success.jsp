<%@ page import="me.ynabouzi.atelier3.entities.Student" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registration Confirmation</title>
  <link rel="icon" href="static/images/ensalogo.png" type="image/x-icon">
  <link rel="stylesheet" href="static/css/stylesheet.css">
</head>
<% Student std = (Student) request.getAttribute("student"); %>
<body>
<img src="static/images/Success.gif" class="success-img">
<div class="success-title">Registration Successful</div>
<form method="post" action="submit-registration">
  <div class="field-group">
    <input type="text" id="firstname" name="firstname" class="input-field" placeholder="First Name" autocomplete="off" value="<%= std.getFirstName()%>" disabled>
    <label for="firstname" class="input-label">First Name</label>
  </div>
  <div class="field-group">
    <input type="text" id="lastname" name="lastname" class="input-field" placeholder="Last Name" autocomplete="off" value="<%=std.getLastName()%>" disabled>
    <label for="lastname" class="input-label">Last Name</label>
  </div>
  <div class="field-group">
    <input type="text" id="email" name="email" class="input-field" placeholder="Email" autocomplete="off" value="<%=std.getEmail()%>" disabled>
    <label for="email" class="input-label">Email</label>
  </div>
  <div class="field-group">
    <input type="date" id="birthdate" name="birthdate" class="input-field" placeholder="Birth Date" autocomplete="off" value="<%=std.getBirthDate()%>" disabled>
    <label for="birthdate" class="input-label">Birth Date</label>
  </div>
  <div class="field-group">
    <input type="text" id="CIN" name="CIN" class="input-field" placeholder="CIN" autocomplete="off" value="<%=std.getCIN()%>" disabled>
    <label for="CIN" class="input-label" >CIN</label>
  </div>
  <div class="field-group">
    <input type="text" id="Phone Number" name="Phone Number" class="input-field" placeholder="Phone Number" autocomplete="off" pattern="[0-9]{10}" value="<%=std.getPhoneNumber()%>" disabled>
    <label for="Phone Number" class="input-label">Phone Number</label>
  </div>
</form>
<div class="error-msg" id="error-msg">Please fill all the filleds.</div>
<script src="static/js/app.js"></script>
</body>

</html>

