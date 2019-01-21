<nav class="navigation-container">
    <input type="hidden" name="${_csrf.parameterName}" id="${_csrf.parameterName}" value="${_csrf.token}"/>
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
            <a href="#" class="donate-navigation sub-navigation">Donate</a>
            <a href="#" class="my-identity-navigation sub-navigation">My Identity</a>
            <a href="#" class="logout-navigation sub-navigation" id="logout-navigation">Logout</a>
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
            <div class="warning-messages">
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
                <div class="warning-messages" id="warning-messages">
                    <p>Address already Exist. Please Sign up.</p>
                </div>

                <ul class="signup-unorder-list">
                    <li>
                        <fieldset class="div-signup">
                            <legend>UserName</legend>
                            <input type="text" id="signup-username" class="input-signup placeholder-fix" required onblur="checkExistingUserName()"/>
                            <div class="ion-android-checkmark-circle signup-username-circle" id="signup-username-circle"></div>
                            <div class="close-circle-outline close-username-circle" id="close-username-circle"></div>
                        </fieldset>
                    </li>
                    <li>
                        <fieldset class="div-signup">
                            <legend>Password</legend>
                            <input type="password" id="signup-password" class="input-signup placeholder-fix" required onblur="verifyPassword()"/>
                            <div class="ion-android-checkmark-circle signup-password-circle" id="signup-password-circle"></div>
                            <div class="close-circle-outline close-password-circle" id="close-password-circle"></div>
                        </fieldset>
                    </li>
                    <li>
                        <fieldset class="div-signup">
                            <legend>Confirm Password</legend>
                            <input type="password" id="signup-password-cnf" class="input-signup placeholder-fix" required onfocusout="cnfVerifyPassword()"/>
                            <div class="ion-android-checkmark-circle signup-cnf-password-circle" id="signup-cnf-password-circle"></div>
                            <div class="close-circle-outline close-cnf-password-circle" id="close-cnf-password-circle"></div>
                        </fieldset>
                    </li>
                    <li>
                        <fieldset class="div-signup">
                            <legend>Mail Id</legend>
                            <input type="email" id="signup-mail-id" class="input-signup placeholder-fix" required onfocusout="verifyMailId()"/>
                            <div class="ion-android-checkmark-circle signup-email-circle" id="signup-email-circle"></div>
                            <div class="close-circle-outline close-email-circle" id="close-email-circle"></div>
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

            <div class="warning-messages">
                <p>Address already Exist. Please Sign up.</p>
            </div>

            <div class="clearfix">
            </div>

            <form class="form-forgot-password form-reset-pass" method="post" action="forgotPassword.do">
                <fieldset class="div-signup">
                    <legend>Enter Your Mail Id</legend>
                    <input type="email" class="forgot-pass-mail-id input-signup placeholder-fix"
                           id="forgot-pass-mail-id"/>
                </fieldset>
                <div class="forgot-pass-submit">
                    <a href="#" class="forgot-pass-reset-pass media-link">Reset Password.</a>
                </div>
            </form>

            <div class="forgot-pass-dashes">
                -------------------
            </div>

            <form class="form-account-validator form-reset-pass" method="post" action="accountValidator.do">
                <fieldset class="div-signup">
                    <legend>Enter Secret Code.</legend>
                    <input type="number" class="secret-code input-signup placeholder-fix" id="secret-code">
                </fieldset>
                <div class="forgot-pass-submit">
                    <a href="#" class="media-link forgot-pass-validate-code ">Validate</a>
                </div>
            </form>

            <div class="forgot-pass-dashes">
                -------------------
            </div>

            <form class="form-new-password-getter form-reset-pass" action="newPassword.do" method="post">
                <fieldset class="div-signup">
                    <legend>New Password</legend>
                    <ul class="reset-password-ul">
                        <li>
                            <label class="lbl-reset-password" for="reset-password">Password : </label> <input
                                type="password" class="reset-password placeholder-fix" id="reset-password">
                        </li>
                        <li>
                            <label class="lbl-reset-password-conf" for="reset-password-conf">Confirm : </label>
                            <input type="password" class="reset-password-conf placeholder-fix"
                                   id="reset-password-conf">
                        </li>
                    </ul>
                </fieldset>
                <div class="forgot-pass-submit">
                    <a href="#" class="media-link forgot-pass-change-pass">Change</a>
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