import static org.junit.Assert.assertEquals;

import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mycompany.dscproject.model.NotaFiscal;
import com.mycompany.dscproject.model.Usuario;

public class userTest {

    @Test
    public void test() {
        Usuario user = new Usuario();
        NotaFiscal nota = new NotaFiscal();
        List<NotaFiscal> compras = new List();

        compras.add(nota);
        user.setCpf("251145745787-8");
        user.setEmail("gostoso@sim.br");
        user.setNome("Lucas");
        user.setSenha("LucasDmaisSoh");
        user.setTelefone("81955476829");
        user.setUsuario("LukinhasDaRapeize");
        user.setCompras(compras);

        ManagerDao.getCurrentInstance().insert(user);

        assertNotNull(user.getCompras());
        assertEquals("251145745787-8", user.getCpf());
        assertEquals("gostoso@sim.br", user.getEmail());
        assertEquals("Lucas", user.getNome());
        assertEquals("LucasDmaisSoh", user.getSenha());
        assertEquals("81955476829", user.getTelefone());
        assertEquals("LukinhasDaRapeize", user.getUsuario());

    }
}