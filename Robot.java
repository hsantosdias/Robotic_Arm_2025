/*
 * PROJETO: Braço Robótico 3D em Java
 * AUTOR: Hugo Santos Dias
 * GITHUB: https://github.com/hsantosdias
 * LINKEDIN: https://www.linkedin.com/in/hugo-santos-dias/
 * DESCRIÇÃO: Simulação e renderização de um braço robótico interativo, 
 *            agora com interface Swing atualizada e controles de objetos.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//classe principal do braÃ§o robo

public class Robot extends JPanel implements Runnable, MouseListener, MouseMotionListener, KeyListener
{
    private volatile boolean running = false;
    public static boolean objectGrabbed = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Projeto de Computacao Grafica - Braco Robo");
        frame.setLayout(new BorderLayout());
        
        Robot robot = new Robot();
        frame.add(robot, BorderLayout.CENTER);
        
        JButton helpBtn = new JButton("Comandos de Movimentacao");
        helpBtn.addActionListener(e -> JOptionPane.showMessageDialog(frame,
            "COMANDOS DO BRACO:\n\n" +
            "Setas Esquerda/Direita: Gira a base\n" +
            "Setas Cima/Baixo: Move a articulacao central\n" +
            "Home / End: Move a articulacao da ponta\n" +
            "Teclas * e /: Abre e fecha a pinca\n" +
            "Tecla G: Pega / Solta o objeto (Cubo)\n\n" +
            "Movimentacao da Camera (Mouse ou Teclas 1 a 9):\n" +
            "Arraste o mouse para girar a camera.\n" +
            "F1 a F7: Visoes predefinidas de camera.", 
            "Comandos", JOptionPane.INFORMATION_MESSAGE));
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(helpBtn);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        robot.init();
        robot.start();
        robot.requestFocusInWindow();
    }

    public Robot() {
        mouse_mode = false;
        setFocusable(true);
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
    }

    public void init()
    {
        appletWidth = getWidth();
        appletHeight = getHeight();
        bufferImage = createImage(appletWidth, appletHeight); 
        if (bufferImage != null) {
            bufferGraphics = bufferImage.getGraphics();
        }
        img = new ImageIcon("uesb.gif").getImage();
        render(); //chama o objeto render
    }

    public void paintComponent(Graphics g) //desenha os graficos na tela 
    {
       super.paintComponent(g);
       if (bufferImage != null) {
           g.drawImage(bufferImage, 0, 0, this); //desenha o braÃ§o robo na tela
       }
       
       g.drawImage(img, 5, 5, 70, 90, this); //imprime a logo da uesb

       g.setColor(Color.lightGray); //define a cor do texto.

       g.setFont(f1); 
       g.drawString("Universidade Estadual do Sudoeste da Bahia", 90, 20);
 
 	   g.setFont(f6); 
       g.drawString("Curso: Bacharelado em CiÃªncia da ComputaÃ§Ã£o", 90, 45);

       g.setFont(f3); 
       g.drawString("Professor: Bruno SilvÃ©rio Costa", 90, 60);

 	   g.setFont(f3); 
       g.drawString("Alunos: Hugo Santos Dias / Bruno Boaventura ", 90, 75);
             
       g.drawString("Clique com o mouse na viewport para comeÃ§ar.", 90, 90); 		           
    }

    public void update(Graphics g) //atualizar constantimente os graficos
    {
        paintComponent(g);
    }

//renderiza toda a viewport com seus elementos
    void render()
    {
        //infelizmente nÃ£o funciona o thread
      //setLayout(new BorderLayout());
      //add( new Label("Projeto de ComputaÃ§Ã£o Grafica - BraÃ§o Robo"), BorderLayout.NORTH);
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
    
     
	//aguarda eventos do mouse
    public void mousePressed(MouseEvent evt)
    {
        mouse_x = evt.getX();
        mouse_y = evt.getY();
    }

    public void mouseReleased(MouseEvent evt)
    {
        int dx = evt.getX() - mouse_x;
        int dy = evt.getY() - mouse_y;
        mouse_ang1 += (double)dx / 100D;
        mouse_ang2 += (double)dy / 100D;
    }
    
    public void mouseClicked(MouseEvent evt) {}
    public void mouseEntered(MouseEvent evt) {}
    public void mouseExited(MouseEvent evt) {}
    public void mouseDragged(MouseEvent evt) {}
    public void mouseMoved(MouseEvent evt) {}

//tecla em down
    public void keyPressed(KeyEvent evt)
    {
        int mappedKey = mapKey(evt);
        if(this.key != mappedKey)
        {
            time_down = evt.getWhen();
            this.key = mappedKey;
        }
    }
//tecla em up
    public void keyReleased(KeyEvent evt)
    {
        time_up = evt.getWhen();
    }
    
    public void keyTyped(KeyEvent evt) {}

    private int mapKey(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_G:
                objectGrabbed = !objectGrabbed;
                return 0; // custom event handled directly
            case KeyEvent.VK_LEFT: return 1006;
            case KeyEvent.VK_RIGHT: return 1007;
            case KeyEvent.VK_HOME: return 1000;
            case KeyEvent.VK_END: return 1001;
            case KeyEvent.VK_UP: return 1004;
            case KeyEvent.VK_DOWN: return 1005;
            case KeyEvent.VK_PAGE_UP: return 1002;
            case KeyEvent.VK_PAGE_DOWN: return 1003;
            case KeyEvent.VK_F1: return 1008;
            case KeyEvent.VK_F2: return 1009;
            case KeyEvent.VK_F3: return 1010;
            case KeyEvent.VK_F4: return 1011;
            case KeyEvent.VK_F5: return 1012;
            case KeyEvent.VK_F6: return 1013;
            case KeyEvent.VK_F7: return 1014;
        }
        return e.getKeyChar();
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

//comeÃ§a o thread
    public void start()
    {
        if (ligar == null) {
            running = true;
            ligar = new Thread(this);
            ligar.setPriority(3);
            ligar.start();
        }
    }
//para a execuÃ§Ã£o
    public void stop()
    {
        running = false;
        ligar = null;
    }

//roda o processo
    public void run()
    {
        while(running)
        {
            for(; moveRobot(); Thread.yield())
            {
                if (!running) break;
                try
                {
                    render();
                }
                catch(ArithmeticException _ex) { }
                repaint();
                System.gc();
            }

            Thread.yield();
        }
    }

	//definiÃ§Ã£o das variaveis
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
    //definiÃ§Ã£o do thread
    Thread ligar;
    Image img;
    Font f1 = new Font("Helvetica", Font.PLAIN, 18);
	Font f2 = new Font("Helvetica", Font.BOLD, 10);
    Font f3 = new Font("Helvetica", Font.ITALIC, 12);	
	Font f4 = new Font("Courier",   Font.PLAIN, 12);
	Font f5 = new Font("TimesRoman", Font.BOLD + Font.ITALIC, 14);
	Font f6 = new Font("Dialog", Font.ITALIC, 14);

    
	//definicÃ£o inicial dos angulos do braÃ§o
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