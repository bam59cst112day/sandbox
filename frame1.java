void drawFrame1(){
 
 noStroke();
 fill(233,203,141);                    //skin color
 rect(manX-5,manY-40,25,30);           //head
 fill(0,191,243);                      //dark shirt color
 quad(manX+10,manY-8, manX+18,manY-10, manX+25,manY-5, manX+25,manY);  //front arm
 fill(109,207,246);                    //light shirt color
 rect(manX-10,manY-10,25,25);          //bodmanY
 rect(manX-25,manY-15,20,5);           //back upper arm
 fill(233,203,141);                    //skin color
 rect(manX-35,manY-5,10,10);           //back hand
 fill(109,207,246);                    //light shirt color
 quad(manX-25,manY-15, manX-20,manY-10, manX-25,manY, manX-30,manY-5); //backforearm
 fill(233,203,141);                    //skin color
 rect(manX+20,manY-5,10,10);           //front hand
 fill(246,150,121);                    //light pants color
 rect(manX-10,manY+15,25,10);          //waist
 quad(manX+15,manY+22, manX+12,manY+25, manX+35,manY+50, manX+40,manY+50); //front leg
 fill(242,108,79);                     //dark pants color
 quad(manX-10,manY+25, manX-5,manY+25, manX-15,manY+40, manX-20,manY+35);  //back upper leg
 rect(manX-35,manY+35, 20,5);          //back shin
 fill(54,47,45);                       //shoe hair color
 rect(manX-40,manY+35,5,15);           //back shoe
 quad(manX+35,manY+50, manX+38,manY+55,  manX+51,manY+49, manX+48,manY+45); //front shoe
 rect(manX-5,manY-40, 25, 5);          //hair top bar
 rect(manX-5,manY-35, 10,5);           //hair mid
 rect(manX-5,manY-30, 5,5);            //hair low

}
