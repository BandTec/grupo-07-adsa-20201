const express = require('express');
const app = express();

const connection = require('./connection');
const bodyParser = require('body-parser');

const cors = require ('cors');

const port = 3000;

app.use(cors());
app.use(bodyParser.urlencoded({extended: true}));

app.get('/',(req,res)=>{
    res.send('Você está na localhost:3000');
});

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

    let sql = "INSERT INTO tbMaquina (nomeMaquina, modeloMaquina, dataCadastroMaquina) values (?, ?, ?)"; 
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


app.listen(port, function(){
    console.log('Servidor rodando na porta '+port);
});
