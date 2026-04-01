package com.example.ecclesiaapi.service;

import com.example.ecclesiaapi.domain.Pessoa;
import com.example.ecclesiaapi.dto.PessoaRequest;
import com.example.ecclesiaapi.dto.PessoaResponse;
import com.example.ecclesiaapi.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    /**
     * Usado pela tela de cadastro de pessoa
     */
    public Pessoa salvar(PessoaRequest request) {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(request.nome);
        pessoa.setCpf(request.cpf);
        pessoa.setEmail(request.email);
        pessoa.setTelefone(request.telefone);
        pessoa.setIgreja(request.igreja);
        pessoa.setAtivo(request.ativo);
        pessoa.setDataInativacao(request.dataInativacao);
        pessoa.setFoto(request.foto);

        pessoa.setCep(request.cep);
        pessoa.setPais(request.pais);
        pessoa.setEndereco(request.endereco);
        pessoa.setNumero(request.numero);
        pessoa.setComplemento(request.complemento);
        pessoa.setBairro(request.bairro);
        pessoa.setCidade(request.cidade);

        // NOVO CAMPO (pode vir nulo nesse fluxo)
        pessoa.setTipo(request.tipo);

        return pessoaRepository.save(pessoa);
    }

    /**
     * Usado pela aprovação (criação direta)
     */
    public Pessoa salvarDireto(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<PessoaResponse> listarTodas() {
        return pessoaRepository.findAll()
                .stream()
                .map(p -> new PessoaResponse(
                        p.getId(),
                        p.getNome(),
                        p.getCpf()
                ))
                .collect(Collectors.toList());
    }
}