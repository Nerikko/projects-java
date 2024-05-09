package pt.ulusofona.aed.deisiworldmeter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class TestPaises {

    @Test
    public void conversaoStringPaises(){
        String resultadoEsperado="Afeganistão | 4 | AF | AFG";
        Pais paisTeste= new Pais(4,"af","afg","Afeganistão");
        String resultadoActual= paisTeste.toString();

        Assertions.assertEquals(resultadoEsperado,resultadoActual);

    }
    @Test
    public void conversaoStringPaises2(){
        Main.parseFiles(new File("test-files/testFiles"));
        String resultadoEsperado="África do Sul | 710 | ZA | ZAF | 151";
        System.out.println(Main.getObjects(TipoEntidade.INPUT_INVALIDO));
        Pais paisnovo = Main.obtemPaisAssociadoAId(710);
        System.out.println(Main.pais.get(0));
        System.out.println(paisnovo);
        //String resultadoActual= paisnovo.toString();
        //Assertions.assertEquals(resultadoEsperado,resultadoActual);

    }
}
