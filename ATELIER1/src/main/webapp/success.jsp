<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Confirmation</title>
    <link rel="icon" href="./static/images/ensalogo.png" type="image/x-icon">
    <link rel="stylesheet" href="./static/css/style.css">
</head>
<body>
<%@ page import="com.ynabouzi.atelier1.model.Student" %>
<%@ page import="com.ynabouzi.atelier1.model.Registration" %>

<%
    Student std = (Student) request.getAttribute("Student");
    Registration reg = (Registration) request.getAttribute("Registration");
%>

<div class="row">
    <div class="col-left">
        <img src="static/images/Success.gif" class="success-img">
        <div class="field-group">
            <input type="text" id="FirstName" name="FirstName" class="input-field" placeholder="First Name"
                   autocomplete="off" value="<%=std.getFirstName()%>" disabled>
            <label for="FirstName" class="input-label">First Name</label>
        </div>
        <div class="field-group">
            <input type="text" id="LastName" name="LastName" class="input-field" placeholder="Last Name"
                   autocomplete="off" value="<%=std.getLastName()%>" disabled>
            <label for="LastName" class="input-label">Last Name</label>
        </div>
        <div class="field-group">
            <input type="text" id="Email" name="Email" class="input-field" placeholder="Email" autocomplete="off"
                   value="<%=std.getEmail()%>"
                   disabled>
            <label for="Email" class="input-label">Email</label>
        </div>
        <div class="field-group">
            <input type="text" id="BirthDate" name="BirthDate" class="input-field" placeholder="Birth Date"
                   autocomplete="off" onfocus="(this.type='date')" onblur="if(!this.value)this.type='text'"
                   value="<%=std.getBirthDate()%>"
                   disabled>
            <label for="BirthDate" class="input-label">Birth Date</label>
        </div>
        <div class="field-group">
            <input type="text" id="CIN" name="CIN" class="input-field" placeholder="CIN" autocomplete="off"
                   value="<%=std.getCIN()%>"
                   disabled>
            <label for="CIN" class="input-label">CIN</label>
        </div>
    </div>
    <div class="col-right">
        <div class="success-title">Registration Success</div>
        <div class="field-group">
            <input type="text" id="PhoneNumber" name="PhoneNumber" class="input-field" placeholder="Phone Number"
                   autocomplete="off" pattern="[0-9]{10}" value="<%=std.getPhoneNumber()%>" disabled>
            <label for="PhoneNumber" class="input-label">Phone Number</label>
        </div>
        <div class="field-group">
            <input type="text" id="RegDate" name="RegDate" class="input-field" placeholder="RegDate"
                   autocomplete="off" onfocus="(this.type='date')" onblur="if(!this.value)this.type='text'"
                   value="<%=reg.getRegDate()%>"
                   disabled>
            <label for="RegDate" class="input-label">Registration Date</label>
        </div>
        <div class="field-group">
            <input type="text" id="Group" name="Group" class="input-field" placeholder="Group" autocomplete="off"
                   value="<%=reg.getGroup()%>"
                   disabled>
            <label for="Group" class="input-label">Group</label>
        </div>
        <div class="field-group">
            <input type="text" id="Major" name="Major" class="input-field" placeholder="Major" autocomplete="off"
                   value="<%=reg.getMajor()%>"
                   disabled>
            <label for="Major" class="input-label">Major</label>
        </div>
        <div class="field-group">
            <input type="text" id="Level" name="Level" class="input-field" placeholder="Level" autocomplete="off"
                   value="<%=reg.getLevel()%>"
                   disabled>
            <label for="Level" class="input-label">Level</label>
        </div>
    </div>
</div>
<script src="./static/js/app.js"></script>
</body>
</html>

