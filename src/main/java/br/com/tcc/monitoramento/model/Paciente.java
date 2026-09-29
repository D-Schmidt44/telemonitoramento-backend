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

    @Column(nullable = false, length = 100) //cria as colunas a adiciona regras
    private String nome;
    private int idade;
    private String telefone;
    private LocalDate dataNascimento;


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

    //Metodos

    public void adicionarRegistro(RegistroSinalVital adicionarRegistro){
        historicoRegistros.add(adicionarRegistro);

    }

    // Adiciona a lista de limiar do paciente um objeto limiar -- obs: Não utilizamos o metodo, ele é acionado pelo metodo da classe Cuidador - definirLimiarPaciente
    public void adicionarAListaLimiarSegurancaPaciente(LimiarSeguranca limiarSeguranca){
        this.limiarSegurancaPaciente.add(limiarSeguranca);

    }

    public void AnalisarRegistros(){

        /*limiarSegurancaPaciente.get(i).getTipoSinalVital();
        limiarSegurancaPaciente.get(i).getValorMax();
        limiarSegurancaPaciente.get(i).getValorMin();*/

        for (int i = 0; i < limiarSegurancaPaciente.size() ; i++) {


            for (int j = 0; j < historicoRegistros.size() ; j++) {

           /* historicoRegistros.get(j).getTipoSinalVital();
            historicoRegistros.get(j).getValorSinalVital();*/

            if (limiarSegurancaPaciente.get(i).getTipoSinalVital() == historicoRegistros.get(j).getTipoSinalVital()) {
                if (historicoRegistros.get(j).getValorSinalVital() > limiarSegurancaPaciente.get(i).getValorMax() || historicoRegistros.get(j).getValorSinalVital() < limiarSegurancaPaciente.get(i).getValorMin()) {

                    System.out.println("Alerta!!! o Valor Mínimo da " + limiarSegurancaPaciente.get(i).getTipoSinalVital() + " é de: " + limiarSegurancaPaciente.get(i).getValorMin() + ". Já o Máximo é de: " + limiarSegurancaPaciente.get(i).getValorMax() );
                    System.out.println("O Valor medido é dê: " + historicoRegistros.get(j).getValorSinalVital());
                }

                else System.out.println("Tudo ok!");
            }

            }

        }

    }








}


