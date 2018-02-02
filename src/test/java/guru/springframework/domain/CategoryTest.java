package guru.springframework.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryTest {
    private Category category;
    
    @Before
    public void setUp() {
        category = new Category();
    }
    
    @Test
    public void getId() {
        long id = 4L;
        
        category.setId(id);
        
        assertThat(category.getId()).isEqualTo(id);
    }
}