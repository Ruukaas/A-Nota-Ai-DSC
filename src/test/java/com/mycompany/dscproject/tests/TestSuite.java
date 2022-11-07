package com.mycompany.dscproject.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    com.mycompany.dscproject.tests.ItemTest.class,
    com.mycompany.dscproject.tests.LojaTestes.class,
    com.mycompany.dscproject.tests.NotaFiscalTest.class,
    com.mycompany.dscproject.tests.PrecoTest.class,
    com.mycompany.dscproject.tests.ProdutoTest.class,
    com.mycompany.dscproject.tests.userTest.class
})
public class TestSuite {}
