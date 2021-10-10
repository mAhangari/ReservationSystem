<%--
  Created by IntelliJ IDEA.
  User: MORTEZA
  Date: 10/10/2021
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Employee</title>
        <link rel="stylesheet" href="employee-style">
    </head>
    <body>
        <%
            String message = (String) request.getAttribute("message");
            if (message != null)
                out.println(message);
        %>
        <form action="sign-up-employee" style="border:1px solid #ccc" method="post">
            <div class="container">
                <h1>Sign Up</h1>
                <p>Please fill in this form to create an account.</p>
                <hr>

                <label for="firstnameID"><b>First Name</b></label>
                <input id="firstnameID" type="text" name="firstName" required />

                <label for="lastnameID"><b>Last Name</b></label>
                <input id="lastnameID" type="text" name="lastName" required />

                <label for="usernameID"><b>Username</b></label>
                <input id="usernameID" type="text" name="username" placeholder="3-15 character and contain ([a-z0-9_-])" maxlength="15" minlength="3" pattern="^[A-Za-z0-9_-]{3,15}$" required>

                <label for="passID"><b>Password</b></label>
                <input id="passID" type="password" placeholder="8 or more character" pattern="^.{8,}$" name="password" required>

                <label for="pass-repeatID"><b>Repeat Password</b></label>
                <input id="pass-repeatID" type="password" placeholder="Repeat Password" name="passRepeat" required>

                <label for="nationalCodeID"><b>National Code</b></label>
                <input id="nationalCodeID" type="text" name="nationalCode" required>


                <label for="employeeTypeID"><b>Select Employee Type:</b></label>
                <select name="employeeType" id="employeeTypeID">
                    <option value="1">Employee</option>
                    <option value="2">Boss</option>
                </select>
                <br />
                <br />

                <label>
                    <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
                </label>

                <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

                <div class="clearfix">
                    <button type="button" class="cancelbtn">Cancel</button>
                    <button type="submit" class="signupbtn">Sign Up</button>
                </div>
            </div>
        </form>
    </body>
</html>
