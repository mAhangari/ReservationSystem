<%--
  Created by IntelliJ IDEA.
  User: MORTEZA
  Date: 10/6/2021
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            * {box-sizing: border-box}

            /* Full-width input fields */
            input[type=text], input[type=password] {
                width: 100%;
                padding: 15px;
                margin: 5px 0 22px 0;
                display: inline-block;
                border: none;
                background: #f1f1f1;
            }

            input[type=text]:focus, input[type=password]:focus {
                background-color: #ddd;
                outline: none;
            }

            hr {
                border: 1px solid #f1f1f1;
                margin-bottom: 25px;
            }

            /* Set a style for all buttons */
            button {
                background-color: #04AA6D;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
                opacity: 0.9;
            }

            button:hover {
                opacity:1;
            }

            /* Extra styles for the cancel button */
            .cancelbtn {
                padding: 14px 20px;
                background-color: #f44336;
            }

            /* Float cancel and signup buttons and add an equal width */
            .cancelbtn, .signupbtn {
                float: left;
                width: 50%;
            }

            /* Add padding to container elements */
            .container {
                padding: 16px;
            }

            /* Clear floats */
            .clearfix::after {
                content: "";
                clear: both;
                display: table;
            }

            /* Change styles for cancel button and signup button on extra small screens */
            @media screen and (max-width: 300px) {
                .cancelbtn, .signupbtn {
                    width: 100%;
                }
            }
        </style>
    </head>
    <body>
        <%
            String message = (String) request.getAttribute("message");
            if (message != null)
                out.println(message);
        %>
        <form action="sign_up" style="border:1px solid #ccc" method="post">
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
