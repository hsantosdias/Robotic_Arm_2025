/*
 * PROJETO: Braço Robótico 3D em Java
 * AUTOR: Hugo Santos Dias
 * GITHUB: https://github.com/hsantosdias
 * LINKEDIN: https://www.linkedin.com/in/hugo-santos-dias/
 * DESCRIÇÃO: Simulação e renderização de um braço robótico interativo, 
 *            agora com interface Swing atualizada e controles de objetos.
 */
//pinca do braÃ§o
import java.awt.Color;
import java.awt.Graphics;

class Pincer extends Shape
{

    void Draw(Matrix viewmatold, Point3d relpt)
    {
        Matrix viewmat = viewmatold.copy();
        DoPoint(0, viewmat, relpt, 0, 0, 20);
        DoPoint(1, viewmat, relpt, 20, 0, 20);
        DoPoint(2, viewmat, relpt, 0, 40, 20);
        DoPoint(3, viewmat, relpt, 0, 0, -20);
        DoPoint(4, viewmat, relpt, 20, 0, -20);
        DoPoint(5, viewmat, relpt, 0, 40, -20);
        Robot.graphics.setColor(Color.white );
        DrawLine(9, 0, 1);
        DrawLine(9, 1, 2);
        DrawLine(9, 2, 0);
        DrawLine(9, 3, 4);
        DrawLine(9, 4, 5);
        DrawLine(9, 5, 3);
        DrawLine(9, 0, 3);
        DrawLine(9, 1, 4);
        DrawLine(9, 2, 5);
    }

    Pincer()
    {
    }
}