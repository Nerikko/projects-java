package pt.ulusofona.aed.deisiworldmeter;

import java.util.ArrayList;

class Pais {
    int id;
    String alfa2;
    String alfa3;
    String nome;
    ArrayList <Populacao> estatistica=new ArrayList<>();



    public Pais() {
    }


    public Pais(int id, String alfa2, String alfa3, String nome) {
        this.id = id;
        this.alfa2 = alfa2;
        this.alfa3 = alfa3;
        this.nome = nome;

    }

    public Pais(int id, String alfa2, String alfa3, String nome, ArrayList<Populacao> estatistica) {
        this.id = id;
        this.alfa2 = alfa2;
        this.alfa3 = alfa3;
        this.nome = nome;
        this.estatistica = estatistica;
    }

    public int getId() {
        return id;
    }



    public String getAlfa2() {
        return alfa2;
    }

    @Override
    public String toString() {
        if (id>700 && estatistica!=null && estatistica.size()>0 ){
            return nome + " | " + id + " | " + alfa2.toUpperCase() + " | " + alfa3.toUpperCase()+ " | " + estatistica.size();

        }else{
            return nome + " | " + id + " | " + alfa2.toUpperCase() + " | " + alfa3.toUpperCase();
        }


    }
}
