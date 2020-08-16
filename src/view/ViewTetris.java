package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.IController;

public class ViewTetris extends JFrame implements IViewTetris {
    private static final long serialVersionUID = 1L;
    private JButton newgamebt, optionbt, quitbt, resumebt, levelbt, highscorebt;
    private final IController controller;

    public ViewTetris(IController controller) {
        super("Tetris - Game");
        this.controller = controller;
        init();
    }

    public void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setContentPane(new JLabel(new ImageIcon("image\\rsz_tetris.png")));
        getContentPane().setLayout(null);
        addButton();
        mouseEventButton();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //Thêm các option lên màn hình chính
    public void addButton() {
        /** GridLayout */
        JPanel p = new JPanel(new GridLayout(6, 1, 5, 5));
        p.setSize(new Dimension(200, 250));
        /** create button */
        newgamebt = new JButton("New Game");
        levelbt = new JButton("Level");
        quitbt = new JButton("Quit");
        /** set font and size for text in button */
        newgamebt.setFont(new Font("SVN-Block", Font.PLAIN, 16));
        levelbt.setFont(new Font("SVN-Block", Font.PLAIN, 16));
        quitbt.setFont(new Font("SVN-Block", Font.PLAIN, 16));
        /** set no border for button */
        newgamebt.setBorder(null);
        levelbt.setBorder(null);
        quitbt.setBorder(null);
        /** hiden background button */
        newgamebt.setFocusPainted(false);
        levelbt.setFocusPainted(false);
        quitbt.setFocusPainted(false);
        newgamebt.setContentAreaFilled(false);
        levelbt.setContentAreaFilled(false);
        quitbt.setContentAreaFilled(false);
        /** no bug for hide background jbutton */
        p.setOpaque(false);
        /** add button ==> layout */
        p.add(newgamebt);
        p.add(levelbt);
        p.add(quitbt);
        p.setLocation(80, 200);
        getContentPane().add(p);
    }

    // Hiệu ứng các button
    public void mouseEventButton() {
        newgamebt.addMouseListener(addEvent());
        levelbt.addMouseListener(addEvent());
        quitbt.addMouseListener(addEvent());
    }

    //Thay đổi size text khi hover
    public MouseListener addEvent() {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (e.getSource() == newgamebt) {
                    newgamebt.setFont(new Font("SVN-Block", Font.PLAIN, 20));
                }
                if (e.getSource() == levelbt) {
                    levelbt.setFont(new Font("SVN-Block", Font.PLAIN, 20));
                }
                if (e.getSource() == quitbt) {
                    quitbt.setFont(new Font("SVN-Block", Font.PLAIN, 20));
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == newgamebt) {
                    newgamebt.setFont(new Font("SVN-Block", Font.PLAIN, 16));
                }
                if (e.getSource() == levelbt) {
                    levelbt.setFont(new Font("SVN-Block", Font.PLAIN, 16));
                }
                if (e.getSource() == quitbt) {
                    quitbt.setFont(new Font("SVN-Block", Font.PLAIN, 16));
                }
                super.mouseExited(e);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == newgamebt) {
                    startGame();
                }
                if (e.getSource() == quitbt) {
                    closeGame();
                }
                if (e.getSource() == levelbt) {
                    showLevel();
                }
                super.mouseClicked(e);
            }

        };
    }

    public void resume() {
        controller.resume();
    }

    public void closeGame() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure to close this game?", "Close Tetris",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void startGame() {
        setVisible(false);
        controller.start();
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {

    }

    @Override
    public void pause() {
        setVisible(true);
    }

    @Override
    public void lose() {
        setVisible(true);
    }

    public void showLevel() {
        new ViewLevel(controller);
    }

    @Override
    public void hidden() {
        setVisible(false);
    }
}
