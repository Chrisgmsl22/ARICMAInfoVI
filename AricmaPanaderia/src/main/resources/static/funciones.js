function eliminar(id_empleado){
        swal({
      title: "¿Estas seguro de Eliminar?",
      text: "Una vez eliminado, no podrá recuperar el registro!",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((OK) => {
      if (OK) {
          $.ajax({
              url:"/eliminar/"+id_empleado,
              success: function(res){
                  console.log(res);
              }
          });
        swal("El registro fue eliminado", {
          icon: "success",
        }).then((ok)=>{
            if(ok){
                location.href="/listar";
            }         
        });
      } else {
        swal("El registro no fue eliminado!");
      }
    });
    
}

