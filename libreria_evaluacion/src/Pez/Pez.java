package Pez;

public class Pez {
    String tipo_pez;
    int por_nacimiento;

    public Pez(String tipo_pez, int por_nacimiento) {
        this.tipo_pez = tipo_pez;
        this.por_nacimiento = por_nacimiento;
    }

    public double peces_al_anio() {
        double pnacidos = this.por_nacimiento;
        double dead = 0;
        double alive = 0;
        dead = pnacidos * 0.1;
        alive = pnacidos - dead;
        pnacidos=alive;
        return pnacidos;
    }

    public String getTipo_pez() {
        return tipo_pez;
    }

    public void setTipo_pez(String tipo_pez) {
        this.tipo_pez = tipo_pez;
    }

    public int getPor_nacimiento() {
        return por_nacimiento;
    }

    public void setPor_nacimiento(int por_nacimiento) {
        this.por_nacimiento = por_nacimiento;
    }

}

