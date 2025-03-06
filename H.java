/* UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA
 * Ciência da Computação
 * Disciplina: Computação Gráfica
 * Alunos: Bruno Boaventura de Oliveira Lacerda
 *         Hugo Santos Dias
 * Professor: Bruno Silvério Costa
 */

import java.awt.Color;
import java.awt.Graphics;

class H extends Shape
{

    void Draw(Matrix viewmatold, Point3d relpt)
    {
        Matrix viewmat = viewmatold.copy();
        DoPoint(0, viewmat, relpt, 25, 25, 25);
        DoPoint(1, viewmat, relpt, -25, 25, 25);
        DoPoint(2, viewmat, relpt, -25, -25, 25);
        DoPoint(3, viewmat, relpt, 25, -25, 25);
        DoPoint(4, viewmat, relpt, 25, 25, -25);
        //DoPoint(5, viewmat, relpt, -25, 25, -25);
        //DoPoint(6, viewmat, relpt, -25, -25, -25);
        //DoPoint(7, viewmat, relpt, 25, -25, -25);
        Robot.graphics.setColor(Color.red);
        DrawLine(7, 0, 1);
        DrawLine(7, 1, 2);
        DrawLine(7, 2, 3);
        DrawLine(7, 3, 0);
        DrawLine(7, 4, 5);
        //DrawLine(7, 5, 6);
        //DrawLine(7, 6, 7);
        //DrawLine(7, 7, 4);
        //DrawLine(7, 0, 4);
        //DrawLine(7, 1, 5);
        //DrawLine(7, 2, 6);
        //DrawLine(7, 3, 7);
		  
    }

    H ()
    {
    }
}
