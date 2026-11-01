package br.com.tcc.monitoramento.service;

import br.com.tcc.monitoramento.model.LimiarSeguranca;
import br.com.tcc.monitoramento.model.RegistroSinalVital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotorRegraService {

    private final NotificacaoService notificacaoService;


    @Autowired
    public MotorRegraService(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    public void analisarRegistro(LimiarSeguranca limiarSeguranca, RegistroSinalVital registroSinalVital){


        if (registroSinalVital.getValorSinalVital() > limiarSeguranca.getValorMax()){

            //Manda a notificação pro celular
            notificacaoService.enviarAlertaLimiar(registroSinalVital.getPaciente().getTokenFcm(), "Limiar: " + limiarSeguranca.getTipoSinalVital() + "Está com o valor acima dos limites!" );
        }

       else if (registroSinalVital.getValorSinalVital() < limiarSeguranca.getValorMin()){

            //Manda a notificação pro celular
           notificacaoService.enviarAlertaLimiar(registroSinalVital.getPaciente().getTokenFcm(), "Limiar: " + limiarSeguranca.getTipoSinalVital() + "Está com o valor abaixo dos limites!");


        }

        else {
            // valor ok
        }

    }







}
