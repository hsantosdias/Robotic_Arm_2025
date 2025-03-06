/* UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA
 * Ciência da Computação
 * Disciplina: Computação Gráfica
 * Alunos: Bruno Boaventura de Oliveira Lacerda
 *         Hugo Santos Dias
 * Professor: Bruno Silvério Costa
 */


//classe de shape (formas)
//define os métodos que qualquer forma geométrica deve apresentar

import java.awt.Graphics;
import java.applet.Applet;
import java.*;


abstract class Shape
{

    Shape()
    {
        MAXPTS = 40;
        points = new Point3d[MAXPTS];
        scrpts = new Screen[MAXPTS];
        for(int count = 0; count < MAXPTS; count++)
        {
            points[count] = new Point3d();
            scrpts[count] = new Screen();
        }

    }

    abstract void Draw(Matrix matrix, Point3d point3d);

    void DoPoint(int num, Matrix rotmat, Point3d cenpos, int x, int y, int z)
    {
        Point3d temp = new Point3d();
        temp.x = x;
        temp.y = y;
        temp.z = z;
        points[num].Rotate(rotmat, temp);
        points[num].Add(cenpos);
        scrpts[num].Project(points[num]);
    }

    void DrawLine(int color, int p0, int p1)
    {
        if(points[p0].z <= 1.0F || points[p1].z <= 1.0F)
        {
            return;
        } else
        {
            Robot.graphics.drawLine(scrpts[p0].x, scrpts[p0].y, scrpts[p1].x, scrpts[p1].y);
            return;
        }
    }

    int MAXPTS;
    Point3d points[];
    Screen scrpts[];
}

