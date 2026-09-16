package br.com.starlog.model;
import br.com.starlog.exception.CapacidadeExcedidaException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class ModuloCarga {
    private String codigoModulo;
    private int capacidadeMaxima;
    private List<Carga> cargas;
    public ModuloCarga(String codigoModulo, int capacidadeMaxima) {
        this.codigoModulo = codigoModulo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.cargas = new ArrayList<>();
    }
    public String getCodigoModulo() {
        return codigoModulo;
    }
    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
    
    public List<Carga> getCargas() {
        return new ArrayList<>(cargas);
    }
    
    public void carregarCarga(Carga carga)
            throws CapacidadeExcedidaException {
        if (cargas.size() >= capacidadeMaxima) {
            throw new CapacidadeExcedidaException(
                "Modulo '" + codigoModulo
                + "' atingiu a capacidade maxima de "
                + capacidadeMaxima + " cargas."
            );
        }
        cargas.add(carga);
    }
    
    public double calcularSeguroTotal() {
        return cargas.stream()
                .mapToDouble(Carga::getValorSeguro)
                .sum();
    }
    
    public long contarCargasPorCategoria(String categoria) {
        return cargas.stream()
                .filter(carga ->
                    Objects.equals(categoria, carga.getCategoria())
                )
                .count();
    }
    
    public double calcularSeguroCargasPesadas(
            String categoria, double pesoMinimo) {
        return cargas.stream()
                .filter(carga ->
                    Objects.equals(categoria, carga.getCategoria())
                )
                .filter(carga -> carga.getPesoKg() > pesoMinimo)
                .mapToDouble(Carga::getValorSeguro)
                .sum();
    }
}
