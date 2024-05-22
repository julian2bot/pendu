import java.util.InputMismatchException;
import java.util.Scanner;

public class ExecutablePendu {
    public static void main(String[] args) {
        MotMystere miMystere = new MotMystere("salut", 2, 2);
        
        System.out.println("pendu \n -> Entrer autre chose pour quitter");
        Scanner sc = new Scanner(System.in);
        boolean quitte = false;
        char lettre;
        int nbErreur = miMystere.getNbErreursRestants();
        while (!quitte || nbErreur != 0){
            try{
                lettre = sc.next().charAt(0);
                miMystere.essaiLettre(lettre);

                // temperature.setvaleurCelcius(tempC);
                // System.out.println( "win ! "+miMystere.gagne());
                // System.out.println( "fail ! "+miMystere.perdu());
                // System.out.println(" err : "+nbErreur+ " err rest : "+ miMystere.getNbErreursRestants() +" err max :"+miMystere.getNbErreursMax());
                System.out.println(miMystere.getMotCrypte());
                if(miMystere.perdu()){System.out.println("vous avez perdu");}
                if(miMystere.gagne()){System.out.println("vous avez gagnez");}
            }
            catch(InputMismatchException e){
                quitte = true;
            }
        }

    }
}
