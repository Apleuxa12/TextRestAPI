package com.ddmukhin.main.repositories;

import com.ddmukhin.main.models.Text;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class TextRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TextRepository textRepository;

    @Test
    public void simpleTextFindByIdTest(){
        Text text = new Text("theme", "value");

        entityManager.persist(text);
        entityManager.flush();

        Optional<Text> found = textRepository.findById(1L);

        assertTrue(found.isPresent() && found.get().getTheme().equals(text.getTheme()) && found.get().getValue().equals(text.getValue()));
    }

    @Test
    public void simpleFindAllTest(){
        Text text1 = new Text("theme1", "value1");
        Text text2 = new Text("theme2", "value2");
        Text text3 = new Text("theme3", "value3");

        entityManager.persist(text1);
        entityManager.persist(text2);
        entityManager.persist(text3);
        entityManager.flush();

        List<Text> found = textRepository.findAll();

        assertEquals(found.size(), 3);
    }

}