/**
 * 
 */
// JavaScript Document
	// Contact Form 
	$(".brandform").validate({
   submitHandler: function(form) {
	   var companyId = $("input#companyId").val();
	   var brandName = $("input#brandName").val();
	   var brandType = $("input#brandType").val();
	   console.log("inside brandform validate");
	   var dataString = 'companyId='+ companyId + '&brandName=' + brandName + '&brandType=' + brandType;
	  $.ajax({
	  type: "GET",
	  url: "/add/brand",
	  data: dataString,
	  success: function() {
		  $('#contactmsg').remove();
		  $('.contactform').prepend("<div id='contactmsg' class='successmsg'>Form submitted successfully!</div>");
		   $('#contactmsg').delay(1500).fadeOut(500);
		  $('#submit_id').attr('disabled','disabled');
		  }
		});   
   return false;
	}
	});
	