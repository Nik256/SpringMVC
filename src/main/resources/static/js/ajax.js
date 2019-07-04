$(document).ready(function () {
    $("#newTable").on("click", "#ajax", function() {
        var $call = $(this);
        var userId = $call.closest('tr').find("td:first").text();
        var durl = '/delete-user/' + userId;
        $.ajax({
            type: 'GET',
            url: durl
        }).done(
            function (answer) {
                $call.closest('tr').remove();
            }
        )
    })
})