package com.sige.specifications;

import com.sige.model.Pesquisa;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;


public class PesquisaSpecifications {
    public static Specification<Pesquisa> palavraChave(String palavraChave) {
        return (root, query, builder) -> {
            if(ObjectUtils.isEmpty(palavraChave)) {
                return null;
            }
            return builder.or(builder.like(root.get("titulo"), "%" + palavraChave + "%"), builder.like(root.get("descricao"), "%" + palavraChave + "%"));
        };
    }
    public static Specification<Pesquisa> area(String area) {
        return (root, query, builder) -> {
            if(ObjectUtils.isEmpty(area)) {
                return null;
            }
            return builder.equal(root.get("area"), area);
        };
    }
    public static Specification<Pesquisa> modalidade(String modalidade) {
        return (root, query, builder) -> {
            if(ObjectUtils.isEmpty(modalidade)) {
                return null;
            }
            return builder.equal(root.get("modalidade"), modalidade);
        };
    }
    public static Specification<Pesquisa> local(String localizacao) {
        return (root, query, builder) -> {
            if(ObjectUtils.isEmpty(localizacao)) {
                return null;
            }
            return builder.equal(root.get("localizacao"), localizacao);
        };
    }
}