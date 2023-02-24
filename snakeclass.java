class Snake {
    int x, y, w, h;
    color c;
    
    Snake(int Sx, int Sy, int Sw, int Sh, color Sc) {
    x = Sx;
    y = Sy;
    w = Sw;
    h = Sh;
    c = Sc;
}
 void  show(float vx, float vy) {

    x += vx*w;
    y += vy*h;
    fill(c);
    rect(x, y, w, h, 15);
 }
}