/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
   // interface
 interface Command {
    public void execute();
}

// lighnt class 

 class Light {
    String location = "";
    public Light(String location){
        this.location = location;
    }

    public void on() {
        System.out.println(location + "light is on!");
    }

    public void off() {
        System.out.println(location + "light is off!");
    }
}
//   remote controller
 class SimpleRemoteControl {
    Command[] onCommnads;
    Command[] offCommands;

    public SimpleRemoteControl() {
        // this.slot = slot;
        onCommnads = new Command[7];
        offCommands = new Command[7];

        for(int i = 0; i < 7; i++){
            onCommnads[i] = () -> { };
            offCommands[i] = () -> { };
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand){
        onCommnads[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot){
        onCommnads[slot].execute();
    }

    public void offButtonWasPushed(int slot){
        offCommands[slot].execute();
    }

    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n-------- Remote Control --------\n");
        for(int i = 0; i < onCommnads.length; i++){
            stringBuffer.append("[slot] " + i + "]" + onCommnads[i].getClass().getName() + "         " + offCommands[i].getClass().getName()+ "\n");
        }
        return stringBuffer.toString();
    }
}


  // tv class 
 class TV {
    String location;
    int channel;

    public TV(String location){
        this.location = location;
    }

    public void on(){
        System.out.println("TV is on!");
    }

    public void off(){
        System.err.println("TV is off!");
    }

    public void setChannel(){
        this.channel = 5;
        System.out.println("Channel is set for Television");
    }
}

public class App {

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args )
    {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        Light livingRoomLight = new Light("room is  ");
        Light kitchenLight = new Light("hall is Light");
        TV tv = new TV("childern  Room");

        // set the light
        remoteControl.setCommand(0, livingRoomLight::on, livingRoomLight::off);
        remoteControl.setCommand(1, kitchenLight::on, kitchenLight::off);
        // livingRoomLight.on();

        // set television
        remoteControl.setCommand(2, tv::on, tv::off);
        
        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
    }
}
