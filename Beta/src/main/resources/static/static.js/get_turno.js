window.addEventListener('load', function () {
    (function(){


      const url = '/turnos';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {

         for(turno of data){

            var table = document.getElementById("turnoTable");
            var turnoRow =table.insertRow();
            let tr_id = 'tr_' + turno.id;
            turnoRow.id = tr_id;

            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + turno.id + '\"' +
                                      ' type="button" onclick="deleteBy('+turno.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';


            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                      ' type="button" onclick="findBy('+turno.id+')" class="btn btn-info btn_id">' +
                                      turno.id +
                                      '</button>';


            turnoRow.innerHTML = '<td>' + updateButton + '</td>' +
                    '<td class=\"td_odontologoId\">' + '<p>Odontologo&nbsp</p>' + turno.odontologo.nombre +  '</td>' +
                    '<td class=\"td_pacienteId\">' + '<p>Paciente&nbsp</p>' + turno.paciente.nombre + '</td>' +
                    '<td class=\"td_fechaId\">' + '<p>Fecha&nbsp</p>' + turno.fecha + '</td>' +
                    '<td class=\"td_horaId\">' + '<p>Hora&nbsp</p>' + turno.hora + '</td>' +
                    '<td>' + deleteButton + '</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/turnoList.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })