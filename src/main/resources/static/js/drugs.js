let currentPage = 1;

getDrugs(currentPage);

function getDrugs(page) {

    let pageSize = 20;

    $.ajax({
        url: 'http://localhost:8082/api/v1/drugs/list-pageable?page=' + page + '&?size=' + pageSize,
        type: 'GET',
        contentType: "application/json",

        success: function (res) {

            let totalPages = res.totalPages;
            const $pagination = $('#pagination');

            $pagination.empty();

            for (let i = 0; i < totalPages; i++) {
                $pagination.append(`<li class="page-item"><a class="page-link" href="#">${i + 1}</a></li>`)
            }

            let content = res.content;
            const $tableBody = $('#drug-body');

            $tableBody.empty();

            content.forEach(function (item) {
                $tableBody.append(`<tr><td>${item.name}</td>
                                     <td>${item.manufactureDate}</td>
                                     <td>${item.manufacturer.name} ${item.manufacturer.city} ${item.manufacturer.street}</td>
                                     <td>${item.coordinates.latitude} ${item.coordinates.longitude}</td>
                                     <td>${item.contraindications}</td></tr>`);
            });
        }
    });
}

$('body').on('click', '.page-item', function () {
    currentPage = $(this).find('a').text();
    getDrugs(currentPage);
});