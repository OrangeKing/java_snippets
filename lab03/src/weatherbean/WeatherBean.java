/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherbean;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Norbert
 */
public class WeatherBean extends JPanel {

    // Region Fields \\
    
    private JLabel _titleLbl = new JLabel("Title");
    private JLabel _tempLbl = new JLabel("Temperature: ");
    private JLabel _barLbl = new JLabel("Bar: ");
    private JLabel _weatherLbl = new JLabel("Weather: ");
    
    private JTextField _tempText = new JTextField();
    private JTextField _barText = new JTextField();
    private JTextField _weatherText = new JTextField(); 
    
    private String _title = "Title";
    private double _temperature = 0.0;
    private double _bar = 0.0;
    private String _weather = "No information";
    
    private JPanel _componentsPanel = new JPanel(new GridLayout(3,2));
    
    // End Region \\
    
    //Region Ctors
    
    public WeatherBean()
    {
        _tempText.setEnabled(false);
        _barText.setEnabled(false);
        _weatherText.setEnabled(false);
        
        this.setLayout(new BorderLayout());
        this.add(_titleLbl,BorderLayout.NORTH);
        _componentsPanel.add(_tempLbl);
        _componentsPanel.add(_tempText);
        
        _componentsPanel.add(_barLbl);
        _componentsPanel.add(_barText);
        
        _componentsPanel.add(_weatherLbl);
        _componentsPanel.add(_weatherText);
        this.add(_componentsPanel);
    }
    
    //End Region
    
    // Region Props
    
    public String getTitle() {return _title;}
    public void setTitle(String value) { 
        if(value != _title)
        {
            _title = value;
            _titleLbl.setText(value);
        }
    }
    
    public double getTemperature() {return _temperature;}
    public void setTemperature(double value)
    {
        if(value != _temperature)
        {
            _temperature = value;
            _tempText.setText(value + "");
        }
    }
    
    public Color getBackgroundColor() {return this.getBackground();}
    public void setBackgroundColor(Color value) {this.setBackground(value);}
    
    public double getBar() {return _bar;}
    public void setBar(double value)
    {
        if(value != _bar)
        {
            _bar = value;
            _barText.setText(value + "");
        }
    }
    
    public String getWeather() {return _weather;}
    public void setWeather(String value)
    {
        if(!value.equals(_weather))
        {
            _weather = value;
            _weatherText.setText(value);
        }
    }
    
    // End Region
    
    
    
    

    
}
