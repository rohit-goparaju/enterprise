$(
	function(){
		
		$("#deleteButton").click(
			function(){
				let deleteDelay = 5000;
				let aadhaar = $("#deleteAadhaar").text();
				let userConfirmation = window.confirm("Are you sure that you want to delete the aadhaar "+aadhaar+"?");
				if(userConfirmation){
					let myData = "deleteRequest=true&aadhaar="+encodeURIComponent(aadhaar);
					$.ajax(
						{
							url : "PersonServlet",
							type: "POST",
							data: myData,
							contentType: "application/x-www-form-urlencoded",
							success: function(response){
								$(".deletable").remove();
								$("#deleteButton").prop("disabled",true).delay(deleteDelay).fadeOut();
								$("#deletedMessage").removeAttr("hidden").fadeIn().delay(deleteDelay).fadeOut();
								
								setTimeout(function(){
									$("#"+aadhaar+"record").remove();
								}, deleteDelay*0.5);
								
								setTimeout(function(){
									window.location.href = response.trim();
								}, deleteDelay*0.6);
							},
							error: function(xhr, status, error){
								console.log("Error: ", error);
							}
						}
					);
				}
			}
		);	
		
		
	}
);