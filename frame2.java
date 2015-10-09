void drawFrame2(){
 
 noStroke();
 fill(233,203,141);                    //skin color
 rect(manX-5,manY-35,25,30);           //head
 fill(0,191,243);                      //dark shirt color
 quad(manX+10,manY-3, manX+18,manY-5, manX+25,manY, manX+25,manY+5);  //front arm
 fill(109,207,246);                   //light shirt color
 rect(manX-10,manY-5,25,25);          //bodmanY
 rect(manX-25,manY-10,20,5);          //back upper arm
 fill(233,203,141);                   //skin color
 rect(manX-35,manY,10,10);            //back hand
 fill(109,207,246);                   //light shirt color
 quad(manX-25,manY-10, manX-20,manY-5, manX-25,manY+5, manX-30,manY); //backforearm
 fill(233,203,141);                  //skin color
 rect(manX+20,manY,10,10);           //front hand
 fill(246,150,121);                  //light pants color
 rect(manX-10,manY+20,25,10);        //waist
 quad(manX+15,manY+27, manX+12,manY+30, manX+20,manY+35, manX+25,manY+35); //front leg upper
 rect(manX+20,manY+35,5,20);           //front leg shin
 fill(242,108,79);                     //dark pants color
 quad(manX-10,manY+30, manX-5,manY+30, manX-15,manY+45, manX-20,manY+40);  //back upper leg
 rect(manX-30,manY+40, 15,5);          //back shin
 fill(54,47,45);                       //shoe hair color
 rect(manX-35,manY+40,5,15);           //back shoe
 rect(manX+20,manY+55,15,5);           //front shoe
 rect(manX-5,manY-35, 25, 5);          //hair top bar
 rect(manX-5,manY-30, 10,5);           //hair mid
 rect(manX-5,manY-25, 5,5);            //hair low 
  
}
