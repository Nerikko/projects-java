package pt.ulusofona.aed.deisiworldmeter;

class Populacao {
    int id;
    int ano;
    long populacaoMasculina;
    long populacaoFeminina;
    float densidade;

    public Populacao() {
    }

    public int getId() {
        return id;
    }

    public Populacao(int id, int ano, long populacaoMasculina, long populacaoFeminina, float densidade) {
        this.id = id;
        this.ano = ano;
        this.populacaoMasculina = populacaoMasculina;
        this.populacaoFeminina = populacaoFeminina;
        this.densidade = densidade;
    }

    @Override
    public String toString() {
        return id + " | " + ano + " | " + populacaoMasculina + " | " + populacaoFeminina + " | " + densidade;
    }
}
