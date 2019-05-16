<%@ page import="static com.sunsat.sathish.j2ee.health.base.util.GeneralConstants.LIKE_COUNT" %>
<%@ page import="static com.sunsat.sathish.j2ee.health.base.util.GeneralConstants.USER_LIKE" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%--Header--%>
  <jsp:include page="head_import.jsp" />
  <%--Header--%>
</head>
<body>
  <div class="main-body-container">
    <jsp:include page="navLogin.jsp"/>
    <jsp:include page="header.jsp"/>

    <div class="main-home-container">

      <div class="multiple-image-container">
        <div class="no-yogo-image">
        </div>
        <div class="no-medicine-image">
        </div>
        <div class="no-diat-image">
        </div>
      </div>
      <div class="hero-textbox">
        <h1>A Simple Fundamental Technique <br> To Live an Healthy Life. </h1>
      </div>
      <div class="clearfix">

      </div>

      <div class="row main-container-row">
        <div class="col span-1-of-6 main-left" >
          <div class="section-movable" id="section-movable">
            <div class="content-navigation-side-bar">
              <a href="#" class="select">Introduction</a>
              <a href="#" class="">Hospitals, Shops, Centers</a>
              <a href="#" class="">Walk To Any Hospital</a>
              <a href="#" class="">Reason For Non-Healthy Life</a>
              <a href="#" class="">Do We Need All These</a>
              <a href="#" class="">Benefits</a>
              <a href="#" class="">Strict Diat plan</a>
              <a href="#" class="">Benifites I got</a>
              <a href="#" class="">My Guru(Heler Basker)</a>
              <a href="#" class="">Donate me</a>
              <a href="#" class="">Share this Video or Site</a>
              <a href="#" class="">Technique</a>
            </div>

            <div class="thumpsup_count" onclick="performLikeClicked(this)">
              <input type="hidden" id="userLike" value="<%=request.getAttribute(USER_LIKE)%>">
              <div class="thumpsup_msg">
                <p class="like_count_msg"><span class="total-no-likes" id="total-no-likes"><%=request.getAttribute(LIKE_COUNT)%></span> Likes</p>
              </div>
              <div class="thumpsupicon shake-up-down-effort">
                <i class="ion-thumbsup"></i>
              </div>
            </div>
          </div>

          <div class="content-temp-visible" id="content-temp-visible">

          </div>

          <!--div class="shareIconsdiv">
              <div class="icon-bar">
                  <a href="#" class="facebook"><i class="fa fa-facebook"></i></a>
                  <a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
                  <a href="#" class="google"><i class="fa fa-google"></i></a>
              </div>
          </div-->

        </div>
        <div class="col span-4-of-6 main-center">
          <div>
            <h3>
              Introduction
            </h3>
            <p>
              In this blog I am going to teach/tell you about <strong>"how to live an health life?"</strong> by applying a <strong>Simple Fundamental Technique</strong>
              <b><h4>The Meaning of Healthy Life is : </h4></b>
              <ul>
                <li>
                  All your Disease will be self healed. (Everything has some exceptional cases, So Except Few Type of Disease).
                </li>
                <li>
                  You can eat what ever you want. High/Low quality food. No need of any Diet Plan.
                </li>
                <li>
                  You dont need to do any Yoga or Exercise.
                </li>
                <li>
                  You dont required to take any health supplements.
                </li>
              </ul>
            </p>
          </div>

          <div>
            <h3>
              Hospitals, Shops, Centers, Classes, Internet & Ads:
            </h3>

            <p>
              In this world, If you go to any street in a country, definitely you will be able to find minimum of
              3 to 5 Health related Hospitable, Shops, Centers & Classes like
            </p>
            <div class="clearfix">

            </div>
            <div class="col span-2-of-3 div-different-varity-of-hospitals">
              <ul class="ul-different-varity-of-hospitals">
                <li class="li-with-img">
                  Different verity of Multi Speciality medical hospitals and clinic for Allopathy(English Medicine),
                  Homepathy, Sidha, Aurvedha, Unani, Acupuncture, PranicHealing, Touchhealing etc,
                </li>
                <li>
                  Medical Institutions & Advance Technology Research Labs.
                </li>
                <li>
                  Medical & Health products selling shops.
                </li>
                <li>
                  Diagnostic, Scanning & Blood Testing centers.
                </li>
                <li>
                  Skin, Eye, Dental & Heir Cares.
                </li>
                <li>
                  Spa, Gym, Yoga centers.
                </li>
                <li>
                  Parenting, Pregnancy related classes.
                </li>
                <li>
                  High quality Food, Air, Water purifiers & Health related equipments.
                </li>
                <li>
                  Vaccinations for child's
                </li>
                <li>
                  So many health awareness programs / Free BMI, Suger, BB & Eye checking campus.
                </li>
                <li>
                  Health product related advertisements in TV(Around the world on all channels), FM & Internet every where.
                </li>
              </ul>
            </div>
            <div class="col span-1-of-3 img-different-varity-of-hospitals" >
              <table class="img-table1">
                <tr>
                  <td>
                    <img src="webRes/img/content/hospitals_420_232.png">
                  </td>
                </tr>
                <tr>
                  <td>
                    <img src="webRes/img/content/Research_Labs_microscope-275984__480.jpg"/>
                  </td>
                </tr>

                <tr>
                  <td>
                    <img src="webRes/img/content/health_products.jpg"/>
                  </td>
                </tr>

                <tr>
                  <td>
                    <img src="webRes/img/content/bethesda-naval-medical-center-80380__480.jpg"/>
                  </td>
                </tr>
              </table>
              <table class="img-table2">
                <tr>
                  <td>
                    <img src="webRes/img/content/the_top_50_most_valuable_cosmetics_brands_2014.jpg"/>
                  </td>
                </tr>
                <tr>
                  <td>
                    <img src="webRes/img/content/bethesda-naval-medical-center-80380__480.jpg"/>
                  </td>
                </tr>
                <tr>
                  <td>
                    <img src="webRes/img/content/bethesda-naval-medical-center-80380__480.jpg"/>
                  </td>
                </tr>
              </table>
            </div>
            <div class="clearfix"></div>
            <p>
              And, The bad news is, we are utilizing all these by more then 130%. But still we are not able to live an
              healthy life. Because <strong>We Are Not Applying The Fundamental Technique.</strong>
            </p>
          </div>
          <div>
            <h3>
              It Means
            </h3>
            <p>
              We are heavily practicing in a Car to drive a Flight. Obliviously will end up in crashing the flight.
            </p>
            <p>
              So to live an health life, every human being should know about?
              <ul>
                <li>
                  What is Human Body? and organs? And how its Functioning?
                </li>
                <li>
                  What is Mind/Soul?. And how its Functioning?
                </li>
                <li>
                  What is Diseases?. Why we are having it?. What are the different Types of Diseases?
                </li>
                <li>
                  And Finally the way to self heal them.
                </li>
              </ul>
            </p>
          </div>
          <div>
            <p>
              So Am I asking you to study MBBS and become a doctor?. Definitely Not. To drive a Car do you study Mechanical
              Engineering and become Car Mechanic? No, Not required. If you know the basis of how to drive a Car and some basic repare technique then you can
              happily use your Car for ever. In the same way if you know the basic of your body and some self healing fundamental technique then you can live an health life for ever.
            </p>
          </div>
          <div>
            <h3>
              Fundamental Rules Every where:
            </h3>
            <p>
              In This world every thing has a rule. For Ex :
              <ul>
                <li>
                  Walking in a Road
                </li>
                <li>
                  Watching a movie in Theater
                </li>
                <li>
                  Buying products
                </li>
                <li>
                  Studying in a schools
                </li>
                <li>
                  Chatting in Whatsapp
                </li>
                <li>
                  Driving a car
                </li>
                <li>
                  Working in office
                </li>
                <li>
                  etc., etc., etc.,
                </li>
              </ul>
            </p>
            <p>
              In The same way living an healthy life also has some rules. And we need to follow those rules strictly.
              Otherwise we cannot live an health life. Unfortunately those rules were very simple if we understand and make practice it.
            </p>
            <div>
              <h3>
                Type of Diseases.
              </h3>
              <p>
                According to Allopathy medicine more then 1 million different type Diseases available in human body.
                But according to our ancient saint there were only 3 type of Diseases available
                <ol>
                  <li>
                    <h4>Diseases one have when he/she born. </h4>
                    <p>
                      This type of Diseases has only 50% chance to self heal by applying the fundamental technique.
                      So its mandatory to seek doctor advice and also you can try to apply the fundamental technique.
                      For Ex.
                      <ul>
                        <li>
                          Any Type of Genetic Disorder.
                        </li>
                        <li>
                          Any Type of Disease the baby has in the womb itself.
                        </li>
                      </ul>
                    </p>
                  </li>
                  <li>
                    <h4>Any Type of Emergency in once lifespan Or Any Type Physical damage to your body. </h4>
                    <p>
                      These type cases cannot be self healed by applying this technique. Its mandatory to go to hospital and seek doctor advise.
                      For Ex:
                      <ul>
                        <li>
                          Twin Baby born with attached organs.
                        </li>
                        <li>
                          One suddenly get an Heart Attack.
                        </li>
                        <li>
                          Some poisoned inset bite.
                        </li>
                        <li>
                          Any type of accident.
                        </li>
                        <li>
                          Any type of born fracture.
                        </li>
                      </ul>
                    </p>
                  </li>
                  <li>

                    <h4>
                      Diseases comes inside from your body after he/she born.
                    </h4>
                    <p>
                      In this world majority of people face this type of Diseases due to lack of knowledge, about human body, its function and fundamental techniques.
                      By applying the fundamental we can easily solve this these type of
                      Like Ex:
                    </p>
                    <ul>
                      <li>
                        Asthuma, Vising, Headach, Any type of Eye Disease, Teeth problem, Heart Problem, Hair Falling, stones in kidney, Alsur etc....
                      </li>
                      <li>

                      </li>
                    </ul>
                  </li>
                </ol>

              </p>
            </div>
            <div>
              If you have 3rd type desiases and your intersted to know about fundamental technique to self
              heal please send out a mail to healthylifetechnique@gmail.com for further communication.
            </div>
          </div>
        </div>
        <div class="col span-1-of-6 main-right" style="border:  1px solid deepskyblue">
          Display Empty Container.
        </div>
        <div class="col span-1-of-6 main-right" style="border:  1px solid deepskyblue">
          Display Empty Container.
        </div>

      </div>
    </div>

  </div>
  <jsp:include page="foot_import.jsp"/>
</body>
</html>
