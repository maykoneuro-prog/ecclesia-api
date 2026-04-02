package com.example.ecclesiaapi.controller;

import com.example.ecclesiaapi.domain.Igreja;
import com.example.ecclesiaapi.service.IgrejaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/igrejas")
public class IgrejaController {

    private final IgrejaService igrejaService;

    public IgrejaController(IgrejaService igrejaService) {
        this.igrejaService = igrejaService;
    }

    /**
     * ✅ CREATE e UPDATE
     * - Sem ID  -> cria
     * - Com ID  -> altera
     */
    @PostMapping
    public Igreja salvar(@RequestBody Map<String, Object> body) {

        Igreja igreja;

        // ✅ SE VEIO ID, BUSCA PARA ALTERAR
        if (body.get("id") != null) {
            Long id = Long.valueOf(body.get("id").toString());
            igreja = igrejaService.buscarPorId(id);

            if (igreja == null) {
                throw new RuntimeException("Igreja não encontrada para alteração");
            }
        } else {
            // ✅ SENÃO, CRIA NOVA
            igreja = new Igreja();
        }

        igreja.setNome((String) body.get("nome"));
        igreja.setTipo((String) body.get("tipo"));
        igreja.setCnpj((String) body.get("cnpj"));
        igreja.setAtiva((Boolean) body.get("ativa"));

        // ✅ CAMPO DIOCESE (AGORA FUNCIONA)
        igreja.setDiocese((String) body.get("diocese"));

        igreja.setCep((String) body.get("cep"));
        igreja.setPais((String) body.get("pais"));
        igreja.setEndereco((String) body.get("endereco"));
        igreja.setNumero((String) body.get("numero"));
        igreja.setComplemento((String) body.get("complemento"));
        igreja.setBairro((String) body.get("bairro"));
        igreja.setCidade((String) body.get("cidade"));

        Long igrejaPaiId = body.get("igrejaPaiId") != null
                ? Long.valueOf(body.get("igrejaPaiId").toString())
                : null;

        Long responsavelId = body.get("responsavelId") != null
                ? Long.valueOf(body.get("responsavelId").toString())
                : null;

        return igrejaService.salvar(igreja, igrejaPaiId, responsavelId);
    }

    @GetMapping
    public List<Igreja> listar(@RequestParam(required = false) String tipo) {
        if (tipo != null) {
            return igrejaService.listarPorTipo(tipo);
        }
        return igrejaService.listar();
    }
}
