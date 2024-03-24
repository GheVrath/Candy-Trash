import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Class used to create colored block
 */
public class Block extends JPanel {
    private int colorIndex;

    /**
     * Creates a new randomised block
     */
    public Block() {
        this.setOpaque(true);
        this.setBounds(5, 5, 40, 40);
        this.setVisible(true);
        colorIndex=randomizeColor();
    }

    /**
     * Replaces this block with other given block
     * @param block colored block that replaces this one
     */
    public Block(Block block){
        this.setOpaque(true);
        this.setBounds(5, 5, 40, 40);
        this.setVisible(true);
        colorIndex=block.colorIndex;
        makeColor(colorIndex,240);
    }

    /**
     * Sets color of this block based on given index color
     * @param index Color index: 1-Red, 2-Green, 3-Blue.
     * @param alpha Alpha of a color
     */
    private void makeColor(int index,int alpha){
        switch (index) {
            case 1 -> {this.setBackground(new Color(255, 50, 50,alpha));}
            case 2 -> {this.setBackground(new Color(50, 255, 50,alpha));}
            case 3 -> {this.setBackground(new Color(50, 50, 255,alpha));}
        }
    }

    /**
     * Generate random value of integer from 1 up to 3
     * then based on that number applies color to this block
     * @return Integer value in range 1 to 3
     */
    private int randomizeColor() {
        Random random = new Random();
        int randomColorNumber = random.nextInt(3) + 1;
        makeColor(randomColorNumber,240);
        return randomColorNumber;
    }

    /**
     *
     * @return Current color index
     */
    public int getColorIndex(){
        return colorIndex;
    }
}
