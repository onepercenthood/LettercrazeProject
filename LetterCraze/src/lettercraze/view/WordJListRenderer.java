package lettercraze.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import lettercraze.model.Word;

/**
 * Controlls the JList rendering for Word Class
 * 
 * Allows us to inject a custom Renderer for JList
 * @author ddeisadze
 *
 */
class WordJListRenderer extends JLabel implements ListCellRenderer {
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

	public WordJListRenderer() {
		setOpaque(true);
		setIconTextGap(12);
	}


	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
		Word entry = (Word) value;
		setText(entry.getWordString());
		if (isSelected) {
			setBackground(HIGHLIGHT_COLOR);
			setForeground(Color.white);
		} else {
			setBackground(Color.white);
			setForeground(Color.black);
		}
		return this;
	}
	
}
