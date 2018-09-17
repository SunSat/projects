/**
 * Created by sathishkumar_su on 5/29/2018.
 */

window.onload = function() {
    document.getElementById('logging-popup-container').style.display = 'none';
    document.getElementById('login-button-container').style.display = 'block';
}

function performSignUp() {

    var uName = document.getElementById("signUpUserName");
    var pass = document.getElementById("signUpPassword");
    var cPass = document.getElementById("signUpConfirmPassword");
    var mailId = document.getElementById("signUpMailId");

    var data = {
        signUpUserName : uName,
        signUpPassword : pass,
        signUpMailId : mailId,
        formAction : "loginPage",
        formSubAction : "signUp"
    }

    var xhttp = new XMLHttpRequest();
    xhttp.open("post","signUpAction.do",true);
    xhttp.onreadystatechange = function() {
        if(xhttp.readyState == 4 && xhttp.status == 200) {
            performSuccessfulSignUp(xhttp);
        }
    }
    xhttp.send(data);
}

function performSuccessfulSignUp(xhttp) {
    var formModel = JSON.parse(xhttp.responseText)
    document.getElementById("signupMessage").value = formModel.message;
}

function performLogin() {

    var uName  = document.getElementById("loginUserName").value;
    var pass  = document.getElementById("loginPassword").value;
    var csrfToken = document.getElementById("csrfTokenDetail");
    var csrfParaName = csrfToken.name;
    var csrfParaValue = csrfToken.value;

    var formAction = "loginPage";
    var formSubAction = "login";
    var xhttp = new XMLHttpRequest();
    var data = {
        loginUserName: uName,
        loginPassword: pass,
        formAction : formAction,
        formSubAction : formSubAction,
        _csrf : csrfParaValue
    }
    xhttp.open("post","loginAction.do",true);
    xhttp.onreadystatechange = function() {
        if(xhttp.readyState == 4 && xhttp.status == 200) {
            performSuccessfulLogin(xhttp);
        }
    }
    xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    var jsonObj = JSON.stringify(data);
    xhttp.send("_csrf="+csrfParaValue+"&loginUserName="+uName+"&loginPassword="+pass);
}

function performSuccessfulLogin(xhttp) {
    var formModel = JSON.parse( xhttp.responseText );
    var loginMessage = formModel.message;
    if(loginMessage != "successful") {
        document.getElementById("loginMessage").innerHTML = loginMessage;
    } else {
        hideAllContainer();
        document.getElementById("login-button-container").style.display = "none";
        document.getElementById("small-avator-image").style.display = "block";

        var fUserName = formModel.fullUserName;
        var fChar =  fUserName.substring(0,1);
        document.getElementById("userInitial").innerHTML = fChar;
        document.getElementById("fullName").innerHTML = formModel.fullUserName;
        document.getElementById("mailId").innerHTML = formModel.mailId;
        document.getElementById("userId").value = formModel.userId;
    }
}

function showLoginContainer() {
    hideAllContainer();
    document.getElementById("logging-popup-container").style.display = "block";
    document.getElementById("login-userInput-container").style.display = "block";
}

function showSignUpContainer() {
    hideAllContainer();
    document.getElementById("logging-popup-container").style.display = "block";
    document.getElementById("signup-userinput-container").style.display = "block";
}

function cleanLoginContainer() {
    document.getElementById("loginUserName").innerHTML = "";
    document.getElementById("loginPassword").innerHTML = "";
    document.getElementById("login-userInput-container").style.display = "none";
}

function cleanSignUpContainer() {
    document.getElementById("signUpuserName").innerHTML = "";
    document.getElementById("signUpPassword").innerHTML = "";
    document.getElementById("signUpConfirmPassword").innerHTML = "";
    document.getElementById("signup-userinput-container").style.display = "none";
}

function showDetailAvatorImage() {
    document.getElementById("logging-popup-container").style.display = "block";
    document.getElementById("logged-user-container").style.display = "block";
}

function hideAllContainer() {
    document.getElementById('logging-popup-container').style.display = 'none';
    document.getElementById("login-userInput-container").style.display = "none";
    document.getElementById("signup-userinput-container").style.display = "none";
    document.getElementById("logged-user-container").style.display = "none";
}

function performSignout() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("post","logout",true);
    var csrfToken = document.getElementById("csrfTokenDetail");
    var csrfParaName = csrfToken.name;
    var csrfParaValue = csrfToken.value;
    var data = csrfParaName+"="+csrfParaValue;
    xhttp.send(data);
}