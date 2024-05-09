package pt.ulusofona.aed.deisiworldmeter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ulusofona.aed.deisiworldmeter.Main;

import java.io.File;
import java.util.ArrayList;

public class TestInputInvalido {

    @Test
    public void leituraInputInvalido(){
        String resultadoEsperado="paises.csv | 4 | 1 | 6 cidades.csv | 4 | 1 | 6 populacao.csv | 10 | 3 | 4";

        if (Main.parseFiles(new File("test-files/testFilesInputInvalido"))){
            ArrayList resultadoActualArray= Main.getObjects(TipoEntidade.INPUT_INVALIDO);
            String resultadoActual= resultadoActualArray.get(0).toString()  + " "+
            resultadoActualArray.get(1).toString() + " "+
            resultadoActualArray.get(2).toString();

            Assertions.assertEquals(resultadoEsperado,resultadoActual);
        }
    }
}
