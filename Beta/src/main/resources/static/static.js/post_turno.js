window.addEventListener('load', function () {


    const formulario = document.querySelector('#add_new_turno');


    formulario.addEventListener('submit', function (event) {

        let odontologo = document.querySelector('#odontologo_id').value;
        let paciente = document.querySelector('#paciente_id').value;


        const formData = {
            odontologo: { "id" : odontologo},
            paciente: { "id" : paciente},
            fecha: document.querySelector('#fecha').value,
            hora: document.querySelector('#hora').value,

        };

        const url = '/turnos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {

                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Turno agregado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

            })
            .catch(error => {

                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";

                     resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#odontologo_id').value = "";
        document.querySelector('#paciente_id').value = "";
         document.querySelector('#fecha').value = "";
         document.querySelector('#hora').value = "";

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/turnoAlta.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});