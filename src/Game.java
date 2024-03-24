/**
 * This class is responsible for starting whole project
 * including new window, panel, threads etc
 */
public class Game implements Runnable{
    private GamePanel gamePanel;
    public Game(){
        gamePanel = new GamePanel();
        new GameWindow(gamePanel);
        gameLoop();
    }

    /**
     * Creates a new thread and starts it.
     */
    private void gameLoop(){
        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     * Overrides run() function of Thread.
     * This function is game loop checking conditions
     */
    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(100);
            }
            catch(Exception e){
                System.out.println("Failed to sleep at Game.run()");
            }
            gamePanel.fallDown();
            gamePanel.spawnAtTop();
            gamePanel.isGameDone();
            gamePanel.setVisible(false);
            gamePanel.setVisible(true);
        }
    }
}