
package Menus;

import java.util.Scanner;

/**
 *
 * @author Anderson
 */
public class MenuPrincipal {
    public static void main(String[] args) {
        MenuForma1 Menu1 = new MenuForma1();
        MenuForma2 Menu2 = new MenuForma2();
        MenuForma3 Menu3 = new MenuForma3();
        boolean i = true;
        Scanner scan = new Scanner(System.in);
        while(i == true){
            System.out.println("-----------------------");
            System.out.println("|   Menú Principal    |");
            System.out.println("-----------------------");
            System.out.println("|1) Polinomios Forma 1|");
            System.out.println("|2) Polinomios Forma 2|");
            System.out.println("|3) Polinomios Forma 3|");
            System.out.println("|4) Salir             |");
            System.out.println("-----------------------");
            System.out.print("Por favor ingrese con que forma desea trabajar: ");
            int opcion = scan.nextInt();

            switch (opcion){
                case 1: System.out.println("Ha seleccionado Polinomios Forma 1");
                        Menu1.MenuForma1();
                        break;
                case 2: System.out.println("Ha seleccionado Polinomios Forma 2");
                        Menu2.MenuForma2();
                        break;
                case 3: System.out.println("Ha seleccionado Polinomios Forma 2");
                        Menu3.MenuForma3();
                        break;
                case 4: System.out.println("Ha seleccionado salir, vuelva pronto");
                        i = false;
                        break;
                default: System.out.println("Opcion incorrecta");
            }
        }
    }
        
}
