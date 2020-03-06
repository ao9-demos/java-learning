package com.example.awtSample;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindow extends Frame {
    public MyWindow(String title) {
        super(title);
        setSize(800, 500);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font sanserifLarge = new Font("sanserif", Font.BOLD, 24);
        Font sanserifsmall = new Font("sanserif", Font.BOLD, 14);
        g.setFont(sanserifLarge);
        g.drawString("This is a window", 60, 60);
        g.setFont(sanserifsmall);
        g.drawString("aaaaaaaaaaaabbbbbbbbbbbbbccccccccc", 60, 200);

    }
}
