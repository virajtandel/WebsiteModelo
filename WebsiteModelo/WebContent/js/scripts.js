$(document).ready(function(){
    var next = 1;
    $(".add-more").click(function(e){
        e.preventDefault();
        var addto = "#ref" + next;
        var addRemove = "#ref" + (next);
        next = next + 1;
        var newIn = '<input autocomplete="off" class="input form-control" id="ref' + next + '" name="ref' + next + '" type="text" placeholder="Referência ' + next +'">';
        var newInput = $(newIn);
        $(addto).after(newInput);
        $("#ref" + next).attr('data-source',$(addto).attr('data-source'));
        $("#count").val(next);
    });
    
    $('.remove-last').click(function(e){
        e.preventDefault();
        if(next > 1){
            var fieldID = "#ref" + next;
            next = next - 1;
            $("#count").val(next);
            $(fieldID).remove();
        }
    });
    
});