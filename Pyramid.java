/* UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA
 * Ciência da Computação
 * Disciplina: Computação Gráfica
 * Alunos: Bruno Boaventura de Oliveira Lacerda
 *         Hugo Santos Dias
 * Professor: Bruno Silvério Costa
 */


//faz parte do pincel do braço robo
import java.awt.Color;
import java.awt.Graphics;

class Pyramid extends Shape
{

    void Draw(Matrix viewmatold, Point3d relpt)
    {
        Matrix viewmat = viewmatold.copy();
        DoPoint(10, viewmat, relpt, 0, 0, 0);
        DoPoint(11, viewmat, relpt, 0, Robot.stringlen, 0);
        relpt = super.points[11];
        DoPoint(0, viewmat, relpt, 40, 20, 20);
        DoPoint(1, viewmat, relpt, -40, 20, 20);
        DoPoint(2, viewmat, relpt, 40, 20, -20);
        DoPoint(3, viewmat, relpt, -40, 20, -20);
        DoPoint(4, viewmat, relpt, 0, 0, 0);
        Robot.graphics.setColor(Color.green);
        DrawLine(15, 10, 11);
        Robot.graphics.setColor(Color.gray);
        DrawLine(9, 0, 1);
        DrawLine(9, 2, 3);
        DrawLine(9, 0, 2);
        DrawLine(9, 1, 3);
        DrawLine(9, 0, 4);
        DrawLine(9, 1, 4);
        DrawLine(9, 2, 4);
        DrawLine(9, 3, 4);
        DoPoint(5, viewmat, relpt, Robot.popen, 20, 0);
        DoPoint(6, viewmat, relpt, -Robot.popen, 20, 0);
//        viewmat.RotateZ(-3.1400000000000001D);
        Pincer obj = new Pincer();
        obj.Draw(viewmat, super.points[5]);
        viewmat.RotateY(3.1400000000000001D);
  //      Pincer obj1 = new Pincer();
  //      obj1.Draw(viewmat, super.points[5]);
 //       viewmat.RotateZ(2.1400000000000001D);
        Pincer obj2 = new Pincer();
        obj2.Draw(viewmat, super.points[6]);
    }

    Pyramid()
    {
    }
}