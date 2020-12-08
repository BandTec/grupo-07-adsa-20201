const mysql = require('mysql');

const connection = mysql.createConnection({
    host:"34.226.164.18",
    port:"3306",
    user:"root",
    password:"urubu100",
    database:"bdTelemon",
    multipleStatements: true
});

connection.connect(function(err){
    if(err) return console.log(err);
    console.log("Conectado com sucesso")
});

module.exports=connection;