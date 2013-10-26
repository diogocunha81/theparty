package br.com.giveparty.modelo;
 
public class User {
	private String email = "UNKNOW";
	private String password = "UNKNOW";
	private String nome = "UNKNOW";
	private String cpf = "UNKNOW";
	private String telefone = "UNKNOW";
	private String data_nascimento = "UNKNOW";
	private String sexo = "UNKNOW";
    private String estado_civil = "UNKNOW";
    private String data_cadastro = "UNKNOW";
	private String perfil = "A";
	
     
    public User(String nome, String password, String perfil){
        this.nome = nome;
        this.password = password;
        this.perfil = perfil;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
	public String getNome() {
        return nome;
    }
	
    public void setNome(String nome) {
        this.nome = nome;
    }
    
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
    public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public String getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(String data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}
