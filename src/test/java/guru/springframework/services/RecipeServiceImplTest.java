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
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    private RecipeServiceImpl recipeService;
    
    @Mock
    private
    RecipeRepository recipeRepository;
    
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        recipeService = new RecipeServiceImpl(recipeRepository);
    }
    
    @Test
    public void getRecipes() {
        
        Recipe recipe = new Recipe();
        HashSet<Recipe> receipesData = new HashSet<>();
        receipesData.add(recipe);
        
        when(recipeService.getRecipes()).thenReturn(receipesData);
        
        Set<Recipe> recipes = recipeService.getRecipes();
        
        assertThat(recipes).hasSize(1);
        verify(recipeRepository, times(1)).findAll();
    }
}