$(window).on('load',function () {
    $('#login_button').on('click',function () {
        let reqData  = {
            username: $('#username_req').val(),
            password: $('#passwrod_req').val(),
        }
        $.ajax({
            type: 'POST',
            url: '/manual_loggin',
            data : reqData,
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Accept', 'application/json');
                xhr.setRequestHeader('X-CSRF-TOKEN', $('#_csrf').val());
            },
            success:function(response){
                if(response.login_message === 'success') {
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
    });
    $('#signup_button').on('click',function () {
        console.log("Hello World");
    });
});