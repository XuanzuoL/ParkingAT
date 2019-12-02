<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.parking.entity.Customer"%>
<%@ page isELIgnored ="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/customerProfile.css" type="text/css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
    
    <div class="outline" style="margin-left:45px">
  		<img src="./img/PGA logo.png" class="logo" >
    <div class="row ">
        <div class="col-lg">
            <img src="./img/admincover.png"class="cover" width=95% height=180px >
        </div>
    </div>
    <div class="row">
        <div class="col-md-3 col-sm-3 col-xs-12">
                <div class="row ">
                    <div class="col-md-12 col-md-12-sm-12 col-xs-12 ">
                        <img src="https://www.jamf.com/jamf-nation/img/default-avatars/generic-user-purple.png" class="rounded-circle profilepic">
                    </div>
                </div>
        </div>
        <div class="col-sm col-xs ">
                <div class="row">
                        <div class="col-md-2">
                            <label class="text-primary">Name:</label>
                        </div>
                        <div class="col-md-5">
                            <p>${customer.name}</p>
                        </div>
	            </div>
	            <div class="row">
                        <div class="col-md-2 ">
                            <label class="text-primary">Account ID:</label>
                        </div>
                        <div class="col-md-5">
                            <p>${customer.driverLicenceId}</p>
                        </div>
                </div>
                <div class="row">
                        <div class="col-md-2">
                            <label class="text-primary">Email:</label>
                        </div>
                        <div class="col-md-5">
                            <p>${customer.email}</p>
                        </div>
                </div>
                <div class="row">
                        <div class="col-md-2">
                            <label class="text-primary">Phone:</label>
                        </div>
                        <div class="col-md-5">
                            <p>${customer.phone}</p>
                        </div>
        	    </div>
        </div>
    </div> 
	<div class="row">
    	<div class="center" style="margin-left:25px;">
			<aside class="menu">
            	<li ><a href= "./customerProfileElement/personinfo.jsp" target="main">Personal Information</a></li>
	        	<li ><a href="./customerProfileElement/reservation.jsp" target="main">Reservation</a></li>
            	<li ><a href= "./customerProfileElement/message.html" target="main">Message</a></li>
            	<li ><a href= "./customerProfileElement/history.jsp" target="main">History</a></li>
    	    	<li ><a href= "./customerProfileElement/payment.html" target="main">Payment</a></li>
	        	<li ><a href= "./customerProfileElement/privacy.html" target="main">Privacy Center</a></li>
   			 </aside>
   	 </div>
    <div class="col-main">
        <div class="main-wrap">
            <iframe id="external-frame" scrolling="no" onload="setIframeHeight(this)" name="main" width=800px scrolling="auto" height=600px src="./customerProfileElement/reservation.jsp" frameborder="0"></iframe>
        </div>
    </div>
</div>
</div>
<script type="text/javascript">
    function setIframeHeight(iframe) {
        if(iframe) {
            var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
            if(iframeWin.document.body) {
                iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
            }
        }
    };

    window.onload = function() {
        setIframeHeight(document.getElementById('external-frame'));
    };
</script>
</body>
</html>
