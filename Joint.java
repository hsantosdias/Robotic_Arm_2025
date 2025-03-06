/* UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA
 * Ciência da Computação
 * Disciplina: Computação Gráfica
 * Alunos: Bruno Boaventura de Oliveira Lacerda
 *         Hugo Santos Dias
 * Professor: Bruno Silvério Costa
 */


//segunda junta do braço
//desenha a segunda peça do robo
import java.awt.Color;
import java.awt.Graphics;

class Joint extends Shape
{

    void Draw(Matrix viewmatold, Point3d relpt)
    {
        Matrix viewmat = viewmatold.copy();
        viewmat.RotateX(Robot.ang2);
        DoPoint(0, viewmat, relpt, -18, -42, 30);
        DoPoint(1, viewmat, relpt, 18, -42, 30);
        DoPoint(2, viewmat, relpt, 42, -18, 30);
        DoPoint(3, viewmat, relpt, 42, 18, 30);
        DoPoint(4, viewmat, relpt, 18, 42, 30);
        DoPoint(5, viewmat, relpt, -18, 42, 30);
        DoPoint(6, viewmat, relpt, -42, 18, 30);
        DoPoint(7, viewmat, relpt, -42, -18, 30);
        DoPoint(8, viewmat, relpt, -18, -42, 130);
        DoPoint(9, viewmat, relpt, 18, -42, 130);
        DoPoint(10, viewmat, relpt, 42, -18, 130);
        DoPoint(11, viewmat, relpt, 42, 18, 130);
        DoPoint(12, viewmat, relpt, 18, 42, 130);
        DoPoint(13, viewmat, relpt, -18, 42, 130);
        DoPoint(14, viewmat, relpt, -42, 18, 130);
        DoPoint(15, viewmat, relpt, -42, -18, 130);
        DoPoint(16, viewmat, relpt, 0, 0, 160);
        DoPoint(17, viewmat, relpt, 0, 0, 0);
        Robot.graphics.setColor(Color.lightGray);
        DrawLine(5, 0, 1);
        DrawLine(5, 1, 2);
        DrawLine(5, 2, 3);
        DrawLine(5, 3, 4);
        DrawLine(5, 4, 5);
        DrawLine(5, 5, 6);
        DrawLine(5, 6, 7);
        DrawLine(5, 7, 0);
        DrawLine(5, 8, 9);
        DrawLine(5, 9, 10);
        DrawLine(5, 10, 11);
        DrawLine(5, 11, 12);
        DrawLine(5, 12, 13);
        DrawLine(5, 13, 14);
        DrawLine(5, 14, 15);
        DrawLine(5, 15, 8);
        DrawLine(5, 0, 8);
        DrawLine(5, 1, 9);
        DrawLine(5, 2, 10);
        DrawLine(5, 3, 11);
        DrawLine(5, 4, 12);
        DrawLine(5, 5, 13);
        DrawLine(5, 6, 14);
        DrawLine(5, 7, 15);
        DrawLine(5, 0, 17);
        DrawLine(5, 1, 17);
        DrawLine(5, 2, 17);
        DrawLine(5, 3, 17);
        DrawLine(5, 4, 17);
        DrawLine(5, 5, 17);
        DrawLine(5, 6, 17);
        DrawLine(5, 7, 17);
        DrawLine(5, 8, 16);
        DrawLine(5, 9, 16);
        DrawLine(5, 10, 16);
        DrawLine(5, 11, 16);
        DrawLine(5, 12, 16);
        DrawLine(5, 13, 16);
        DrawLine(5, 14, 16);
        DrawLine(5, 15, 16);
        Joint2 obj = new Joint2();
        obj.Draw(viewmat, super.points[16]);
    }

    Joint()
    {
    }
}