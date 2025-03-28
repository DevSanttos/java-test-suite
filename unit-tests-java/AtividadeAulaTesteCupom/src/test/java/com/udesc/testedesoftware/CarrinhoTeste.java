package com.udesc.testedesoftware;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;


public class CarrinhoTeste {


    @Test
    public void testa_Validade_Cupom() {
        //Arrange
        LocalDate validadeCumpom = LocalDate.now().plusDays(7);
        Cupom cupomValido = new Cupom("DESC10", 10.0, validadeCumpom, 1);
        double valorCompra = 100.0;

        //Act
        double resultado = Carrinho.aplicarCupom(cupomValido, valorCompra, LocalDate.now());

        //Assert
        Assert.assertEquals("Valor do resultado após aplicação do cupom foi incorreto", 90.0, resultado, 0.0);
    }

    @Test
    public void testa_Cupom_Exipirado() {
        //Arrange
        LocalDate armazenaDataMenos1 = LocalDate.now().minusDays(1);
        Cupom cumpomValido = new Cupom("Desc", 10, armazenaDataMenos1, 1);
        double valorCompra = 100;

        //Act
        double resultado = Carrinho.aplicarCupom(cumpomValido, valorCompra, LocalDate.now());

        //Assert
        Assert.assertEquals("Valor do resultado após aplicação do cupom foi incorreto", 100.0, resultado, 0.0);
    }

    @Test
    public void testa_Cupom_Com_Validade_Atual() {
        //Arrange
        Cupom cumpom = new Cupom("DESC10", 10.0, LocalDate.now(), 1);
        double valorCompra = 100.0;

        //Act
        double resultado = Carrinho.aplicarCupom(cumpom, valorCompra, LocalDate.now());

        //Assert
        Assert.assertEquals("Valor do resultado após aplicação do cupom foi incorreto", 90.0, resultado, 0.0);
    }

    @Test
    public void testa_Cupom_Com_Codigo_Vazio() {
        //Arrange
        Cupom cumpomTeste = new Cupom("", 10.0, LocalDate.now().plusDays(7), 1);
        double valorCompra = 100.0;

        //Act
        double resultado = Carrinho.aplicarCupom(cumpomTeste, valorCompra, LocalDate.now());

        //Assert
        Assert.assertEquals("Valor do resultado após aplicação do cupom foi incorreto", 100.0, resultado, 0.0);
    }

    @Test
    public void testa_Cupom_Com_Codigo_Nulo() {
        //Arrange
        Cupom cumpomTeste = new Cupom(null, 10.0, LocalDate.now().plusDays(7), 1);
        double valorCompra = 100.0;

        //Act
        double resultado = Carrinho.aplicarCupom(cumpomTeste, valorCompra, LocalDate.now());

        //Assert
        Assert.assertEquals("Valor do resultado após aplicação do cupom foi incorreto", 100.0, resultado, 0.0);
    }

    @Test
    public void testa_Cupom_Com_Desconto_Igual_Que_Valor_Compra() {
        //Arrange
        Cupom cupomTeste = new Cupom("DESC100", 100.0, LocalDate.now().plusDays(7), 1);
        double valorCompra = 100.0;

        //Act
        double resultado = Carrinho.aplicarCupom(cupomTeste, valorCompra, LocalDate.now());

        //Assert
        Assert.assertEquals("Valor do resultado após aplicação do cupom foi incorreto", 0.0, resultado, 0.0);
    }

    @Test
    public void testa_Cupom_Com_Desconto_Maior_Que_Valor_Compra() {
        //Arrange
        Cupom cupomTeste = new Cupom("DESC110", 110.0, LocalDate.now().plusDays(7), 1);
        double valorCompra = 100.0;

        //Act
        double resultado = Carrinho.aplicarCupom(cupomTeste, valorCompra, LocalDate.now());

        //Assert
        Assert.assertEquals("Valor do resultado após aplicação do cupom foi incorreto", 0.0, resultado, 0.0);
    }

    @Test
    public void testa_Cupom_Com_Valor_Compra_Igual_A_Zero() {
        //Arrange
        Cupom cupomTeste = new Cupom("DESC10", 10.0, LocalDate.now().plusDays(7), 1);
        double valorCompra = 0.0;

        //Act
        double resultado = Carrinho.aplicarCupom(cupomTeste, valorCompra, LocalDate.now());

        //Assert
        Assert.assertEquals("Valor do resultado após aplicação do cupom foi incorreto", 0.0, resultado, 0.0);
    }

    @Test
    public void testa_Cupom_Com_Valor_Compra_Negativo() {
        //Arrange
        Cupom cupomTeste = new Cupom("DESC10", 10.0, LocalDate.now().plusDays(7), 1);
        double valorCompra = -100.0;

        //Act
        double resultado = Carrinho.aplicarCupom(cupomTeste, valorCompra, LocalDate.now());

        //Assert
        Assert.assertEquals("Valor do resultado após aplicação do cupom foi incorreto", 0.0, resultado, 0.0);
    }

    @Test
    public void testa_Calculo_Desconto_Com_Valor_Decimal() {
        //Arrange
        Cupom cupomTeste = new Cupom("DESC10.5", 10.5, LocalDate.now().plusDays(7), 1);
        double valorCompra = 100.0;

        //Act
        double resultado = Carrinho.aplicarCupom(cupomTeste, valorCompra, LocalDate.now());

        //Assert
        Assert.assertEquals("Valor do resultado após aplicação do cupom foi incorreto", 89.5, resultado, 0.0);
    }

    @Test
    public void testa_Calculo_Desconto_Com_Valor_Zero() {
        //Arrange
        Cupom cupomTeste = new Cupom("DESC0", 0.0, LocalDate.now().plusDays(7), 1);
        double valorCompra = 100.0;

        //Act
        double resultado = Carrinho.aplicarCupom(cupomTeste, valorCompra, LocalDate.now());

        //Assert
        Assert.assertEquals("Valor do resultado após aplicação do cupom foi incorreto", 100.0, resultado, 0.0);
    }

    @Test
    public void testa_Cupom_Com_Uso_Limitado() {
        //Arrange
        Cupom cupomTeste = new Cupom("DESC10", 10.0, LocalDate.now().plusDays(7), 2);
        double valorCompra = 100.0;

        //Act
        double resultado = Carrinho.aplicarCupom(cupomTeste, valorCompra, LocalDate.now());
        double resultado2 = Carrinho.aplicarCupom(cupomTeste, valorCompra, LocalDate.now());
        double resultado3 = Carrinho.aplicarCupom(cupomTeste, valorCompra, LocalDate.now());

        //Assert
        Assert.assertEquals("Valor do resultado após aplicação do cupom foi incorreto", 90.0, resultado, 0.0);
        Assert.assertEquals("Valor do resultado após aplicação do cupom foi incorreto", 90.0, resultado2, 0.0);
        Assert.assertEquals("Valor do resultado após aplicação do cupom foi incorreto", 100.0, resultado3, 0.0);
    }
}
