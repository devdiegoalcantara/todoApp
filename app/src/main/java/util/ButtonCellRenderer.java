package util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Objects;

public class ButtonCellRenderer extends DefaultTableCellRenderer {

    private String buttonType;

    public ButtonCellRenderer(String buttonType) {
        this.buttonType = buttonType;
    }

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/" + buttonType + ".png"))));

        return label;
    }

}
