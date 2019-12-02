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
        <td>05/21/2019</td>
        <td>7:33:50</td>
        <td>11:15:49</td>
        <td>EWR Parking</td>
        <td>D3-41</td>
        <td>$9</td>
        <td>Paid</td>
    </tr>
    <tr>
        <td>192314000413DTJ7C</td>
        <td>04/13/2019</td>
        <td>14:07:06</td>
        <td>20:30:07</td>
        <td>EWR Parking</td>
        <td>C2-22</td>
        <td>$30</td>
        <td>Paid</td>
    </tr>
    <tr>
        <td>732121000115DTJ7C</td>
        <td>01/15/2018</td>
        <td>21:10:08</td>
        <td>01:08:34</td>
        <td>JFK Parking</td>
        <td>C5-33</td>
        <td>$20</td>
        <td>Paid</td>
    </tr>
    <tr>
            <td>192319000923DTJ7C</td>
            <td>09/23/2018</td>
            <td>19:06:11</td>
            <td>01:20:19</td>
            <td>EWR Parking</td>
            <td>A6-09</td>
            <td>$30</td>
            <td>Paid</td>
    </tr>
    <tr>
        <td>192307300918DTJ7C</td>
        <td>08/18/2018</td>
        <td>07:34:18</td>
        <td>12:12:20</td>
        <td>NWR Parking</td>
        <td>A4-12</td>
        <td>$40</td>
        <td>Paid</td>
    </tr>
    </table>
    <br>
    <button>Clear History</button>
    </body>
</html>