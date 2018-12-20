/**
 * 
 */
$( document ).ready((function ()
{
	
	$("#rapp").hide();
	
	$("#visitorIP").append(
			"Votre IP est : "+ visitor.ip.address 	
	);
	
	$("#visitorCountry").append(
			"Votre pays est : "+ visitor.geo.countryName 	
	);
	
	$("#visitorBrowser").append(
			"Vous êtes sur le navigateur : "+ visitor.browser.name	
	);
	
	$("#visitorScreenResolution").append(
			"La taille de votre écran est : "+ visitor.device.screen.resolution
	);
	
	var dataJSON = 
	{
		ip : visitor.ip.address,
		country : visitor.geo.countryName,
		browser : visitor.browser.name,
		screen : visitor.device.screen.resolution			
	}


	$.ajax(
        {
            type:"post",
            url: "http://localhost:8080/Analytics/Visitor",
            contentType: "application/json",
            data : JSON.stringify(dataJSON),
            success: function(data)
            {
            	console.log(dataJSON);
            },
            error: function(data)
            {
            	alert("fail");
            }
        
        })    
	
}));

$("#generate").on("click", showRapp);


function showRapp()
{
	
	$("#wrapper").hide();
	$("#rapp").fadeIn();

};





















