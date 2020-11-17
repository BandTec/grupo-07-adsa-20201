
function iniciar(){
    msgErroCadastro.innerHTML = '';
    input_senha.style.borderColor = 'gray';
    input_confsenhacad.style.borderColor = 'gray';
    input_email.style.borderColor = 'gray';
}
function iniciarLogin(){
    msgErroLogin.innerHTML = '';
}

function formCadastro(){

    divcadastro.style.display = 'block';
    divlogin.style.display = 'none';
}

function formRecuperar(){
    divrecuperacao.style.display = 'block';
    divlogin.style.display = 'none';

}

function formLogin(){
    divrecuperacao.style.display = 'none';
    divcadastro.style.display = 'none';
    divlogin.style.display = 'block';

}

function painelproduto1(){

    if(selecaoproduto.value == 'alcool'){
        
        painelprod.innerHTML = '<div class="produto">Álcool perfumado Azul<br><img src="../img/20200614_142549.jpg" alt="" class="img-selecao"></div><div class="produto">Álcool perfumado Rosa<br><img src="../img/20200614_142922.jpg" alt="" class="img-selecao"></div><div class="produto">Álcool perfumado Verde<br><img src="../img/20200614_144304.jpg" alt="" class="img-selecao"></div><div class="produto">Álcool 70%<br><img src="../img/20200614_143124.jpg" alt="" class="img-selecao"></div>';

    }else if(selecaoproduto.value == 'amaciante'){
        painelprod.innerHTML = '<div class="produto">Amaciante azul<br><img src="../img/confor.jpg" alt="" class="img-selecao"></div><div class="produto">Amaciante Rosa Floral<br><img src="../img/floral.jpg" alt="" class="img-selecao"></div><div class="produto">Amaciante Amarelo Fofo<br><img src="../img/20200614_140602.jpg" alt="" class="img-selecao"></div>';
    }else if(selecaoproduto.value == 'detergente'){
        painelprod.innerHTML = '<div class="produto">Neutro<br><img src="../img/20200614_134701.jpg" alt="" class="img-selecao"></div><div class="produto">Maçã<br><img src="../img/20200614_134832.jpg" alt="" class="img-selecao"></div><div class="produto">Cristal<br><img src="../img/20200614_134903.jpg" alt="" class="img-selecao"></div>';
    }else if(selecaoproduto.value == 'desinfetante'){
        painelprod.innerHTML = '<div class="produto">Casa Limpa<br><img src="../img/20200614_141451.jpg" alt="" class="img-selecao"></div><div class="produto">Dove<br><img src="../img/20200614_142204.jpg" alt="" class="img-selecao"></div><div class="produto">kaiak<br><img src="../img/20200614_141205.jpg" alt="" class="img-selecao"></div><div class="produto">Bom ar<br><img src="../img/20200614_142407.jpg" alt="" class="img-selecao"></div><div class="produto">Flesh limão<br><img src="../img/20200614_142721.jpg" alt="" class="img-selecao"></div><div class="produto">Pinho sol<br><img src="../img/20200614_141646.jpg" alt="" class="img-selecao"></div><div class="produto">Citronela<br><img src="../img/20200614_140855.jpg" alt="" class="img-selecao"></div>';
    }else if(selecaoproduto.value == 'limpezaleve'){
        painelprod.innerHTML = '<div class="produto">Cândida Perfumada<br><img src="../img/20200614_144047.jpg" alt="" class="img-selecao"></div><div class="produto">Veja multiuso<br><img src="../img/20200614_144304.jpg" alt="" class="img-selecao"></div>';
    }else if(selecaoproduto.value == 'limpezapesada'){
        painelprod.innerHTML = '<div class="produto">Cloro<br><img src="../img/cloro.jpg" alt="" class="img-selecao"></div><div class="produto">Facilit<br><img src="../img/20200614_134750.jpg" alt="" class="img-selecao"></div><div class="produto">Limpa alumínio<br><img src="../img/20200614_144600.jpg" alt="" class="img-selecao"></div>';
    }else if(selecaoproduto.value == 'sabaoliquido'){
        painelprod.innerHTML = '<div class="produto">Sabão<br><img src="../img/azul.jpg" alt="" class="img-selecao"></div><div class="produto">Sabão líquido coco<br><img src="../img/coco.jpg" alt="" class="img-selecao"></div><div class="produto">Sabão em pó <br><img src="../img/20200614_144612.jpg" alt="" class="img-selecao"></div><div class="produto">Sabão em pó<br><img src="../img/20200614_144624.jpg" alt="" class="img-selecao"></div>';
    }else if(selecaoproduto.value == 'utensilios'){
        painelprod.innerHTML = '<div class="produto">Saco de lixo<br><img src="../img/20200614_133311.jpg" alt="" class="img-selecao"></div><div class="produto">Sabão em pedra<br><img src="../img/20200614_133045.jpg" alt="" class="img-selecao"></div><div class="produto">Aplik para vasos sanitários<br><img src="../img/20200614_133215.jpg" alt="" class="img-selecao"></div><div class="produto">Pedra sanitária<br><img src="../img/20200614_144635.jpg" alt="" class="img-selecao"></div><div class="produto">Esponja de aço<br><img src="../img/20200614_133123.jpg" alt="" class="img-selecao"></div><div class="produto">Luvas de borracha<br><img src="../img/20200614_132654.jpg" alt="" class="img-selecao"></div><div class="produto">Varal Nº5<br><img src="../img/20200614_135019.jpg" alt="" class="img-selecao"></div>';
    }
    else if(selecaoproduto.value == 'vassouras'){
        painelprod.innerHTML = '<div class="produto">Vassoura noviça com capa<br><img src="../img/20200614_132158.jpg" alt="" class="img-selecao"></div><div class="produto">Vassoura cantoneira<br><img src="../img/20200614_132116.jpg" alt="" class="img-selecao"></div><div class="produto">Rodo 30CM plástico<br><img src="../img/20200614_132233.jpg" alt="" class="img-selecao"></div><div class="produto">Vassoura piaçava<br><img src="../img/20200614_132546.jpg" alt="" class="img-selecao"></div><div class="produto">Escovinha para roupas<br><img src="../img/20200614_133726.jpg" alt="" class="img-selecao"></div>';
    }
}

