import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyDetective extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == e.VK_LEFT) {
            if (Huerfana.limit == false) {
                Huerfana.setXDirection(-4);
            }
        }
        if (keyCode == e.VK_RIGHT) {
            if (Huerfana.limit == false) {
                Huerfana.setXDirection(+4);
            }
        }
        if (keyCode == e.VK_UP) {
            if (Huerfana.limit == false) {
                Huerfana.setYDirection(-4);
            }
        }
        if (keyCode == e.VK_DOWN) {
            if (Huerfana.limit == false) {
                Huerfana.setYDirection(+4);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == e.VK_LEFT) {
            Huerfana.limit = false;
            Huerfana.setXDirection(0);
        }
        if (keyCode == e.VK_RIGHT) {
            Huerfana.limit = false;
            Huerfana.setXDirection(0);
        }
        if (keyCode == e.VK_UP) {
            Huerfana.limit = false;
            Huerfana.setYDirection(0);
        }
        if (keyCode == e.VK_DOWN) {
            Huerfana.limit = false;
            Huerfana.setYDirection(0);
        }
        if (keyCode == e.VK_SPACE && Huerfana.disparo < 1 && Huerfana.fuegoX <= 0 && !Huerfana.pause) {
            Huerfana.disparo++;
            Huerfana.ataque();
        }
        if (keyCode == e.VK_P) {
            if (!Huerfana.pause) {
                Huerfana.pause = true;
            } else {
                Huerfana.pause = false;
            }
        }
    }
}