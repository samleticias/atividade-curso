package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ProdutoUsado extends Produto{
    private LocalDate dataFabricacao;

    public ProdutoUsado(String nome, Double preco, LocalDate dataFabricacao) {
        super(nome, preco);
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }
    @Override
    public String taxa() {
        return getNome()
                + " (usado) $ "
                + String.format("%.2f", getPreco())
                + " (Data de fabricação: "
                + dataFabricacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + ")";
    }
}
