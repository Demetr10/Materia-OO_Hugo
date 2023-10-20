public class Pessoa {

    private String nome;
    private String cpf;
    private String email;
    private String tell;

    public Pessoa(String nome, String cpf, String email, String tell) {

        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.tell = tell;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String toString() {
        return "\nNome: " + nome +
                "\nCpf: " + cpf +
                "\nEmail: " + email +
                "\nTell: " + tell;
    }

}