package test;

import java.awt.Color;  
import java.awt.Font;  
import java.awt.event.FocusAdapter;  
import java.awt.event.FocusEvent;  
import javax.swing.JTextField;  
  
public class HintTextField extends JTextField {  
  
  Font gainFont = new Font("Tahoma", Font.PLAIN, 12);  
  Font lostFont = new Font("Tahoma", Font.ITALIC, 12);  
  
  public HintTextField(final String hint) {  
  
    setText(hint);  
    setFont(lostFont);  
    setForeground(Color.GRAY);  
  
    this.addFocusListener(new FocusAdapter() {  
  
      @Override  
      public void focusGained(FocusEvent e) {  
        if (getText().equals(hint)) {  
          setText("");  
          setFont(gainFont);  
        } else {  
          setText(getText());  
          setFont(gainFont);  
        }  
      }  
  
      @Override  
      public void focusLost(FocusEvent e) {  
        if (getText().equals(hint)|| getText().length()==0) {  
          setText(hint);  
          setFont(lostFont);  
          setForeground(Color.GRAY);  
        } else {  
          setText(getText());  
          setFont(gainFont);  
          setForeground(Color.BLACK);  
        }  
      }  
    });  
  
  }  
}  