<%@page import="com.sunsat.sathish.j2ee.health.base.util.GeneralConstants" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navigation-container">
    <input type="hidden" name="${_csrf.parameterName}" id="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="hidden" name="<%=GeneralConstants.LOGGED_USER_ID%>" id="<%=GeneralConstants.LOGGED_USER_ID%>" value="<%=session.getAttribute(GeneralConstants.LOGGED_USER_ID)%>"/>
    <input type="hidden" name="<%=GeneralConstants.LOGGED_USER_NAME%>" id="<%=GeneralConstants.LOGGED_USER_NAME%>" value="<%=session.getAttribute(GeneralConstants.LOGGED_USER_NAME)%>">
    <input type="hidden" name="<%=GeneralConstants.IS_ADMIN%>" id="<%=GeneralConstants.IS_ADMIN%>" value="<%=session.getAttribute(GeneralConstants.IS_ADMIN)%>">
    <a href="#" class="ion-navicon-round shortcut-div"></a>
    <div class="search-share-navigations">
        <div class="search-share-div">
            <div class="search-navigation" onclick="showSearchBar()">
                <a href="#" class="ion-search"></a>
            </div>
            <div class="share-navigation">
                <a href="#" class="ion-android-share-alt"></a>
            </div>
        </div>
        <div class="navigation-div">
            <a href="#" class="admin-navigation sub-navigation" id="admin-sesstings">Admin Settings</a>
            <a href="#" class="donate-navigation sub-navigation">Donate</a>
            <a href="#" class="my-identity-navigation sub-navigation">My Identity</a>
            <a href="#" class="logout-navigation sub-navigation" id="logout-navigation" onclick="showLogoutUserContainer(true)">Logout/Settings</a>
            <a href="#" class="login-navigation sub-navigation" id="login-navigation" onclick="loginMouseHover()">Login</a>
            <a href="#" class="health-life-navigation sub-navigation">Health Technique</a>
            <a href="#" class="home-navigation  sub-navigation">Home</a>
        </div>
    </div>

    <div class="general-search-container" id="general-search-container" onclick="showExpandSearchBar()">
        <form class="general-search-form" id="general-search-form">
            <i class="ion-search"></i>
            <div class="general-search-div" id="general-search-div">
                <input type="text" name="search" placeholder="Search..">
            </div>
            <div class="general-search-div-closebut" id="general-search-div-closebut">
                <i class="ion-close-round mycloseicon" onclick="searchCloseBut()"></i>
            </div>
        </form>
    </div>

    <!--div id="general-share-container" class="general-share-container">
        <a href="#" id="facebook"> <i class="ion-social-facebook"></i>Face Book</a>
        <a href="#" id="twitter"> <i class="ion-social-twitter"></i>Twitter</a>
        <a href="#" id="google"> <i class="ion-social-googleplus"></i>Google+</a>
    </div-->

    <div class="logout-user-setting-container" id="logout-user-setting-container">
        <ul class="logout-user-ul">
            <li class="logout-user-li avator-img-li">
                <div class="avator-img-div">
                    <img src="webRes/img/Healthy_life_Large_Img_900_506.jpg" alt="Welcome User" class="user-avator-img">
                </div>
                <div class="wlecome-user-div">
                    <span class="welcome-msg">Welcome</span>
                    <span class="logged-username" id="logged-username">Sathish Kumar Sundaram</span>
                </div>
            </li>
            <li class="logout-user-li personal-setting-li">
                    <a href="#" class="personal-user-setings media-link">Personal Settings</a>
            </li>
            <li class="logout-user-li logout-li">
                    <a href="#" class="personal-user-setings media-link" onclick="performSignout()">Logout</a>
            </li>
        </ul>
    </div>


</nav>
<div class="clearfix">

</div>

<div class="main-login-container" id="main-login-container">
    <div class="contant-container">
        <div class="login-container" id="login-container">
            <div class="login-header">
                <p class="header-text">Sign In</p>
                <i class="ion-close-round mycloseicon" onclick="loginCloseBut()"></i>
            </div>
            <div class="clearfix">

            </div>
            <div class="login-warning-messages" id="login-warning-messages">
            </div>
            <form method="post" action="submit" class="login-handler">
                <div class="through-social-media">
                    <p class="login-catption">With Your Social Network</p>
                    <a href="#" class="div-facebook by_social_medai media-link">
                        <i class="ion-social-facebook social-icon"></i>
                        <span>Facebook</span>
                    </a>
                    <a href="#" class="div-twitter by_social_medai media-link">
                        <i class="ion-social-twitter social-icon"></i>
                        <span>Twitter</span>
                    </a>
                    <a href="#" class="div-gmail by_social_medai media-link">
                        <i class="ion-social-googleplus social-icon"></i>
                        <span>Gmail</span>
                    </a>
                </div>
                <div class="clearfix">

                </div>

                <div class="between-social-and-user">
                    ------------------ Or ------------------
                </div>

                <div class="through-username-pass">
                    <p class="login-catption">With Your UserName</p>
                    <fieldset class="div-username">
                        <legend>UserName</legend>
                        <input type="text" id="loginUsername" class="username placeholder-fix" placeholder="UserName" required/>
                    </fieldset>
                    <fieldset class="div-password">
                        <legend>Password</legend>
                        <input type="password" id="loginPassword" class="password placeholder-fix" placeholder="Password" required/>
                    </fieldset>

                    <div class="keep-me-signed-in">
                        <label for="keepMeSignedIn">Keep Me Signed In:</label>
                        <input type="checkbox" class="signedIn-checkbox" id="keepMeSignedIn"/>
                    </div>
                    <!--span class="keep-me-signed-in">Keep Me Signed In:

                    </span-->
                    <div class="clearfix"></div>

                    <a href="#" class="btn-submit div-submit media-link" id="btn-submit" onclick="performLogin()">Sign In</a>

                    <div class="signup-forgotpassword">
                            <span class="div-not-a-member">Not a member?
                                <a href="#" class="sign-up media-link" onclick="showSignUpForm()">Sign Up</a>
                            </span>
                        <a href="#" class="forgot-password media-link" onclick="showForgotPasswordForm()">Recover my password?</a>
                    </div>
                </div>
            </form>
        </div>
        <div class="clearfix">

        </div>

        <div class="signUp-container" id="signUp-container">
            <div class="login-header">
                <p class="header-text">Sign Up</p>
                <i class="ion-close-round mycloseicon" onclick="loginCloseBut()"></i>
            </div>
            <form method="post" action="submit" class="signup-handler">
                <div class="signup-warning-msg" id="signup-warning-msg">
                </div>
                <ul class="signup-unorder-list">
                    <li>
                        <fieldset class="div-signup">
                            <legend>UserName</legend>
                            <input type="text" id="signup-username" class="input-signup placeholder-fix" required onfocusout="verifyExistingUserName()"/>
                            <input type="hidden" id="verifyUserNameStatus" name="verifyUserNameStatus" value="false"/>
                            <div class="signup-icons">
                                <i class="ion-android-checkmark-circle signup-username-circle sign-up-warning-msg-icons" id="signup-username-circle"></i>
                                <i class="ion-close-circled signup-username-circle-failed sign-up-warning-msg-icons-failed" id="signup-username-circle-failed"></i>
                            </div>
                            <div class="signup-warning-msg signup-username-warning-messages" id="signup-username-warning-messages"/>
                        </fieldset>
                    </li>
                    <li>
                        <fieldset class="div-signup">
                            <legend>Password</legend>
                            <input type="password" id="signup-password" class="input-signup placeholder-fix" required onfocusout="verifyPassword()"/>
                            <input type="hidden" id="verifyPasswordStatus" name="verifyPasswordStatus" value="false"/>
                            <div class="signup-icons">
                                <i class="ion-android-checkmark-circle signup-password-circle sign-up-warning-msg-icons" id="signup-password-circle"></i>
                                <i class="ion-close-circled signup-password-circle-failed sign-up-warning-msg-icons-failed" id="signup-password-circle-failed"></i>
                            </div>
                            <div class="signup-warning-msg signup-password-warning-messages" id="signup-password-warning-messages"/>
                        </fieldset>
                    </li>
                    <li>
                        <fieldset class="div-signup">
                            <legend>Confirm Password</legend>
                            <input type="password" id="signup-password-cnf" class="input-signup placeholder-fix" required onfocusout="verifyCnfPassword()"/>
                            <input type="hidden" id="verifyCnfPasswordStatus" name="verifyCnfPasswordStatus" value="false"/>
                            <div class="signup-icons">
                                <i class="ion-android-checkmark-circle signup-cnf-password-circle sign-up-warning-msg-icons" id="signup-cnf-password-circle"></i>
                                <i class="ion-close-circled signup-cnf-password-circle-failed sign-up-warning-msg-icons-failed" id="signup-cnf-password-circle-failed"></i>
                            </div>
                            <div class="signup-warning-msg signup-cnf-password-warning-messages" id="signup-cnf-password-warning-messages"/>
                        </fieldset>
                    </li>
                    <li>
                        <fieldset class="div-signup">
                            <legend>Mail Id</legend>
                            <input type="email" id="signup-mail-id" class="input-signup placeholder-fix" required onfocusout="verifyMailId()"/>
                            <input type="hidden" id="verifyMailIdStatus" name="verifyMailIdStatus" value="false"/>
                            <div class="signup-icons">
                                <i class="ion-android-checkmark-circle signup-email-circle sign-up-warning-msg-icons" id="signup-email-circle"></i>
                                <i class="ion-close-circled signup-email-circle-failed sign-up-warning-msg-icons-failed"  id="signup-email-circle-failed"></i>
                            </div>
                            <div class="signup-warning-msg signup-email-warning-messages" id="signup-email-warning-messages"/>
                        </fieldset>
                    </li>
                    <li>
                        <fieldset class="div-signup">
                            <legend>Terms And Conditions</legend>
                            <input type="checkbox" id="termsConditions" class="termsConditions"/><a href="#">Read and Accept.</a>
                        </fieldset>
                    </li>
                    <div class="clearfix"></div>
                    <div class="sign-up-footer">
                        <a href="#" class="btn-submit media-link" id="signup-btn-submit" onclick="performSignUp()">Sign
                            Up</a>

                        <div class="signup-forgotpassword">
                            <a href="#" class="sign-up media-link" onclick="showSignInForm()">Sign In?</a>
                            <a href="#" class="forgot-password media-link" onclick="showForgotPasswordForm()">Forgot
                                Password?</a>
                        </div>
                    </div>
                </ul>
            </form>
        </div>
        <div class="clearfix">
        </div>
        <div class="forgot-password-container" id="forgot-password-container">
            <div class="login-header">
                <p class="header-text">Password Reset</p>
                <i class="ion-close-round mycloseicon" onclick="loginCloseBut()"></i>
            </div>

            <div class="password-reset-warning-messages" id="password-reset-warning-messages"></div>

            <div class="clearfix">
            </div>

            <input type="hidden" id="forgot-password-current-status" value="mailid">

            <form class="form-forgot-password form-reset-pass" id="form-forgot-password-mailid" method="post" action="forgotPassword.do">
                <fieldset class="div-signup">
                    <legend>Enter Your Mail Id</legend>
                    <input type="email" class="forgot-pass-mail-id input-signup placeholder-fix" id="forgot-pass-mail-id"/>
                </fieldset>
                <div class="forgot-pass-submit">
                    <a href="#" class="forgot-pass-reset-pass media-link">Reset Password.</a>
                </div>
            </form>

            <div class="forgot-pass-dashes">
                -------------------
            </div>

            <form class="form-account-validator form-reset-pass" id="form-forgot-pass-account-validator" method="post" action="accountValidator.do">
                <fieldset class="div-signup">
                    <legend>Enter Secret Code.</legend>
                    <input type="number" class="secret-code input-signup placeholder-fix" id="forgot-pass-secret-code">
                </fieldset>
                <div class="forgot-pass-submit">
                    <a href="#" class="media-link forgot-pass-validate-code" id="forgot-pass-validate-code-but">Validate</a>
                </div>
            </form>

            <div class="forgot-pass-dashes">
                -------------------
            </div>

            <form class="form-new-password-getter form-reset-pass" id="form-forgot-pass-new-password-getter" action="newPassword.do" method="post">
                <fieldset class="div-signup">
                    <legend>New Password</legend>
                    <ul class="reset-password-ul">
                        <li>
                            <label class="lbl-reset-password" for="forgot-password-reset-password">Password : </label>
                            <input type="password" class="reset-password placeholder-fix" id="forgot-password-reset-password">
                        </li>
                        <li>
                            <label class="lbl-reset-password-conf" for="forgot-password-reset-password-conf">Confirm : </label>
                            <input type="password" class="reset-password-conf placeholder-fix" id="forgot-password-reset-password-conf">
                        </li>
                    </ul>
                </fieldset>
                <div class="forgot-pass-submit">
                    <a href="#" class="media-link forgot-pass-change-pass-but" id="forgot-pass-change-pass-but">Change Password.</a>
                </div>
            </form>
            <div class="signup-forgotpassword">
                <a href="#" class="sign-up media-link" onclick="showSignInForm()">Sign In?</a>
                <a href="#" class="forgot-password media-link" onclick="showSignUpForm()">SignUp?</a>
            </div>
        </div>
        <div class="clearfix">
        </div>
    </div>
</div>
<div class="clearfix">

</div>
