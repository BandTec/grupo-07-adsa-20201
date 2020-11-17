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
    let sql = "select count(id) as 'id',nome from usuario where login = ? and senha = ?"; 

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

app.post('/addMsg',(req,res)=>{
    let data=[req.body.nomeMensagem, req.body.emailMensagem, req.body.textoMensagem];

    let sql = "INSERT INTO Mensagem (nome,email,textoMensagem) values (?,?,?)";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);
    });
    
});

app.post('/addPedido',(req,res)=>{
    let data=[req.body.logradouro, req.body.cep, req.body.ncasa, req.body.fixo, req.body.celular, req.body.bairro, req.body.cidade, req.body.email, req.body.senha];

    let sql = "UPDATE usuario set logradouro = ?, cep = ?, numeroCasa = ?, telefoneFixo = ?, telefoneCelular = ?, bairro = ?,cidade = ? where emailUsuario = ? and senhaUsuario = ?";

    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);  
    });

            //let agora = new Date();
            //let data3=[resultado1.codigoUsuario,agora,req.body.valortotal];
            //let sql3 = "insert into Pedido (fkUsuario, dataPedido, valorPedido) values (?,?,?)";
            //connection.query(sql3,data3, function(err2,result2){
                //if(err2) throw err2;
                //res.send(result2); 
            //});                   
});

app.post('/recuperarCliente',(req,res)=>{
    let data=[req.body.email, req.body.senha];
    let sql = "SELECT codigoUsuario FROM usuario where emailUsuario = ? and senhaUsuario = ?";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);  
    });
});

app.post('/addVenda',(req,res)=>{
    let data=[req.body.codigo, req.body.agora, req.body.total];
    let sql = "INSERT INTO Pedido (fkUsuario, dataPedido, valorPedido) values (?,?,?)";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);  
    });
});

app.post('/addItensPedido',(req,res)=>{

        let data=[req.body.itens, req.body.fkpedido];
        let sql = "INSERT INTO ProdutoPedido (fkProduto, fkPedido) values (?,?)";
    connection.query(sql,data,function(err,result){
        if(err) throw err;
        res.send(result);  
    });

    
});

app.get('/abrirProduto',(req,res)=>{
    connection.query("SELECT * FROM Produto",function(err,result){
        if(err) throw err;
        res.send(result);
    })
});

app.get('/recuperarVenda',(req,res)=>{
    connection.query("SELECT MAX(codPedido) as ultimoRegistro FROM Pedido",function(err,result){
        if(err) throw err;
        res.send(result);
    })
});

app.listen(port, function(){
    console.log('Servidor rodando na porta '+port);
});
