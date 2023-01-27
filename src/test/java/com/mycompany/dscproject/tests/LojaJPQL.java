package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Loja;
import com.mycompany.dscproject.model.Produto;
import jakarta.persistence.TypedQuery;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LojaJPQL extends BaseTests {
    @Test
    public void lojasQueTemTelevisao() {
        Produto produto = em.find(Produto.class, Long.valueOf(2));
        TypedQuery<Loja> query;
        query = em.createQuery(
                "SELECT l FROM Loja l WHERE :produto MEMBER OF l.produtos",
                Loja.class);
        query.setParameter("produto", produto);
        Loja loja = query.getSingleResult();
        assertEquals("Eletronic Arts", loja.getNome());
    }
}
