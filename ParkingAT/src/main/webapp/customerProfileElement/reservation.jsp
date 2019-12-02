<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored ="false"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/customerProfile.css">
        <link rel="stylesheet" href="./reservation.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class= "Reservation">
        <table class="Ordertable">
        <tr>
            <th>Reservation Number</th>
            <th>Date</th>
            <th>Check In</th>
            <th>Check Out</th>
            <th>Garage Name</th>
            <th>Spots </th>
            <th>Price</th>
            <th>Paid</th>
        </tr>
        <tr>
            <td>192307305213DTJ7C</td>
        <td>05/21</td>
        <td>07:31:07</td>
        <td>09:50:12</td>
        <td>NWR Parking</td>
        <td>D3-41</td>
        <td>$9</td>
        <td>Paid</td>
    </tr>
    <tr>
        <td>192307300918DTJ7C</td>
        <td>09/18</td>
        <td>07:34:18</td>
        <td></td>
        <td>NWR Parking</td>
        <td>A4-12</td>
        <td></td>
        <td>unpaid</td>
    </tr>
    </table>
    <br>
        <button><a href="../homepage.jsp">New Reservation</a></button>
    <br>
    <br>
        <button>Edit Reservation</button>
    <br>
    </div>
    </body>
</html>