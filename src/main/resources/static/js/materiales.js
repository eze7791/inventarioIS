// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarMateriales();
  $('#materiales').DataTable(); //DataTable convierte lo que le pasamos en un tabla para que tenga paginacion
});

async function cargarMateriales() {
  const request = await fetch('/materials', {
    method: 'GET',
  });
  const materials = await request.json();

  let materialsHtml= '';
  for(let material of materials){
        let materialHtml = '<tr><td>'+material.name+'</td><th scope="row">'+material.amount+'</th></tr>';
        materialsHtml += materialHtml;
  }
  document.querySelector('#materiales tbody').outerHTML = materialsHtml;
 }



