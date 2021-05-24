import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

public class Starter {
  public static Color[] colors = {Color.GREEN, Color.RED, Color.MAGENTA};
  public static String[] colorDescriptions = {"Line 1", "Line 2", "Line 3"};

  public static void main(String[] args) {
    JFrame f = new JFrame("Subway Map");

    final int FRAME_HEIGHT = 600, FRAME_WIDTH = 600;
    final StationComponent stationComponent = new StationComponent(colors);

    f.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    f.add(stationComponent);

    // mouse listener
    class FrameMouseListener implements MouseListener {
      public void mouseClicked(MouseEvent e) {
        String[] options = new String[colors.length];
        boolean newMap = stationComponent.getCurrentSubwayLine() == -1;
        if(newMap) {
          options = colorDescriptions;
        } else {
          options = new String[2];
          options[0] = "New Stop For "+colorDescriptions[stationComponent.getCurrentSubwayLine()];
          options[1] = "Change Line";
        }

        int response = JOptionPane.showOptionDialog(null, "Choose Line", "Choose Line", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if(response != -1) {
          if(newMap) {
            // if there are no stations
            stationComponent.setColor(colors[response]);
          } else {
            // if there is already at least 1 station
            if(response == 1) {
              // change color from previous
              String colorChosen = (String) JOptionPane.showInputDialog(null, "Choose Line", "Choose Line", JOptionPane.INFORMATION_MESSAGE, null, colorDescriptions, colorDescriptions[stationComponent.getCurrentSubwayLine()]);
              int colorIndex = Arrays.asList(colorDescriptions).indexOf(colorChosen);
              stationComponent.setColor(colors[colorIndex]);
            }
          }

          // extra credit: check if there are nearby stations
          Station nearbyStation = stationComponent.stationExists(e.getX(), e.getY());
          if(nearbyStation != null) {
            stationComponent.addStation(nearbyStation);
          } else {
            String stationName = JOptionPane.showInputDialog("Station Name");
            if(stationName != null) {
              stationComponent.addStation(e.getX(), e.getY(), stationName);
            }
          }
        }
      }
      // remaining methods from interface
      public void mouseEntered(MouseEvent e) {}
      public void mouseExited(MouseEvent e) {}
      public void mousePressed(MouseEvent e) {}
      public void mouseReleased(MouseEvent e) {}
    }
    MouseListener frameMouseListener = new FrameMouseListener();
    f.addMouseListener(frameMouseListener);

    f.setVisible(true);
  }
}
