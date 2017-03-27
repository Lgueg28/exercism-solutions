import java.util.ArrayList;
import java.util.List;

/**
 * The Allergies class takes a person's allergy score and determines the allergens that compose it
 *
 * @author Loic Guegan
 * @since   2017-03-26
 */
public class Allergies {
    private List<Allergen> allergens = new ArrayList<Allergen>();
    private int score;

    Allergies(int score) {
        this.score = score;
        determineAllergens();
    }

    public boolean isAllergicTo(Allergen allergen) { return (allergen.getScore() & this.score) != 0; }

    public List<Allergen> getList() { return this.allergens; }

    private void determineAllergens() {
        if (this.score < 0) {
            System.out.println("Please provide a positive allergen score");
            return;
        }

        for (Allergen allergen : Allergen.values()) {
            if ((allergen.getScore() & score) != 0) {
                this.allergens.add(allergen);
            }
        }
    }
}
