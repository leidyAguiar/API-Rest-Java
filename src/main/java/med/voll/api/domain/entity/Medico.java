package med.voll.api.domain.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.dto.DadosAtualizacaoMedicoDTO;
import med.voll.api.domain.dto.DadosCadastroMedicoDTO;
import med.voll.api.enums.Especialidade;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Medico(DadosCadastroMedicoDTO dadosMedicoDTO) {
        this.nome = dadosMedicoDTO.nome();
        this.email = dadosMedicoDTO.email();
        this.telefone = dadosMedicoDTO.telefone();
        this.crm = dadosMedicoDTO.crm();
        this.especialidade = dadosMedicoDTO.especialidade();
        this.endereco = new Endereco(dadosMedicoDTO.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoMedicoDTO dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.dadosEnderecoDTO() != null) {
            this.endereco.atualizarInformacoes(dados.dadosEnderecoDTO());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}