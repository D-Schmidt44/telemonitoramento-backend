package br.com.tcc.monitoramento.model;

public class LimiarSeguranca {


    private RegistroSinalVital.TipoSinalVital tipoSinalVital;
    private double valorMax;
    private double valorMin;




 public LimiarSeguranca(double valorMax, double valorMin,  RegistroSinalVital.TipoSinalVital tipoSinalVital) {
     this.valorMax = valorMax;
     this.valorMin = valorMin;
     this.tipoSinalVital = tipoSinalVital;

 }


 //metodos

    public void setValorMax(double valorMax){
        this.valorMax = valorMax;
    }

    public void setValorMin(double valorMin){
        this.valorMin = valorMin;
    }


    public RegistroSinalVital.TipoSinalVital getTipoSinalVital() {
     return tipoSinalVital;
    }
    public double getValorMax() {
        return valorMax;
    }
    public double getValorMin() {
     return valorMin;
    }


}