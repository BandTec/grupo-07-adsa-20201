const mysql = require('mysql');

const connection = mysql.createConnection({
    host:"localhost",
    port:"3306",
    user:"root",
    password:"82408560",
    database:"bdTelemon"
});

connection.connect(function(err){
    if(err) return console.log(err);
    console.log("Conectado com sucesso")
});

module.exports=connection;