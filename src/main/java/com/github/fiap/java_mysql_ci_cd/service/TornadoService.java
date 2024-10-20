package com.github.fiap.java_mysql_ci_cd.service;

import com.github.fiap.java_mysql_ci_cd.Exception.UserNaoEncontrado;
import com.github.fiap.java_mysql_ci_cd.dto.TornadoCadastroDTO;
import com.github.fiap.java_mysql_ci_cd.dto.TornadoExibicaoDTO;
import com.github.fiap.java_mysql_ci_cd.model.Tornado;
import com.github.fiap.java_mysql_ci_cd.repository.TornadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TornadoService {

    @Autowired
    private TornadoRepository tornadoRepository;

    public TornadoExibicaoDTO cadastrar (TornadoCadastroDTO tornadoCadastroDTO){
        Tornado tornado = new Tornado();
        BeanUtils.copyProperties(tornadoCadastroDTO, tornado);

        Tornado salvarTornado = tornadoRepository.save(tornado);
        return new TornadoExibicaoDTO(salvarTornado);
    }

    public Page<TornadoExibicaoDTO> listarTodos (Pageable pageable){
        return tornadoRepository.findAll(pageable) .map(TornadoExibicaoDTO::new);
    }


    public TornadoExibicaoDTO atualizar (Tornado tornado){
        Optional<Tornado> contatoOptional = tornadoRepository.findById(tornado.getId());

        if (contatoOptional.isPresent()){
            tornadoRepository.save(tornado);
            return new TornadoExibicaoDTO(tornado);
        }else{
            throw new UserNaoEncontrado("Tornado não existe");
        }

    }

    public void excluir (Long id){
        Optional<Tornado> optionalTornado = tornadoRepository.findById(id);
        if(optionalTornado.isPresent()){
            tornadoRepository.delete(optionalTornado.get());
        }else {
            throw new UserNaoEncontrado("Tornado não existe!");
        }
    }

    public TornadoExibicaoDTO buscarNome (String nome){
        Optional<Tornado> optionalTornado = tornadoRepository.findByNome(nome);
        if(optionalTornado.isPresent()){
            return new TornadoExibicaoDTO(optionalTornado.get());
        }else {
            throw new UserNaoEncontrado("Nome do Usuário Não encontrado!");
        }

    }

    public  List<TornadoExibicaoDTO> buscarEntreData (LocalDate dataInicial, LocalDate dataFinal){

        List<Tornado> tornado = tornadoRepository.findByDataBetween(dataInicial, dataFinal);
        if (tornado.isEmpty()){
            throw new UserNaoEncontrado("Não foram registrando nenhum tornado entre as datas referidas!");
        }else{
            return tornado.stream().map(TornadoExibicaoDTO::new).toList();
        }
    }

}
