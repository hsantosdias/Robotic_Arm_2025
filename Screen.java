/* UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA
 * Ciência da Computação
 * Disciplina: Computação Gráfica
 * Alunos: Bruno Boaventura de Oliveira Lacerda
 *         Hugo Santos Dias
 * Professor: Bruno Silvério Costa
 */


//rotação da tela de apresentação do viewport

class Screen
{

    void Project(Point3d pt)
    {
        x = ((int)pt.x * Robot.appletHeight) / (int)pt.z + Robot.appletWidth / 2;
        y = ((int)pt.y * Robot.appletHeight) / (int)pt.z + Robot.appletHeight / 2;
    }

    Screen()
    {
    }

    int x;
    int y;
}