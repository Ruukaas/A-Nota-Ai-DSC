import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.mycompany.dscproject.dao.ManagerDao;
import com.mycompany.dscproject.model.Item;
import com.mycompany.dscproject.model.Preco;

public class pricesTest {
    @Test
    public void test() {
        Preco price = new Preco(); 

        price.setDataDeRegistro("21/32/1231");
        price.setItem(new Item());
        price.setProduto("Cachaça");
        price.setValor(15.56);

        ManagerDao.getCurrentInstance().insert(price);

        assertNotNull(price.getCodigo());

        // Get id from db, work In Progress
        ManagerDao.getCurrentInstance().read(null, getClass());

    }
}
