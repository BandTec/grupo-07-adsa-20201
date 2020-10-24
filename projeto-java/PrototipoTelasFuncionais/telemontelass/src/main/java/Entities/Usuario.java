
package Entities;

public class Usuario {
    
    private Integer codigo = 0;
    private String nome = "";
    private String login = "";
    private String senha = "";
    
    public Usuario(Integer codigo, String nome, String login, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
       
    }
    
    public Usuario(){
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
    public Boolean fazerLogin(){
        if(this.login.equals("larissa") && this.senha.equals("123")){
            return true;
        }else {
            return false;
        }
    }
    
}
