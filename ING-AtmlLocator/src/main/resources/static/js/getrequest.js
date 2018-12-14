$( document ).ready(function() {
	
	// GET REQUEST
	$("#getAllAtmLocation").click(function(event){
		event.preventDefault();
		ajaxGet();
	});

	// GET REQUEST
    	$("#hideData").click(function(event){
    		event.preventDefault();
    		$('#getResultDiv ul').empty();
    	});
	
	// DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : window.location + "atm/allLocation",
			success: function(result){
				if(result.status == "SUCCESS"){
					$('#getResultDiv ul').empty();
					var custList = "";
					$.each(result.data, function(i, location){
						var location = "location : " + i +
						", street = " + location.address.street +
						 ", housenumber = " + location.address.housenumber +
						  ", postalcode = " + location.address.postalcode +
						   ", city = " + location.address.city +
						    ", geoLocation lat = " + location.address.geoLocation.lat +
						     ", geoLocation lan = " + location.address.geoLocation.lng +
						     ", distance = " + location.distance +
						     ", type = " + location.type +
						  "<br>";
						$('#getResultDiv .list-group').append(location)

			        });
					console.log("Success: ", result);
				}else{
					$("#getResultDiv").html("<strong>Error</strong>");
					console.log("Fail: ", result);
				}
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}
})