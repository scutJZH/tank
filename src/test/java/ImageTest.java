import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ImageTest {
    @Test
    public void test() {

        try {
            BufferedImage image = ImageIO.read(new File("F:/StudyPrograms/马士兵/tank/tank/src/images/0.gif"));
            assertNotNull(image);
            BufferedImage image1 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/0.gif"));
            assertNotNull(image1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
