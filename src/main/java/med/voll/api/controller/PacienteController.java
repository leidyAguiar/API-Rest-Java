package med.voll.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.dto.DadosAtualizacaoPacienteDTO;
import med.voll.api.domain.dto.DadosCadastroPacienteDTO;
import med.voll.api.domain.dto.DadosDetalhamentoPacienteDTO;
import med.voll.api.domain.dto.DadosListagemPacienteDTO;
import med.voll.api.domain.entity.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity cadastrarPaciente(@RequestBody @Valid DadosCadastroPacienteDTO dadosPacienteDTO, UriComponentsBuilder uriBuilder) {
        var paciente = new Paciente(dadosPacienteDTO);
        repository.save(paciente);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPacienteDTO(paciente));
    }

    @Operation(summary = "Listagem de pacientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna uma lista de Pacientes"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @GetMapping
    public ResponseEntity<Page<DadosListagemPacienteDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPacienteDTO::new);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "Atualiza informações de um paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informações do paciente atualizadas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPacienteDTO dadosAtualizacaoPacienteDTO) {
        var paciente = repository.getReferenceById(dadosAtualizacaoPacienteDTO.id());
        paciente.atualizarInformacoes(dadosAtualizacaoPacienteDTO);

        return ResponseEntity.ok(new DadosDetalhamentoPacienteDTO(paciente));
    }

    @Operation(summary = "Exclusão de paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Paciente excluído com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.inativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPacienteDTO(paciente));
    }
}