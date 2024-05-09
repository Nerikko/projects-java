package pt.ulusofona.aed.deisiworldmeter;

import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static ArrayList<Cidade> cidade = new ArrayList<>();
    static ArrayList<Pais> pais = new ArrayList<>();
    static ArrayList <Populacao> populacao = new ArrayList();

    static int[] indiceCidade= new int[]{0,0,-1};
    static int[] indicePais= new int[]{0,0,-1};
    static int[] indicePopulacao= new int[]{0,0,-1};


    public static Pais obtemPaisAssociadoAId(int id){
        for (int indice=0;indice<pais.size();indice++){
            if ( id == pais.get(indice).id){
                return pais.get(indice);
            }
        }
        return null;
    }
    public static Boolean leitorFicheiros (Scanner leitor, int[] indice,int tipo){
        Boolean teste = true;
        while (leitor.hasNext()){
            String linha = leitor.nextLine();
            if (teste){
                teste = false;   //ignorar cabeçalho
            }
            else {
                String[] linhaAtual= linha.split(",");
                switch (tipo){
                    case 1->{   //PAISES                  //verificação de campos vazio ou inexistentes
                        if (linhaAtual.length==4 && linhaAtual[0].length() >0
                                && linhaAtual[1].length() ==2 && linhaAtual[1].charAt(0)>='A'
                                && linhaAtual[1].charAt(1)>='A' && linhaAtual[2].length() ==3
                                && linhaAtual[2].charAt(0)>='A' && linhaAtual[2].charAt(1)>='A'
                                && linhaAtual[2].charAt(2)>='A' && linhaAtual[3].length()>0) {

                            Pais novoPais = new Pais(Integer.parseInt(linhaAtual[0]), linhaAtual[1],   //criação de novo país
                                    linhaAtual[2], linhaAtual[3]);
                            int existeDuplicado=0;
                            for (int i=0;i<pais.size();i++){          //verificaçao paises duplicados
                                if (novoPais.id == pais.get(i).getId()){
                                    existeDuplicado=1;
                                }
                            }
                            if (existeDuplicado==0){             //adiciona pais ao array se não existir repetido
                            pais.add(novoPais);
                            indice[0]++;                        //adciona como linha valida
                            }else{
                                indice[1]++;
                                if(indice[1]==1){
                                    indice[2]= indice[0]+2;         //estabelece a primeira linha invalida
                                }
                            }
                        }
                        else {
                            indice[1]++;                        //adiciona como linha invalida
                            if(indice[1]==1){
                                indice[2]= indice[0]+2;         //estabelece a primeira linha invalida
                            }
                        }
                    }
                    case 2->{  //CIDADES
                        //verificação de campos vazio ou inexistentes
                        if (linhaAtual.length==6 && linhaAtual[0].length()==2 && linhaAtual[2].length() >0
                                && linhaAtual[3].length() >0 && linhaAtual[4].length() >0 && linhaAtual[5].length()>0) {
                            //criação de nova cidade
                            Cidade novaCidade = new Cidade(linhaAtual[0], linhaAtual[1],
                                    linhaAtual[2], Float.parseFloat(linhaAtual[3]),
                                    Double.parseDouble(linhaAtual[4]), Double.parseDouble(linhaAtual[5]));
                            //verifica se existe o pais referente à cidade que queremos adicionar
                            int verificadorSeExistePais=0;
                            for (int i=0;i<pais.size();i++){
                                if (novaCidade.alfa2.equals(pais.get(i).getAlfa2())){
                                    verificadorSeExistePais=1;
                                }
                            }
                            if (verificadorSeExistePais==1){                //adiciona cidade
                                cidade.add(novaCidade);
                                indice[0]++;                                //adiciona linha válida
                            }else{
                                indice[1]++;
                                if(indice[1]==1){
                                    indice[2]= indice[0]+2;                     //adiciona primeira linha inválida
                                }
                            }
                        }
                        else {
                            indice[1]++;                                    //adiciona linha inválida
                            if(indice[1]==1){
                                indice[2]= indice[0]+2;                     //adiciona primeira linha inválida
                            }
                        }
                    }
                    case 3->{   //POPULACAO
                        //verificação de campos vazio ou inexistentes

                        if (linhaAtual.length==5 && linhaAtual[0].length() >0 && linhaAtual[1].length()==4
                                && Integer.parseInt(linhaAtual[1])>1949 && linhaAtual[2].length() >0
                                && linhaAtual[3].length() >0 && linhaAtual[4].length()>0 ) {
                            // criação de nova população
                            Populacao novaPopulacao = new Populacao(Integer.parseInt(linhaAtual[0]),
                                    Integer.parseInt(linhaAtual[1]),Integer.parseInt(linhaAtual[2]),
                                    Integer.parseInt(linhaAtual[3]),Float.parseFloat(linhaAtual[4]));
                            // verifica se existe o pais referente á nova populacao
                            int verificadorSeExistePais=0;
                            Pais novoPais=null;
                            for (int i=0;i<pais.size();i++){
                                if (novaPopulacao.id==pais.get(i).id){
                                    verificadorSeExistePais=1;
                                    novoPais=obtemPaisAssociadoAId(novaPopulacao.id);     //vai buscar o pais com o id da novaPopulacao
                                }
                            }
                            if (verificadorSeExistePais==1){
                                populacao.add(novaPopulacao);               //adiciona nova populacao
                                indice[0]++;
                                novoPais.estatistica.add(novaPopulacao);    // adiciona nova populacao no pais respectivo em estatistica

                                                                   //adiciona linha válida
                            }else{
                                indice[1]++;                          //adiciona linha inválida
                                if(indice[1]==1){
                                    indice[2]= indice[0]+2;
                                }
                            }
                        }
                        else {
                            indice[1]++;                          //adiciona linha inválida
                            if(indice[1]==1){
                                indice[2]= indice[0]+2;
                            }
                        }
                    }
                }

            }
        }
        return false;
    }
    public static ArrayList getObjects(TipoEntidade tipo){

        switch (tipo){
            case PAIS ->{
                return pais;
            }
            case CIDADE ->{
                return cidade;
            }
            case INPUT_INVALIDO ->{
                ArrayList invalido= new ArrayList();
                invalido.add("paises.csv | " + indicePais[0] + " | " + indicePais[1] + " | " + indicePais[2]);
                invalido.add("cidades.csv | " + indiceCidade[0] + " | " + indiceCidade[1] + " | " + indiceCidade[2]);
                invalido.add("populacao.csv | " + indicePopulacao[0] + " | " + indicePopulacao[1] + " | " + indicePopulacao[2]);
                return invalido;
            }
        }
        return null;
    }
    public static Boolean parseFiles (File file) {
        pais.clear();                                   // fazer reset às variáveis globais
        cidade.clear();
        populacao.clear();
        indiceCidade=new int[]{0,0,-1};
        indicePais=new int[]{0,0,-1};
        indicePopulacao=new int[]{0,0,-1};

        File ficheiroPais = new File(file + "/paises.csv");
        Scanner leitorPais=null;
        try {
            leitorPais = new Scanner(ficheiroPais);

        }catch(FileNotFoundException e){
            return false;
        }
        File ficheiroCidade = new File(file +"/cidades.csv");
        Scanner leitorCidades=null;
        try {
            leitorCidades = new Scanner(ficheiroCidade);

        }catch(FileNotFoundException e){
            return false;
        }
        File ficheiroPopulacao = new File(file +"/populacao.csv");
        Scanner leitorPopulacao=null;
        try {
            leitorPopulacao = new Scanner(ficheiroPopulacao);
        }catch(FileNotFoundException e){
            return false;
        }

        leitorFicheiros(leitorPais, indicePais, 1);
        leitorFicheiros(leitorCidades, indiceCidade, 2);
        leitorFicheiros(leitorPopulacao,indicePopulacao,3);
        return true;
    }

    public static void main(String[] args){
        parseFiles(new File("test-files/oi"));
        System.out.println(getObjects(TipoEntidade.INPUT_INVALIDO));
    }
}



