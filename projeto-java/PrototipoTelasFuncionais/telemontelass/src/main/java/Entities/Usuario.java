
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
        if(this.login.equals("victoria") && this.senha.equals("321")){
            return "Funcionario";
        }
        else {
            return "";
        }
    }
    
}
