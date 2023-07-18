window.addEventListener('load', function () {


    const formulario = document.querySelector('#update_turno_form');

    formulario.addEventListener('submit', function (event) {
        let turnoId = document.querySelector('#turno_id').value;

        let odontologo = document.querySelector('#odontologo_id').value;
        let paciente = document.querySelector('#paciente_id').value;

        const formData = {
            id: document.querySelector('#turno_id').value,
            odontologo: { "id" : odontologo},
            paciente: { "id" : paciente},
            fecha : document.querySelector('#fecha_id').value,
            hora : document.querySelector('#hora_id').value,
        };


        const url = '/turnos';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })


    function findBy(id) {
          const url = '/turnos'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let turno = data;
              document.querySelector('#turno_id').value = turno.id;
              document.querySelector('#odontologo_id').value = turno.odontologo.id;
              document.querySelector('#paciente_id').value = turno.paciente.id;
              document.querySelector('#fecha_id').value = turno.fecha;
              document.querySelector('#hora_id').value = turno.hora;

              document.querySelector('#div_turno_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }