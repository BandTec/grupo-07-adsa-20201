const express = require('express');
const path = require('path');
const app = express();

const connection = require('./connection');
const bodyParser = require('body-parser');

const cors = require ('cors');
const port = 3000;

var today = `${new Date().getFullYear()}-${new Date().getMonth()+1}-${String(new Date().getDate()).padStart(2, '0')}`;

var today2 = `${new Date().getFullYear()}${new Date().getMonth()+1}${String(new Date().getDate()).padStart(2, '0')}`;

app.use(cors());
app.use(bodyParser.urlencoded({extended: true}));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'cliente')));



app.post('/user',(req,res)=>{
    let data = [req.body.login, req.body.senha];
    let sql = "select count(codUsuario) as 'id',nomeUsuario from tbUsuario where loginUsuario = ? and senhaUsuario = ? group by codUsuario"; 

    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);
    })
});

app.post('/addUser',(req,res)=>{
    let data=[req.body.nome, req.body.email, req.body.senha];

    let sql = "INSERT INTO usuario (nomeUsuaio,emailUsuario,senhaUsuario) values (?,?,?)";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});

app.post('/addComponente',(req,res)=>{
    let data=[req.body.nomeComponente, req.body.descComponente];

    let sql = "INSERT INTO tbComponente (nomeComponente,descComponente) values (?,?)";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});

app.post('/addPrograma',(req,res)=>{
    let data=[req.body.nomePrograma];

    let sql = "INSERT INTO tbPrograma (nomePrograma) values (?)";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});

app.post('/addFuncionario',(req,res)=>{
    let data=[req.body.nomeFuncionario, req.body.loginFuncionario, req.body.senhaFuncionario, req.body.dataCadastro];

    let sql = "INSERT INTO tbUsuario (nomeUsuario, loginUsuario, senhaUsuario, dataCadastroUsuario) values (?,?,?,?)";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});

app.post('/getValues',(req,res)=>{
    let data=[req.body.pacote, req.body.fkMaquina];

    let sql = "insert into tbComponenteMaquina (fkComponente, fkMaquina) values (?,?);";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});

app.post('/getValuesFuncionario',(req,res)=>{
    let data=[req.body.fkFuncionario, req.body.pacoteFuncionario];

    let sql = "insert into tbUsuarioMaquina (fkUsuario, fkMaquina) values (?,?);";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});




app.post('/addMaquina',(req,res)=>{
    let data=[req.body.nomeMaquina, req.body.modeloMaquina, req.body.dataCadastro];

    let sql = "INSERT INTO tbMaquina (userMaquina, modeloMaquina, dataCadastradoMaquina) values (?, ?, ?)"; 
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});



app.get('/listarComponentes',(req,res)=>{
    connection.query("SELECT * FROM tbComponente",function(err,result){
        if(err) throw err;
        res.send(result);
    })
});

app.get('/buscarUltimaMaquina',(req,res)=>{
    connection.query("SELECT Max(codMaquina) as UltimoRegistro FROM tbMaquina",function(err,result){
        if(err) throw err;
        res.send(result);
    })
});

app.get('/buscarUltimoFuncionario',(req,res)=>{
    connection.query("SELECT Max(codUsuario) as UltimoRegistro FROM tbUsuario",function(err,result){
        if(err) throw err;
        res.send(result);
    })
});

app.get('/listarPrograma',(req,res)=>{
    connection.query("SELECT * FROM tbPrograma",function(err,result){
        if(err) throw err;
        res.send(result);
    })
});

app.get('/listarFuncionario',(req,res)=>{
    connection.query("SELECT * FROM tbUsuario",function(err,result){
        if(err) throw err;
        res.send(result);
    })
});


app.get('/listarComponenteMaquina',(req,res)=>{
    connection.query("SELECT * FROM tbComponente",function(err,result){
        if(err) throw err;
        res.send(result);
    })
});



app.get('/listarFuncionarioMaquina',(req,res)=>{
    connection.query("SELECT * FROM tbMaquina",function(err,result){
        if(err) throw err;
        res.send(result);
    })
});

app.get('/listarMaquina',(req,res)=>{
    connection.query("SELECT * FROM tbMaquina",function(err,result){
        if(err) throw err;
        res.send(result);
    })
});

app.post('/excluirComponente',(req,res)=>{
    let data=[req.body.codComponente];

    let sql = "DELETE FROM tbComponente WHERE codComponente = ?";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});

app.post('/excluirFuncionarioMaquina',(req,res)=>{
    let data=[req.body.codFuncionario];

    let sql = "DELETE FROM tbUsuarioMaquina WHERE fkUsuario = ?";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});

app.post('/excluirFuncionario',(req,res)=>{
    let data=[req.body.codFuncionario];

    let sql = "DELETE FROM tbUsuario WHERE codUsuario = ?";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});

app.post('/excluirPrograma',(req,res)=>{
    let data=[req.body.codPrograma];

    let sql = "DELETE FROM tbPrograma WHERE codPrograma = ?";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});

app.post('/listarDadosCpu',(req,res)=>{
    let data1=[req.body.codMaquina,req.body.cod1];
 
    connection.query(`SELECT avg(valorDadosComponente) as 'mediaCpu' FROM tbDadosComponente INNER JOIN tbComponenteMaquina ON tbDadosComponente.fkComponenteMaquina = tbComponenteMaquina.codComponenteMaquina INNER JOIN tbComponente ON tbComponenteMaquina.fkComponente = tbComponente.codComponente WHERE nomeComponente = 'cpu' AND fkMaquina = ? AND registroDadosComponente like '${today2}%'; SELECT avg(valorDadosComponente) as 'mediaCpuTotal' FROM tbDadosComponente INNER JOIN tbComponenteMaquina ON tbDadosComponente.fkComponenteMaquina = tbComponenteMaquina.codComponenteMaquina INNER JOIN tbComponente ON tbComponenteMaquina.fkComponente = tbComponente.codComponente WHERE nomeComponente = 'cpu' AND registroDadosComponente like '${today2}%';`, data1, function(err, results, fields) {
        if (err) throw err;
        res.send(results);
      });
    
});

app.post('/listarDadosMem',(req,res)=>{
    let data1=[req.body.codMaquina,req.body.cod1];
 
    connection.query(`SELECT avg(valorDadosComponente) as 'mediaMem' FROM tbDadosComponente INNER JOIN tbComponenteMaquina ON tbDadosComponente.fkComponenteMaquina = tbComponenteMaquina.codComponenteMaquina INNER JOIN tbComponente ON tbComponenteMaquina.fkComponente = tbComponente.codComponente WHERE nomeComponente = 'ram' AND fkMaquina = ? AND registroDadosComponente like '${today2}%'; SELECT avg(valorDadosComponente) as 'mediaMemTotal' FROM tbDadosComponente INNER JOIN tbComponenteMaquina ON tbDadosComponente.fkComponenteMaquina = tbComponenteMaquina.codComponenteMaquina INNER JOIN tbComponente ON tbComponenteMaquina.fkComponente = tbComponente.codComponente WHERE nomeComponente = 'ram' AND registroDadosComponente like '${today2}%';`, data1, function(err, results, fields) {
        if (err) throw err;
        res.send(results);
      });
    
});

app.post('/excluirMaquina',(req,res)=>{
    let data=[req.body.codMaquina];

    let sql = "DELETE FROM tbMaquina WHERE codMaquina = ?";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});

app.post('/editarComponente',(req,res)=>{
    let data=[req.body.codComponente];

    let sql = "SELECT nomeComponente, descComponente FROM tbComponente WHERE codComponente = ?";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);

    });
    
});

app.get('/getProcessNamebyCount',(req,res)=>{

    let procName = req.query.proc;
    let limit = req.query.limit;
    let sql;

    if(procName == undefined){
        sql = `select nomeProcesso, count(nomeProcesso) as count from tbProcessos where registroProcesso like '${today} %' group by nomeProcesso order by count desc limit ${Number(limit)};` 
    }else{
        sql = `select nomeProcesso, count(nomeProcesso) as count from tbProcessos where registroProcesso like '${today} %' and nomeProcesso = '${procName}' group by nomeProcesso order by count desc limit ${Number(limit)};` 
    }

    connection.query(sql,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});


app.get('/getAvg',(req,res)=>{

    let comp = req.query.comp;

    let sql = `SELECT avg(valorDadosComponente) as 'media' FROM tbDadosComponente 
    INNER JOIN tbComponenteMaquina ON tbDadosComponente.fkComponenteMaquina = tbComponenteMaquina.codComponenteMaquina 
    INNER JOIN tbComponente ON tbComponenteMaquina.fkComponente = tbComponente.codComponente WHERE nomeComponente = '${comp}' AND registroDadosComponente like '${today2}%';`

    connection.query(sql,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});

app.get('/getBellowAvg',(req,res)=>{

    let comp = req.query.comp;

    let sql = `SELECT fkMaquina as maquina, avg(valorDadosComponente) as media FROM tbMaquina, tbDadosComponente
        INNER JOIN tbComponenteMaquina ON tbDadosComponente.fkComponenteMaquina = tbComponenteMaquina.codComponenteMaquina
        INNER JOIN tbComponente ON tbComponenteMaquina.fkComponente = tbComponente.codComponente WHERE nomeComponente = '${comp}' 
        AND registroDadosComponente like '${today2}%' group by fkMaquina;`

    connection.query(sql,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});

app.get('/getImproperProcess',(req,res)=>{

    let sql = `select count(count) as count from 
    (select count(nomeProcesso) as count from tbProcessos 
    where permitido = 0
    and 
    registroProcesso like '${today}%' group by nomeProcesso) as A;`

    connection.query(sql,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});

app.listen(process.env.PORT || port, function(){
    console.log('Servidor rodando na porta '+port);
});