import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MySQLColumnCreatorTest {

    @Test
    void generateScript1() {
        MySQLColumnCreator column = new MySQLColumnCreator("codigo", "INT", true, true);
        assertEquals("'codigo' INT NOT NULL AUTO_INCREMENT", column.generateScript());
    }

    @Test
    void generateScript2() {
        MySQLColumnCreator column = new MySQLColumnCreator("codigo", "INT", false, true);
        assertEquals("'codigo' INT AUTO_INCREMENT", column.generateScript());
    }

    @Test
    void generateScript3() {
        MySQLColumnCreator column = new MySQLColumnCreator("codigo", "INT", true, false);
        assertEquals("'codigo' INT NOT NULL", column.generateScript());
    }

    @Test
    void generateScript4() {
        MySQLColumnCreator column = new MySQLColumnCreator("codigo", "INT", false, false);
        assertEquals("'codigo' INT", column.generateScript());
    }
}
