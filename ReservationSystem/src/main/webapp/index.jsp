<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Reservation</title>
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}
        form {border: 30px solid #f1f1f1;}

        label {
            width: 30%;
            margin: 10px 100px 10px 550px;
        }

        input[type=text], input[type=password] {
            width: 30%;
            padding: 12px 20px;
            margin: 10px 400px 10px 550px;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        button {
            background-color: #04AA6D;
            color: white;
            padding: 14px 20px;
            margin: 10px 400px 10px 610px;
            border: none;
            cursor: pointer;
            width: 20%;
        }

        button:hover {
            opacity: 0.8;
        }

        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            margin: 10px 0 10px 550px;
            background-color: #f44336;
        }

        .imgcontainer {
            text-align: center;
            margin: 24px 0 12px 0;
        }

        img.avatar {
            width: 40%;
            border-radius: 50%;
        }

        .container {
            padding: 16px;
        }

        span.psw {
            float: right;

            padding-top: 16px;
            margin: 0 450px 0 0;
        }

        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }
            .cancelbtn {
                width: 100%;
            }
        }
    </style>
</head>
<body>

<h2>Login Form</h2>

<form action=page method="post">
    <div class="imgcontainer">
        <img src="img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
        <label for="uname"><b>Username</b></label>
        <br>
        <input id="uname" type="text" placeholder="Enter Username" name="username" required>
        <br>
        <label for="psw"><b>Password</b></label>
        <br>
        <input id="psw" type="password" placeholder="Enter Password" name="password" required>

        <button type="submit">Login</button>
        <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me</label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">
        Forgot <a href=PasswordRecovery>password?</a>
        or <a href=NewAccount>Sign Up</a>
    </span>
    </div>
</form>

</body>
</html>
