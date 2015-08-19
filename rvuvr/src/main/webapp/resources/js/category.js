/**
 * 
 */
/**
 * 
 */
// JavaScript Document
	// Contact Form 
	$(".categoryform").validate({
   submitHandler: function(form) {
	   var categoryName = $("input#categoryName").val();
	   var parentCategoryId = $("input#parentCategoryId").val();
	   console.log("inside areaform validate");
	   var dataString = 'categoryName='+ categoryName + '&parentCategoryId=' + parentCategoryId ;
	  $.ajax({
	  type: "GET",
	  url: "/add/category",
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
	/**
 * 
 */