/**
 * Created by sathishkumar_su on 5/29/2018.
 */

window.onload = function() {

    /*document.getElementById('logging-popup-container').style.display = 'none';
    document.getElementById('login-button-container').style.display = 'block';
    document.getElementById('login-button').onclick = showLoginContainer;
    document.getElementById('small-avator-image').onclick = showDetailAvatorImage;
    document.getElementById('login-continer-signin').onclick = performLogin;
    document.getElementById('login-continer-signup').onclick = showSignUpContainer;
    document.getElementById('login-continer-cancel').onclick = cleanLoginContainer;
    document.getElementById('signup-continer-submit').onclick =performSignUp;
    document.getElementById('signup-continer-signin').onclick =showLoginContainer;
    document.getElementById('signup-continer-cancel').onclick =cleanSignUpContainer;
    do=cument.getElementById('logged-user-container-signout').onclick = performSignout;*/

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

    performAjaxRequest("post","signUpAction.an",data,performSuccessfulSignUp);
}

function performSuccessfulSignUp(xhttp) {
    var formModel = JSON.parse(xhttp.responseText)
    document.getElementById("signupMessage").value = formModel.message;
}

function performLogin() {

    var uName  = document.getElementById("loginUserName").value;
    var pass  = document.getElementById("loginPassword").value;

    var formAction = "loginPage";
    var formSubAction = "login";
    
    var data = {
        userName: uName,
        password: pass,
        formAction : formAction,
        formSubAction : formSubAction,
    }
    performAjaxRequest("post","loginAction.an",true,data,performSuccessfulLogin);
}

function performSuccessfulLogin(xhttp) {
    if(xhttp.readyState != 4 || xhttp.status != 200) {
        return;
    }
    var formModel = JSON.parse( xhttp.responseText );
    var loginMessage = formModel.message;
    if(loginMessage != "successful") {
        document.getElementById("loginMessage").innerHTML = loginMessage;
        document.getElementById("loginMessage").style.display = "block";
        return;
    } else {
        hideAllContainer();
        document.getElementById("login-button-container").style.display = "none";
        document.getElementById("small-avator-image").style.display = "block";

        var fUserName = formModel.userName;
        var fChar =  fUserName.substring(0,1);
        document.getElementById("userInitial").innerHTML = fChar;
        document.getElementById("userName").innerHTML = fUserName;
        document.getElementById("mailId").innerHTML = formModel.mailId;
        document.getElementById("userId").value = formModel.userId;
        document.getElementById("sessionId").value = formModel.sessionId;
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
    var userId = document.getElementById("userId").value
    var sessionId = document.getElementById("sessionId").value
    var data = {
        userId:userId,
        sessionId : sessionId,
        formAction : 'login',
        formSubAction : 'logout'
    }
    performAjaxRequest("post","logoutAction.do",true,data,completeSignout)
}

function completeSignout(xhttp) {
    if(xhttp.status == 200 && xhttp.readyState == 4) {
        hideAllContainer();
        document.getElementById('small-avator-image').style.display = 'none';
        document.getElementById('login-button-container').style.display = 'block';
    }
}
