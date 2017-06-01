package com.company;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 * Created by Yk on 2017/5/18.
 */
public class Chess extends JFrame {
    private static final int w = 30;
    private int size;
    private int[][] b;
    private int r;
    private int c;

    private Graphics g;
    private Color rectColor = new Color(0xf5f5f5);

    public void paint(Graphics g) {
        try {
            g.setColor(Color.black);
            int rw = size * w;
            g.drawRect(50, 50, rw, rw);
            for (int i = 0; i < size; i++) {

                g.drawLine(50 + (i * w), 50, 50 + (i * w), 50 + rw);


                g.drawLine(50, 50 + (i * w), 50 + rw, 50 + (i * w));
//                for (int j = 0; j < size; j++) {
//                    drawString(g, j, i);
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void drawString(Graphics g, int x, int y) {


        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", 0, 15));//
//        if (b[y][x] == 0)
            g.drawString(b[y][x] + "", 50 + (x * w) + 10, 50 + ((y + 1) * w) - 10);

    }

    Chess(int size, int[][] b,int dr,int dc) {
        this.r=dr;
        this.c=dc;

        setLocationRelativeTo(getOwner());
        setTitle("Chess Board");
        this.size = size;
        this.b = b;
//        setLocationRelativeTo(null);
        Container p = getContentPane();
        setSize(size * w + 100, size * w + 100);
        setVisible(true);
        p.setBackground(rectColor);
        setLayout(null);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        g = this.getGraphics();
        drawString(g,dc,dr);
        paint(g);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int sx[] = new int[3];
                int sy[] = new int[3];
                int n = 0;
                int x = e.getX(), y = e.getY();
//                System.out.print(x+" "+y);
                if (x >= 50 && y >= 50 && x <= 50 + size * w && y <= 50 + size * w) {
                    int cx = (x - 50) / w, cy = (y - 50) / w;
                    System.out.println(cx + " " + cy);
                    for (int i = cy-1; i < cy+2; i++)
                        for (int j = cx-1; j < cx+2; j++) {
                            if(i>=0&&i<=size-1&&j>=0&&j<=size-1)
                            if (b[i][j] == b[cy][cx]) {
                                sx[n] = j;
                                sy[n] = i;
                                n++;
                                drawString(g, j, i);


                            }

                        }
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setStroke(new BasicStroke(3.0f));
                    if (!((sx[0] != sx[1]) && (sy[0] != sy[1])))
                        g2.drawLine(70 + sx[0] * w, 70 + sy[0] * w, 70 + sx[1] * w, 70 + sy[1] * w);
                    if (!((sx[2] != sx[1]) && (sy[2] != sy[1])))
                        g2.drawLine(70 + sx[1] * w, 70 + sy[1] * w, 70 + sx[2] * w, 70 + sy[2] * w);
                    if (!((sx[0] != sx[2]) && (sy[0] != sy[2])))
                        g2.drawLine(70 + sx[0] * w, 70 + sy[0] * w, 70 + sx[2] * w, 70 + sy[2] * w);
                }
            }
        });

    }
}
