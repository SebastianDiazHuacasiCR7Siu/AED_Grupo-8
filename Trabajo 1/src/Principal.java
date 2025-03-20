// Clase Coordenada
class Coordenada {
    private double x, y;

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}

// Clase Rectangulo
class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;

    public Rectangulo(Coordenada c1, Coordenada c2) {
        this.esquina1 = c1;
        this.esquina2 = c2;
    }

    public Coordenada getEsquina1() { return esquina1; }
    public Coordenada getEsquina2() { return esquina2; }

    public double calcularArea() {
        double base = Math.abs(esquina1.getX() - esquina2.getX());
        double altura = Math.abs(esquina1.getY() - esquina2.getY());
        return base * altura;
    }

    public String toString() {
        return "Rectangulo([" + esquina1 + ", " + esquina2 + "])";
    }
}

// Clase Verificador
class Verificador {
    public static boolean seSobreponen(Rectangulo A, Rectangulo B) {
        return !(A.getEsquina2().getX() <= B.getEsquina1().getX() || 
                 A.getEsquina1().getX() >= B.getEsquina2().getX() || 
                 A.getEsquina2().getY() <= B.getEsquina1().getY() || 
                 A.getEsquina1().getY() >= B.getEsquina2().getY());
    }

    public static boolean seJuntan(Rectangulo A, Rectangulo B) {
        return (A.getEsquina2().getX() == B.getEsquina1().getX() ||
                A.getEsquina1().getX() == B.getEsquina2().getX() ||
                A.getEsquina2().getY() == B.getEsquina1().getY() ||
                A.getEsquina1().getY() == B.getEsquina2().getY());
    }
}

// Clase Principal
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese la coordenada x1, y1 del 1er rectángulo:");
        Coordenada c1 = new Coordenada(scanner.nextDouble(), scanner.nextDouble());
        System.out.println("Ingrese la coordenada x2, y2 del 1er rectángulo:");
        Coordenada c2 = new Coordenada(scanner.nextDouble(), scanner.nextDouble());
        Rectangulo A = new Rectangulo(c1, c2);
        
        System.out.println("Ingrese la coordenada x1, y1 del 2do rectángulo:");
        Coordenada c3 = new Coordenada(scanner.nextDouble(), scanner.nextDouble());
        System.out.println("Ingrese la coordenada x2, y2 del 2do rectángulo:");
        Coordenada c4 = new Coordenada(scanner.nextDouble(), scanner.nextDouble());
        Rectangulo B = new Rectangulo(c3, c4);

        System.out.println("Rectángulo A: " + A);
        System.out.println("Rectángulo B: " + B);

        if (Verificador.seSobreponen(A, B)) {
            System.out.println("Los rectángulos se sobreponen.");
        } else if (Verificador.seJuntan(A, B)) {
            System.out.println("Los rectángulos se juntan.");
        } else {
            System.out.println("Los rectángulos son disjuntos.");
        }

        scanner.close();
    }
}


