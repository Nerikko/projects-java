package pt.ulusofona.aed.deisiworldmeter;

class Cidade {
    String alfa2;
    String cidade;
    String regiao;
    float populacao;
    double latitude;
    double longitude;

    public Cidade() {
    }



    public Cidade(String alfa2, String cidade, String regiao, float populacao, double latitude, double longitude) {
        this.alfa2 = alfa2;
        this.cidade = cidade;
        this.regiao = regiao;
        this.populacao = populacao;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return cidade + " | " + alfa2.toUpperCase() + " | " + regiao + " | " + String.format("%.0f", populacao) + " | (" + latitude + "," + longitude + ")";
    }
}
