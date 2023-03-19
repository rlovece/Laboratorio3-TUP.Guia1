import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        int ejercicio = menu();

        switch (ejercicio){
            case 1:
                ejercicio1();
                break;
            case 2:
                ejercicio2();
                break;
            case 3:
                ejercicio3();
                break;
            case 4:
                ejercicio4();
                break;
            case 5:
                ejercicio5();
                break;
            case 6:
                ejercicio6();
                break;
            case 7:
                ejercicio7();
                break;
            case 8:
                ejercicio8();
                break;
            case 9:
                ejercicio9();
                break;
            case 10:
                ejercicio10();
                break;
            default:
                System.out.println("Opcion incorrecta!");
                break;

        }
    }
    public static int menu(){
        int nro;
        Scanner scan = new Scanner(System.in);  // Le indicamos que va a recibir datos por consola;
        bienvenida();

        System.out.println("Estas 👇 son las opciones!");
        System.out.println("1)    Calcular promedio de un array de enteros");
        System.out.println("2)    Saber si un nro es par");
        System.out.println("3)    Ver los primeros n nros primos");
        System.out.println("4)    Saber si un año es bisiesto");
        System.out.println("5)    Pasar caracter a ASCII");
        System.out.println("6)    Calular áreas");
        System.out.println("7)    Verificar temperaturas del mes");
        System.out.println("8)    Obtenga 10 nros random entre dos enteros");
        System.out.println("9)    Cant de cifras de un nro");
        System.out.println("10)   Calculadora");
        System.out.println("Ingrese el número del ejercicio que desea ejecutar: ");

        nro = scan.nextInt();

        return nro;
    }

    /// Bienvenida
    public static void bienvenida (){
        Scanner scan = new Scanner(System.in);  // Le indicamos que va a recibir datos por consola;
        System.out.print("Hola, cuál es tu nombre? : ");
        String nombre = scan.next();
        System.out.println("Bienvenido/a " + nombre);
    }

    /// 1) Promedio de nros en un array
    public static void ejercicio1(){
        int arrayNros[] = new int[10];

        Scanner scan = new Scanner(System.in);  // Le indicamos que va a recibir datos por consola;

        for (int i=0; i<10; i++){
            System.out.print("Ingrese el nro " + i + " para el array: ");
            arrayNros[i] = scan.nextInt();
        }
        scan.close();
        System.out.println(Arrays.toString(arrayNros));

        float suma = 0;

        for (int i=0; i<10; i++){
            suma += arrayNros[i];
        }

        float promedio = suma/ arrayNros.length;

        System.out.println("El Promedio es: " + promedio);
    }

    /// 2) Ingrese un nro para saber si es par
    public static void ejercicio2(){
        int nro;
        Scanner scan = new Scanner(System.in);  // Le indicamos que va a recibir datos por consola;
        System.out.print("Ingrese un nro: ");

        nro = scan.nextInt();

        scan.close();

        if (nro % 2 == 0) {
            System.out.println("El nro es par!");
        } else {
            System.out.println("El NO nro es par!");
        }
    }

    /// Ver los primeros n nros primos (n>2)
    public static void ejercicio3(){
        int nro;
        Scanner scan = new Scanner(System.in);  // Le indicamos que va a recibir datos por consola;
        System.out.print("Ingrese el nro (mayor que 2) de primos que desea ver: ");
        nro = scan.nextInt();

        scan.close();
        int arrayPrimos[] = new int[nro];
        arrayPrimos[0]=2;
        arrayPrimos[1]=3;
        int natural = 4;
        for (int i=2; i<nro; i++) {
            int encontrado =0; /// no encontrado
            int evalucion =0; /// 0 si es primo
            while (encontrado==0){
                int j=i-1;
                evalucion =0;
                while (j>=0 && evalucion==0){
                    if (natural % arrayPrimos[j]==0){
                        evalucion = 1; // no es primo
                    } else {
                        j--;
                    }
                }
                if (evalucion==0){
                    arrayPrimos[i] = natural;
                    encontrado=1;
                }
                natural++;
            }
        }
        System.out.println(Arrays.toString(arrayPrimos));
    }

    /// 4) ingrese un año para saber si es bisiesto
    public  static void ejercicio4(){
        int anio;
        Scanner scan = new Scanner(System.in);  // Le indicamos que va a recibir datos por consola;
        System.out.print("Ingrese un año: ");
        anio = scan.nextInt();
        scan.close();

        if (anio % 4==0 && (anio %100 !=0 || anio %400 ==0)){
            System.out.print("El año es bisiesto");
        } else {
            System.out.print("El año NO es bisiesto ");
        }
    }

    /// 5) Ingrese un nro para saber su valor con codigo ASCII
    public static void ejercicio5(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un caracter: ");
        char caracter = scanner.next().charAt(0); // Se pone 0 porque solo se va a leer un caracter

        System.out.println("El valor en ASCII del caracter es: " + (int)caracter);
    }

    /// 6) Calcular área Rectangulo, cuadrado, triangulo y círculo
    public static void ejercicio6(){
        int opcion = subMenuAreas();
        float base, altura, radio, area=0; /// Si no inicializo area me tira error.
        Scanner scan = new Scanner(System.in);
        switch (opcion){
            case 1:
                System.out.print("Base del rectangulo?: ");
                base = scan.nextInt();
                System.out.print("Altura del rectangulo?: ");
                altura = scan.nextInt();
                area = areaRectangulo(base, altura);
                break;
            case 2:
                System.out.print("Lado del cuadrado?: ");
                base = scan.nextInt();
                area = areaRectangulo(base, base);
                break;
            case 3:
                System.out.print("Base del triángulo?: ");
                base = scan.nextInt();
                System.out.print("Altura del triángulo?: ");
                altura = scan.nextInt();
                area = areaTriangulo(base, altura);
                break;
            case 4:
                System.out.print("Radio del circulo?: ");
                radio = scan.nextInt();
                area = areaCirculo(radio);
                break;
        }
        System.out.println("Area = " + area);

    }

    public static int subMenuAreas(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Qué area desea calcular? (Ingrese nro del 1 al 4)");
        System.out.println("1) Rectangulo");
        System.out.println("2) Cuadrado");
        System.out.println("3) Triángulo");
        System.out.println("4) Circulo");
        return scan.nextInt();
    }
    public static float areaRectangulo(float base, float altura) {
        return base*altura;
    }

    public static float areaTriangulo(float base, float altura) {
        return base*altura/2;
    }

    public static float areaCirculo(float radio) {
        return (float) Math.PI * (float) Math.pow(radio,2);
    }

    /// Ingrese la temperatura de cada día de los 30 días
    public static void ejercicio7 (){
        int temperaturas[] = new int[30];
        Scanner scan = new Scanner(System.in);  // Le indicamos que va a recibir datos por consola;

        for (int i=0; i<30; i++){
            System.out.print("Ingrese el día " + (i+1) + " : ");
            temperaturas[i] = scan.nextInt();
        }
        scan.close();
        Arrays.sort(temperaturas);
        float promedioTemp = promedioArray(temperaturas, 30);
        System.out.println("La menor temperatura fue: " + temperaturas[0] + "°, la mayor "
                + temperaturas[29] + " y el promedio" + promedioTemp + "°");
    }

    static public float promedioArray (int array[], int dim){
        float suma=0;
        for (int i=0; i<dim; i++){
            suma += (float) array[i];
        }
        return suma/ (float) dim;
    }

    /// Random entre dos nros.
    static public void ejercicio8 (){
        double arrayRandom[] = new double[10];
        Scanner scan = new Scanner(System.in);  // Le indicamos que va a recibir datos por consola;
        System.out.print("Ingresa un nro entero: " );
        int nro1 = scan.nextInt();
        System.out.print("Ingresa otro entero mayor: ");
        int nro2 = scan.nextInt();
        scan.close();
        for (int i=0; i<10; i++){
            arrayRandom[i] = randomEntreDosEnteros(nro1,nro2);
        }
        System.out.println("10 nros entre los enteros ingresados: " + Arrays.toString(arrayRandom));

    }

    static public double randomEntreDosEnteros (int incio, int fin){
        return 1+(Math.random()* (double) (fin-incio+1));
    }

    /// Cant de cifras
    static public void ejercicio9(){
        Scanner scan = new Scanner(System.in);  // Le indicamos que va a recibir datos por consola;
        int cifras = 0;
        do {
            System.out.print("Ingresa un nro entero: " );
            int nro1 = scan.nextInt();
            cifras = cantCifrasEntero(nro1);
            if (cifras==0){
                System.out.println("Debe ingresar un nro natural");
            }
        } while (cifras==0);
        scan.close();
        System.out.println("Su nro tiene " + cifras + " cifras");

    }

    static public int cantCifrasEntero (int nro){
        int cifras=0;
        while (nro>0){
            nro = nro / 10;
            cifras++;
        }
        return cifras;
    }

    static public void ejercicio10 (){
        Scanner scan = new Scanner(System.in);  // Le indicamos que va a recibir datos por consola;
        System.out.print("Ingresa un nro entero: " );
        int nro1 = scan.nextInt();
        System.out.print("Ingresa la operación: + suma, - resta, / división, * multiplicación, % modulo, ^ potencia " );
        String operacion = scan.next();
        System.out.print("Ingresa otro nro entero: " );
        int nro2 = scan.nextInt();
        scan.close();
        double resultado = calculadora(nro1, nro2, operacion);
        System.out.println("Rta: " + nro1 + " " + operacion + " " + nro2 + " = " + resultado);
    }

    static public double calculadora (int nro1, int nro2, String operacion){

        switch (operacion){
            case "+":
                return nro1+nro2;
            case "-":
                return nro1-nro2;
            case "*":
                return nro1*nro2;
            case "/":
                return nro1/nro2;
            case "^":
                return Math.pow(nro1,nro2);
            case "%":
                return nro1%nro2;
            default:
                System.out.println("Operacion incorrecta");
                return -99999;
        }
    }
}

