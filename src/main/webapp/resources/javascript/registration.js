/*
*
 * Created by alexandr on 13.7.15.

*/


$(document).ready(function(){
    $('#sendButton').click(function(){
        $.ajax({
            url:'hello',
            data: {
                login:$('#login').val(),
                password:$("#password").val(),
                language:$("#language").val(),
                remember:$("#remember").val()

            },
            success : function(data){

                $('html').html(data);


            }
        });

    })
});
