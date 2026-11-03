package techstore;
public class Element {
    private Article article;
    private long quantite;
    public Element(Article article, long quantite) {
        if (article == null) {
            throw new IllegalArgumentException("Article manquant");
        }
        if (quantite < 0) {
            throw new IllegalArgumentException("La quantité ne peut pas être négative");
        }
        this.article = article;
        this.quantite = quantite;
    }
    public Element(String nom, double prix, long quantite) {
        this(new Article(nom, prix), quantite);
    }
    public Article getArticle() {
        return article;
    }
    public long getQuantite() {
        return quantite;
    }
    public String getReferenceArticle() {
        return article.getReference();
    }
    public String getNomArticle() {
        return article.getNom();
    }
    public double getPrixArticle() {
        return article.getPrix();
    }
    public void setArticle(Article article) {
        if (article != null) {
            this.article = article;
        }
    }
    public boolean setQuantite(long quantite) {
        if (quantite < 0) {
            return false;
        }
        this.quantite = quantite;
        return true;
    }
    public boolean incrementerQuantite(long q) {
        if (q <= 0) {
            return false;
        }
        this.quantite += q;
        return true;
    }
    public boolean decrementerQuantite(long q) {
        if (q <= 0 || q > this.quantite) {
            return false;
        }
        this.quantite -= q;
        return true;
    }
    public boolean modifier(String nom, double prix, long quantite) {
        if (quantite < 0) {
            return false;
        }
        this.article = new Article(nom, prix);
        this.quantite = quantite;
        return true;
    }
    public boolean equals(String reference) {
        return article.getReference().equals(reference);
    }
    public boolean equals(Article autre) {
        return article.equals(autre);
    }
    @Override
    public String toString() {
        return "Element [article=" + article + ", quantite=" + quantite + "]";
    }
}