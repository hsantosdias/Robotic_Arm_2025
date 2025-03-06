# Implementação Braço Robô (Arm Robot) - versão 2025

## Braço Robotico em 3D construido em Java

Os arquivos contém um conjunto de classes Java utilizadas  para a simulação gráfica de um braço  robótico em um  ambiente de Applet versão legada.


O código foi desenvolvido como parte de um projeto acadêmico na  **Universidade Estadual do Sudoeste da Bahia (UESB)** , especificamente para a disciplina de  **Computação Gráfica - Prova da Terceira - Unidade de Computação Gráfica por Hugo Santos Dias e a participação especial de Bruno Boa Ventura**. Professor: Bruno Silvério Costa


## **Pequeno tutorial sobre o fontes do Braço Robô (Arm Robot)**

*Obs: Os dois principais arquivos do projeto são matrix.java e point3d.java, pois são os arquivos que armazenam e tratam os valores do desenho.*

*O desenho foi um braço robô, porem poderia ser qualquer outro o principio de desenhar, mover, transpor, escala, e outras funções em 3d pode ser aplicado a qualquer desenho, basta usar os arquivos matrix.java e point3d.java.*

### **Resumo do código**

1. **Robot.java**
   – Classe principal que inicializa a simulação e gerencia a interface gráfica do applet.
2. **Base.java**
   – Representa a base fixa do braço robótico.
3. **Cubo.java**
   – Define um cubo tridimensional, provavelmente um objeto de referência ou parte do cenário.
4. **H.java**
   – Possivelmente um objeto gráfico em forma de "H", usado para alguma marcação ou referência.
5. **Joint.java,
   Joint2.java, Joint3.java** – Representam as juntas do braço robótico, permitindo movimentação segmentada.
6. **Matrix.java**
   – Manipula matrizes para transformações tridimensionais (rotação e translação).
7. **Pincer.java**
   – Define a pinça do braço robótico, permitindo interação com objetos.
8. **Point3d.java**
   – Classe de pontos 3D usada para representar coordenadas tridimensionais.
9. **Pyramid.java**
   – Representa uma pirâmide, possivelmente parte da pinça ou um objeto gráfico.
10. **Screen.java**
    – Gerencia a projeção da cena 3D em um espaço 2D (viewport).
11. **Shape.java**
    – Classe abstrata para definição de formas geométricas.
12. **Support.java**
    – Representa o suporte do braço robótico.
13. **World.java**
    – Classe que define o mundo gráfico onde os objetos são renderizados.

**Principais funcionalidades**

* Renderização do braço robótico com projeção 3D em um  Applet Java.
* Interação via **mouse** (movimentação do braço) e  **teclado** (controle dos ângulos das juntas).
* Uso de **transformações lineares** (rotações e  translações) para manipulação dos componentes do robô.
* **Threading** para atualização contínua da simulação.

O código utiliza  **Java Applet** , que foi  **removido a  partir do Java 17** . Para rodá-lo em versões mais  recentes, você precisará **remover a dependência de  Applet** e migrar para uma biblioteca gráfica moderna, como  **JavaFX** ou **Swing** .

# Passos para rodar o código em versões recentes do Java

## 1. Remover a Dependência de Applet

O código atual usa:

```java
import java.applet.Applet;

public class Robot extends Applet implements Runnable
```

Isso precisa ser substituído por uma classe com **JFrame** ou  **JavaFX** .

---

## 2. Migrar para JFrame (Swing)

* Substituir **Applet** por  **JFrame** .
* Criar um **JPanel** para desenhar o robô.
* Utilizar `paintComponent(Graphics g)` no lugar de `paint(Graphics g)`.

### Exemplo de código atualizado usando JFrame:

```java
import javax.swing.*;
import java.awt.*;

public class RobotFrame extends JFrame {
    public RobotFrame() {
        setTitle("Braço Robótico");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new RobotPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RobotFrame::new);
    }
}

class RobotPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Universidade Estadual do Sudoeste da Bahia", 90, 20);
        g.drawString("Braço Robótico", 90, 50);
        // Aqui você pode chamar os métodos de renderização do robô
    }
}
```

---

## 3. Substituir Métodos Obsoletos

O código usa `size().width` e `size().height`, que eram comuns em  **Applets** .

Agora, use `getWidth()` e `getHeight()` dentro do  **JPanel** .

### Exemplo:

```java
int appletWidth = getWidth();
int appletHeight = getHeight();
```

---

## 4. Gerenciar Threads Corretamente

O código atual usa:

```java
ligar = new Thread(this);
ligar.start();
```

Mas o método `stop()` da **Thread** foi removido.

Agora, use **ScheduledExecutorService** para melhor controle de execução contínua.

### Exemplo:

```java
ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
executor.scheduleAtFixedRate(() -> repaint(), 0, 16, TimeUnit.MILLISECONDS);
```

---

## 5. Manter Transformações 3D

* Você pode manter a lógica da `Matrix.java` para transformações  **3D** .
* Alternativas modernas:
  * **JavaFX** (melhor para gráficos 3D).
  * **JOGL** (Java OpenGL) se quiser alto desempenho.

---

## 6. Mapeamento de Comandos e  t**eclas de atalho e movimentação do braço e da  viewport:**

```java
public static final int 1006 = "Movimentar para a esquerda";
public static final int 1007 = "Movimentar para a direita";
public static final int 1000 = "Movimenta o home";
public static final int 1001 = "ACTION_EVENT";
public static final int 1005 = "LOST_FOCUS";
public static final int 1004 = "GO_T_FOCUS";
public static final int 1002 = "Levanta o braço";
public static final int 1003 = "Abaixa o braço";
public static final int 42 = "Abre a pinça";
public static final int 47 = "Fecha a pinça";
public static final int 54 = "Gira em torno de Y (tecla 6)";
public static final int 52 = "Gira em torno de Y (tecla 4)";
public static final int 50 = "Gira em torno de X (tecla 2)";
public static final int 56 = "Gira em torno de X (tecla 8)";
public static final int 57 = "Gira em torno de Z (tecla 9)";
public static final int 51 = "Gira em torno de Z (tecla 3)";
public static final int 55 = "Diminui o zoom (tecla 7)";
public static final int 49 = "Aumenta o zoom (tecla 1)";
public static final int 1008 = "Visão do view por baixo (F1)";
public static final int 1009 = "Visão do view por cima (F2)";
public static final int 1010 = "Visão do view pela diagonal – por cima (F3)";
public static final int 1011 = "Visão do view pela diagonal – por baixo (F4)";
public static final int 1012 = "Visão do view original do ponto 0,0,0 (F5)";
public static final int 1013 = "Giro sobre X (F6)";
public static final int 1014 = "Visão do view por cima e na diagonal (F7)";
```

---

## Conclusão

Para rodar esse código em  **Java 17+** , você precisa:

* Remover **Applet** e usar  **JFrame** .
* Substituir `size()` por `getWidth()/getHeight()`.
* Gerenciar **Threads** corretamente.
* Usar bibliotecas modernas para gráficos (**JavaFX** ou  **JOGL** ).
* Implementar corretamente os comandos de controle.

Se quiser, pode atualizar o código completo para **JFrame** . Me avise!
