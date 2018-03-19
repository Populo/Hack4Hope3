$(document).ready(function() {

    $("#createUserSubmitButton").click(function() {
       var firstName = document.getElementById("firstName").value;
       var lastName = document.getElementById("lastName").value;
       var dob = document.getElementById("dob").value;
       var username = document.getElementById("username").value;
       var password = document.getElementById("password").value;
       var email = document.getElementById("email").value;

       var path = "/users/create";

       $.ajax({
           url: path,
           type: "POST",
           beforeSend: function(request) {
               request.setRequestHeader("username", username);
               request.setRequestHeader("email", email);
               request.setRequestHeader("first", firstName);
               request.setRequestHeader("last", lastName);
               request.setRequestHeader("dob", dob);
               request.setRequestHeader("password", password);
           }
       })
    });
});