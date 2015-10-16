//// X5:  collisions.
//// (Assume ball diameter of 30.)

//// GLOBALS:  pool table, 3 colored balls

String title=  "ELASTIC COLLISIONS";
String news=   "Use 'r' key to reset.";
String author=  "Emmett Woytovich";

int balldiam = 30;
double friction = 1.0 + 7E-9 ;

float left, right, top, bottom;//John Allen
//Project 2 Code


//Global Variables
float left,right,top,bottom;



void setup(){
  size(640,480);
  background(100,150,250);
}

void draw(){
  table();
  balls();
  bounce();
  collision();
}

//Green Table with blue background
void table(){
  rectMode(CORNERS);
  fill(10,200,100);
  strokeWeight(20);
  stroke(127,0,0);
  rect(width/10,height/2,width);
}

//Just drawing color and balls
void balls(){
}

//Bouncing off of the walls
void bounce(){
}

//Bouncing off of each other
void collision(){
}
float middle;

double cueX,  cueY,  cueDX,  cueDY;
float redX,  redY,  redDX,  redDY;
float yelX,  yelY,  yelDX,  yelDY;
float bluX, bluY, bluDX, bluDY;

float modX,modY;

float pW = 1;


//// SETUP:  size and table
void setup() {
  size( 600, 400 );
  rectMode( CORNERS );
  left=   50;
  right=  width-50;
  top=    100;
  bottom= height-50;
  middle= left + (right-left) / 2;
  //
  reset();
 }
 void reset() {
   cueX=  left + (right-left) / 4;
   cueY=  top + (bottom-top) / 2;
   // Random positions.
   redX=  random( middle,right );   redY=  random( top, bottom );
   yelX=  random( middle,right );   yelY=  random( top, bottom );
   if(dist(redX,redY, yelX,yelY) <= balldiam){ reset(); }
   bluX=  random( middle,right );   bluY=  random( top, bottom );
   if(dist(bluX,bluY, yelX,yelY) <= balldiam){ reset(); }
   if(dist(redX,redY, bluX,bluY) <= balldiam){ reset(); }
   // Random speeds
   redDX=  random( 0,5 );   redDY=  random( -5,5 );
   yelDX=  random( 0,5 );   redDY=  random( -5,5 );
   bluDX=  random( 0,5 );   bluDY=  random( -5,5 );
   cueDX = 0; cueDY = 0;
 }

//// NEXT FRAME:  table, bounce off walls, collisions, show all
void draw() {
  background( 250,250,200 );  
  table( left, top, right, bottom );
  bounce();
  pointer();
  collisions();
  show();
  messages();
  rButton();
}

//// SCENE:  draw the table with walls
void table( float left, float top, float right, float bottom ) {
  fill( 100, 250, 100 );    // green pool table
  strokeWeight(10);
  stroke( 127, 0, 0 );      // Brown walls
  rect( left-20, top-20, right+20, bottom+20 );
  
}

//// ACTION:  bounce off walls, collisions
void bounce() {
  redX += redDX;  if ( redX<=left || redX>=right ) redDX = -redDX;
  redY += redDY;  if ( redY<=top || redY>=bottom ) redDY =  -redDY;
  redDX = float( redDX/friction );
  redDY = redDY/friction;
  
  
  bluX += bluDX;  if ( bluX<left || bluX>right ) bluDX *= -1;
  bluY += bluDY;  if ( bluY<top || bluY>bottom ) bluDY *=  -1;
  bluDX = bluDX/friction;
  bluDY = bluDY/friction;
  
  yelX += yelDX;  if ( yelX<left || yelX>right ) yelDX *= -1;
  yelY += yelDY;  if ( yelY<top || yelY>bottom ) yelDY *=  -1;
  yelDX = yelDX/friction;
  yelDY = yelDY/friction;
  
  cueX += cueDX;  if ( cueX<left || cueX>right ) cueDX *= -1;
  cueY += cueDY;  if ( cueY<top || cueY>bottom ) cueDY *=  -1;
  cueDX = cueDX/friction;
  cueDY = cueDY/friction;
}
void collisions() {
  float tmp;
  // Swap velocities!
  if ( dist( redX,redY, yelX,yelY ) <= balldiam ) {
    tmp=yelDX;  yelDX=+redDX;  redDX=+tmp;
    tmp=yelDY;  yelDY=+redDY;  redDY=+tmp;
  }
  if ( dist( redX,redY, bluX,bluY ) <= balldiam ) {
    tmp=bluDX;  bluDX=+redDX;  redDX=+tmp;
    tmp=bluDY;  bluDY=+redDY;  redDY=+tmp;
  }
  if ( dist( bluX,bluY, yelX,yelY ) <= balldiam ) {
    tmp=yelDX;  yelDX=+bluDX;  bluDX=+tmp;
    tmp=yelDY;  yelDY=+bluDY;  bluDY=+tmp;
  }
  if ( dist( cueX,cueY, yelX,yelY ) <= balldiam ) {
    tmp=yelDX;  yelDX=+cueDX;  cueDX=+tmp;
    tmp=yelDY;  yelDY=+cueDY;  cueDY=+tmp;
  }
  if ( dist( cueX,cueY, bluX,bluY ) <= balldiam ) {
    tmp=bluDX;  bluDX=+cueDX;  cueDX=+tmp;
    tmp=bluDY;  bluDY=+cueDY;  cueDY=+tmp;
  }
  if ( dist( cueX,cueY, redX,redY ) <= balldiam ) {
    tmp=redDX;  redDX=+cueDX;  cueDX=+tmp;
    tmp=redDY;  redDY=+cueDY;  cueDY=+tmp;
  }
}

//// SHOW:  balls, messages
void show() {
  noStroke();
  
  fill( 255,0,0 );        ellipse( redX,redY, balldiam,balldiam );
  fill(0); text("Red", redX-10, redY+3);
  fill( 255,255,0 );      ellipse( yelX,yelY, balldiam,balldiam );
  fill(0); text("Yel", yelX-10, yelY+3);
  fill( 0,0,255 );        ellipse( bluX,bluY, balldiam,balldiam );
  fill(255); text("Blu", bluX-10, bluY+3);
  fill( 255,255,255 );    ellipse( cueX,cueY, balldiam,balldiam );
  fill(0); text("Cue", cueX-10, cueY+3);
}
void messages() {
  fill(0);
  text( title, width/3, 20 );
  text( news, width/3, 40 );
  text( author, 10, height-10 );
}

void pointer(){
  fill(0);
  strokeWeight(pW);  
  line(cueX,cueY,mouseX,mouseY);
  strokeWeight(1);
  pW = 1;
}

//// HANDLERS:  keys, click
void mousePressed(){
  if(mouseX > 10 && mouseX < 50 && mouseY > 10 && mouseY < 50){
    reset();
  }
  else{
    //--      cueDX = cueDX + (cueX - mouseX)/50;
    cueDX += (cueX - mouseX)/50;
    //--  cueDY = cueDY + (cueY - mouseY)/50;
    cueDY =+ (cueY - mouseY)/50;

    pW = dist(cueX,cueY,mouseX,mouseY)/25;  
  }
  
}

void keyPressed() {
  if (key == 'r') {
    reset();
  }
}

void rButton(){
  fill(0);
  rect(10,10,50,50);
  text("Reset", 60,30);
}
