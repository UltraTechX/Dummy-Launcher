package Dashboard;
import java.awt.MouseInfo;
import javax.swing.JButton;
import javax.swing.JFrame;

public class WindowResize {
    boolean isMoving = false;
    JFrame objFrm = new JFrame("Resize Demo");
    JButton ctrlButton = new JButton("Press and hold");
    public void fnShow() {
        objFrm.setSize(500, 500);
        objFrm.add(ctrlButton, java.awt.BorderLayout.PAGE_END);
        ctrlButton.setLocation(9, 0);
        objFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        objFrm.setVisible(true);
        ctrlButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fnSetScreenSize(evt, true);
            }
        });
        ctrlButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                isMoving = !isMoving;
                if (isMoving) {
                    ctrlButton.setText("Resizing now");
                } else {
                    ctrlButton.setText("Window size just fine");
                }
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fnSetScreenSize(evt, isMoving);
            }
        });
        ctrlButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                fnSetScreenSize(evt, isMoving);
            }
        });
        objFrm.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                fnSetScreenSize(evt, isMoving);
            }
        });
    }
    private void fnSetScreenSize(java.awt.event.MouseEvent evt, boolean _isMoving) {
        if (_isMoving) {
            int intWidth = MouseInfo.getPointerInfo().getLocation().x - objFrm.getLocationOnScreen().x + ((ctrlButton.getHeight() / 2) * 2);
            int intHeight = MouseInfo.getPointerInfo().getLocation().y - objFrm.getLocationOnScreen().y + ((ctrlButton.getHeight() / 2) * 2);
            objFrm.setSize(intWidth, intHeight);
        }
    }
    public static void main(String[] args) {
        new WindowResize().fnShow();
    }
}