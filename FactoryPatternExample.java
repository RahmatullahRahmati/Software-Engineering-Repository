/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package  FactoryPatternExample;

    abstract class Vehicle {
         public abstract int getWheel();
  
            public String toString() {
              return "Wheel: " + this.getWheel();
  }
}

class Car extends Vehicle {
  int wheel;
  
  Car(int wheel) {
    this.wheel = wheel;
  }

  @Override
  public int getWheel() {
    return this.wheel;
  }
}

class Bike extends Vehicle {
  int wheel;
  
  Bike(int wheel) {
    this.wheel = wheel;
  }
  
  @Override
  public int getWheel() {
    return this.wheel;
  }
}

class VehicleFactory {
  public static Vehicle getInstance(String type, int wheel) {
    if(type == "car") {
      return new Car(wheel);
      
    } else if(type == "bike") {
      return new Bike(wheel);
    }
    
    return null;
  }
}

public class FactoryPatternExample {

  public static void main(String[] args) {
    Vehicle car = VehicleFactory.getInstance("car", 4);
    System.out.println(car);
    
      Vehicle car2 = VehicleFactory.getInstance("car", 4393);
    System.out.println(car2);
    
    Vehicle bike = VehicleFactory.getInstance("bike", 2);
    System.out.println(bike);
    
      Vehicle bike2 = VehicleFactory.getInstance("bike", 11);
    System.out.println(bike2);
    
   }

}    

