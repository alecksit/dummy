/**
 * 
 */
/**
 * 
 */
// JavaScript Document
	// Contact Form 
	$(".areaform").validate({
   submitHandler: function(form) {
	   var stateId = $("input#stateId").val();
	   var areaName = $("input#areaName").val();
	   console.log("inside areaform validate");
	   var dataString = 'stateId='+ stateId + '&areaName=' + areaName ;
	  $.ajax({
	  type: "GET",
	  url: "/add/area",
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
	