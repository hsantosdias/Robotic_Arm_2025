/*
 * PROJETO: Braço Robótico 3D em Java
 * AUTOR: Hugo Santos Dias
 * GITHUB: https://github.com/hsantosdias
 * LINKEDIN: https://www.linkedin.com/in/hugo-santos-dias/
 * DESCRIÇÃO: Simulação e renderização de um braço robótico interativo, 
 *            agora com interface Swing atualizada e controles de objetos.
 */
//classe de pontos 3d para transfomaÃ§Ãµes de 3d para 2d 
//criada para tratar pontos nos espaÃ§o
class Point3d
    implements Cloneable
{

    Point3d copy()
    {
        try
        {
            return (Point3d)super.clone();
        }
        catch(CloneNotSupportedException _ex)
        {
            return null;
        }
    }

    Point3d()
    {
    }

    Point3d(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    void Rotate(Matrix mat, Point3d pt) //chama a classe que faz a rotaÃ§Ã£o da matriz 
    {
        pt = pt.copy();
        x = pt.x * mat.x0 + pt.y * mat.x1 + pt.z * mat.x2;
        y = pt.x * mat.y0 + pt.y * mat.y1 + pt.z * mat.y2;
        z = pt.x * mat.z0 + pt.y * mat.z1 + pt.z * mat.z2;
    }

    void Add(Point3d pt)
    {
        x += pt.x;
        y += pt.y;
        z += pt.z;
    }

    Point3d Neg()
    {
        return new Point3d(-x, -y, -z);
    }

    float x;
    float y;
    float z;
}