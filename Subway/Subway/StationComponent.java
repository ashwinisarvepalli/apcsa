import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class StationComponent extends JComponent {
  private SubwayLine[] subwayLines;
  private int currSubwayLine = -1;

  private final int stationRadius = 15;

  StationComponent(Color[] colors) {
    // initialize all arraylists
    subwayLines = new SubwayLine[colors.length];
    for(int i = 0; i < colors.length; i++) {
      subwayLines[i] = new SubwayLine(colors[i]);
    }
  }

  public void setColor(Color color) {
    for(int i = 0; i < subwayLines.length; i++) {
      if(subwayLines[i].getColor() == color) {
        currSubwayLine = i;
      }
    }
  }
  public int getCurrentSubwayLine() {
    return currSubwayLine;
  }

  public Station stationExists(double x, double y) {
    for(SubwayLine subwayLine : subwayLines) {
      for(Station station : subwayLine.getStations()) {
        if(station.intersects(x,y, stationRadius*2)) {
          // if station found that is nearby location
          return station;
        }
      }
    }
    // if no station found
    return null;
  }

  public void addStation(double x, double y, String name) {
    // fix offset of pointer from tip of click by stationRadius from y
    subwayLines[currSubwayLine].addStation(x, y-stationRadius, name);
  }

  public void addStation(Station st) {
    st.setMultipleLines(true);
    subwayLines[currSubwayLine].addStation(st);
  }

  public void paintComponent(Graphics g) {
    SwingUtilities.updateComponentTreeUI(this);
    Graphics2D component = (Graphics2D) g;

    for(int i = 0; i < subwayLines.length; i++) {
      ArrayList<Station> stations = subwayLines[i].getStations();

      for(int j = 0; j < stations.size(); j++) {
        Station station = stations.get(j);

        Ellipse2D.Double stationGUI = new Ellipse2D.Double(station.getX()-stationRadius,
          station.getY()-stationRadius, stationRadius*2, stationRadius*2);
        if(station.hasMultipleLines()) {
          // if station has multiple lines, make the station an open black circle
          component.setColor(Color.BLACK);
          component.draw(stationGUI);
        } else {
          // else the station is a filled dot using the line's color
          component.setColor(subwayLines[i].getColor());
          component.fill(stationGUI);
        }

        if(j > 0) {
          // if at least on the second station, print line on graphics
          Station prevStation = stations.get(j-1);
          if(prevStation.hasMultipleLines() && station.hasMultipleLines()) {
            // if there are multiple lines between the stations, draw line as black
            component.setColor(Color.BLACK);
          } else {
            // else use the subway line's color
            component.setColor(subwayLines[i].getColor());
          }
          component.draw(new Line2D.Double(prevStation.getX(), prevStation.getY(), station.getX(), station.getY()));
        }

        // print station name
        component.setColor(Color.BLACK);
        component.drawString(station.getName(), (float) station.getX()-stationRadius, (float) station.getY());
      }
    }
  }
}

class SubwayLine {
  public ArrayList<Station> stations = new ArrayList<Station>();
  public Color color;

  SubwayLine(Color color) {
    this.color = color;
  }

  public void addStation(Station st) {
    stations.add(st);
  }
  public void addStation(double x, double y, String name) {
    stations.add(new Station(x, y, name));
  }

  public Color getColor() {
    return color;
  }

  public ArrayList<Station> getStations() {
    return stations;
  }
}

class Station {
  public double x;
  public double y;
  public String name;
  public boolean multipleLines;

  Station(double x, double y, String name) {
    this.x = x;
    this.y = y;
    this.name = name;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public String getName() {
    return name;
  }

  public void setMultipleLines(boolean bool) {
    multipleLines = bool;
  }
  public boolean hasMultipleLines() {
    return multipleLines;
  }

  public boolean intersects(double x, double y, double threshold) {
    return Math.abs(this.x-x) <= threshold && Math.abs(this.y-y) <= threshold;
  }
}
