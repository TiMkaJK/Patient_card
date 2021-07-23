$('#user-save').on('submit', function (event) {

    let firstName = $('#firstName').val();
    let lastName = $('#lastName').val();
    let email = $('#email').val();
    let password = $('#password').val();

    let user = {
        "firstName": firstName,
        "lastName": lastName,
        "email": email,
        "password": password,
        "status": {
            "id": 1
        }
    }

    $.ajax({
        url: 'http://localhost:8082/api/v1/users/',
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(user),

        success: function (result) {
            if (result) {
                window.location.href = "otp-form.html";
            }
        }
    });
})