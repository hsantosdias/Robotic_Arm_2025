/*
 * PROJETO: Braço Robótico 3D em Java
 * AUTOR: Hugo Santos Dias
 * GITHUB: https://github.com/hsantosdias
 * LINKEDIN: https://www.linkedin.com/in/hugo-santos-dias/
 * DESCRIÇÃO: Simulação e renderização de um braço robótico interativo, 
 *            agora com interface Swing atualizada e controles de objetos.
 */
import java.awt.Color;
import java.awt.Graphics;

class Cubo extends Shape
{

    void Draw(Matrix viewmatold, Point3d relpt)
    {
        Matrix viewmat = viewmatold.copy();
        DoPoint(0, viewmat, relpt, 15, 15, 15);
        DoPoint(1, viewmat, relpt, -15, 15, 15);
        DoPoint(2, viewmat, relpt, -15, -15, 15);
        DoPoint(3, viewmat, relpt, 15, -15, 15);
        DoPoint(4, viewmat, relpt, 15, 15, -15);
        DoPoint(5, viewmat, relpt, -15, 15, -15);
        DoPoint(6, viewmat, relpt, -15, -15, -15);
        DoPoint(7, viewmat, relpt, 15, -15, -15);
        Robot.graphics.setColor(Color.yellow);
        DrawLine(14, 0, 1);
        DrawLine(14, 1, 2);
        DrawLine(14, 2, 3);
        DrawLine(14, 3, 0);
        DrawLine(14, 4, 5);
        DrawLine(14, 5, 6);
        DrawLine(14, 6, 7);
        DrawLine(14, 7, 4);
        DrawLine(14, 0, 4);
        DrawLine(14, 1, 5);
        DrawLine(14, 2, 6);
        DrawLine(14, 3, 7);
    }

    Cubo()
    {
    }
}