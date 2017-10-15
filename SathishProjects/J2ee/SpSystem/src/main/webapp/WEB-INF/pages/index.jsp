<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <h1 style="align-content: center"> Welcome to SP Data System</h1>
    <style>
        h1 {
            margin: 50px auto;
            width: 350px;
        }
        body
        {
            background: url(<%= request.getContextPath()%>/images/sp_system_index_page.jpg) no-repeat center center fixed;
            background-size: cover;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            margin: 0;
            padding: 0;
            font: 87.5%/1.5em 'Open Sans', sans-serif;
        }

        #loginDao form span
        {
            font: 87.5%/1.5em 'Open Sans', sans-serif;
            line-height: 50px;
            text-align: center;
            width: 200px;
            height: 50px;
            font-size: 150%;
        }
        #loginDao
        {
            margin: 50px auto;
            width: 340px;
        }

        #loginDao form input[type="text"]
        {
            background-color: #3b4148;
            border-radius: 0px 3px 3px 0px;
            color: #a9a9a9;
            margin-bottom: 1em;
            padding: 0 16px;
            width: 235px;
            height: 30px;
        }

        #loginDao form input[type="password"]
        {
            background-color: #3b4148;
            border-radius: 0px 3px 3px 0px;
            color: #a9a9a9;
            margin-bottom: 1em;
            padding: 0 16px;
            width: 235px;
            height: 30px;
        }

        #loginDao form input[type="submit"]
        {
            background: #b5cd60;
            border: 0;
            width: 100%;
            height: 30px;
            border-radius: 3px;
            color: white;
            cursor: pointer;
            transition: background 0.3s ease-in-out;
        }

        #loginDao form input[type="submit"]:hover
        {
            background: #16aa56;
        }
        #Message
        {
            color: Red;
            text-align: center;
            font-size: 150%;
        }
    </style>

</head>
<body>
<div id="loginDao">
    <form action="<%= request.getContextPath()%>/Login.sp" method="post">
            <dev id="Message">
            <%
                if(request.getAttribute("Message") != null) {
                    out.println(request.getAttribute("Message"));
                }
            %>
            </dev>
            </br>
	        <span>
	    	    </br>User ID:<input type="text" name="userid">
    	    </span>
	        <span>
                </br>Password:<input type="password" name="password">
	        </span>
            </br>
	        <span>
                <input type="submit" value="Submit">
	        </span>
    </form>
</div>
</body>
</html>