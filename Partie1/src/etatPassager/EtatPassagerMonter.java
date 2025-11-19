package etatPassager;

// Implémentation ne gérant que les passagers à l'intérieur.
public class EtatPassagerMonter implements IEtatPassager {
    
    // Utilise l'enum pour définir les états internes possibles.
    private final EtatPassager.Etat monEtat;

    // Construit un passager, mais refuse l'état DEHORS.
    public EtatPassagerMonter(EtatPassager.Etat e) {
        if (e == EtatPassager.Etat.DEHORS) {
            // Lance une erreur si on essaie de créer un passager dehors.
            throw new IllegalArgumentException("EtatPassagerMonter ne gère pas l'état DEHORS.");
        }
        this.monEtat = e;
    }

    // Un passager "monté" n'est jamais à l'extérieur.
    @Override
    public boolean estExterieur() {
        return false;
    }

    // Vérifie si le passager est assis.
    @Override
    public boolean estAssis() {
        return monEtat == EtatPassager.Etat.ASSIS;
    }

    // Vérifie si le passager est debout.
    @Override
    public boolean estDebout() {
        return monEtat == EtatPassager.Etat.DEBOUT;
    }

    // Un passager "monté" est toujours à l'intérieur.
    @Override
    public boolean estInterieur() {
        return true;
    }

    // Un passager "monté" ne peut pas sortir.
    @Override
    public IEtatPassager changerEnDehors() {
        throw new UnsupportedOperationException("Un passager déjà monté ne peut pas sortir.");
    }

    // Crée un nouvel objet passager à l'état "assis".
    @Override
    public IEtatPassager changerEnAssis() {
        return new EtatPassagerMonter(EtatPassager.Etat.ASSIS);
    }

    // Crée un nouvel objet passager à l'état "debout".
    @Override
    public IEtatPassager changerEnDebout() {
        return new EtatPassagerMonter(EtatPassager.Etat.DEBOUT);
    }
}