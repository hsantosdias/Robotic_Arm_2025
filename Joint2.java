/* UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA
 * Ciência da Computação
 * Disciplina: Computação Gráfica
 * Alunos: Bruno Boaventura de Oliveira Lacerda
 *         Hugo Santos Dias
 * Professor: Bruno Silvério Costa
 */

//terceira junta do braço
import java.awt.Color;
import java.awt.Graphics;

class Joint2 extends Shape
{

    void Draw(Matrix viewmatold, Point3d relpt)
    {
        Matrix viewmat = viewmatold.copy();
        viewmat.RotateX(Robot.ang3);
        DoPoint(0, viewmat, relpt, -12, -28, 20);
        DoPoint(1, viewmat, relpt, 12, -28, 20);
        DoPoint(2, viewmat, relpt, 28, -12, 20);
        DoPoint(3, viewmat, relpt, 28, 12, 20);
        DoPoint(4, viewmat, relpt, 12, 28, 20);
        DoPoint(5, viewmat, relpt, -12, 28, 20);
        DoPoint(6, viewmat, relpt, -28, 12, 20);
        DoPoint(7, viewmat, relpt, -28, -12, 20);
        DoPoint(8, viewmat, relpt, -12, -28, 80);
        DoPoint(9, viewmat, relpt, 12, -28, 80);
        DoPoint(10, viewmat, relpt, 28, -12, 80);
        DoPoint(11, viewmat, relpt, 28, 12, 80);
        DoPoint(12, viewmat, relpt, 12, 28, 80);
        DoPoint(13, viewmat, relpt, -12, 28, 80);
        DoPoint(14, viewmat, relpt, -28, 12, 80);
        DoPoint(15, viewmat, relpt, -28, -12, 80);
        DoPoint(16, viewmat, relpt, 0, 0, 100);
        DoPoint(17, viewmat, relpt, 0, 0, 0);
        Robot.graphics.setColor(Color.gray);
        DrawLine(13, 0, 1);
        DrawLine(13, 1, 2);
        DrawLine(13, 2, 3);
        DrawLine(13, 3, 4);
        DrawLine(13, 4, 5);
        DrawLine(13, 5, 6);
        DrawLine(13, 6, 7);
        DrawLine(13, 7, 0);
        DrawLine(13, 8, 9);
        DrawLine(13, 9, 10);
        DrawLine(13, 10, 11);
        DrawLine(13, 11, 12);
        DrawLine(13, 12, 13);
        DrawLine(13, 13, 14);
        DrawLine(13, 14, 15);
        DrawLine(13, 15, 8);
        DrawLine(13, 0, 8);
        DrawLine(13, 1, 9);
        DrawLine(13, 2, 10);
        DrawLine(13, 3, 11);
        DrawLine(13, 4, 12);
        DrawLine(13, 5, 13);
        DrawLine(13, 6, 14);
        DrawLine(13, 7, 15);
        DrawLine(13, 0, 17);
        DrawLine(13, 1, 17);
        DrawLine(13, 2, 17);
        DrawLine(13, 3, 17);
        DrawLine(13, 4, 17);
        DrawLine(13, 5, 17);
        DrawLine(13, 6, 17);
        DrawLine(13, 7, 17);
        DrawLine(13, 8, 16);
        DrawLine(13, 9, 16);
        DrawLine(13, 10, 16);
        DrawLine(13, 11, 16);
        DrawLine(13, 12, 16);
        DrawLine(13, 13, 16);
        DrawLine(13, 14, 16);
        DrawLine(13, 15, 16);
        Joint3 obj = new Joint3();
        obj.Draw(viewmat, super.points[16]);
    }

    Joint2()
    {
    }
}