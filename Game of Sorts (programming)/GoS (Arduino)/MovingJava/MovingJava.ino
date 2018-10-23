/*
  Button

  Turns on and off a light emitting diode(LED) connected to digital pin 13,
  when pressing a pushbutton attached to pin 2.

  The circuit:
  - LED attached from pin 13 to ground
  - pushbutton attached to pin 2 from +5V
  - 10K resistor attached to pin 2 from ground

  - Note: on most Arduinos there is already an LED on the board
    attached to pin 13.

  created 2005
  by DojoDave <http://www.0j0.org>
  modified 30 Aug 2011
  by Tom Igoe

  This example code is in the public domain.

  http://www.arduino.cc/en/Tutorial/Button
*/

// constants won't change. They're used here to set pin numbers:

// variables will change:
int buttonState = 0;         // variable for reading the pushbutton status
int buttonState1 = 0;
int buttonState2 = 0;         // variable for reading the pushbutton status
int buttonState3 = 0;
int contador = 0;
void setup() {
  Serial.begin(9600);
  // initialize the LED pin as an output:
  pinMode(50, OUTPUT);
  
  // initialize the pushbutton pin as an input:
  pinMode(53, INPUT);
    // initialize the LED pin as an output:
  pinMode(52, OUTPUT);
  
  // initialize the pushbutton pin as an input:
  pinMode(51, INPUT);

  pinMode(32, OUTPUT);
  
  // initialize the pushbutton pin as an input:
  pinMode(31, INPUT);

  pinMode(30, OUTPUT);
  
  // initialize the pushbutton pin as an input:
  pinMode(33, INPUT);



  
}

void loop() {
  // read the state of the pushbutton value:
  contador = contador +1;
  if (contador == 1){
    Serial.println("Inicio juego");
  }
  
  buttonState = digitalRead(53);
  buttonState1 = digitalRead(51);
  buttonState2 = digitalRead(31);
  buttonState3 = digitalRead(33);
  // check if the pushbutton is pressed. If it is, the buttonState is HIGH:
 
  if (buttonState == HIGH) {
    Serial.println("D");
    digitalWrite(50, HIGH);
  } else {
    digitalWrite(50, LOW);
  }
  if (buttonState1 == HIGH) {
    Serial.println("I");
    digitalWrite(52, HIGH);
  } else {
    digitalWrite(52, LOW);
  }
    if (buttonState2 == HIGH) {
    Serial.println("Ar");
    digitalWrite(30, HIGH);
  } else {
    digitalWrite(30, LOW);
  }
    if (buttonState3 == HIGH) {
    Serial.println("Ab");
    digitalWrite(32, HIGH);
  } else {
        
    digitalWrite(32, LOW);
  }
}
