package br.com.tcc.monitoramento.controller;

import br.com.tcc.monitoramento.model.RegistroSinalVital;
import br.com.tcc.monitoramento.repository.RegistroSinalVitalRepository;
import br.com.tcc.monitoramento.service.RegistroSinalVitalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrosinalvital")
public class RegistroSinalVitalController {

    private final RegistroSinalVitalService registroSinalVitalService;

    public RegistroSinalVitalController(RegistroSinalVitalService registroSinalVitalService) {
        this.registroSinalVitalService = registroSinalVitalService;
    }

    @PostMapping
    public ResponseEntity<RegistroSinalVital> criarRegistro(@RequestBody RegistroSinalVital registroSinalVital) {
        RegistroSinalVital novoRegistroSinalVital = registroSinalVitalService.salvar(registroSinalVital);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoRegistroSinalVital);
    }


    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<RegistroSinalVital>> listarPorPaciente(@PathVariable Long pacienteId) {
        List<RegistroSinalVital> historico = registroSinalVitalService.listarPorPaciente(pacienteId);
        return ResponseEntity.ok(historico);
    }

}
