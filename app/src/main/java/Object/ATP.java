package Object;

public class ATP {
    private String[] p_tipo = {"Pizza Napolitana", "Pizza Predilecta", "Pizza Vegana", "Pizza Selecta"};
    private int[] p_precio = {12500, 13800, 15600, 18600};
    private String[] ingrediente = {"Tocino", "Extra queso", "Champiñón", "Salame", "Albahaca"};
    private int[] i_precio = {350, 500, 250, 300, 450};

    public ATP() {
    }

    public String[] getP_tipo() {
        return p_tipo;
    }

    public void setP_tipo(String[] p_tipo) {
        this.p_tipo = p_tipo;
    }

    public int[] getP_precio() {
        return p_precio;
    }

    public void setP_precio(int[] p_precio) {
        this.p_precio = p_precio;
    }

    public String[] getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String[] ingrediente) {
        this.ingrediente = ingrediente;
    }

    public int[] getI_precio() {
        return i_precio;
    }

    public void setI_precio(int[] i_precio) {
        this.i_precio = i_precio;
    }

    public int calcularPizza(int valor, int adicional){
        return valor + adicional;
    }
}
