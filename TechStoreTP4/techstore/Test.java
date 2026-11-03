package techstore;
import java.util.ArrayList;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> noms = new ArrayList<>();
        noms.add("Apple iPad 8e Génération");
        noms.add("Micro Casque 588 Filaire");
        ArrayList<Double> prixs = new ArrayList<>();
        prixs.add(1269.0);
        prixs.add(150.0);
        ArrayList<Long> quantites = new ArrayList<>();
        quantites.add(8L);
        quantites.add(5L);
        Stock stock = new Stock(noms, prixs, quantites);
        int choix;
        do {
            System.out.println("========== GESTION DU STOCK TECHSTORE ==========");
            System.out.println("0 - Ajouter un article");
            System.out.println("1 - Augmenter la quantité d'un article");
            System.out.println("2 - Modifier un article");
            System.out.println("3 - Supprimer un article");
            System.out.println("4 - Consulter le stock");
            System.out.println("5 - Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 0:
                    System.out.print("Nom de l'article : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prix de l'article : ");
                    double prix = scanner.nextDouble();
                    System.out.print("Quantité : ");
                    long qte = scanner.nextLong();
                    stock.ajouterArticle(nom, prix, qte);
                    System.out.println("Article ajouté avec succès !\n");
                    break;
                case 1:
                    System.out.print("Référence de l'article à augmenter : ");
                    String refAugment = scanner.nextLine();
                    System.out.print("Quantité à ajouter : ");
                    long qteAjout = scanner.nextLong(); 
                    stock.incrementerQuantiteArticle(refAugment, qteAjout);
                    System.out.println("Quantité augmentée avec succès !\n");
                    break;
                case 2:
                    System.out.print("Référence de l'article à modifier : ");
                    String refModif = scanner.nextLine();
                    System.out.print("Nouveau nom : ");
                    String nouvNom = scanner.nextLine();
                    System.out.print("Nouveau prix : ");
                    double nouvPrix = scanner.nextDouble();
                    System.out.print("Nouvelle quantité : ");
                    long nouvQte = scanner.nextLong(); 
                    stock.modifierArticle(refModif, nouvNom, nouvPrix, nouvQte);
                    System.out.println("Article modifié avec succès !\n");
                    break;
                case 3:
                    System.out.print("Référence de l'article à supprimer : ");
                    String refSupp = scanner.nextLine();
                    
                    stock.supprimerArticle(refSupp);
                    System.out.println("Article supprimé avec succès !\n");
                    break;
                case 4:
                    System.out.println("--- Contenu du Stock ---");
                    System.out.println(stock.toString());
                    break;

                case 5:
                    System.out.println("Fermeture du programme...");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.\n");
            }
        } while (choix != 5);

        scanner.close();
    }
}