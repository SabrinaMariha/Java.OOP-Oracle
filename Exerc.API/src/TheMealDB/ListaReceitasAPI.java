package TheMealDB;

import java.util.List;

public class ListaReceitasAPI {
    private List<ReceitaAPI> meals;

    public List<ReceitaAPI> getMeals() {
        return meals;
    }

    public void setMeals(List<ReceitaAPI> meals) {
        this.meals = meals;
    }


}
