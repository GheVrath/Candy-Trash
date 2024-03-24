import javax.swing.*;
import java.awt.*;

/**
 * Class creates panel inside a frame
 * and fills it with containers and blocks.
 * Here are methods responsible for game mechanisms
 */
public class GamePanel extends JPanel{
    static final int PANEL_WIDTH=800;
    static final int PANEL_HEIGHT=800;
    public static final int rows=15;
    public static final int columns=15;
    static Container[][] containers=new Container[rows][columns];
    public GamePanel() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setVisible(true);
        this.setOpaque(true);
        this.setBackground(Color.black);
        generateContainers();
        fillBoard();
    }

    /**
     * Creates an empty containers, that can hold
     * colored blocks inside
     */
    private void generateContainers(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                Container container=new Container(i,j);
                container.setLocation(i*50,j*50);
                containers[i][j]=container;
                this.add(container);
            }
        }
    }

    /**
     *Inserts a new colored block into specific container
     * returns void
     * @param row index of container at row
     * @param column index of container at column
     */
    public void generateBlock(int row,int column){
        if(!containers[row][column].isFilled()){
            containers[row][column].setBlock(new Block());
        }
    }

    /**
     * Fills every container with a colored block
     */
    public void fillBoard(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                generateBlock(i,j);
            }
        }
    }

    /**
     * Checks if container below colored block
     * is empty, if true: colored block is moved lower.
     */
    public void fallDown(){
        for(int i=0;i<rows;i++)
            for(int j=0;j<columns;j++){
                if(j+1<columns&&containers[i][j].isFilled()&&!containers[i][j+1].isFilled()){
                    Block tempBlock=new Block(containers[i][j].getBlock());
                    containers[i][j+1].setBlock(tempBlock);
                    containers[i][j].removeBlock();
                }
            }
    }

    /**
     * Fills every empty container at the top
     * with colored block
     */
    public void spawnAtTop(){
        for(int i=0;i<columns;i++){
            if(!containers[i][0].isFilled()){
                Block tempBlock=new Block();
                containers[i][0].setBlock(tempBlock);
            }
        }
    }

    /**
     * Prepare for future check win condition
     */
    public void isGameDone(){
    }
}
