/**
 * Created by sathishkumar_su on 3/21/2018.
 */

$(document).ready(function () {
    var userId = document.getElementById('loggedUserId').value;
    var userName = document.getElementById('loggedUserName').value;
    if(userId > 0 && userName != null && userName.trim().length > 0) {
        performSuccessfulLogin();
    }
});

function loginMouseHover() {
    var classList = document.getElementById('main-login-container').classList
    if(classList.length <= 1) {
        classList.toggle('show-login');
        showSignInForm();
    }
}

function loginCloseBut() {
    var classList = document.getElementById('main-login-container').classList;
    classList.remove('show-login');
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

function performSignUp() {

    var uName = document.getElementById("signup-username").value;
    var pass = document.getElementById("signup-password").value;
    var cPass = document.getElementById("signup-password-cnf").value;
    var mailId = document.getElementById("signup-mail-id").value;

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
        if(formModel.responseStatus != 'successful') {
            //Todo Show Error message.
            document.getElementById("signup-warning-msg").innerText = formModel.responseMessage;
        } else {
            //Todo generate a successful popup. OnClick Ok clear all the window.
            document.getElementById("signup-warning-msg").innerText = formModel.responseMessage;
            hideAllValidationCircles();
            clearSignupWarningMsgs();
            clearSignUpStatus();
        }
    };
    performAjaxJsonRequest("post","signUpAction.an",data,successfulSignUp);
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

function verifyExistingUserName(isAsync) {
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
        var loginMessage = formModel.responseStatus;
        clearUserNameWarnings();
        if(loginMessage != "successful") {
            showUserNameError(formModel.responseMessage);
        } else {
            showUserNameSuccess();
        }
    };
    performAjaxJsonRequest("post","checkUserNameForSignUp.an",data,checkUserNameResponse);
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
    verifyPassword();
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

function cleanSignUpContainer() {
    document.getElementById("signUpuserName").innerHTML = "";
    document.getElementById("signUpPassword").innerHTML = "";
    document.getElementById("signUpConfirmPassword").innerHTML = "";
    document.getElementById("signup-userinput-container").style.display = "none";
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


function showDetailAvatorImage() {
    document.getElementById("logging-popup-container").style.display = "block";
    document.getElementById("logged-user-container").style.display = "block";
}

function hideAllContainer() {
    document.getElementById('login-container').style.display = 'none';
    document.getElementById('forgot-password-container').style.display = "none";
    document.getElementById('signUp-container').style.display = "none";
    loginCloseBut();
}

function performSignout() {
    var userId = document.getElementById("loggedUserId").value
    var userName = document.getElementById("loggedUserName").value
    var csrf = document.getElementById('_csrf')
    if(csrf != null) csrf = csrf.value;
    else csrf = "1";
    var data = {
        userId:userId,
        userName : userName,
        formAction : 'login',
        formSubAction : 'logout',
        _csrf : csrf
    }
    performAjaxJsonRequest("post","logoutAction.do",data,completeSignout)
}

function completeSignout(xhttp) {
    if(xhttp.status == 200 && xhttp.readyState == 4) {
        hideAllContainer();
        document.getElementById("loggedUserId").value = 0;
        document.getElementById("loggedUserName").value = null;
        showLogoutUserContainer(false);
        showHideAdminSettings(false);
        document.getElementById('login-navigation').style.display = 'block';
        document.getElementById('logout-navigation').style.display = 'none';
    }
}

function showSignInForm() {
    document.getElementById("signUp-container").style.display = "none";
    document.getElementById("forgot-password-container").style.display = "none";
    document.getElementById("login-container").style.display = "block";
}

function showForgotPasswordForm() {
    document.getElementById("signUp-container").style.display = "none";
    document.getElementById("login-container").style.display = "none";
    document.getElementById("forgot-password-container").style.display = "block";
    clearForgotPasswordWarning();
    clearForgotPasswordMailId();
    clearForgotPassSecCode();
    clearForgotPasswordPasswords();
    disableOrEnableForgotPassPasswordsForm(true);
    disableOrEnableForgotPassSecreateCodeForm(true);
    forgotPasswordSetCurrentStatus("mailid");
}

function clearForgotPasswordWarning() {
    document.getElementById("password-reset-warning-messages").innerText = "";
}
function showForgotPasswordWarning(message) {
    document.getElementById("password-reset-warning-messages").innerText = message;
}

function clearForgotPasswordMailId() {
    document.getElementById("forgot-pass-mail-id").value = "";
}
function clearForgotPassSecCode() {
    document.getElementById("forgot-pass-secret-code").value =  "";
}
function clearForgotPasswordPasswords() {
    document.getElementById("forgot-password-reset-password").value= "";
    document.getElementById("forgot-password-reset-password-conf").value= "";
}

function disableOrEnableForgotPassSecreateCodeForm(isEnable) {
    document.getElementById("forgot-pass-secret-code").disabled = isEnable;
    document.getElementById("forgot-pass-validate-code-but").disabled = isEnable;
}
function disableOrEnableForgotPassPasswordsForm(isEnable) {
    document.getElementById("forgot-password-reset-password").disabled = isEnable;
    document.getElementById("forgot-password-reset-password-conf").disabled = isEnable;
    document.getElementById("forgot-pass-change-pass-but").disabled = isEnable;
}

function forgotPasswordSetCurrentStatus(currentStatus) {
    document.getElementById("forgot-password-current-status").value = currentStatus;
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


function performLogin() {

    var uName  = document.getElementById('loginUsername').value;
    var pass  = document.getElementById('loginPassword').value;
    var csrf = document.getElementById('_csrf')
    if(csrf != null) csrf = csrf.value;
    else csrf = "1";

    var formAction = "loginPage";
    var formSubAction = "login";

    var data = {
        userName: uName,
        password: pass,
        formAction : formAction,
        formSubAction : formSubAction,
        _csrf : csrf
    };

    var performLoginCallBack = function(xhttp) {
        if(xhttp.readyState != 4 || xhttp.status != 200) {
            return;
        }
        var formModel = JSON.parse( xhttp.responseText );
        var loginMessage = formModel.responseStatus;
        if(loginMessage != "successful") {
            document.getElementById("login-warning-messages").innerText = formModel.responseMessage;
            document.getElementById("login-warning-messages").style.display = "block";
            return;
        } else {
            document.getElementById('loggedUserId').value = formModel.primarykeyId;
            document.getElementById('loggedUserName').value = formModel.userName;
            document.getElementById('isAdmin').value = formModel.isAdmin;
            document.getElementById('userLike').value = formModel.userLike;
            performSuccessfulLogin();
        }
    };
    performAjaxRequest("post","loginAction.an",data,performLoginCallBack);
}
function performSuccessfulLogin() {
    var fUserName = document.getElementById('loggedUserName').value;
    var userNameFirstLetter = fUserName.charAt(0);


    document.getElementById("login-navigation").style.display = "none";
    var logoutElement = document.getElementById("logout-navigation");
    logoutElement.style.display = "block";

    var react = logoutElement.getBoundingClientRect();
    document.getElementById('logout-user-setting-container').style.left = react.left;

    hideAllContainer();

    var isAdminVal = document.getElementById('isAdmin').value;
    showHideAdminSettings(isAdminVal);

    var isUserLike = document.getElementById('userLike').value;
    //changeColorto green.

}
function searchCloseBut() {
    var clsList = document.getElementById('general-search-container').classList;
    if ( clsList.contains('general-search-container-hover') ) {
        clsList.remove('general-search-container-hover');
    }
}

function showLogoutUserContainer(isShow) {
    var clsList = document.getElementById("logout-user-setting-container").classList;
    if(isShow) {
        if(!clsList.contains('logout-user-setting-container-show')) {
            clsList.add('logout-user-setting-container-show');
        }
    } else {
        if(clsList.contains('logout-user-setting-container-show')) {
            clsList.remove('logout-user-setting-container-show');
        }
    }
}
function showHideAdminSettings(isAdmin) {
    var admin_setting = document.getElementById('admin-sesstings');
    if(isAdmin == 'true') {
        admin_setting.style.display = 'block';
    } else {
        admin_setting.style.display = 'none';
    }
}