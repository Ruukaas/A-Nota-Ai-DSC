package com.mycompany.dscproject.tests;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import com.mycompany.dscproject.dao.ManagerDao;
import com.mycompany.dscproject.model.Item;
import com.mycompany.dscproject.model.Preco;
import com.mycompany.dscproject.model.Produto;
import java.util.Date;

public class pricesTest extends BaseTests
{
    @Test
    public void test() {
        Preco price = new Preco(); 

        price.setDataDeRegistro(new Date(2022, 12, 20));
        price.setItem(new Item());
        price.setProduto(new Produto());
        price.setValor(15.56);

        ManagerDao.getCurrentInstance().insert(price);

        assertNotNull(price.getCodigo());

        // Get id from db, work In Progress
        ManagerDao.getCurrentInstance().read(null, getClass());
    }
}
