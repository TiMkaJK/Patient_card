fetch('http://localhost:8082/api/v1/users/')
    .then(function (res) {
        return res.json();
    })
    .then(function (res) {

        const $usersList = $('#user-list');

        res.forEach(function (item) {
            let $user = $(`<option value="${item.id}">${item.firstName} ${item.lastName}</option>`);
            $usersList.append($user);
        });
    });

fetch('http://localhost:8082/api/v1/clinics/')
    .then(function (res) {
        return res.json();
    })
    .then(function (res) {

        const $clinicList = $('#clinic-list');

        res.forEach(function (item) {
            let $clinic = $(`<option value="${item.id}">${item.name}</option>`);
            $clinicList.append($clinic);
        });
    });

$('#patient-form').on('submit', function (event) {
    event.preventDefault();
})

$('#submit').on('click', function (event) {
    let firstName = $('#first-name').val();
    let lastName = $('#last-name').val();
    let admissionDate = $('#admission-date').val();
    let ward = $('#ward').val();
    let floor = $('#floor').val();

    console.log(admissionDate);

    let patientObject = {
        "firstName": firstName,
        "lastName": lastName,
        "admissionDate": admissionDate,
        "user": {
            id: 1
        },
        "clinic": {
            id: 2
        },
        "diagnoses": [],
        "allergies": [],
        "patientDrugs": [],
        "ward": ward,
        "floor": floor,
    }

    $.ajax({
        url: 'http://localhost:8082/api/v1/patients/save',
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(patientObject),
        success: function (result) {
            location.assign("/admin");
        }
    });
});