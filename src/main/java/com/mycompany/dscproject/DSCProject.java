package com.mycompany.dscproject;

import com.mycompany.dscproject.dao.ManagerDao;
import com.mycompany.dscproject.model.Usuario;

public class DSCProject {

    public static void main(String[] args) {
        Usuario user = new Usuario();
        user.setCpf("251145745787-8");
        user.setEmail("gostoso@sim.br");
        user.setNome("Lucas");
        user.setSenha("LucasDmaisSoh");
        user.setTelefone("81955476829");
        user.setUsuario("LukinhasDaRapeize");
        
        

        ManagerDao.getCurrentInstance().insert(user);

    }
}
