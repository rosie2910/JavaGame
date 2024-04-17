package game;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatch implements ActionListener {

    JFrame frame;
    JButton startButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    //JButton stopButton = new JButton("Stop");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String secondsString = String.format("%02d", seconds);
    String minutesString = String.format("%02d", minutes);
    String hoursString = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime = elapsedTime + 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 600000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            secondsString = String.format("%02d", seconds);
            minutesString = String.format("%02d", minutes);
            hoursString = String.format("%02d", hours);
            timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);


        }
    });
    public StopWatch(BackgroundImage view){
        this.frame = frame;
        timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
        timeLabel.setBounds(350, 10, 100, 25);
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(300, 50, 100,25);
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(400, 50, 100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        //stopButton.setBounds(460, 50, 100, 25);
        //stopButton.setFocusable(false);
        //stopButton.addActionListener(this);

        view.setLayout(null);
        view.add(timeLabel);
        view.add(startButton);
        view.add(resetButton);
        // view.add(stopButton);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton) {
            if(started == false){
                started = true;
                startButton.setText("Stop");
                start();
            }
            else{
                started = false;
                startButton.setText("Start");
                stop();
            }
        }
        if(e.getSource() == resetButton){
            started = false;
            reset();
        }
    }

    public void start(){
        timer.start();
    }

    public void stop(){
        timer.stop();
    }

    void reset(){
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        secondsString = String.format("%02d", seconds);
        minutesString = String.format("%02d", minutes);
        hoursString = String.format("%02d", hours);
        timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);


    }
}