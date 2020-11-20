package Entities;

public class Usuario {

    private String login = "";
    private String senha = "";
    
    public Usuario(String login, String senha, String tipoUsuario) {
        this.login = login;
        this.senha = senha;
       
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String fazerLogin(){
<<<<<<< HEAD
        if(this.login.equals("victoria") && this.senha.equals("321")){
=======
        if(this.login.equals("victoria") && this.senha.equals("321") && this.tipoUsuario.equals("Funcionario")){
>>>>>>> 4778d7f4159afd83c8e1922bedb76f21d0ef7a80
            return "Funcionario";
        }
        else {
            return "";
        }
    }
    
}
