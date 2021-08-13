import {API_URL} from './const.js'

fetch(API_URL + '/users/')
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

fetch(API_URL + '/clinics/')
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
        url: API_URL + '/patients/save',
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(patientObject),
        success: function (result) {
            location.assign("/admin");
        }
    });
});