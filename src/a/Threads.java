package a;


import javax.swing.*;

class Threads implements Runnable {
    JSlider slider1;
    boolean operation;
    public Threads(JSlider slider1, boolean operation) {
        this.slider1 = slider1;
        this.operation = operation;
    }
    @Override
    public void run(){
        int new_value;
        if(operation)
            new_value = 1;
        else
            new_value = -1;
        while(true) {
            synchronized (slider1) {
                slider1.setValue(new_value + slider1.getValue());
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}