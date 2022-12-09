package util;

import model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.time.LocalDate;

public class DeadlineCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

        label.setHorizontalAlignment(CENTER);

        TaskTableModel taskTableModel = (TaskTableModel) table.getModel();
        Task task = taskTableModel.getTasks().get(row);

        if (task.getDeadline().isAfter(LocalDate.now())) {
            label.setBackground(Color.GREEN);
        } else {
            label.setBackground(Color.RED);
        }

        return label;
    }

}
