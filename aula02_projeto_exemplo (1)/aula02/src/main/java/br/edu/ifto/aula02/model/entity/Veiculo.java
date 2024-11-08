package br.edu.ifto.aula02.model.entity;

public class Veiculo {

    private Long id;
    private String marca;
    private String modelo;
    private double preco;
    private int anoFabricacao;

    public Long getId() { // Método para obter o ID
        return id;
    }

    public void setId(Long id) { // Método para definir o ID
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
}
