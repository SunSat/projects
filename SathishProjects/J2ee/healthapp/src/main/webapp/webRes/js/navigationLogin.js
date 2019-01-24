/**
 * Created by sathishkumar_su on 3/21/2018.
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

    verifyExistingUserName();
    verifyPassword();
    verifyCnfPassword();
    verifyMailId();

    var userNameStatus = document.getElementById('verifyUserNameStatus').value;
    var passwordStatus = document.getElementById('verifyPasswordStatus').value
    var cnfPasswordStatus = document.getElementById('verifyCnfPasswordStatus').value;
    var mailIdStatus = document.getElementById('verifyMailIdStatus').value;

    if(!userNameStatus || !passwordStatus || !cnfPasswordStatus || !mailIdStatus) {
        document.getElementById('signup-warning-msg').innerText = "Please fill required data properly.";
        return;
    }

    var data = {
        userName : uName,
        password : pass,
        confirmPassword : cPass,
        mailId : mailId,
        formAction : "loginPage",
        formSubAction : "signUp"
    };

    var successfulSignUp = function (xhttp) {
        if(xhttp.readyState != 4 || xhttp.status != 200) {
            return;
        }
        var formModel = JSON.parse(xhttp.responseText)
        if(formModel.message != "successful") {
            document.getElementById("signup-warning-msg").innerText = formModel.message;
        } else {
            document.getElementById("signup-warning-msg").innerText = "Account Created Successfully. Please confirm your mail id and SignIn.";
        }
    };
    performAjaxJsonRequest("post","signUpAction.an",data,successfulSignUp);
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
    };

    var performSuccessfulLogin = function(xhttp) {
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
    };
    performAjaxRequest("post","login",data,performSuccessfulLogin);
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
    document.getElementById("login-container").style.display = "none";
    document.getElementById("forgot-password-container").style.display = "none";
    document.getElementById("signUp-container").style.display = "block";
    clearSignupInputs();
    hideAllValidationCircles();
    clearSignupWarningMsgs();
    clearSignUpStatus();
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

function hideAllValidationCircles() {
    document.getElementById('signup-username-circle').style.display = 'none';
    document.getElementById('signup-username-circle-failed').style.display = 'none';
    document.getElementById('signup-password-circle').style.display = 'none';
    document.getElementById('signup-password-circle-failed').style.display = 'none';
    document.getElementById('signup-cnf-password-circle').style.display = 'none';
    document.getElementById('signup-cnf-password-circle-failed').style.display = 'none';
    document.getElementById('signup-email-circle').style.display = 'none';
    document.getElementById('signup-email-circle-failed').style.display = 'none';
}

function clearSignupInputs() {
    document.getElementById('signup-username').value = "";
    document.getElementById('signup-password').value = "";
    document.getElementById('signup-password-cnf').value = "";
    document.getElementById('signup-mail-id').value = "";
}

function clearSignupWarningMsgs() {
    document.getElementById('signup-username-warning-messages').innerText = "";
    document.getElementById('signup-password-warning-messages').innerText = "";
    document.getElementById('signup-email-warning-messages').innerText = "";
    document.getElementById('signup-cnf-password-warning-messages').innerText = "";
}

function  clearSignUpStatus() {
    document.getElementById('verifyUserNameStatus').value = "false";
    document.getElementById('verifyPasswordStatus').value = "false";
    document.getElementById('verifyCnfPasswordStatus').value = "false";
    document.getElementById('verifyMailIdStatus').value = "false";

}
function clearUserNameWarnings() {
    document.getElementById('signup-username-circle').style.display = 'none';
    document.getElementById('signup-username-circle-failed').style.display = 'none';
    document.getElementById('signup-username-warning-messages').innerText = "";
    document.getElementById('verifyUserNameStatus').value = "false";
}
function clearPasswordWarnings() {
    document.getElementById('signup-password-circle').style.display = 'none';
    document.getElementById('signup-password-circle-failed').style.display = 'none';
    document.getElementById('signup-password-warning-messages').innerText = "";
    document.getElementById('verifyPasswordStatus').value = "false";
}
function clearcnfPasswordWarnings() {
    document.getElementById('signup-cnf-password-circle').style.display = 'none';
    document.getElementById('signup-cnf-password-circle-failed').style.display = 'none';
    document.getElementById('signup-cnf-password-warning-messages').innerText = "";
    document.getElementById('verifyCnfPasswordStatus').value = "false";
}
function clearEmailIdWarnings() {
    document.getElementById('signup-email-circle').style.display = 'none';
    document.getElementById('signup-email-circle-failed').style.display = 'none';
    document.getElementById('signup-email-warning-messages').innerText = "";
    document.getElementById('verifyMailIdStatus').value = "false";
}

function showUserNameError(message) {
    document.getElementById('signup-username-warning-messages').innerText = message;
    document.getElementById('signup-username-circle-failed').style.display = "inline-block";
    document.getElementById('verifyUserNameStatus').value = 'false';
}
function showUserNameSuccess() {
    document.getElementById('verifyUserNameStatus').value = 'true';
    document.getElementById('signup-username-circle').style.display = "inline-block";
}

function verifyExistingUserName() {
    var userName = document.getElementById('signup-username').value;
    clearUserNameWarnings();
    if(!userName || userName ==null || userName.trim().length == 0) {
        showUserNameError('Please provide UserName');
        return;
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
        clearUserNameWarnings();
        if(loginMessage != "successful") {
            showUserNameError(loginMessage);
        } else {
            showUserNameSuccess();
        }
    };
    performAjaxJsonRequest("post","checkExistingUserName.an",data,checkUserNameResponse);
}
function showPasswordError(message) {
    document.getElementById('signup-password-warning-messages').innerText = message;
    document.getElementById('signup-password-circle-failed').style.display = "inline-block";
    document.getElementById('verifyPasswordStatus').value = 'false';
}
function showPasswordSuccess() {
    document.getElementById('signup-password-circle').style.display = "inline-block";
    document.getElementById('verifyPasswordStatus').value = 'true';
}

function verifyPassword() {
    var password = document.getElementById("signup-password").value;
    clearPasswordWarnings();
    if(!password || password == null || password.trim().length == 0) {
        showPasswordError("Please provide Password");
    } else {
        showPasswordSuccess();
    }
}
function showCnfPasswordError(message) {
    document.getElementById('signup-cnf-password-warning-messages').innerText = message;
    document.getElementById('signup-cnf-password-circle-failed').style.display = "inline-block";
    document.getElementById('verifyUserNameStatus').value = 'false';
}
function showCnfPasswordSuccess() {
    document.getElementById('signup-cnf-password-circle').style.display = "inline-block";
    document.getElementById('verifyCnfPasswordStatus').value = 'true';
}
function verifyCnfPassword() {
    clearcnfPasswordWarnings();
    var cnfpassword = document.getElementById("signup-password-cnf").value;
    if(!cnfpassword || cnfpassword == null || cnfpassword.trim().length == 0) {
        showCnfPasswordError("Please provide Confirm Password.");
        return;
    }
    var password = document.getElementById("signup-password").value;
    if(cnfpassword != password) {
        showCnfPasswordError("password and confirm password do not match.");
    } else {
        showCnfPasswordSuccess()
    }
}
function showMailIdError(message) {
    document.getElementById('signup-email-warning-messages').innerText = message;
    document.getElementById('signup-email-circle-failed').style.display = "inline-block";
    document.getElementById('verifyMailIdStatus').value = 'false';

}
function showMailIdSuccess() {
    document.getElementById('signup-email-circle').style.display = "inline-block";
    document.getElementById('verifyMailIdStatus').value = 'true';
}
function verifyMailId() {
    clearEmailIdWarnings();
    var emailid = document.getElementById("signup-mail-id").value;
    if(!emailid || emailid == null || emailid.trim().length == 0) {
        showMailIdError("Please provide Email Id.");
        return;
    }
    var cnfpassword = emailid;
    if(cnfpassword != emailid) {
        showMailIdError("Mail Id is Not in proper Format");
    } else {
        showMailIdSuccess();
    }
}