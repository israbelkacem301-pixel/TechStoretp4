package techstore;
public class Article {
    private static int compteur = 0; 
    private int id;
    private String nom;
    private String reference;
    private double prix;
    public Article(String nom, double prix) {
        compteur++;
        this.id = compteur;
        this.nom = nom;
        this.prix = prix;
        this.reference = genererReference();
    }
    private String genererReference() {
        String sansEspaces = nom.replace(" ", "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sansEspaces.length(); i += 5) {
            sb.append(sansEspaces.charAt(i));
        }
        return sb.toString() + id;
    }
    public int getId() {
        return id;
    }
    public String getReference() {
        return reference;
    }
    public String getNom() {
        return nom;
    }
    public double getPrix() {
        return prix;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public void setNom(String nom) {
        this.nom = nom;
        this.reference = genererReference();
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public void modifier(String nom) {
        setNom(nom);
    }
    public void modifier(String nom, double prix) {
        setNom(nom);
        setPrix(prix);
    }
    public boolean equals(Article autre) {
        return autre != null && this.reference.equals(autre.reference);
    }
    @Override
    public String toString() {
        return "id=" + id + ", nom=" + nom + ", reference=" + reference + ", prix=" + prix;
    }
}