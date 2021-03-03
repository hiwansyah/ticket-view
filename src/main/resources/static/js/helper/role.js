$(document).ready(function(){
    $('#activeRole').val('true'); 
});




function editRole(param){
    console.log(param);
    
    //$('.idRoleEdit').val(idRole);
    //$('.nameRoleEdit').val(nameRole);
    //$('.activeRoleEdit').val(activeRole);
    

    $('#editRole').modal('toggle');
}

function removeRole(param){
    console.log(param);
    var idRole = $('#idRoleText'+param).text();
    var nameRole = $('#nameRoleText'+param).text();
    $('.idRoleRemove').val(idRole);
    $('.nameRoleRemove').text(nameRole);    

    $('#removeRole').modal('toggle');
}