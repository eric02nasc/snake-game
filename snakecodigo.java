//Início do jogo
boolean start, gameMenu;

// Snake na cena
Snake[]sn;
int snakeStroke = 40; // espessura da snake 
int snakeSizeInitial = 3, snakeSize; //comprimento da snake 
//Pontuação
int scores, bestScore;
// move da snake
int  x = 1 , y; 
int textBlink = 0, blink = 54;
//Comida
Snake food = new Snake(0, 0, snakeStroke, snakeStroke, #B7A929); 

void setup(){
    size(600,600);
    height = 600;
    frameRate(7); // atualização da cena
 
}
void draw(){
    if(start == true && gameMenu == true) game(); 
    else menu();
    
    //Pontos e Recordes
    fill(0);
    rect(0, 540, width ,60);
    fill(255);
    textSize(30);
    textAlign(LEFT);
    text("Pontos " + scores, 20, 580);
    text("Recorde " + bestScore, 320, 580);
    
    println(textBlink);
}


void menu(){
    gameMenu = false;
    //Apresentação menu
    background(21,23,44);
    textSize(50);
    textAlign(CENTER,CENTER);
    fill(255);
    text("Game Snake", width/2, height/3);
    
    //Texto Start
    textBlink += blink; //Faz o texto brilhar
    if(textBlink >= 255) blink *=-1;
    else if(textBlink == 0) blink *=-1;
    fill(textBlink);
    text("Press 'S' ",width/2, height/2);
    
    
    
    if(start == true){
        x = 1;
        y = 0;
        snakeSize = snakeSizeInitial;
        scores = 0;
        gameMenu = true;
        growSnake();
    }
}

void growSnake(){
  snakeSize++;
  color c = #B7A929;
  int[][] xy = new int[2][snakeSize];
  
  for(int i = 0; i < snakeSize-1; i++){
        if(snakeSize > snakeSizeInitial + 1){
            xy[0][1] = sn[i].x;
            xy[1][i] = sn[i].y;
        } else{
            xy[0][i] = snakeStroke*5;
            xy[1][i] = snakeStroke*2;
        }
    
  }
  
  sn = new Snake[snakeSize];
  
  for(int i = 0; i < snakeSize; i++){
        sn[i] = new Snake(xy[0][1], xy[1][i],snakeStroke,snakeStroke,c);
  }
  sn[0].c = #A24700;
  newFood();
}

void newFood(){
    boolean f = false;
    while(!f){
        f = true;
        food.x = int(random(width/snakeStroke)) * snakeStroke;
        food.y = int(random(height/snakeStroke)) * snakeStroke;
    
    for(int i = 0; i < snakeSize; i++){
        if(food.x == sn[i].x && food.y == sn[i].y) f =  false;
    }
 }
}

void game(){
  background(#4BB42F);
  
    for(int i = snakeSize - 1; i >= 0; i--){
        if(i == 0){
            sn[i].show(x,y); // move da snake
        }else{
            sn[i].x = sn[i-1].x;
            sn[i].y = sn[i-1].y;
            sn[i].show(0,0);
        }   
        if((i > 4 && sn[0].x == sn[i].x && sn[0].y == sn[i].y) 
            || sn[0].x < 0 || sn[0].y < 0 
            || sn[0].x > width - snakeStroke || sn[0].y > height - snakeStroke){
            start = false;
        }
    }
    food.show(0,0);
 
    //Colisão com a comida
    if(sn[0].x == food.x && sn[0].y == food.y){
        scores += 15;
        if(scores > bestScore) bestScore = scores;
        growSnake();
    }
}


void keyPressed(){
    if(keyCode == LEFT){
        x = -1;
        y = 0;   
    } else if (keyCode == UP && y == 0){
        y = -1;
        x = 0;
    } else if (keyCode == RIGHT && x == 0){
        x = 1;
        y = 0;
    } else if (keyCode == DOWN && y == 0){
        y = 1;
        x = 0;
    } else if (keyCode == 'S' && !start) start = true;
 
}