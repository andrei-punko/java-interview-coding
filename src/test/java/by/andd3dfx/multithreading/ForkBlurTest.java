package by.andd3dfx.multithreading;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ForkBlurTest {

    @Test
    public void blurIt() throws Exception {
        String srcName = "target/test-classes/red-tulips.jpg";
        File srcFile = new File(srcName);
        BufferedImage image = ImageIO.read(srcFile);

        System.out.println("Source image: " + srcName);

        BufferedImage blurredImage = ForkBlur.blur(image);

        String dstName = "target/blurred-tulips.jpg";
        File dstFile = new File(dstName);
        ImageIO.write(blurredImage, "jpg", dstFile);

        System.out.println("Output image: " + dstName);
    }
}
