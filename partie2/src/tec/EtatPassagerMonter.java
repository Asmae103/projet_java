package tec;

/**
 * Implémentation ne gérant que les passagers à l'intérieur.
 * Cette classe refuse l'état DEHORS et ne permet pas de sortir.
 */
public class EtatPassagerMonter implements IEtatPassager {
    
    // Utilise l'enum pour définir les états internes possibles.
    private final EtatPassager.Etat monEtat;

    /**
     * Construit un passager, mais refuse l'état DEHORS.
     * @param e l'état initial (doit être ASSIS ou DEBOUT)
     * @throws IllegalArgumentException si l'état est DEHORS
     */
    public EtatPassagerMonter(EtatPassager.Etat e) {
        if (e == EtatPassager.Etat.DEHORS) {
            // Lance une erreur si on essaie de créer un passager dehors.
            throw new IllegalArgumentException("EtatPassagerMonter ne gère pas l'état DEHORS.");
        }
        this.monEtat = e;
    }

    @Override
    public boolean estExterieur() {
        return false; // Un passager "monté" n'est jamais à l'extérieur.
    }

    @Override
    public boolean estAssis() {
        return monEtat == EtatPassager.Etat.ASSIS;
    }

    @Override
    public boolean estDebout() {
        return monEtat == EtatPassager.Etat.DEBOUT;
    }

    @Override
    public boolean estInterieur() {
        return true; // Un passager "monté" est toujours à l'intérieur.
    }

    @Override
    public IEtatPassager changerEnDehors() {
        throw new UnsupportedOperationException("Un passager déjà monté ne peut pas sortir.");
    }

    @Override
    public IEtatPassager changerEnAssis() {
        return new EtatPassagerMonter(EtatPassager.Etat.ASSIS);
    }

    @Override
    public IEtatPassager changerEnDebout() {
        return new EtatPassagerMonter(EtatPassager.Etat.DEBOUT);
    }
}
