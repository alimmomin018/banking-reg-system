(function ($) {
    var btn = document.getElementById("myBtn");
    var updateBtn = document.getElementById("update");
    var span = document.getElementsByClassName("close")[0];
    var modal = document.getElementById("myModal");

    $('.hide').hide();

    $('#update').click(function () {

    });


    $('#main_password, #confirm_password').on('keyup', function () {
        var regex = /((?=.*d)(?=.*[a-z])(?=.*[A-Z]).{8,15})/gm;
        if (($('#main_password').val() == $('#confirm_password').val()) &&  $('#main_password').val().match(regex)) {
            $("#myBtn").prop("disabled", false);
            $('#message').html('Matching').css('color', 'green');
        } if ($('#main_password').val() != $('#confirm_password').val()) {
            $('#message').html('Password Must be between 8 to 15 characters'+
            'Password Must Contain at least one uppercase,lowercase character, a number and a special character').css('color', 'red');
            $("#myBtn").prop("disabled", true);
        }});


    btn.onclick = function (e) {

        $("#modal_username").val($("#main_username").val());
        $("#modal_firstName").val($("#main_firstName").val());
        $("#modal_lastName").val($("#main_lastName").val());
        $("#modal_address").val($("#main_address").val());
        $("#modal_city").val($("#main_city").val());
        $("#modal_company").val($("#main_company").val());
        $("#modal_jobTitle").val($("#main_jobTitle").val());
        $("#modal_phone").val($("#main_phone").val());
        $("#modal_password").val($("#main_password").val());
        modal.style.display = "block";
    }

    var output = document.getElementById("jsonResponse").innerHTML;
    if(output!=null){
        output = JSON.parse(output);
        $("#main_username").val(output.customerId);
        $("#main_firstName").val(output.firstName);
        $("#main_lastName").val(output.lastName);
        $("#main_address").val(output.address);
        $("#main_city").val(output.city);
        $("#main_company").val(output.company);
        $("#main_jobTitle").val(output.jobTitle);
        $("#main_phone").val(output.phoneNumber);
        $("#main_password").val(output.password);
        $("#confirm_password").val(output.password);
        $("#main_gender").val(output.gender);

    }


    span.onclick = function () {
        modal.style.display = "none";
    }


    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
})(jQuery);