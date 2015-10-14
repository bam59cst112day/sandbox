//////// Exercise x2:  modularize exercise x1, and add dog to chase hero.
//////// Teng Lin  (CST 112; 2015/10/07)

String author=  "Teng Lin";
String title=  " Chasing Dog ";
String help=  " Click to relocate hero \n 'q' to quit; 'r' to reset. ";
String HeroHelp= "HELP!!!";

//// GLOBALS:  coordinates, speed, etc.
float horizon;
float x, y;       // Position.
float dx, dy;     // Speed.
float dogX=200, dogY=450, heroX=250, heroY=250;

//// SETUP:  window size, initialization (start in middle of screen).
void setup() {
  size( 600,600);
  horizon=  height/4;
  x=  width/2;
  y=  height/2;
  dx=  1;
  dy=  1;
}

//// NEXT FRAME:  scene, action, show.
void draw() {
  scene();
  hero();
  dog();
  messages();
 
}

//// SCENE:  sky, sun, tree, house, etc.
void scene() {  
  background(104,186,240);
  fill (0,240,0);
  stroke(0,240,0);
  rect(0,300,600,300);
  
  stroke(162,167,165);
  fill(162,167,165);
  rect(350,150, 200,150);    
  triangle(320,150, 580,150, 450,80); //roof
  rect(370,90,30,50);
  fill(255);
  stroke(255);
  ellipse(360,70, 50,30);
  ellipse(340,50, 60,35);
  
  //sun
  fill(255,255,0);
  ellipse(0, 0, 160,160);
 
   //window
   strokeWeight(1);
   fill(255);
   stroke(0);
   rect(450,150, 60,60);
   stroke(0);
   line(480,150, 480,210);
   line(450,180, 510,180);
   
   //door
   fill(188, 110, 82);
   stroke(188, 110, 82);
   rect(380,220, 60,80);
   fill(255,255,0);
   stroke(255,200,0);
   ellipse(390,260, 15,15);
   
   //tree
   fill(188, 110, 82);
   stroke(188,110,82);
   rect( 150, horizon, 50, 150);  
   stroke(50,247,127);
   fill(50,247,127);
   ellipse( 175,150, 160,160);

}

//// ACTION:  move (x,y) coordinates of hero & dog; show them.
void hero() {
  strokeWeight(1);
  fill(56,182,242);
  stroke(255);
  rect(heroX,heroY, 30,30);                     //head
  rect(heroX-9,heroY+30, 50,65);                //body
  rect(heroX-9, heroY+95, 15,40);               //Left leg
  rect(heroX+26, heroY+95, 15,40);              //Right leg
  rect(heroX-19,heroY+30, 10,40);               //Left arm
  rect(heroX+41,heroY+30, 10,40);               //Right arm
  fill(0);
  ellipse( heroX+10, heroY+10, 5,5);            //Left eye
  ellipse( heroX+25, heroY+10, 5,5);            //Right eye
  stroke(0);
  strokeWeight(3);
  line(heroX+10,heroY+20, heroX+20, heroY+20);  //mouth
  
  if ( dogX > heroX ) {
   text( HeroHelp, heroX-45, heroY+20);
  }
  
  if ( dogX < heroX ) {
  text( HeroHelp, heroX+40, heroY+20);
  }
  
  
  //moving hero
  heroX= heroX + 2*dx;
  heroY= heroY + 2*dy; 
  
  //bounce hero
   if ( heroX < 15 || heroX > 550) {
    dx *= -1;
   }
   if ( heroY < horizon+60 || heroY >460) {
    dy *=-1;
   }
  
      
 }

 
void dog() {
  dogX=  dogX + (heroX-dogX)/50;
  dogY=  dogY + (heroY-dogY)/50;
float headX=dogX+50;
  fill(250,100,10);
  noStroke();
  rect(dogX,dogY, 60,30);                    //body
  
  rect(dogX, dogY+29, 10,20);                //leg
  float toe=dogX;  

  rect(dogX+50, dogY+29, 10,20);
  //text( "woof, woof!!!", dogX+80, dogY );
  //rect(headX, dogY-20, 30,30);             //head
  //fill(255,255,0);
  //ellipse( dogX+70, dogY-10, 5,5);           //eye
  
  if( dogX > heroX ){
    fill(250,100,10);
    headX= dogX-10;
    rect (headX-5, dogY-20, 30,30);
    fill(255,255,0);
    ellipse(dogX, dogY-10, 5,5);
    fill(0);
    text( "woof, woof!!!", dogX-82, dogY );
 }
 
 if ( dogX < heroX){
  fill(250,100,10);
  rect(headX, dogY-20, 30,30);
  fill(255,255,0);
  ellipse( dogX+70, dogY-10, 5,5);
  fill(0);
  text( "woof, woof!!!", dogX+82, dogY );
 }
 
}


void messages() {
  fill(0);
  text( title, width/3, 20 );
  text( help, width*2/3, 30 );
  text( author, 10,height-20 );
  
}



//////// HANDLERS:  mouse clicks, keys
void mousePressed() {
  x=  mouseX;                             // Set (x,y) to mouse
  y=  mouseY;
  //
  dx=  random( 1, 5  );                  // random speed.
  dy=  random( 1, 5  );
}
     
void keyPressed() {
  if (key == 'q') {
    exit();                           // press 'q' key to QUIT.
  }
  if (key== 'r' ) {                   // press 'r' key to RESET.
    heroX=250;
    heroY=250;
    dogX=200;
    dogY=450;
  }
 
}
