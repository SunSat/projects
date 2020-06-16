$(window).on('load', function () {
    $('#logout_button').on('click',function () {
        $.ajax({
            type: 'POST',
            url: '/logout',
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Accept', 'application/json');
                xhr.setRequestHeader('X-CSRF-TOKEN', $('#_csrf').val());
            },
            success:function(response){
                if(response.logout_message === 'success') {
                    if (response.redirect) {
                        window.location.href = response.redirect;
                    }
                    else {
                        // Process the expected results...
                    }
                }
            },
            error: function(xhr, textStatus, errorThrown) {
                alert('Error!  Status = ' + xhr.status);
            }
        })
    })
});