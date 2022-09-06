import javax.swing.*;
import java.awt.*;

public class Main extends  JPanel {  // JPanel это, как html (по сути в ней хранится, весь интерфейс // )
    final int BF_WIDTH = 576;  // BF_WIDTH - ширинаПолеБоя
    final int BF_HEIGHT = 576;  // BF_HEIGHT - высотаПолеБоя

    int direction = 1;  // int - направление танка  // 1-up, 2- down, 3-left, 4-right
    int bulletX = 320;
    int bulletY = 320;

    int x = 256;  // координаты танка, где он будет находиться по умолчанию
    int y = 256;

    void move(int direction) throws Exception {   //в зависимости от direction будет ходить
        this.direction = direction;
        if (direction==1){
            y--;
        }else if (direction==2){
            y++;
        } else if (direction==3) {
            x--;
        } else if (direction==4) {
            x++;
        }
        Thread.sleep(33);
        repaint();
    }
     void runTheGame() throws Exception {   //логика игры, чтобы он мог передвигаться
        while (y != BF_HEIGHT-64){
            move(2);

        }

     }
    void moveUp () throws Exception {
        direction = 1; // направлене при движениии
        while (y != BF_HEIGHT + 64) {// != неравно
            y--;
            Thread.sleep(10); //задержка
            repaint();  // функция JPanel, которая перерисовывает панель ( без данной функциии движение танка с задержкй толкь  на расширении окна реагиурет)
        }
    }
    void moveDown () throws Exception {
        direction = 2;
        while (y != BF_HEIGHT-64) {
            y++;
            Thread.sleep(10);
            repaint();
        }}
    void moveLeft () throws Exception {
        direction = 3;
        while (x != BF_WIDTH-64) {
            x--;
            Thread.sleep(10);
            repaint();
        }}
     void moveRight () throws Exception {
        direction = 4;
        while (x != BF_WIDTH - 64) {
            x++;
            Thread.sleep(10);
            repaint();
        }}

      public static void main (String[] args) throws Exception {
        Main main = new Main();
        main.runTheGame();
    }


    Main(){
        JFrame frame = new JFrame("Dendy Tanks");  //создали окно и дали название
        frame.setMinimumSize(new Dimension(BF_WIDTH,BF_HEIGHT));      // размеры окна
        frame.getContentPane().add(this);          // getContentPane - как body в html
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  //нажали на крестик ( выход) и процесс закончен.
        frame.setLocation(0,0);  // доп.характеристика по расположению окна, где оно будет находится при появлении
        frame.setVisible(true);
    }

    @Override
     protected void paintComponent(Graphics g) {   // Graphics - будет прорисована графика
        super.paintComponent(g);  //paintComponent- МЕТОД;  PS написав его  автомат создался метод
        g.setColor(Color.RED);   // именно после paintComponent, cтавим setColor ( в другом месте поставим, цвет другой будет)
        g.fillRect(x,y,64,64);     //координаты - 256,256 местонахождения. 64,64 - размеры квадрата + fillRect - заливка

        g.setColor(Color.GREEN);
        if (direction == 1){    // создаем пушку
            g.fillRect(x + 20,y-25,24,34);
        } else if (direction == 2){
            g.fillRect(x+20,y+60,24,34);
        }else if (direction == 3){
            g.fillRect(x-15,y+25,30,15);
        }else if (direction == 4){
            g.fillRect(x+50,y+25,30,15);
        }
         g.setColor(Color.YELLOW);
         g.fillRect(bulletX,bulletY,14,14);
    }


}
