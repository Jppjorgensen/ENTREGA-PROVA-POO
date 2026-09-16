package br.com.starlog.model;
import java.util.HashMap;
import java.util.Map;
public class BaseLancamento {
    private Map<String, ModuloCarga> modulos;
    public BaseLancamento() {
        this.modulos = new HashMap<>();
    }
    
    public void cadastrarModulo(ModuloCarga modulo) {
        modulos.put(modulo.getCodigoModulo(), modulo);
    }
    
    public ModuloCarga buscarModulo(String codigoModulo) {
        return modulos.get(codigoModulo);
    }
    
    public Map<String, ModuloCarga> getModulos() {
        return new HashMap<>(modulos);
    }
}