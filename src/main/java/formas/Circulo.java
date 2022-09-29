package formas;

public class Circulo implements FormaGeometrica {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double area() {
        return Math.PI * Math.pow(this.raio, 2);
    }
}
