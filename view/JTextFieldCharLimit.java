package view;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldCharLimit extends PlainDocument{
    private int limit;

    public JTextFieldCharLimit(int limit) {
        this.limit = limit;
    }

    public void insertString(int offset, String string, AttributeSet attributeSet) throws BadLocationException {
        if(string == null) {
            return;
        }
        else {
            if((getLength() + string.length()) <= limit) {
                super.insertString(offset, string, attributeSet);
            }
        }
    }
}
