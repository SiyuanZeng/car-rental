<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Roux Meetups</title>
  <link rel="stylesheet" href="http://localhost:8080/car-rental/resources/Responsive/_/css/styles.css">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
</head>
<body>
  <header>
    <div class="hero">
      <section class="layout">
        <div class="branding"><a href="index.html"><img src="http://localhost:8080/car-rental/resources/Responsive/images/misc/rouxacademymeetups.svg" alt="Roux Academy Meetups"></a></div><!-- branding -->
      </section><!-- layout -->
    </div><!-- hero -->
    <div class="navigation">
      <section class="layout">
        <ul class="nav">
          <li><a href="#"><i class="icon-home"></i>Home</a></li>
          <li><a href="task.htm"><i class="icon-question-sign"></i>Add Tasks</a></li>
          <li><a href="reviewTask.htm"><i class="icon-user"></i>Review</a></li>
          <li><a href="#"><i class="icon-heart"></i>Sponsors</a></li>
          <li><a href="#"><i class="icon-keyboard"></i>Contact us</a></li>
        </ul>
      </section><!-- layout -->
    </div><!-- navigation -->
  </header><!-- header -->


  <div id="jQueryAlarm">
	<%@include  file="../jQueryAlarm/jQueryAlarm.html" %>
  </div>

	<%@include  file="../Seed-ReviewTaskForm.jsp" %>


  <footer>
    <section class="layout">
      <div class="socialmediaicons">
        <span class="title">join the movement:</span>
        <ul>
          <li><a href="http://twitter.com"><img src="http://localhost:8080/car-rental/resources/Responsive/images/socialmedia/twitter.png" alt="icon for twitter" class="icon"></a></li>
          <li><a href="http://facebook.com"><img src="http://localhost:8080/car-rental/resources/Responsive/images/socialmedia/facebook.png" alt="icon for facebook" class="icon"></a></li>
          <li><a href="http://meetup.com"><img src="http://localhost:8080/car-rental/resources/Responsive/images/socialmedia/meetup.png" alt="icon for meetup" class="icon"></a></li>
        </ul>
      </div><!-- socialmediaicons -->
    </section><!-- layout -->
  </footer><!-- footer -->

  <script src="http://localhost:8080/car-rental/resources/Responsive/_/js/script.js"></script>
  <script src="http://localhost:35729/livereload.js"></script>

   <!--  // alarm -->
  		<script src="<c:url value="/resources/jQueryAlarm/js/jquery.colorpicker.js" />" ></script>
		<script src="<c:url value="/resources/jQueryAlarm/js/jquery-1.3.2.min.js" />" ></script>
		<script src="<c:url value="/resources/jQueryAlarm/js/jquery.jplayer.js" />" ></script>
		<script src="<c:url value="/resources/jQueryAlarm/js/jquery-ui-1.7.2.custom.min.js" />" ></script>
		<link rel="stylesheet" href="<c:url value="/resources/jQueryAlarm/css/dark-hive/jquery-ui-1.7.2.custom.css" />" type="text/css" media="screen">
		<link rel="stylesheet" href="<c:url value="/resources/jQueryAlarm/main.css" />" type="text/css" media="screen">
		<link rel="stylesheet" href="<c:url value="/resources/jQueryAlarm/css/jquery.colorpicker/colorpicker.css" />" type="text/css" media="screen">


</body>
</html>