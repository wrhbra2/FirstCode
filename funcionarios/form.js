//Conexão.
async function connect() {
  const pg = require('pg');
  const bd = 'postgres://root:w@nd3r2303@localhost:5432/postgres';
  const cliente = new pg.Client(bd);
cliente.connect();
console.log('Conectou!')};



//Funcionarios.
//var id = null;
var nome = document.getElementById("form_nome");
var cargo = document.getElementById("form_cargo");
var celular = document.getElementById("form_celular");
var email = document.getElementById("form_email");



document.getElementById("btnNovo").addEventListener("click", function () {
  addRow(id, nome, cargo, celular, email);  // adiciona o valor na tabela
});

document.getElementById("btnResetar").addEventListener("click", function () {
   resetRows(); // limpa todas as linhas da tabela
});

document.getElementById("btnCancelar").addEventListener("click", function () {
   document.getElementById("cadastro").value=''; // limpa todos os inputs do formulário
});

function resetRows() {
    var table = document.getElementById("tabela"); // obtêm o elemento table
    var rowCount = table.rows.length; // faz a contagem total linhas na table
    for (var x = rowCount-1; x > 0; x--) {
       table.deleteRow(x); // deleta linha por linha
    }
  }

function addRow(id, nome, cargo, material, retirada, devolucao, obs) {
  let table = document.getElementById("tabela");
  let row = table.insertRow(-1); // será adicionado na última linha
  var idCell = row.insertCell(0);
  var nomeCell = row.insertCell(1); // o index "1" refere-se a coluna "Nome"
  var cargoCell = row.insertCell(2); // o index "2" refere-se a coluna "Cargo"
  var celularCell = row.insertCell(3); // o index "3" refere-se a coluna "Material"
  var emailCell = row.insertCell(4); // o index "4" refere-se a coluna "Quantidade"
  
  idCell.innerHTML = id.value;
  nomeCell.innerHTML = nome.value;
  cargoCell.innerHTML = cargo.value;
  celularCell.innerHTML = material.value;
  quantCell.innerHTML = quant.value;
  emailCell.innerHTML = retirada.value;
 
}

document.getElementById('btnBusca').addEventListener("click",function () {
  
 } ); 
 
 






