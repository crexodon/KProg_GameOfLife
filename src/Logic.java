import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logic extends JFrame{

    public static void main(String[] args){
        int[][] state = {
                {0,0,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0,0,0},
                {0,1,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0}
        };
        Logic logi = new Logic(12,12, state);
    }

    JPanel[][] panels;
    int[][] currentState;
    int rows;
    int cols;

    Logic(int rows, int cols, int[][] state){
        this.rows = rows;
        this.cols = cols;

        //JFrame stuff
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setTitle("Game of Life");

        //JPanel grid
        JPanel mainPanel = new JPanel(new GridLayout(rows, cols));

        panels = new JPanel[rows][cols];
        this.currentState = state;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                panels[i][j] = new JPanel(new FlowLayout());
                if(state[i][j] == 1){
                    panels[i][j].setBackground(Color.RED);
                } else{
                    panels[i][j].setBackground(Color.GRAY);
                }
                panels[i][j].setMinimumSize(new Dimension(20,20));
                panels[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                mainPanel.add(panels[i][j]);
            }
        }
        this.add(mainPanel);
        this.setVisible(true);
        evolveGeneration();
    }

    public void nextGeneration(int state[][], int row, int col){
        int futureState[][] = new int[row][col];
        //iterate through every cell
        for(int i = 1; i < row -1; i++){
            for(int j = 1; j < col -1; j++){
                //check for number of neighbour cells that are alive
                int aliveNeighbours = 0;
                for(int k = -1; k <= 1; k++){
                    for(int l = -1; l <= 1; l++){
                        aliveNeighbours += currentState[i + k][j + l];
                    }
                }
                //subtract the checked cell from neighbour cells
                aliveNeighbours -= currentState[i][j];

                //rules of game of life
                if((aliveNeighbours > 3) || (aliveNeighbours < 2)){ //if cell is over or underpopulated it dies
                    futureState[i][j] = 0;
                } else if((currentState[i][j] == 1) && ((aliveNeighbours == 2) || (aliveNeighbours == 3))){ //if cell is okay it will live on
                    futureState[i][j] = 1;
                } else if((currentState[i][j] == 0) && (aliveNeighbours == 3)){ //new cell is born if it has 3 neighbours
                    futureState[i][j] = 1;
                } else { //if nothing happened cells stay the same
                    futureState[i][j] = currentState[i][j];
                }
            }
        }
        //change colors for the next generation
        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols; j++){
                if(futureState[i][j] == 0){
                    panels[i][j].setBackground(Color.GRAY);
                } else{
                    panels[i][j].setBackground(Color.RED);
                }
            }
        }
        //store future generation in current generation
        currentState = futureState;
    }

    public void evolveGeneration(){
        for(int i = 0; i <= 32; i++){
            try{
                Thread.sleep(500);
                nextGeneration(currentState,rows,cols);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

//TODO create edge case detection