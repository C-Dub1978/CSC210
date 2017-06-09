import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by klown on 6/8/17.
 */
class DrinkerTest {
    Drinker d1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        d1 = new Drinker();
    }

    @org.junit.jupiter.api.Test
    void setWeight() {
        d1.setWeight(160);
        assertEquals(150, 150,"wrong weight");
    }

    @org.junit.jupiter.api.Test
    void setHeight() {
    }

    @org.junit.jupiter.api.Test
    void setMetabolicRate() {
    }

    @org.junit.jupiter.api.Test
    void setId() {
    }

}