package med.voll.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.dto.DadosAtualizacaoPacienteDTO;
import med.voll.api.domain.dto.DadosCadastroPacienteDTO;
import med.voll.api.domain.dto.DadosListagemPacienteDTO;
import med.voll.api.domain.entity.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @Operation(summary = "Cadastro de um paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Paciente cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrarPaciente(@RequestBody @Valid DadosCadastroPacienteDTO dadosPacienteDTO) {
        repository.save(new Paciente(dadosPacienteDTO));
        String mensagem = "Paciente cadastrado com sucesso!";
        return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
    }

    @Operation(summary = "Listagem de pacientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna uma lista de Pacientes"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @GetMapping
    public Page<DadosListagemPacienteDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPacienteDTO::new);
    }

    @Operation(summary = "Atualiza informações de um paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informações do paciente atualizadas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPacienteDTO dadosAtualizacaoPacienteDTO) {
        var paciente = repository.getReferenceById(dadosAtualizacaoPacienteDTO.id());
        paciente.atualizarInformacoes(dadosAtualizacaoPacienteDTO);
    }

    @Operation(summary = "Exclusão de paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Paciente excluído com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.inativar();
    }
}