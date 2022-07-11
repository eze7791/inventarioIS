$(document).ready(function() {
   // on ready
});


async function crearMaterial() {
  let material = {};
  material.name = document.getElementById('material').value;
  material.amount = document.getElementById('cantidad').value;

  const request = await fetch('materials', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(material)
  });
  window.location.href = 'index.html'

}