/* UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA
 * Ciência da Computação
 * Disciplina: Computação Gráfica
 * Alunos: Bruno Boaventura de Oliveira Lacerda
 *         Hugo Santos Dias
 * Professor: Bruno Silvério Costa
 */


//matrix de dados para os movimentos do braço e a viewport
//classe responsavel por rotacionar os pontos em X,Y,Z e fazer o transporte 
//de uma matriz de valoers para os novos

class Matrix
{

    Matrix()
    {
        Init();
    }



    void Init()
    {
        x0 = 1.0F;
        y0 = 0.0F;
        z0 = 0.0F;
        x1 = 0.0F;
        y1 = 1.0F;
        z1 = 0.0F;
        x2 = 0.0F;
        y2 = 0.0F;
        z2 = 1.0F;
    }

    void RotateX(double rot) // rotaciona a matriz em x
    {
        float a1 = x1 * (float)Math.cos(rot) + x2 * (float)Math.sin(rot);
        float a2 = x2 * (float)Math.cos(rot) - x1 * (float)Math.sin(rot);
        float b1 = y1 * (float)Math.cos(rot) + y2 * (float)Math.sin(rot);
        float b2 = y2 * (float)Math.cos(rot) - y1 * (float)Math.sin(rot);
        float c1 = z1 * (float)Math.cos(rot) + z2 * (float)Math.sin(rot);
        float c2 = z2 * (float)Math.cos(rot) - z1 * (float)Math.sin(rot);
        x1 = a1;
        x2 = a2;
        y1 = b1;
        y2 = b2;
        z1 = c1;
        z2 = c2;
    }

//exemplo da formula utilizada na rotacao das matrizes
//matrix(2,2, [cos(theta), -sin(theta), sin(theta), cos(theta)])

    void RotateY(double rot) // rotaciona a matriz em y
    {
        float a0 = x0 * (float)Math.cos(rot) - x2 * (float)Math.sin(rot);
        float a2 = x2 * (float)Math.cos(rot) + x0 * (float)Math.sin(rot);
        float b0 = y0 * (float)Math.cos(rot) - y2 * (float)Math.sin(rot);
        float b2 = y2 * (float)Math.cos(rot) + y0 * (float)Math.sin(rot);
        float c0 = z0 * (float)Math.cos(rot) - z2 * (float)Math.sin(rot);
        float c2 = z2 * (float)Math.cos(rot) + z0 * (float)Math.sin(rot);
        x0 = a0;
        x2 = a2;
        y0 = b0;
        y2 = b2;
        z0 = c0;
        z2 = c2;
    }

    void RotateZ(double rot) // rotaciona a matriz em z
    {
        float a0 = x0 * (float)Math.cos(rot) + x1 * (float)Math.sin(rot);
        float a1 = x1 * (float)Math.cos(rot) - x0 * (float)Math.sin(rot);
        float b0 = y0 * (float)Math.cos(rot) + y1 * (float)Math.sin(rot);
        float b1 = y1 * (float)Math.cos(rot) - y0 * (float)Math.sin(rot);
        float c0 = z0 * (float)Math.cos(rot) + z1 * (float)Math.sin(rot);
        float c1 = z1 * (float)Math.cos(rot) - z0 * (float)Math.sin(rot);
        x0 = a0;
        x1 = a1;
        y0 = b0;
        y1 = b1;
        z0 = c0;
        z1 = c1;
    }

    Matrix Transpose() //mover a matriz 
        {
        Matrix mat = new Matrix();
        mat.x0 = x0;
        mat.y0 = x1;
        mat.z0 = x2;
        mat.x1 = y0;
        mat.y1 = y1;
        mat.z1 = y2;
        mat.x2 = z0;
        mat.y2 = z1;
        mat.z2 = z2;
        return mat;
    }

    Matrix copy() //copia os valores calculados nesta classe
    {
        Matrix mat = new Matrix();
        mat.x0 = x0;
        mat.x1 = x1;
        mat.x2 = x2;
        mat.y0 = y0;
        mat.y1 = y1;
        mat.y2 = y2;
        mat.z0 = z0;
        mat.z1 = z1;
        mat.z2 = z2;
        return mat;
    }

//declara as variaveis da matrix inicial
    float x0;
    float y0;
    float z0;
    float x1;
    float y1;
    float z1;
    float x2;
    float y2;
    float z2;
}