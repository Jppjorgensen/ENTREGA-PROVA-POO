package br.com.starlog.model;
import java.util.Locale;
import java.util.Objects;
public class Carga {
    private final String codigoRastreio;
    private String categoria;
    private double pesoKg;
    private double valorSeguro;
    public Carga(String codigoRastreio, String categoria,
                 double pesoKg, double valorSeguro) {
        if (codigoRastreio == null
                || codigoRastreio.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Codigo de rastreio da carga nao pode ser nulo ou vazio."
            );
        }
        this.codigoRastreio = codigoRastreio;
        this.categoria = categoria;
        this.pesoKg = pesoKg;
        this.valorSeguro = valorSeguro;
    }
    public String getCodigoRastreio() {
        return codigoRastreio;
    }
    public String getCategoria() {
        return categoria;
    }
    public double getPesoKg() {
        return pesoKg;
    }
    public double getValorSeguro() {
        return valorSeguro;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }
    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Carga)) {
            return false;
        }
        Carga outra = (Carga) obj;
        return Objects.equals(codigoRastreio, outra.codigoRastreio);
    }
    @Override
    public int hashCode() {
        return Objects.hash(codigoRastreio);
    }
    @Override
    public String toString() {
        return String.format(
            Locale.US,
            "Carga[rastreio=%s, categoria=%s, peso=%.1fkg, seguro=R$ %.2f]",
            codigoRastreio,
            categoria,
            pesoKg,
            valorSeguro
        );
    }
}
