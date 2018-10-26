/*
Control para Proyecto Game of Sorts (GoS)
Realizado por Alejandro Loría

Este programa captura el estado de los botones de la placa joystick,
para enviar un String con la acción que debe realizar el boton que se presionó.

Hay 5 botones para las funciones:
--UP
--Down
--RIGHT
--LEFT
--SHOOT

Hay un LED que se enciende cada vez que se hace un disparo

*/

//Definición de las etiquetas para los botones

#define B_Up 12
#define B_Right 11
#define B_Left 10 
#define B_Down 9
#define B_Shoot 8
#define Y_Led 7


void setup() {
  // Se inicializa el puerto serie a 9600 baudios
  Serial.begin(9600);
  
  // Se inicializan los pines para los botones como entrada
  pinMode(B_Up, INPUT);
  pinMode(B_Right, INPUT);
  pinMode(B_Left, INPUT);
  pinMode(B_Down, INPUT);
  pinMode(B_Shoot, INPUT);
  
  // Se inicaliza el pin para el LED como salida
  pinMode(Y_Led, OUTPUT);
}

void loop() {
  
  // En el lazo principal se hace pulling esperando que alguno de los botones 
  // haya cambiado de estado, se detecta el cambio mediante un IF y cuando alguno
  // de estos se cumpla, se envia el String con la acción que representa el botón presionado.
  if (digitalRead(B_Up))  {
    delay(10); 
    Serial.println("UP");    
    }
  if (digitalRead(B_Right)) {
    delay(10);
    Serial.println("RIGHT");
    } 
  if (digitalRead(B_Left)) {
     delay(10);
    Serial.println("LEFT");    
    }
  if (digitalRead(B_Down)) {
     delay(10);
    Serial.println("DOWN");    
    }
  if (digitalRead(B_Shoot)) {
    Serial.println("SHOOT");    
    digitalWrite(Y_Led, HIGH);
    delay(200);

    }
  delay(10);
  digitalWrite(Y_Led, LOW);     
}
