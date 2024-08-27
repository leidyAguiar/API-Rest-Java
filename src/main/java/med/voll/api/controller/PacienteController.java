package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.dto.DadosCadastroPacienteDTO;
import med.voll.api.domain.entity.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrarPaciente(@RequestBody @Valid DadosCadastroPacienteDTO dadosPacienteDTO) {
        repository.save(new Paciente(dadosPacienteDTO));
        String mensagem = "Paciente cadastrado com sucesso!";
        return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
    }
}