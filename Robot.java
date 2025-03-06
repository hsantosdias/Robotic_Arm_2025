/* UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA
 * Ciência da Computação
 * Disciplina: Computação Gráfica
 * Alunos: Bruno Boaventura de Oliveira Lacerda
 *         Hugo Santos Dias
 * Professor: Bruno Silvério Costa
 */



import java.applet.Applet;
import java.awt.*;
import java.*;


//classe principal do braço robo

public class Robot extends Applet
    implements Runnable
{

    public void init()
    {
        appletWidth = size().width; //pega os valores no html
        appletHeight = size().height; //pega os valores no html
        bufferImage = createImage(appletWidth, appletHeight); 
        bufferGraphics = bufferImage.getGraphics();
        img = getImage(getCodeBase(), "uesb.gif");
        render(); //chama o objeto render
			
    }

    public void paint(Graphics g) //desenha os graficos na tela 
    {
       g.drawImage(bufferImage, 0, 0, this); //desenha o braço robo na tela
       
       g.drawImage(img, 5, 5, 70, 90, this); //imprime a logo da uesb

       g.setColor(Color.lightGray); //define a cor do texto.

       g.setFont(f1); 
       g.drawString("Universidade Estadual do Sudoeste da Bahia", 90, 20);
 
 	   g.setFont(f6); 
       g.drawString("Curso: Bacharelado em Ciência da Computação", 90, 45);

       g.setFont(f3); 
       g.drawString("Professor: Bruno Silvério Costa", 90, 60);


 	   g.setFont(f3); 
       g.drawString("Alunos: Hugo Santos Dias / Bruno Boaventura ", 90, 75);
             
      
       showStatus("Clique com o mouse na viewport para começar."); 		           

        }

    public void update(Graphics g) //atualizar constantimente os graficos
    {
        paint(g);
    }

//renderiza toda a viewport com seus elementos
    void render()
    {
        //infelizmente não funciona o thread
      //setLayout(new BorderLayout());
      //add( new Label("Projeto de Computação Grafica - Braço Robo"), BorderLayout.NORTH);
      //add( new Label("Hugo Santos Dias / Bruno Boaventura"), BorderLayout.SOUTH);

 
        graphics = bufferGraphics;
        graphics.setColor(Color.black); //cor de fundo da viewports
        graphics.fillRect(0, 0, appletWidth, appletHeight);
        Matrix worldmat = new Matrix();
        Point3d worldpt = new Point3d();
        World world = new World();
        Matrix mat = new Matrix();
        mat.RotateY(viewrotx);
        mat.RotateX(viewroty);
        mat.RotateZ(viewrotz);
        Point3d pt = new Point3d(0.0F, 0.0F, (float)(-viewpos));
        pt.Rotate(mat, pt);
        worldmat = mat.Transpose();
        worldpt = pt.Neg();
        worldpt.Rotate(worldmat, worldpt);
        world.Draw(worldmat, worldpt);
//      Escreve teste = new Escreve ();
//      showStatus("Alunos: Hugo Santos Dias / Bruno Boaventura.");
        
        
    }
    
     
//public
 public class nome extends java.applet.Applet{ 	 // cria a classe Nome e herda o as definições pré-desenvolvidas em java.applet.Applet.
    public void paint (Graphics g)
    {  
         g.drawString("Bem Vindos!",5,25);  
     } 	// Recebe o objeto "g" do tipo Graphics e passa para ele o método drawString com os parâmetros (mensagem, linha e coluna)
}

//void nomes ()
//{ 	
//
//}

	//aguarda eventos do mouse
    public boolean mouseDown(Event evt, int x, int y)
    {
        mouse_x = x;
        mouse_y = y;
        return true;
    }

    public boolean mouseUp(Event evt, int x, int y)
    {
        int dx = x - mouse_x;
        int dy = y - mouse_y;
        mouse_ang1 += (double)dx / 100D;
        mouse_ang2 += (double)dy / 100D;
        return true;
    }

//tecla em down
    public boolean keyDown(Event evt, int key)
    {
        if(this.key != key)
        {
            time_down = evt.when;
            this.key = key;
        }
        return true;
    }
//tecla em up
    public boolean keyUp(Event evt, int key)
    {
        time_up = evt.when;
        return true;
    }

//mover braco
    boolean moveRobot()
    {
        long diff;
        if(time_up != 0L)
        {
            diff = time_up - time_down;
            time_down = 0L;
            time_up = 0L;
            key = 0;
        } else
        if(time_down != 0L)
        {
            long time_new = System.currentTimeMillis();
            diff = time_new - time_down;
            time_down = time_new;
        } else
        {
            return false;
        }
        float delay = (float)diff / 50F;
        switch(key)
        {
        case 1006: //left
            ang1 += 0.040000000000000001D * (double)delay;
            break;

        case 1007: //rigth
            ang1 -= 0.040000000000000001D * (double)delay;
            break;

        case 1000: //home
            ang3 -= 0.040000000000000001D * (double)delay;
            break;

        case 1001: //ACTION_EVENT 
            ang3 += 0.040000000000000001D * (double)delay;
            break;

        case 1005: //LOST_FOCUS 
            ang2 += 0.040000000000000001D * (double)delay;
            break;

        case 1004: //GOT_FOCUS 
            ang2 -= 0.040000000000000001D * (double)delay;
            break;

        //case 45: // '-'
        case 1002: //PGUP
            stringlen = (int)((float)stringlen - 3F * delay);
            if(stringlen < 10)
                stringlen = 10;
            break;

      //  case 43: // '+'
        case 1003: //PGDN
            stringlen = (int)((float)stringlen + 3F * delay);
            if(stringlen > 150)
                stringlen = 150;
            break;

        case 42: // '*' 
            popen = (int)((float)popen + delay);
            if(popen > 20)
                popen = 20;
            break;

        case 47: // '/'
            popen = (int)((float)popen - delay);
            if(popen < 0)
                popen = 0;
            break;

        case 54: // '6'
            viewrotx += 0.040000000000000001D * (double)delay;
            break;

        case 52: // '4'
            viewrotx -= 0.040000000000000001D * (double)delay;
            break;

        case 50: // '2'
            viewroty += 0.040000000000000001D * (double)delay;
            break;

        case 56: // '8'
            viewroty -= 0.040000000000000001D * (double)delay;
            break;

        case 57: // '9'
            viewrotz += 0.040000000000000001D * (double)delay;
            break;

        case 51: // '3'
            viewrotz -= 0.040000000000000001D * (double)delay;
            break;

        case 55: // '7'
            viewpos -= 8F * delay;
            break;

        case 49: // '1'
            viewpos += 8F * delay;
            break;

        case 1008: //F1
            viewrotx = 0.0D;
            viewroty = -1.500000000000001D;
            viewrotz = 0.0D;
            viewpos = 800D;
            break;

        case 1009: //F2
            viewrotx = 0.0D;
            viewroty = 1.5600000000000001D;
            viewrotz = 0.0D;
            viewpos = 800D;
            break;

        case 1010: //F3
            viewrotx = 0.0D;
            viewroty = -0.60000000000000009D;
            viewrotz = 0.0D;
            viewpos = 800D;
            break;

        case 1011: //F4
            viewrotx = 0.0D;
            viewroty = 0.52000000000000002D;
            viewrotz = 0.0D;
            viewpos = 800D;
            break;

        case 1012: //F5
            viewrotx = 0.0D;
            viewroty = 0.0D;
            viewrotz = 0.0D;
            viewpos = 800D;
            break;

        case 1013: //F6
            viewrotx = 1.52000000000000002D;
            viewroty = 0.0D;
            viewrotz = 0.0D;
            viewpos = 800D;
            break;

        case 1014: //F7
            viewrotx = 0.28000000000000003D;
            viewroty = 1.1599999999999999D;
            viewrotz = 0.60999999999999999D;
            break;
        
                  
        }
        
        
        if(ang2 > 1.24D)
            ang2 = 1.24D;
        if(ang2 < -1.24D)
            ang2 = -1.24D;
        if(ang3 > 1.24D)
            ang3 = 1.24D;
        if(ang3 < -1.24D)
            ang3 = -1.24D;
        return true;
    }

//começa o thread
    public void start()
    {
        ligar = new Thread(this);
        ligar.setPriority(3);
        ligar.start();
    }
//para a execução
    public void stop()
    {
        ligar.stop();
        ligar = null;
    }

//roda o processo
    public void run()
    {
        do
        {
            for(; moveRobot(); Thread.yield())
            {
                try
                {
                    render();
                }
                catch(ArithmeticException _ex) { }
                paint(getGraphics());
                System.gc();
            }

            Thread.yield();
        } while(true);
    }


//inicializa com false ate o primeiro clique do mouse
    public Robot()
    {
        mouse_mode = false;
        
    }

	//definição das variaveis
    boolean mouse_mode; 
    static Graphics graphics; 
    static Image bufferImage;
    static Graphics bufferGraphics;
    static int appletWidth;
    static int appletHeight;
    static double mouse_ang1;
    static double mouse_ang2;
    static double mouse_ang3;
    static double ang1;
    static double ang2;
    static double ang3;
    static int stringlen = 41;
    static int popen = 15;
    static Matrix grabmat;
    static double viewrotx;
    static double viewroty;
    static double viewrotz;
    static double viewpos = 800D;
    static int mouse_x;
    static int mouse_y;
    long time_down;
    long time_up;
    int key;
    //definição do thread
    Thread ligar;
    Image img;
    Font f1 = new Font("Helvetica", Font.PLAIN, 18);
	Font f2 = new Font("Helvetica", Font.BOLD, 10);
    Font f3 = new Font("Helvetica", Font.ITALIC, 12);	
	Font f4 = new Font("Courier",   Font.PLAIN, 12);
	Font f5 = new Font("TimesRoman", Font.BOLD + Font.ITALIC, 14);
	Font f6 = new Font("Dialog", Font.ITALIC, 14);

    
	//definicão inicial dos angulos do braço
    static 
    {
        mouse_ang1 = 0.28000000000000003D;
        mouse_ang2 = 1.1599999999999999D;
        mouse_ang3 = 0.60999999999999999D;
        ang1 = mouse_ang1;
        ang2 = mouse_ang2;
        ang3 = mouse_ang3;
    }
}