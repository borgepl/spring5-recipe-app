package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@Slf4j
public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController indexController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {

        String viewName = indexController.getIndexPage(model);
        assertEquals("index",viewName);
        verify(recipeService,times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }
}