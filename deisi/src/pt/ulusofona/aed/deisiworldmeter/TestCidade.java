package pt.ulusofona.aed.deisiworldmeter;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class TestCidade {

    @Test
    public void conversaoStringCidades(){
        String resultadoEsperado= "yangambi | CD | 09 | 35529 | (0.783333,24.466667)";
        Cidade cidadeTeste= new Cidade("cd","yangambi","09",35529,0.783333,24.466667);
        String resultadoActual= cidadeTeste.toString();
        Assertions.assertEquals(resultadoEsperado,resultadoActual);
    }
}
