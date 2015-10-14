//// Luis

String news="(NO NEWS)";

float b1X=200, b1Y=200, b1W=250, b1H=150;
float b2X=400, b2Y=400, b2W=150, b2H=70;

void setup(){
  size(800,800);
  background(255);
 
}
void draw(){
 
  rectMode(CENTER);
  fill(100,125,130);
  stroke(255,0,255);
  strokeWeight(12);
  
//--  rect(300,300,500,400);
  rect( b1X, b1Y, b1W, b1H );
  rect( b2X, b2Y, b2W, b2H );

  fill(100,1,190);
  textSize(30);

//--    text("CLICK for white",0,100 );
//--  text("CLICK outside for black",0,500 );

  text("CLICK for white", b1X+20-b1W/2, b1Y+20 );
  text("CLICK for red", b2X+10-b2W/2, b2Y+20 );
  text("CLICK outside for black",0,500 );

  fill(255,0,0 );
  text( news, 50,300 );
 
    
}
  void mousePressed() {
   if ( hit( mouseX,mouseY, b1X,b1Y, b1W,b1H ) ) {
        background(255);
   }
   else if ( hit( mouseX,mouseY, b2X,b2Y, b2W,b2H ) ) {
        background(255,0,0);
   } else {
        background(0);
   }
  }


//// OTHER METHODS:  detect "hit"
// Return true if "near"
boolean hit( float x1, float y1, float x2, float y2, float w, float h ) {
  boolean result;

  news=    x1 + ","+ y1;
  news +=  "\n" +  x2 + ","+ y2;
  news +=  "\n" +  w + ","+ h;



  // +++++ STUB ALWAYS RETURNS TRUE!
  if ( abs(x1-x2) < w/2 && abs(y1-y2)<h/2 ) {
    result=  true;
  } else {
    result=false;
  }

  return result;
}

