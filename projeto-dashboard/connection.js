const mysql = require('mysql');

const connection = mysql.createConnection({
    host:"3.95.157.176",
    port:"3306",
    user:"root",
    password:"urubu100",
    database:"bdTelemon"
});

connection.connect(function(err){
    if(err) return console.log(err);
    console.log("Conectado com sucesso")
});

module.exports=connection;