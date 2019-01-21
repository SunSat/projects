/**
 * Created by sathishkumar_su on 3/21/2018.
 */

/*

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
    var userName = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var keepMeSigned = document.getElementById('keepMeSignedIn').value;
    var sessionId = document.getElementById('sessionid').value;
    var data = {
        userName : userName,
        password : password,
        keepMeSignedIn : keepMeSigned,
        sessionId : sessionId
    }
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST","/userLogin.do",true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    var jsonUserLogReq = JSON.stringify({userName:userName,password:password});
    xhttp.onreadystatechange = function() {
    };
    xhttp.send(jsonUserLogReq);
}
function doSuccessfulLogin(xhttp) {
    if (this.readyState == 4 && this.status == 200) {
        var message = JSON.parse(this.responseText).responseResult;
        if(message == 'success') {
            document.getElementById('login-navigation').style.display  = 'none'
            document.getElementById('logout-navigation').style.display  = 'block'
            //document.getElementById('main-login-container').style.display = 'none';
            document.getElementById('main-login-container').classList.remove('show-login');
            document.getElementById('responseResult').innerHTML = '';
        } else {
            document.getElementById('responseResult').innerHTML = message;
        }
    }
}
function showSignInForm() {
    document.getElementById("signUp-container").style.display = "none";
    document.getElementById("login-container").style.display = "block";
    document.getElementById("forgot-password-container").style.display = "none";
}

function showSignUpForm() {
    document.getElementById("signUp-container").style.display = "block";
    document.getElementById("login-container").style.display = "none";
    document.getElementById("forgot-password-container").style.display = "none";
}

function showForgotPasswordForm() {
    document.getElementById("signUp-container").style.display = "none";
    document.getElementById("login-container").style.display = "none";
    document.getElementById("forgot-password-container").style.display = "block";
}
/!**
 var xhttp = new XMLHttpRequest();
 xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("demo").innerHTML =
      this.responseText;
    }
  };
 xhttp.open("GET", "ajax_info.txt", true);
 xhttp.send();

 **!/

function showSearchBar() {
    var clsList = document.getElementById('general-search-container').classList;
    if ( !clsList.contains('general-search-container-hover') ) {
        clsList.toggle('general-search-container-hover');
    }
}

function showExpandSearchBar() {
    var clsList = document.getElementById('general-search-container').classList;
    if ( !clsList.contains('general-search-container-expand') ) {
        clsList.toggle('general-search-container-expand');
    }
}*/


/**
 * Created by sathishkumar_su on 5/29/2018.
 */
function loginMouseHover() {
    var classList = document.getElementById('main-login-container').classList
    if(classList.length <= 1) {
        classList.toggle('show-login');
        showSignInForm();
    }
}

function loginCloseBut() {
    //var loginPageDiv = document.getElementById('main-login-container');
    //loginPageDiv.style.display = 'none';
    var classList = document.getElementById('main-login-container').classList;
    classList.remove('show-login');
}

function performSignUp() {

    var uName = document.getElementById("signup-username").value;
    var pass = document.getElementById("signup-password").value;
    var cPass = document.getElementById("signup-password-cnf").value;
    var mailId = document.getElementById("signup-mail-id").value;

    var data = {
        signUpUserName : uName,
        signUpPassword : pass,
        signUpMailId : mailId,
        formAction : "loginPage",
        formSubAction : "signUp"
    }

    performAjaxRequest("post","signUpAction.an",data,performSuccessfulSignUp);
}

performSuccessfulSignUp = function(xhttp) {
    var formModel = JSON.parse(xhttp.responseText)
    document.getElementById("signupMessage").value = formModel.message;
}

function performLogin() {

    var uName  = document.getElementById('loginUsername').value;
    var pass  = document.getElementById('loginPassword').value;
    var csrf = document.getElementById('_csrf')
    if(csrf != null) csrf = document.getElementById('_csrf').value;
    else csrf = "1";

    var formAction = "loginPage";
    var formSubAction = "login";

    var data = {
        username: uName,
        password: pass,
        formAction : formAction,
        formSubAction : formSubAction,
        _csrf : csrf
    }
    performAjaxRequest("post","login",data,performSuccessfulLogin);
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

function showSignInForm() {
    document.getElementById("signUp-container").style.display = "none";
    document.getElementById("login-container").style.display = "block";
    document.getElementById("forgot-password-container").style.display = "none";
}

function showSignUpForm() {
    document.getElementById("signUp-container").style.display = "block";
    document.getElementById("login-container").style.display = "none";
    document.getElementById("forgot-password-container").style.display = "none";
    clearSignupValidationCircle();
    hideAllValidationCircles();
}
function showForgotPasswordForm() {
    document.getElementById("signUp-container").style.display = "none";
    document.getElementById("login-container").style.display = "none";
    document.getElementById("forgot-password-container").style.display = "block";
}
function showSearchBar() {
    var clsList = document.getElementById('general-search-container').classList;
    if ( !clsList.contains('general-search-container-hover') ) {
        clsList.toggle('general-search-container-hover');
    }
}

function showExpandSearchBar() {
    var clsList = document.getElementById('general-search-container').classList;
    if ( !clsList.contains('general-search-container-expand') ) {
        clsList.toggle('general-search-container-expand');
    }
}

function checkExistingUserName() {
    var userName = document.getElementById('signup-username').value;
    if(!userName) {
        return document.getElementById('warning-messages').innerText = "Please provide UserName";
    }
    data = {
        userName : userName,
        formAction : 'login',
        formSubAction : 'checkExistingUserName',
    };
    var checkUserNameResponse = function (xhttp) {
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
            document.getElementById("signup-username-circle").style.display = block;
        }
    }
    performAjaxJsonRequest("post","checkExistingUserName.an",data,checkUserNameResponse);
}

function hideAllValidationCircles() {
    document.getElementById('signup-username-circle').style.display = 'none';
    document.getElementById('signup-password-circle').style.display = 'none';
    document.getElementById('signup-cnf-password-circle').style.display = 'none';
    document.getElementById('signup-email-circle').style.display = 'none';
}

function clearSignupValidationCircle() {
    document.getElementById('signup-username').value = "";
    document.getElementById('signup-password').value = "";
    document.getElementById('signup-password-cnf').value = "";
    document.getElementById('signup-mail-id').value = "";
}