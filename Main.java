import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> resultados = new ArrayList<>();

        System.out.println("Calculadora de área y perímetro de figuras geométricas");
        System.out.println("-------------------------------------------------------");

        while (true) {
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.println("0. Salir");
            System.out.print("Seleccione la figura (0-5): ");

            int figura;
            try {
                figura = scanner.nextInt();
                scanner.nextLine(); // Consume el salto de línea
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número válido.");
                scanner.nextLine(); // Consume la entrada incorrecta
                continue;
            }

            if (figura == 0) {
                break;
            } else if (figura < 0 || figura > 5) {
                System.out.println("Figura no válida.");
                continue;
            }

            String resultado = "";
            switch (figura) {
                case 1:
                    resultado = calcularCirculo(scanner);
                    break;
                case 2:
                    resultado = calcularCuadrado(scanner);
                    break;
                case 3:
                    resultado = calcularTriangulo(scanner);
                    break;
                case 4:
                    resultado = calcularRectangulo(scanner);
                    break;
                case 5:
                    resultado = calcularPentagono(scanner);
                    break;
                default:
                    break;
            }
            resultados.add(resultado);
        }

        System.out.println("Resultados:");
        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    }

    private static String calcularCirculo(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese el radio del círculo: ");
            double radio;
            try {
                radio = scanner.nextDouble();
                scanner.nextLine(); // Consume el salto de línea
                if (radio <= 0) {
                    System.out.println("El radio debe ser un número positivo.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida para el radio del círculo.");
                scanner.nextLine(); // Consume la entrada incorrecta
                continue;
            }
            
            double area = Math.PI * radio * radio;
            double perimetro = 2 * Math.PI * radio;

            return "Área del círculo: " + area + ", Perímetro del círculo: " + perimetro;
        }
    }

    private static String calcularCuadrado(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese el lado del cuadrado: ");
            double lado;
            try {
                lado = scanner.nextDouble();
                scanner.nextLine(); // Consume el salto de línea
                if (lado <= 0) {
                    System.out.println("El lado debe ser un número positivo.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida para el lado del cuadrado.");
                scanner.nextLine(); // Consume la entrada incorrecta
                continue;
            }
            
            double area = lado * lado;
            double perimetro = 4 * lado;

            return "Área del cuadrado: " + area + ", Perímetro del cuadrado: " + perimetro;
        }
    }

    private static String calcularTriangulo(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese la base del triángulo: ");
            double base;
            try {
                base = scanner.nextDouble();
                scanner.nextLine(); // Consume el salto de línea
                if (base <= 0) {
                    System.out.println("La base debe ser un número positivo.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida para la base del triángulo.");
                scanner.nextLine(); // Consume la entrada incorrecta
                continue;
            }
            
            System.out.print("Ingrese la altura del triángulo: ");
            double altura;
            try {
                altura = scanner.nextDouble();
                scanner.nextLine(); // Consume el salto de línea
                if (altura <= 0) {
                    System.out.println("La altura debe ser un número positivo.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida para la altura del triángulo.");
                scanner.nextLine(); // Consume la entrada incorrecta
                continue;
            }
            
            double area = (base * altura) / 2;

            return "Área del triángulo: " + area;
        }
    }

    private static String calcularRectangulo(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese la base del rectángulo: ");
            double base;
            try {
                base = scanner.nextDouble();
                scanner.nextLine(); // Consume el salto de línea
                if (base <= 0) {
                    System.out.println("La base debe ser un número positivo.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida para la base del rectángulo.");
                scanner.nextLine(); // Consume la entrada incorrecta
                continue;
            }
            
            System.out.print("Ingrese la altura del rectángulo: ");
            double altura;
            try {
                altura = scanner.nextDouble();
                scanner.nextLine(); // Consume el salto de línea
                if (altura <= 0) {
                    System.out.println("La altura debe ser un número positivo.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida para la altura del rectángulo.");
                scanner.nextLine(); // Consume la entrada incorrecta
                continue;
            }
            
            double area = base * altura;
            double perimetro = 2 * (base + altura);

            return "Área del rectángulo: " + area + ", Perímetro del rectángulo: " + perimetro;
        }
    }

    private static String calcularPentagono(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese la longitud del lado del pentágono: ");
            double lado;
            try {
                lado = scanner.nextDouble();
                scanner.nextLine(); // Consume el salto de línea
                if (lado <= 0) {
                    System.out.println("La longitud del lado debe ser un número positivo.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida para la longitud del lado del pentágono.");
                scanner.nextLine(); // Consume la entrada incorrecta
                continue;
            }
            
            // Se asumirá que el pentágono es regular, de modo que todos sus lados son iguales.
            double apotema = lado / (2 * Math.tan(Math.toRadians(36))); // Apotema para un pentágono regular
            double area = (5 * lado * apotema)/2;

            return "Área del pentágono: " + area;
        }
    }
}
