package com.sige.controller;

import com.sige.model.Denuncia;
import com.sige.model.Usuario;
import com.sige.repository.UsuarioRepository;
import com.sige.service.DenunciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/denuncias")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DenunciaController {

    private final DenunciaService denunciaService;
    private final UsuarioRepository usuarioRepository;

    /* ==========================
       ALUNO — CRIAR DENÚNCIA
    ========================== */
    @PostMapping
    public Denuncia denunciar(@RequestBody Map<String, String> body) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || auth.getName() == null) {
            throw new RuntimeException("Usuário não autenticado");
        }

        String principal = auth.getName(); // 🔥 email/cpf/cnpj/matricula

        Usuario aluno = usuarioRepository.findByPrincipal(principal)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado: " + principal)
                );

        Long estagioId = Long.valueOf(body.get("estagioId"));
        String descricao = body.get("descricao");

        return denunciaService.criarDenuncia(aluno, estagioId, descricao);
    }

    /* ==========================
       COORDENADOR
    ========================== */
    @GetMapping("/pendentes")
    public List<Denuncia> listarPendentes() {
        return denunciaService.listarPendentes();
    }

    @PostMapping("/manter/{id}")
    public void manter(@PathVariable Long id) {
        denunciaService.manterNoEstagio(id);
    }

    @PostMapping("/remover/{id}")
    public void remover(@PathVariable Long id) {
        denunciaService.removerDoEstagio(id);
    }
}
