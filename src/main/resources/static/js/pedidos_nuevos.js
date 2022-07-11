// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarMateriales();
  $('#pedidos').DataTable(); //DataTable convierte lo que le pasamos en un tabla para que tenga paginacion
});

async function cargarMateriales() {
  const request = await fetch('/orders', {
    method: 'GET',
  });
  const orders = await request.json();

  let ordersHtml= '';
  let boton= '<a href="mostrar_pedido.html" class="btn btn-info btn-icon-split"><span class="icon text-white-50"><i class="fas fa-info-circle"></i></span><span class="text">Leer Pedido</span>';
  for(let order of orders){
        let orderHtml = '<tr><td>'+order.order_id+'</td><td>'+order.date+'</td><td>'+boton+'</td></th></tr>';
        ordersHtml += orderHtml;
  }
  document.querySelector('#pedidos tbody').outerHTML = ordersHtml;
 }

