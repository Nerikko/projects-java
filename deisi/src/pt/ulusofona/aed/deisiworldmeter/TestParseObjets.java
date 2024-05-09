package pt.ulusofona.aed.deisiworldmeter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class TestParseObjets {

    @Test
    public void leitura2Paises2Cidades(){


        String resultadoEsperado="Afeganistão | 4 | AF | AFG\n" +
                "África do Sul | 710 | ZA | ZAF | 151\n" +
                "acin | AF | 18 | 15098 | (34.082481,70.668152)\n" +
                "cah ab | AF | 26 | 23424 | (37.397734,69.814644)\n" +
                "stilfontein | ZA | 10 | 93138 | (-26.844926,26.768294)\n" +
                "stutterheim | ZA | 05 | 35524 | (-32.57076,27.423961)";

        if (Main.parseFiles(new File ("test-files/testFiles"))){
            Main.getObjects(TipoEntidade.PAIS);
            Main.getObjects(TipoEntidade.CIDADE);
            String resultadoActual= Main.pais.get(0).toString() +"\n"+ Main.pais.get(1).toString() +"\n"+ Main.cidade.get(0).toString()+"\n"+
                    Main.cidade.get(1).toString()+"\n"+Main.cidade.get(2).toString()+"\n"+Main.cidade.get(3).toString();
            Assertions.assertEquals(resultadoEsperado,resultadoActual);
        }
    }
}
