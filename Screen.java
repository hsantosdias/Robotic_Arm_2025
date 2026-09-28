/*
 * PROJETO: Braço Robótico 3D em Java
 * AUTOR: Hugo Santos Dias
 * GITHUB: https://github.com/hsantosdias
 * LINKEDIN: https://www.linkedin.com/in/hugo-santos-dias/
 * DESCRIÇÃO: Simulação e renderização de um braço robótico interativo, 
 *            agora com interface Swing atualizada e controles de objetos.
 */
//rotaÃ§Ã£o da tela de apresentaÃ§Ã£o do viewport

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