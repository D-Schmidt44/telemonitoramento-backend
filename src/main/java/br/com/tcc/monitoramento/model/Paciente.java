package br.com.tcc.monitoramento.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;



@Entity //Transformando em Tabela
@Table(name = "tb_paciente") // atribuindo um nome para tabela
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @Column(name = "token_fcm", length = 500)
    private String tokenFcm;

    @Column(nullable = false, length = 100) //cria as colunas a adiciona regras
    private String nome;
    private int idade;
    private String telefone;
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "cuidador_id") // Cria a coluna de chave estrangeira no PostgreSQL
    private Cuidador cuidador;


    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)// 1 Paciente para muitos  Registros de sinais vitais
    private List<RegistroSinalVital> historicoRegistros = new ArrayList<>();

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<LimiarSeguranca> limiarSegurancaPaciente = new ArrayList<>();


    public Paciente() {} // Construtor Vazio (Obrigatorio Para o Jpa Conseguir Instanciar)

    public Paciente(String nome, int idade, String telefone) {

        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;

    }
    



    /// GETTERS E SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<RegistroSinalVital> getHistoricoRegistros() {
        return historicoRegistros;
    }

    public void setHistoricoRegistros(List<RegistroSinalVital> historicoRegistros) {
        this.historicoRegistros = historicoRegistros;
    }

    public List<LimiarSeguranca> getLimiarSegurancaPaciente() {
        return limiarSegurancaPaciente;
    }

    public void setLimiarSegurancaPaciente(List<LimiarSeguranca> limiarSegurancaPaciente) {
        this.limiarSegurancaPaciente = limiarSegurancaPaciente;
    }

    public Cuidador getCuidador() {
        return cuidador;
    }

    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }

    public String getTokenFcm() {
        return tokenFcm;
    }

    public void setTokenFcm(String tokenFcm) {
        this.tokenFcm = tokenFcm;
    }
}


