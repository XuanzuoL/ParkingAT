<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/homepage.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <title>Creating a Garage Locator on Google Maps</title>
	
  </head>
   <body style="margin:0px; padding:0px;" onload="initMap()">
   	<div class="topMenu">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <img src="./img/PGA logo.png"    class="logo">
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav">
                            <a class="nav-item nav-link active" href="/"><b>Home</b></a>
                        </div>
                    </div>
                    <%
	Object obj=session.getAttribute("customer");
	if(null==obj){
		//response.sendRedirect("/admin/login.html");
		%>
                    <div class="dropdown dropdownAlignment">
                            <button class="btn btn-secondary dropdown-toggle" style= "background-color: #3F88C5;color:#ffffff;" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              Login / Signup 
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                              <a class="dropdown-item" href="./Admin.html">Admin</a>
                              <a class="dropdown-item" href="./customerlogin.html">Customer</a>
                              <a class="dropdown-item" href="./garagelogin.html">Garage Owner</a>
                            </div>
                          </div>
                  <% 
    }else{
	
		%>
					<a href="customerProfile.jsp" style="border-radius: 5px; padding:5px; background-color: #3F88C5;color:#ffffff; margin-right:10px">My Account</a>
					<a href="customerLogin" style= "border-radius: 5px; padding:5px; background-color: #3F88C5;color:#ffffff;">Log out</a>
		
		<% }%>
            </nav>
       </div>
    	<form class="SearchGarage" action = "searchGarage" method="post">
         <label for="raddressInput">Search location:</label>
         <input type="text" id="addressInput" size="15"/>
         <label for="SartDate">From:</label>
         <input type="date" id="start" name="parking-start" value="Today" required>
         <input id="setStartime" type="time" step="1" required>
         <label for="endDate">To:</label>
         <input type="date" id="end" name="parking-end" value="Today" required>
         <input id="setEndtime" type="time" step="1" required>
	     <label for="radiusSelect">Radius:</label>
    	 <select id="radiusSelect" label="Radius" style="width:100px">
          <option value="50" selected>50 kms</option>
          <option value="30">30 kms</option>
          <option value="20">20 kms</option>
          <option value="10">10 kms</option>
        </select>
        <input class="buttonS" type="submit" id="searchButton" style="background-color: #27D154;color:white;margin-right:0%;width: 100px;" value="Search"/>
    </form>
    <div><select id="locationSelect" style="width: 30%; visibility: hidden"></select></div>
    <div class="sample">
    	<div class = "garages"><p>The List of garage</p></div>
    	</div>
    <div id="map" style="width: 65%; height: 80%; float:right" ></div>
    
    <script>
      var map;
      var markers = [];
      var infoWindow;
      var locationSelect;

        function initMap() {
          var sydney = {lat: 42.6526, lng: 73.7562};
          map = new google.maps.Map(document.getElementById('map'), {
            center: sydney,
            zoom: 11,
            mapTypeId: 'roadmap',
            mapTypeControlOptions: {style: google.maps.MapTypeControlStyle.DROPDOWN_MENU}
          });
          var marker = new google.maps.Marker({
        	  position:sydney,
        	  map:map
          })
          infoWindow = new google.maps.InfoWindow();

          searchButton = document.getElementById("searchButton").onclick = searchLocations;

          locationSelect = document.getElementById("locationSelect");
          locationSelect.onchange = function() {
            var markerNum = locationSelect.options[locationSelect.selectedIndex].value;
            if (markerNum != "none"){
              google.maps.event.trigger(markers[markerNum], 'click');
            }
          };
        }

       function searchLocations() {
         var address = document.getElementById("addressInput").value;
         var geocoder = new google.maps.Geocoder();
         geocoder.geocode({address: address}, function(results, status) {
           if (status == google.maps.GeocoderStatus.OK) {
            searchLocationsNear(results[0].geometry.location);
           } else {
             alert(address + ' not found');
           }
         });
       }

       function clearLocations() {
         infoWindow.close();
         for (var i = 0; i < markers.length; i++) {
           markers[i].setMap(null);
         }
         markers.length = 0;

         locationSelect.innerHTML = "";
         var option = document.createElement("option");
         option.value = "none";
         option.innerHTML = "See all results:";
         locationSelect.appendChild(option);
       }

       function searchLocationsNear(center) {
         clearLocations();

         var radius = document.getElementById('radiusSelect').value;
         var searchUrl = 'storelocator.php?lat=' + center.lat() + '&lng=' + center.lng() + '&radius=' + radius;
         downloadUrl(searchUrl, function(data) {
           var xml = parseXml(data);
           var markerNodes = xml.documentElement.getElementsByTagName("marker");
           var bounds = new google.maps.LatLngBounds();
           for (var i = 0; i < markerNodes.length; i++) {
             var id = markerNodes[i].getAttribute("id");
             var name = markerNodes[i].getAttribute("name");
             var address = markerNodes[i].getAttribute("address");
             var distance = parseFloat(markerNodes[i].getAttribute("distance"));
             var latlng = new google.maps.LatLng(
                  parseFloat(markerNodes[i].getAttribute("lat")),
                  parseFloat(markerNodes[i].getAttribute("lng")));

             createOption(name, distance, i);
             createMarker(latlng, name, address);
             bounds.extend(latlng);
           }
           map.fitBounds(bounds);
           locationSelect.style.visibility = "visible";
           locationSelect.onchange = function() {
             var markerNum = locationSelect.options[locationSelect.selectedIndex].value;
             google.maps.event.trigger(markers[markerNum], 'click');
           };
         });
       }

       function createMarker(latlng, name, address) {
          var html = "<b>" + name + "</b> <br/>" + address;
          var marker = new google.maps.Marker({
            map: map,
            position: latlng
          });
          google.maps.event.addListener(marker, 'click', function() {
            infoWindow.setContent(html);
            infoWindow.open(map, marker);
          });
          markers.push(marker);
        }

      
  </script>
  <script src="app.js"></script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCFCDqcWZryyPAnPa8h_cJVAWemz-kOhYo&callback=initMap">
    </script>
  </body>
</html>