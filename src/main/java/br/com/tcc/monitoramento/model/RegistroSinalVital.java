package br.com.tcc.monitoramento.model;


import java.time.LocalDateTime;

public class RegistroSinalVital {

    public enum TipoSinalVital{
        PRESSAO_ARTERIAL,
        GLICEMIA,
        PESO;};


    private TipoSinalVital tipoSinalVital;
    private double valorSinalVital;
    private LocalDateTime horaRegistro;

    //associação
    private Paciente paciente;

    ///Construtor
    public RegistroSinalVital(TipoSinalVital tipoSinalVital, double valorSinalVital){
        this.tipoSinalVital = tipoSinalVital;
        this.valorSinalVital = valorSinalVital;
        this.horaRegistro = LocalDateTime.now();
    }




//setter e Getters

public TipoSinalVital getTipoSinalVital() {
    return tipoSinalVital;
}

public double getValorSinalVital() {
        return valorSinalVital;
}

public void setTipoSinalVital(TipoSinalVital tipoSinalVital) {
        this.tipoSinalVital = tipoSinalVital;
}

public LocalDateTime getHoraRegistro() {
        return horaRegistro;
}
}

