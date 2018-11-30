<%@ include file="taglips.jsp"%>
<input type="hidden" name="currentFormAction" id="currentFormAction" value=""/>
<input type="hidden" name="currentFormSubAction" id="currentFormSubAction" value=""/>
<input type="hidden" name="userMessage" id="userMessage" value=""/>
<input type="hidden" name="userId" id="userId" value="">
<input type="hidden" name="sessionId" value="" id="sessionId"/>

<div class="header-container" id="header-container">
  <div id="right-login-avator-image-container" class="right-login-avator-image-container">
    <div class="login-button-container" id="login-button-container">
      <button class="login-button" id="login-button" name="login" >Login</button>
    </div>

    <div class="small-avator-image" id="small-avator-image" >
      <label class="lbl-small-avator-image" id="userInitial" >
      </label>
    </div>
  </div>
</div>


<div class="logging-popup-container" id="logging-popup-container">
  <div class="login-userInput-container" id="login-userInput-container">

    <div class="loginMessage" id="loginMessage"></div>

    <div name="login-userInput-form">
      <div class="logging-row1">
        <label for="loginUserName">UserName : </label>
        <input type="text" name="userName" id="loginUserName" value="">
      </div>
      <div class="logging-row2">
        <label for="loginPassword">Password : </label>
        <input type="password" name="password" id="loginPassword" value="">
      </div>
      <div class="logging-row3">
        <input type="button" name="signin" id="login-continer-signin" value="Sign In" >
        <input type="button"  name="signup" id="login-continer-signup" value="Sign Up" >
        <input type="button" name="cancel" id="login-continer-cancel" value="Cancel">
      </div>
    </div>
  </div>

  <div class="signup-userinput-container" id="signup-userinput-container">
    <div name="signUp-userInput-form" id="signUp-userInput-form">
      <div class="sigupMessage" id="signupMessage">
      </div>
      <div>
        <label for="signUpuserName">UserName : </label>
        <input type="text" id="signUpUserName" class="signUpUserName" value="">
      </div>
      <div>
        <label for="signUpPassword">Password : </label>
        <input type="password" id="signUpPassword" value="">
      </div>
      <div>
        <label for="signUpConfirmPassword">Confirm : </label>
        <input type="password" id="signUpConfirmPassword" value="">
      </div>
      <div>
        <label for="signUpMailId">Mail id : </label>
        <input type="email" id="signUpMailId" value="">
      </div>
      <div>
        <input type="button" class="submit" id="signup-continer-submit" value="Sign Up" >
        <input type="button" class="signin" id="signup-continer-signin" value="Sign In" >
        <input type="button" class="cancel" id="signup-continer-cancel" value="Cancel" >
      </div>
    </div>
  </div>

  <div class="logged-user-container" id="logged-user-container">
    <div class="avator-details-container" id="avator-details-container">
      <div class="row1" id="row1">
        <div class="big-avator-image" id="big-avator-image">
          <img src="#" id="avatorImage">
        </div>
        <div class="other-details">
          <label id="userName" class="userName"></label>
          <label id="mailId" class="mailId"></label>
        </div>
      </div>
      <div class="row2" id="row2">
        <div class="button-setting">
          <button id="setting" name="setting" class="setting">Settings</button>
        </div>
        <div class="button-signout">
          <button id="logged-user-container-signout" class="signout" >Signout</button>
        </div>
      </div>
    </div>
  </div>
</div>
