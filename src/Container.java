import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Class creates containers that can hold colored blocks inside.
 * Here are mechanisms that manage removing color connected blocks
 * and methods managing contents of this container
 */
public class Container extends JPanel implements MouseListener {
    private Block block;
    private boolean isFilled, isChecked;
    public int x_locationArr, y_locationArr, colorInside;

    /**
     *Creates a new container that can hold colored blocks
     * @param x_locationArr Pixel location of left upper corner where container should be placed
     * @param y_locationArr Pixel location of left upper corner where container should be placed
     */
    public Container(int x_locationArr,int y_locationArr){
        colorInside=0;
        this.addMouseListener(this);
        this.setOpaque(false);
        this.setSize(50, 50);
        this.setLayout(null);
        this.setVisible(true);
        isChecked=false;
        isFilled=false;
        this.x_locationArr =x_locationArr;
        this.y_locationArr =y_locationArr;
    }

    /**
     * Insert a colored block into this container
     * @param block colored block
     */
    public void setBlock(Block block){
        if(block==null) {
            return;
        }
        this.block=block;
        this.colorInside=block.getColorIndex();
        this.add(block);
        isFilled=true;
        isChecked=false;
    }

    /**
     * Removes colored block from this container
     */
    public void removeBlock(){
        this.remove(block);
        isFilled=false;
    }

    /**
     * Checks if adjacent containers contains blocks of the same color
     * as this container, and remove all color connected blocks
     */
    private void removePath(){
        int x= x_locationArr;
        int y= y_locationArr;
        if(!isFilled || isChecked){ System.out.println("Returned");return;}
        isChecked=true;
        this.removeBlock();

        if(x+1<GamePanel.rows){
            boolean colorMatches=GamePanel.containers[x+1][y].colorInside==this.colorInside;
            if(GamePanel.containers[x+1][y].isFilled && !GamePanel.containers[x+1][y].isChecked && colorMatches){
                GamePanel.containers[x+1][y].removePath();
            }
        }
        if(x-1>=0){
            boolean colorMatches=GamePanel.containers[x-1][y].colorInside==this.colorInside;
            if(GamePanel.containers[x-1][y].isFilled && !GamePanel.containers[x-1][y].isChecked && colorMatches){
                GamePanel.containers[x-1][y].removePath();
            }
        }
        if(y+1<GamePanel.columns){
            boolean colorMatches=GamePanel.containers[x][y+1].colorInside==this.colorInside;
            if(GamePanel.containers[x][y+1].isFilled && !GamePanel.containers[x][y+1].isChecked && colorMatches){
                GamePanel.containers[x][y+1].removePath();
            }
        }
        if(y-1>=0){
            boolean colorMatches=GamePanel.containers[x][y-1].colorInside==this.colorInside;
            if(GamePanel.containers[x][y-1].isFilled && !GamePanel.containers[x][y-1].isChecked && colorMatches){
                GamePanel.containers[x][y-1].removePath();
            }
        }
        this.colorInside=0;
    }

    /**
     * @return This block
     */
    public Block getBlock(){
        return this.block;
    }

    /**
     * @return Boolean if this container contains a colored block
     */
    public boolean isFilled(){
        return isFilled;
    }

    /**
     * Runs methods after click on this container
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        removePath();
    }

    //Unused methods
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
