Esse jogo é um trabalho da cadeira de Programação Para Jogos I, do curso de Sistemas e Mídias Digitais.
A framework utilizada foi o Processing.
O objetivo é fazer uma recriação do jogo snake classic, trazendo alguns elementos estéticos para cena e a utilização de Programação Orientada a Objeto.
No início do código base é declarado as variáveis que vão ser utilizadas ao longo do jogo, sendo elas responsáveis por introduzir a snake na cena, pontuação, movimentação da snake, comida da snake.
Em seguida são introduzidas as funções que fazem o jogo funcionar (void setup(), void draw()), onde os elementos só serão chamados uma única vez e a função que faz com que os elementos sejam chamados a cada frame, respectivamente.
Dentro da setup() temos atualização e tamanho da cena.
Dentro da draw() temos as principais funções do código, game() e menu(), assim como o marcador de pontos e recorde.
A função game() e menu() trazem todas as outras funções dentro delas, growSnake() e newFood(), exceto pela função keyPressed(), responsável pela movimentação da Snake.
Por fim, temos a criação da classe Snake, onde é tratado cada elemento que constrói a snake como um objeto, desse modo, são traçados os parâmetros de construção e apresentação da mesma na cena.
