$( document ).ready(function() {
    getAllrooms();

    setTimeout(
      function()
      {

      }, 2000);
});

$("#addroomform").submit(function(e){
    e.preventDefault();

    var json = {
        name : $("input[name=roomname]").val()
    };

    $.ajax({
      method: "POST",
      url: "/api/movies/",
      contentType: "application/json",
      data: JSON.stringify(json),
      success: function(result) {
        getAllrooms();
      }
    });

});

function removeRoom(room){

    $.ajax({
      method: "DELETE",
      url: "/api/movies/"+ room + "/",
      contentType: "application/json",
      success: function( result ) {
        getAllrooms();
      }
    });

};

function getAllrooms(){
    $.ajax({
      method: "GET",
      url: "/api/movies/",
      contentType: "application/json",
      success: function( result ) {
        PrintResult(result);
      }
    });

};


function updateMovie(id, idname, moviewatched){

    var json = {
        name : $("input[name="+idname+"]").val(),
        watched : moviewatched
    };


console.log(json);

    $.ajax({
      method: "PUT",
      url: "/api/movies/" + id + "/",
      contentType: "application/json",
      data: JSON.stringify( json),
      success: function( result ) {
        getAllrooms();
      }
    });

};



function PrintResult(result){
    $("#result").html(JSON.stringify(result));

    var resultTable = "<table class='table-rooms table table-striped'>";
    resultTable += "<thead><tr> <th>Film</th> <th>Gezien?</th> <th></th> <th></th></tr></thead>";
    resultTable += "<tbody>";

    $.each(result, function(key,value){
        resultTable += "<tr>";
        resultTable += "<td><input name='idname"+value.id+"' value='"+value.name+"'> <div onclick='updateMovie("+ value.id +", `idname"+ value.id +"` ,"+ value.watched+ ")'>aanpassen</div></td>";
        resultTable += "<td onclick='removeRoom("+ value.id +")'>Remove</td>";

        if(value.watched == true) resultTable += "<td>Seen</td>";
        else resultTable += "<td>Not seen</td>";
        resultTable += "</tr>";
    });

    resultTable += "</tr></tbody></table>";

    $("#result").html(resultTable);
}

function PrintSingleResult(result){
    $("#result").html(result);
}