package domain;

public class Usuario {
    
    private int IdUsuario;
    private String usuario;
    private String password;

    public Usuario() {
    }
    
     //para el select
    public Usuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public Usuario(int IdUsuario, String usuario, String password) {
        this.IdUsuario = IdUsuario;
        this.usuario = usuario;
        this.password = password;
    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "IdUsuario=" + IdUsuario + ", usuario=" + usuario + ", password=" + password + '}';
    }
    
    
}
