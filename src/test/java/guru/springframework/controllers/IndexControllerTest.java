package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class IndexControllerTest {
    @Mock
    private RecipeService recipeService;
    
    @Mock
    private Model model;
    
    private IndexController indexController;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        indexController = new IndexController(recipeService);
    }
    
    @Test
    public void getIndexPage() {
        //given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
    
        Recipe recipe = new Recipe();
        recipe.setId(1L);
    
        recipes.add(recipe);
    
        when(recipeService.getRecipes()).thenReturn(recipes);
    
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
    
        //when
        String viewName = indexController.getIndexPage(model);
    
    
        //then
        assertThat(viewName).isEqualTo("index");
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertThat(setInController).hasSize(2);
    }
}