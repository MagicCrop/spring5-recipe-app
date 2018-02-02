package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

public class RecipeServiceImplTest {
    @Mock
    private RecipeRepository recipeRepository;
    
    private RecipeServiceImpl recipeService;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        
        recipeService = new RecipeServiceImpl(recipeRepository);
    }
    
    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);
        given(recipeService.getRecipes()).willReturn(recipes);
        
        Set<Recipe> result = recipeService.getRecipes();
        
        assertThat(result).isEqualTo(recipes);
        then(recipeRepository).should().findAll();
    }
}