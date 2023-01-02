<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>SignUp</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <style>
        * {box-sizing: border-box}

        /* Full-width input fields */
        input[type=text], input[type=password],input[type=number] {
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
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>--%>
</head>
<body>

<div class="container">
    <h2>Registration</h2>
    <h4>Give Your Data</h4>
    <%--<form:form action="submitSignup" modelAttribute="user">
<%--        <div class="form-group">--%>
<%--            <label for="name">Name:</label>--%>
<%--            <input type="text" class="form-control" id="name" placeholder="Enter your name" name="name">--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <label for="username">Username:</label>--%>
<%--            <input type="text" class="form-control" id="username" placeholder="Enter your username" name="username">--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--        <label for="age">Age:</label>--%>
<%--        <input type="number" id="age" name="age" min="18" max="100">--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <label for="contact">Contact:</label>--%>
<%--            <input type="text" class="form-control" id="contact" placeholder="Enter your contact no" name="contact">--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <label for="gender">Choose a Gender:</label>--%>
<%--            <select name="gender" id="gender">--%>
<%--                <option value="Male">Male</option>--%>
<%--                <option value="Female">Female</option>--%>
<%--                <option value="Other">Other</option>--%>
<%--            </select>--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <label for="email">Email:</label>--%>
<%--            <input type="text" class="form-control" id="email" placeholder="Enter your email" name="email">--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <label for="password">Password:</label>--%>
<%--            <input type="password" class="form-control" id="password" placeholder="Enter your password" name="password">--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <label for="disabled">Disabled??</label>--%>
<%--            <select name="disabled" id="disabled">--%>
<%--                <option value="False">No</option>--%>
<%--                <option value="True">Yes</option>--%>
<%--            </select>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <label for="freedomfighter">Freedom Fighter?? </label>--%>
<%--            <select name="freedomfighter" id="freedomfighter">--%>
<%--                <option value="False">No</option>--%>
<%--                <option value="True">Yes</option>--%>
<%--            </select>--%>
<%--        </div>--%>
<%--        <button type="submit" class="btn btn-primary">Submit</button>--%>
        <form:form action="submitSignup" modelAttribute="user" style="border:1px solid #ccc">
            <div class="container">
                <%--@declare id="email"--%><%--@declare id="psw"--%><%--@declare id="psw-repeat"--%><h1>Sign Up</h1>
                <p>Please fill in this form to create an account.</p>


                    <label for="name"><b>Name</b></label>
                    <input type="text" placeholder="Enter Your Name" id="name" name="name" required>

                    <label for="username"><b>User Name</b></label>
                    <input type="text" placeholder="Enter Your Username" id="username" name="username" required>

                    <label for="age"><b>Age</b></label>
                    <input type="number" placeholder="Enter Your Age" id="age" name="age" required>

                    <label for="contact"><b>Contact</b></label>
                    <input type="text" placeholder="Enter Your Contact" id="contact" name="contact" required>



                        <%--            <select name="gender" id="gender">--%>
                        <%--                <option value="Male">Male</option>--%>
                        <%--                <option value="Female">Female</option>--%>
                        <%--                <option value="Other">Other</option>--%>
                        <%--            </select>--%>

                    <label for="gender"><b>Gender</b></label>
                    <select name="gender" id="gender">--%>
                                            <option value="Male">Male</option>
                                            <option value="Female">Female</option>
                                            <option value="Other">Other</option>
                                        </select>
                    <b></b> <br>
<%--                    <input type="text" placeholder="Enter Your Gender" name="gender" required>--%>

                <label for="email"><b>Email</b></label>
                <input type="text" placeholder="Enter Email" id="email" name="email" required>

                <label for="password"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" id="password" name="password" required>


                <label>
                    <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
                </label>

                <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

                <div class="clearfix">
                    <button type="button" class="cancelbtn">Cancel</button>
                    <button type="submit" class="signupbtn">Sign Up</button>
                </div>
            </div>
        </form:form>
</div>
<a href="/tax_calculator_system_war_exploded/"><input type="button" value="HOME PAGE"></a>
</body>
</html>
