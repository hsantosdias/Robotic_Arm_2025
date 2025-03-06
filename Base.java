/* UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA
 * Ciência da Computação
 * Disciplina: Computação Gráfica
 * Alunos: Hugo Santos Dias & Bruno Boaventura de Oliveira Lacerda
 *         
 * Professor: Bruno Silvério Costa
 */

//base fixa para o componetes do braço robo
import java.awt.Color;
import java.awt.Graphics;

class Base extends Shape
{

    void Draw(Matrix viewmatold, Point3d relpt)
    {
        Matrix viewmat = viewmatold.copy();
        viewmat.RotateX(1.5700000000000001D);
        DoPoint(0, viewmat, relpt, -47, -113, 0);
        DoPoint(1, viewmat, relpt, 47, -113, 0);
        DoPoint(2, viewmat, relpt, 113, -47, 0);
        DoPoint(3, viewmat, relpt, 113, 47, 0);
        DoPoint(4, viewmat, relpt, 47, 113, 0);
        DoPoint(5, viewmat, relpt, -47, 113, 0);
        DoPoint(6, viewmat, relpt, -113, 47, 0);
        DoPoint(7, viewmat, relpt, -113, -47, 0);
        DoPoint(8, viewmat, relpt, -47, -113, 20);
        DoPoint(9, viewmat, relpt, 47, -113, 20);
        DoPoint(10, viewmat, relpt, 113, -47, 20);
        DoPoint(11, viewmat, relpt, 113, 47, 20);
        DoPoint(12, viewmat, relpt, 47, 113, 20);
        DoPoint(13, viewmat, relpt, -47, 113, 20);
        DoPoint(14, viewmat, relpt, -113, 47, 20);
        DoPoint(15, viewmat, relpt, -113, -47, 20);
        DoPoint(16, viewmat, relpt, 0, 0, 20);
        Robot.graphics.setColor(Color.blue); //cor da base
        DrawLine(4, 0, 1);
        DrawLine(4, 1, 2);
        DrawLine(4, 2, 3);
        DrawLine(4, 3, 4);
        DrawLine(4, 4, 5);
        DrawLine(4, 5, 6);
        DrawLine(4, 6, 7);
        DrawLine(4, 7, 0);
        DrawLine(4, 8, 9);
        DrawLine(4, 9, 10);
        DrawLine(4, 10, 11);
        DrawLine(4, 11, 12);
        DrawLine(4, 12, 13);
        DrawLine(4, 13, 14);
        DrawLine(4, 14, 15);
        DrawLine(4, 15, 8);
        DrawLine(4, 0, 8);
        DrawLine(4, 1, 9);
        DrawLine(4, 2, 10);
        DrawLine(4, 3, 11);
        DrawLine(4, 4, 12);
        DrawLine(4, 5, 13);
        DrawLine(4, 6, 14);
        DrawLine(4, 7, 15);
        Support obj = new Support();
        obj.Draw(viewmat, super.points[16]);
    }

    Base()
    {
    }
}