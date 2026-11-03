package techstore;
import java.util.ArrayList;
public class Stock {
    private ArrayList<Element> articleList;
    public Stock() {
        this.articleList = new ArrayList<>();
    }
    public Stock(ArrayList<Element> articleList) {
        this.articleList = (articleList != null) ? articleList : new ArrayList<>();
    }
    public Stock(ArrayList<String> noms, ArrayList<Double> prix, ArrayList<Long> quantites) {
        if (noms.size() != prix.size() || noms.size() != quantites.size()) {
            throw new IllegalArgumentException("Les trois listes doivent avoir la même taille");
        }
        this.articleList = new ArrayList<>();
        for (int i = 0; i < noms.size(); i++) {
            articleList.add(new Element(noms.get(i), prix.get(i), quantites.get(i)));
        }
    }
    public ArrayList<Element> getArticleList() {
        return articleList;
    }
    public int getArticleNb() {
        return articleList.size();
    }
    public void setArticleList(ArrayList<Element> articleList) {
        this.articleList = (articleList != null) ? articleList : new ArrayList<>();
    }
    public boolean ajouterArticle(Article article, long quantite) {
        if (article == null || quantite < 0) {
            return false;
        }
        articleList.add(new Element(article, quantite));
        return true;
    }
    public boolean ajouterArticle(String nom, double prix, long quantite) {
        if (prix < 0 || quantite < 0) {
            return false;
        }
        return ajouterArticle(new Article(nom, prix), quantite);
    }
    public Element trouverArticle(String reference) {
        for (Element e : articleList) {
            if (e.equals(reference)) {
                return e;
            }
        }
        return null;
    }
    public boolean modifierArticle(String reference, String nouveauNom, double nouveauPrix, long nouvelleQuantite) {
        Element e = trouverArticle(reference);
        if (e == null || nouveauPrix < 0 || nouvelleQuantite < 0) {
            return false;
        }
        e.getArticle().modifier(nouveauNom, nouveauPrix);   // l'identifiant reste le même
        e.setQuantite(nouvelleQuantite);
        return true;
    }
    public boolean supprimerArticle(String reference) {
        for (int i = 0; i < articleList.size(); i++) {
            if (articleList.get(i).equals(reference)) {
                articleList.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean incrementerQuantiteArticle(String reference, long quantite) {
        Element e = trouverArticle(reference);
        return e != null && e.incrementerQuantite(quantite);
    }
    public boolean decrementerQuantiteArticle(String reference, long quantite) {
        Element e = trouverArticle(reference);
        return e != null && e.decrementerQuantite(quantite);
    }
    @Override
    public String toString() {
        if (articleList.isEmpty()) {
            return "Le stock est vide.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < articleList.size(); i++) {
            sb.append(articleList.get(i));
            if (i < articleList.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}