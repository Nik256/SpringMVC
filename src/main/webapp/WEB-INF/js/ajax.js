$(document).ready(function () {
    function deleterow() {
        $(this).closest('tr').remove();
        return false;
    }

    $("#delete-button").click(deleterow);

    $("#delete-user").click(function(){
      var link = document.getElementById("delete-user").getAttribute("href");
      $.ajax({
          url: link,
          type: 'GET'
      })
      .done(function () { $(this).closest('tr').remove(); })
    });

});