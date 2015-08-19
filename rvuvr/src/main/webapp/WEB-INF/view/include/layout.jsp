<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Rvuvr - One stop for all product review and service review</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Responisve, Bootstrap, Html5, Css3, Blog, Classified, Ads, Simple, Clean ">
<!-- CSS -->
<link href="/rvuvr/css/bootstrap.min.css" rel="stylesheet" media="screen">
<!-- Google Webfont -->
<link href='https://www.google.com/fonts#UsePlace:use/Collection:Open+Sans:400,300,400italic,600,700,800,800italic' rel='stylesheet' type='text/css'>
<!-- Main Css -->
<link href="/rvuvr/css/color1.css" rel="stylesheet" media="screen" id="color">
<link href="/rvuvr/css/demo.css" rel="stylesheet" >
<!-- Font Icon -->
<link href="/rvuvr/css/font-awesome.min.css" rel="stylesheet" media="screen">
<!-- Include only for MapSearch Page -->
<link rel="stylesheet" href="/rvuvr/css/ui.css"/>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="/rvuvr/js/html5shiv.js"></script>
      <script src="/rvuvr/js/respond.min.js"></script> 
     <![endif]-->
</head>
<body>
<!-- Header Start -->
 <header>
		<tiles:insertAttribute name="appHeader" />
	</header>
  
</header>
<!-- Header End -->
<div id="maincontainer"> 
  	<contentbody>
		<tiles:insertAttribute name="appBody" />
	</contentbody>
  <!-- Footer -->
 <footer>
	<tiles:insertAttribute name="appFooter" />
	</footer>
    
  <!-- Got to top --> 
  <a id="gotop"><i class="fa fa-arrow-circle-up"></i></a> </div>
<div id="styleswitch">
  <h3>Style Color switcher <i class="fa fa-cogs"></i> </h3>
  <a href="javascript: void(0)" title="switch styling" id="color1">color1</a> <a href="javascript: void(0)" title="switch styling" id="color2">color2</a> <a href="javascript: void(0)" title="switch styling" id="color3">color3</a> <a href="javascript: void(0)" title="switch styling" id="color4">color4</a> <a href="javascript: void(0)" title="switch styling" id="color5">color5</a> <a href="javascript: void(0)" title="switch styling" id="color6">color6</a> <a href="javascript: void(0)" title="switch styling" id="color7">color7</a> <a href="javascript: void(0)" title="switch styling" id="color8">color8</a> <a href="javascript: void(0)" title="switch styling" id="color9">color9</a> <a href="javascript: void(0)" title="switch styling" id="color10">color10</a> <a href="javascript: void(0)" title="switch styling" id="color11">color11</a> <a href="javascript: void(0)" title="switch styling" id="color12">color12</a> <a href="javascript: void(0)" title="switch styling" id="color13">color13</a> <a href="javascript: void(0)" title="switch styling" id="color14">color14</a> <a href="javascript: void(0)" title="switch styling" id="color15">color15</a> <a href="javascript: void(0)" title="switch styling" id="color16">color16</a> <a href="javascript: void(0)" title="switch styling" id="color17">color17</a> <a href="javascript: void(0)" title="switch styling" id="color18">color18</a> <a href="javascript: void(0)" title="switch styling" id="color19">color19</a> <a href="javascript: void(0)" title="switch styling" id="color20">color20</a> </div>
<!-- Placed at the end of the document so the pages load faster --> 
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="/rvuvr/js/jquery.js"></script> 
<script src="/rvuvr/js/jquery-migrate-1.2.1.js"></script> 
<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script src="/rvuvr/js/bootstrap.min.js"></script> 
<!-- include jQuery + carouFredSel plugin --> 
<script src="/rvuvr/js/jquery.carouFredSel-6.2.1-packed.js"></script> 
<!-- Flex slider Blog--> 
<script src="/rvuvr/js/jquery.flexslider.js"></script> 
<!-- Jquery zoom on detail page--> 
<script  src="/rvuvr/js/zoomsl-3.0.min.js"></script> 
<!-- Jquery Validation--> 
<script  type="text/javascript" src="/rvuvr/js/jquery.validate.js"></script> 
<!-- Jquery Latest Tweet--> 
<script type="text/javascript" src="/rvuvr/js/jquery.tweet.js"></script> 
<!-- Jquery Countdown--> 
<script type="text/javascript" src="/rvuvr/js/jquery.countdown.js"></script> 
<!-- Social --> 
<script type="text/javascript" src="/rvuvr/js/socialstream.jquery.js"></script> 
<!-- Jquery Map --> 
<!--<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script> --> 
<!--<script type="text/javascript" src="/rvuvr/js/jquery.gmap.js"></script> -->
<!-- Sparkline --> 
<script type="text/javascript" src="/rvuvr/js/jquery.sparkline.min.js"></script> 
<!-- Cloud --> 
<script type="text/javascript" src="/rvuvr/js/jqcloud-1.0.4.js"></script> 
<!-- Ratina View --> 
<script type="text/javascript" src="/rvuvr/js/retina-1.1.0.min.js"></script> 
<!-- Custom --> 
<script src="/rvuvr/js/brand.js"></script> 
<script src="/rvuvr/js/area.js"></script>
<script src="/rvuvr/js/category.js"></script> 
<!-- Include only for MapSearch Page --> 
<script src="/rvuvr/js/jquery.ui.core.min.js"></script> 
<script src="/rvuvr/js/jquery.ui.widget.min.js"></script> 
<script src="/rvuvr/js/jquery.ui.position.min.js"></script> 
<script src="/rvuvr/js/jquery.ui.autocomplete.min.js"></script> 
<!--<script src="/rvuvr/js/map.js"></script> -->
<!-- Style Switcher --> 
<script type="text/javascript" src="/rvuvr/js/jquery.style-switcher.js"></script> 
<script type="text/javascript">
$(document).ready(function() {
	$('#styleswitch').styleSwitcher();
	$("#styleswitch h3").click(function () {
		if($(this).parent().css("left") == "-200px"){
			$(this).parent().animate({left:'0px'}, {queue: false, duration: 500});
 		} else {
    	$(this).parent().animate({left:'-200px'}, {queue: false, duration: 500});
  		}
 	 });
});
</script>
</body>

</html>
