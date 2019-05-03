import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logic extends JFrame{

    public static void main(String[] args){
        int[][] state = {
                {0,1,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0},
                {1,1,1,0,0,0,0,0,0,0,0,0},
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
       for(int r = 0; r < row; r++){
           for(int c = 0; c < col; c++){
               //check for neighbours
               int neighbours = 0;
               if(currentState[wrapIndex(row, r-1)][wrapIndex(col, c+1)] == 1){ //top left
                   neighbours++;
               }if(currentState[wrapIndex(row, r)][wrapIndex(col, c+1)] == 1){ //top middle
                   neighbours++;
               }if(currentState[wrapIndex(row, r+1)][wrapIndex(col, c+1)] == 1){ //top right
                   neighbours++;
               }if(currentState[wrapIndex(row, r-1)][wrapIndex(col, c)] == 1){ //middle left
                   neighbours++;
               }if(currentState[wrapIndex(row, r+1)][wrapIndex(col, c)] == 1){ //middle right
                   neighbours++;
               }if(currentState[wrapIndex(row, r-1)][wrapIndex(col, c-1)] == 1){ //bottom left
                   neighbours++;
               }if(currentState[wrapIndex(row, r)][wrapIndex(col, c-1)] == 1){ //bottom middle
                   neighbours++;
               }if(currentState[wrapIndex(row, r+1)][wrapIndex(col, c-1)] == 1){ //bottom right
                   neighbours++;
               }
               //System.out.println(r+"/"+c+": "+neighbours);

               //game of life rules
               if((neighbours > 3) || (neighbours < 2)){ //if cell is over or underpopulated it dies
                   futureState[r][c] = 0;
                   //System.out.println(r+"/"+c+"dies");
               }else if(currentState[r][c] == 1 && ((neighbours == 2) || neighbours ==3)){ //if cell is okay it survives
                   futureState[r][c] = 1;
                   //System.out.println(r+"/"+c+"survives");
               }else if((currentState[c][r] == 0) && (neighbours == 3)){ //if dead cell has 3 neighbours it is born
                   futureState[r][c] = 1;
                   //System.out.println(r+"/"+c+"born");
               }else{ //else current state stays the same
                   futureState[r][c] = currentState[r][c];
               }
           }
       }
       //change colors
       for(int r = 0; r < row; r++){
           for(int c = 0; c < col; c++){
               if(futureState[r][c] == 1){
                   panels[r][c].setBackground(Color.RED);
               }else{
                   panels[r][c].setBackground(Color.GRAY);
               }
           }
       }
       currentState = futureState; //store future generation in current generation
    }

    private int wrapIndex(int length, int pos){
        int index;
        if(pos < 0){
            index = (pos + length) % length;
        } else if(pos == 0){
            index = 0;
        } else {
            index = pos % length;
        }
        return index;
    }

    public void evolveGeneration(){
        for(int i = 0; i <= 64; i++){
            try{
                Thread.sleep(1000);
                nextGeneration(currentState,rows,cols);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

//TODO create edge case detection