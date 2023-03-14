package vue;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ConditionalRightTableCellRenderer extends DefaultTableCellRenderer {

    private int[] rightAlignRows;

    public ConditionalRightTableCellRenderer(int[] rightAlignRows) {
        this.rightAlignRows = rightAlignRows;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Conditionally align text to right for specified rows
        if (isRightAlignedRow(row)) {
            setHorizontalAlignment(SwingConstants.RIGHT);
        } else {
            setHorizontalAlignment(SwingConstants.LEFT);
        }
        return cellComponent;
    }

    private boolean isRightAlignedRow(int row) {
        for (int rightAlignRow : rightAlignRows) {
            if (row == rightAlignRow) {
                return true;
            }
        }
        return false;
    }
}
