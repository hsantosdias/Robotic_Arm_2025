/* UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA
 * Ciência da Computação
 * Disciplina: Computação Gráfica
 * Alunos: Bruno Boaventura de Oliveira Lacerda
 *         Hugo Santos Dias
 * Professor: Bruno Silvério Costa
 */


//classe do primeira junta para o braço
//desenha a primeira peça

import java.awt.Color;
import java.awt.Graphics;

class Support extends Shape
{

    void Draw(Matrix viewmatold, Point3d relpt)
    {
        Matrix viewmat = viewmatold.copy();
        viewmat.RotateZ(Robot.ang1);
        Robot.grabmat = viewmat.copy();
        Robot.grabmat.RotateX(-1.5700000000000001D);
        DoPoint(0, viewmat, relpt, -23, -56, 0);
        DoPoint(1, viewmat, relpt, 23, -56, 0);
        DoPoint(2, viewmat, relpt, 56, -23, 0);
        DoPoint(3, viewmat, relpt, 56, 23, 0);
        DoPoint(4, viewmat, relpt, 23, 56, 0);
        DoPoint(5, viewmat, relpt, -23, 56, 0);
        DoPoint(6, viewmat, relpt, -56, 23, 0);
        DoPoint(7, viewmat, relpt, -56, -23, 0);
        DoPoint(8, viewmat, relpt, -23, -56, 110);
        DoPoint(9, viewmat, relpt, 23, -56, 110);
        DoPoint(10, viewmat, relpt, 56, -23, 110);
        DoPoint(11, viewmat, relpt, 56, 23, 110);
        DoPoint(12, viewmat, relpt, 23, 56, 110);
        DoPoint(13, viewmat, relpt, -23, 56, 110);
        DoPoint(14, viewmat, relpt, -56, 23, 110);
        DoPoint(15, viewmat, relpt, -56, -23, 110);
        DoPoint(16, viewmat, relpt, 0, 0, 150);
        Robot.graphics.setColor(Color.white);
        DrawLine(12, 0, 1);
        DrawLine(12, 1, 2);
        DrawLine(12, 2, 3);
        DrawLine(12, 3, 4);
        DrawLine(12, 4, 5);
        DrawLine(12, 5, 6);
        DrawLine(12, 6, 7);
        DrawLine(12, 7, 0);
        DrawLine(12, 8, 9);
        DrawLine(12, 9, 10);
        DrawLine(12, 10, 11);
        DrawLine(12, 11, 12);
        DrawLine(12, 12, 13);
        DrawLine(12, 13, 14);
        DrawLine(12, 14, 15);
        DrawLine(12, 15, 8);
        DrawLine(12, 0, 8);
        DrawLine(12, 1, 9);
        DrawLine(12, 2, 10);
        DrawLine(12, 3, 11);
        DrawLine(12, 4, 12);
        DrawLine(12, 5, 13);
        DrawLine(12, 6, 14);
        DrawLine(12, 7, 15);
        DrawLine(12, 8, 16);
        DrawLine(12, 9, 16);
        DrawLine(12, 10, 16);
        DrawLine(12, 11, 16);
        DrawLine(12, 12, 16);
        DrawLine(12, 13, 16);
        DrawLine(12, 14, 16);
        DrawLine(12, 15, 16);
        Joint obj = new Joint();
        obj.Draw(viewmat, super.points[16]);
    }

    Support()
    {
    }
}