/*
 * PROJETO: Braço Robótico 3D em Java
 * AUTOR: Hugo Santos Dias
 * GITHUB: https://github.com/hsantosdias
 * LINKEDIN: https://www.linkedin.com/in/hugo-santos-dias/
 * DESCRIÇÃO: Simulação e renderização de um braço robótico interativo, 
 *            agora com interface Swing atualizada e controles de objetos.
 */
//classe mundo onde se encontra todos os objetos

class World extends Shape
{

    void Draw(Matrix viewmatold, Point3d relpt)
    {
        Matrix viewmat = viewmatold.copy();
    	if (!Robot.objectGrabbed) {
    	    Cubo obj1 = new Cubo();
    		DoPoint(0, viewmat, relpt, -300, 150, 0);
    		obj1.Draw(viewmat, super.points[0]);
    	}
		Base obj = new Base();
        DoPoint(0, viewmat, relpt, 0, 155, 0);
        obj.Draw(viewmat, super.points[0]);
 	}

    World()
    {
    }

}