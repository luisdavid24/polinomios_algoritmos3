
package Menus;

import java.util.Scanner;
import polinomios.Polvf2;

public class MenuForma2 {
    public void MenuForma2(){
        Scanner scan = new Scanner(System.in);
        
        Polvf2 A,B,C,D;
        A=new Polvf2();
        B=new Polvf2();
        C=new Polvf2();
        D=new Polvf2();
        
        boolean i = true;
        
        while(i == true){
            System.out.println("");
            System.out.println("|------------------------------|");
            System.out.println("|   Menú Polinomios Forma 2    |");
            System.out.println("|------------------------------|");
            System.out.println("|1) Ingresar Polinomio         |");
            System.out.println("|2) Mostrar Polinomio en vector|");
            System.out.println("|3) Evaluar Polinomio          |");
            System.out.println("|4) Reconstruir Polinomio      |");
            System.out.println("|5) Sumar Polinomios           |");
            System.out.println("|6) Multiplicar Polinomios     |");
            System.out.println("|7) Dividir Polinomios         |");
            System.out.println("|8) Volver a Menú Principal    |");
            System.out.println("|------------------------------|");
            System.out.print("Por favor ingrese una acción");
            int opcion = scan.nextInt();
       
            switch (opcion){
            case 1: System.out.println("\tHa seleccionado Ingresar Polinomio:");
                    A.ingresarPol();
                    System.out.println("El polinomio se ha ingresado");
                    break;
            case 2: System.out.println("\tHa seleccionado mostrar Polinomio en vector: ");
                    A.mostrarVec();
                    break;
            case 3: System.out.println("\tHa seleccionado evaluar el polinomio: ");
                    System.out.print("Ingrese un valor para x: ");
                    int x = scan.nextInt();
                    A.evaluar(x);
                    break;
            case 4: System.out.println("\tHa seleccionado mostrar Polinomio: ");
                    A.mostrar();
                    break;
            case 5: System.out.println("\tHa seleccionado sumar dos Polinomios: "); 
                    D.ingresarPol();
                    B.ingresarPol();
                    C.sumar(D, B);
                    System.out.print("Marque (1) si desea ver los polinomios ingresados:");
                    int op = scan.nextInt();
                        if(op == 1)
                        {
                            System.out.println("Mostrando Polinomio 1");
                            D.mostrarVec();
                            System.out.println("");
                            System.out.println("Mostrando Polinomio 2");
                            B.mostrarVec();
                        }
                        else
                        {
                            System.out.println("No desea");
                        }
                        System.out.println("");
                        System.out.println("Mostrando resultado:");
                        C.mostrarVec();
                        System.out.println("");
                        C.mostrar();
                    break;
            case 6: System.out.println("\tHa seleccionado multiplicar 2 polinomios: ");
                    D.ingresarPol();
                    B.ingresarPol();
                    C.multiplicar(D, B);
                    System.out.print("Marque (1) si desea ver los polinomios ingresados: ");
                    op = scan.nextInt();
                        if(op == 1)
                        {
                            System.out.println("Mostrando Polinomio 1");
                            D.mostrarVec();
                            System.out.println("");
                            System.out.println("Mostrando Polinomio 2");
                            B.mostrarVec();
                        }
                        else
                        {
                            System.out.println("No desea");
                        }
                        System.out.println("");
                        System.out.println("Mostrando resultado:");
                        C.mostrarVec();
                        System.out.println("");
                        C.mostrar();
                    break;
            case 7: System.out.println("Ha seleccionado dividir 2 polinomios: ");
                    D.ingresarPol();
                    B.ingresarPol();
                    C.dividir(D, B);
                    System.out.print("Marque (1) si desea ver los polinomios ingresados: ");
                    op = scan.nextInt();
                        if(op == 1)
                        {
                            System.out.println("Mostrando Polinomio 1");
                            D.mostrarVec();
                            System.out.println("");
                            System.out.println("Mostrando Polinomio 2");
                            B.mostrarVec();
                        }
                        else
                        {
                            System.out.println("No desea ver los polinomios.");
                        }
                        System.out.println("");
                        System.out.println("Mostrando resultado:");
                        C.mostrarVec();
                        System.out.println("");
                        C.mostrar();
                    break;
            case 8: System.out.println("Ha seleccionado volver al menú principal.");
                    String[] args = {};
                    MenuPrincipal.main(args);
                    i = false;
                    break;
                default:System.out.println("Opcion incorecta");
            }
        }
    }
}
