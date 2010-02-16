/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DSWorkbenchDistanceFrame.java
 *
 * Created on 30.09.2009, 14:49:50
 */
package de.tor.tribes.ui;

import de.tor.tribes.types.Village;
import de.tor.tribes.ui.models.DistanceTableModel;
import de.tor.tribes.ui.renderer.DistanceTableCellRenderer;
import de.tor.tribes.ui.renderer.SortableTableHeaderRenderer;
import de.tor.tribes.ui.renderer.VillageCellRenderer;
import de.tor.tribes.util.GlobalOptions;
import de.tor.tribes.util.JOptionPaneHelper;
import de.tor.tribes.util.dist.DistanceManager;
import de.tor.tribes.util.parser.VillageParser;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.log4j.Logger;

/**
 *
 * @author Jejkal
 */
public class DSWorkbenchDistanceFrame extends AbstractDSWorkbenchFrame {

    private static Logger logger = Logger.getLogger("DistanceFrame");
    private static DSWorkbenchDistanceFrame SINGLETON = null;
    private DefaultTableCellRenderer headerRenderer = null;
    private DistanceTableCellRenderer cellRenderer = null;

    public static synchronized DSWorkbenchDistanceFrame getSingleton() {
        if (SINGLETON == null) {
            SINGLETON = new DSWorkbenchDistanceFrame();
        }
        return SINGLETON;
    }

    /** Creates new form DSWorkbenchDistanceFrame */
    DSWorkbenchDistanceFrame() {
        initComponents();
        jDistanceTable.setModel(DistanceTableModel.getSingleton());
        cellRenderer = new DistanceTableCellRenderer();
        jDistanceTable.setDefaultRenderer(Double.class, cellRenderer);
        jDistanceTable.setDefaultRenderer(Village.class, new VillageCellRenderer());

        // <editor-fold defaultstate="collapsed" desc=" Init HelpSystem ">
        GlobalOptions.getHelpBroker().enableHelpKey(getRootPane(), "pages.distance_overview", GlobalOptions.getHelpBroker().getHelpSet());
        // </editor-fold>
    }

    public void setup() {
        jDistanceTable.invalidate();
        jDistanceTable.setColumnSelectionAllowed(true);
        jDistanceTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(DistanceTableModel.getSingleton());
        jDistanceTable.setRowSorter(sorter);
        headerRenderer = new SortableTableHeaderRenderer();
        /*DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = new DefaultTableCellRenderer().getTableCellRendererComponent(table, value, hasFocus, hasFocus, row, row);
        c.setBackground(Constants.DS_BACK);
        DefaultTableCellRenderer r = ((DefaultTableCellRenderer) c);
        r.setHorizontalAlignment(JLabel.CENTER);
        return r;
        }
        };*/

        int w0 = 100;
        try {
            for (Village v : DSWorkbenchMainFrame.getSingleton().getCurrentUser().getVillageList()) {
                int w = getGraphics().getFontMetrics().stringWidth(v.toString());
                if (w > w0) {
                    w0 = w;
                }
            }
        } catch (Exception e) {
        }
        for (int i = 0; i < jDistanceTable.getColumnCount(); i++) {
            TableColumn column = jDistanceTable.getColumnModel().getColumn(i);
            column.setHeaderRenderer(headerRenderer);
            if (i == 0) {
                column.setWidth(w0);
                column.setPreferredWidth(w0);
            } else {
                try {
                    String v = (String) column.getHeaderValue();
                    int w = getGraphics().getFontMetrics().stringWidth(v);
                    column.setWidth(w);
                    column.setPreferredWidth(w);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // column.setPreferredWidth(w);
            }
            // renderers.add(headerRenderer);
        }

        jDistanceTable.setModel(DistanceTableModel.getSingleton());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDistanceTable = new javax.swing.JTable();
        jCopyFromClipboardEvent = new javax.swing.JButton();
        jCopyFromClipboardEvent1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMinValue = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jMaxValue = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCopyFromClipboardEvent2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setTitle("Entfernungsübersicht");

        jPanel1.setBackground(new java.awt.Color(239, 235, 223));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jDistanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jDistanceTable);

        jCopyFromClipboardEvent.setBackground(new java.awt.Color(239, 235, 223));
        jCopyFromClipboardEvent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/ui/clipboard.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("de/tor/tribes/ui/Bundle"); // NOI18N
        jCopyFromClipboardEvent.setText(bundle.getString("DSWorkbenchAttackFrame.jCleanupAttacksButton.text")); // NOI18N
        jCopyFromClipboardEvent.setToolTipText(bundle.getString("DSWorkbenchAttackFrame.jCleanupAttacksButton.toolTipText")); // NOI18N
        jCopyFromClipboardEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireCopyVillagesFromClipboardEvent(evt);
            }
        });

        jCopyFromClipboardEvent1.setBackground(new java.awt.Color(239, 235, 223));
        jCopyFromClipboardEvent1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/ui/att_remove.png"))); // NOI18N
        jCopyFromClipboardEvent1.setText(bundle.getString("DSWorkbenchAttackFrame.jCleanupAttacksButton.text")); // NOI18N
        jCopyFromClipboardEvent1.setToolTipText(bundle.getString("DSWorkbenchAttackFrame.jCleanupAttacksButton.toolTipText")); // NOI18N
        jCopyFromClipboardEvent1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireRemoveColumnEvent(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("Minimale Entfernung");
        jLabel1.setOpaque(true);

        jMinValue.setText("10");
        jMinValue.setToolTipText("Gibt die Entfernung an, ab der Werte in der Tabelle grün eingezeichnet werden");
        jMinValue.setMaximumSize(new java.awt.Dimension(80, 20));
        jMinValue.setMinimumSize(new java.awt.Dimension(80, 20));
        jMinValue.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Maximale Entfernung");
        jLabel2.setOpaque(true);

        jMaxValue.setText("20");
        jMaxValue.setToolTipText("Gibt die Entfernung an, ab der Werte in der Tabelle rot eingezeichnet werden");
        jMaxValue.setMaximumSize(new java.awt.Dimension(80, 20));
        jMaxValue.setMinimumSize(new java.awt.Dimension(80, 20));
        jMaxValue.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel3.setText("Felder");

        jLabel4.setText("Felder");

        jCopyFromClipboardEvent2.setBackground(new java.awt.Color(239, 235, 223));
        jCopyFromClipboardEvent2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/ui/replace2.png"))); // NOI18N
        jCopyFromClipboardEvent2.setText(bundle.getString("DSWorkbenchAttackFrame.jCleanupAttacksButton.text")); // NOI18N
        jCopyFromClipboardEvent2.setToolTipText(bundle.getString("DSWorkbenchAttackFrame.jCleanupAttacksButton.toolTipText")); // NOI18N
        jCopyFromClipboardEvent2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireUpdateEvent(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCopyFromClipboardEvent)
                                .addComponent(jCopyFromClipboardEvent1))
                            .addComponent(jCopyFromClipboardEvent2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jMinValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jMaxValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCopyFromClipboardEvent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCopyFromClipboardEvent1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCopyFromClipboardEvent2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jMinValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jMaxValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jCheckBox1.setText("Immer im Vordergrund");
        jCheckBox1.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fireCopyVillagesFromClipboardEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireCopyVillagesFromClipboardEvent
        try {
            Transferable t = (Transferable) Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            List<Village> villages = VillageParser.parse((String) t.getTransferData(DataFlavor.stringFlavor));
            if (villages == null || villages.isEmpty()) {
                JOptionPaneHelper.showInformationBox(this, "Es konnten keine Dorfkoodinaten in der Zwischenablage gefunden werden.", "Information");
                return;
            } else {
                jDistanceTable.invalidate();
                for (Village v : villages) {
                    DistanceManager.getSingleton().addVillage(v);
                }
                DistanceTableModel.getSingleton().fireTableStructureChanged();
                jDistanceTable.revalidate();
                setup();
            }
        } catch (Exception e) {
            logger.error("Failed to parse villages from clipboard", e);
        }
    }//GEN-LAST:event_fireCopyVillagesFromClipboardEvent

    private void fireRemoveColumnEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireRemoveColumnEvent
        int[] cols = jDistanceTable.getSelectedColumns();
        if (cols == null) {
            return;
        }
        jDistanceTable.invalidate();
        int[] correctedCols = new int[cols.length];
        for (int i = 0; i < cols.length; i++) {
            correctedCols[i] = jDistanceTable.convertColumnIndexToModel(cols[i]);
        }

        DistanceManager.getSingleton().removeVillages(correctedCols);
        DistanceTableModel.getSingleton().fireTableStructureChanged();
        jDistanceTable.revalidate();
        setup();
    }//GEN-LAST:event_fireRemoveColumnEvent

    private void fireUpdateEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireUpdateEvent
        int min = 10;
        int max = 20;
        try {
            min = Integer.parseInt(jMinValue.getText());
        } catch (Exception e) {
            JOptionPaneHelper.showWarningBox(this, "Der Eintrag für den minimalen Wert ist ungültig.", "Fehler");
            return;
        }
        try {
            max = Integer.parseInt(jMaxValue.getText());
        } catch (Exception e) {
            JOptionPaneHelper.showWarningBox(this, "Der Eintrag für den maximalen Wert ist ungültig.", "Fehler");
            return;
        }

        if (min >= max) {
            JOptionPaneHelper.showWarningBox(this, "Der minimale Wert muss kleiner als der maximale Wert sein.", "Fehler");
            return;
        }

        cellRenderer.setMarkerMin(min);
        cellRenderer.setMarkerMax(max);
        jDistanceTable.repaint();
    }//GEN-LAST:event_fireUpdateEvent

    @Override
    public void fireVillagesDraggedEvent(List<Village> pVillages, Point pDropLocation) {
        try {
            for (Village v : pVillages) {
                DistanceManager.getSingleton().addVillage(v);
            }
            DistanceTableModel.getSingleton().fireTableStructureChanged();
            jDistanceTable.revalidate();
            setup();
        } catch (Exception e) {
            logger.error("Failed to received dropped villages", e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DSWorkbenchDistanceFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JButton jCopyFromClipboardEvent;
    private javax.swing.JButton jCopyFromClipboardEvent1;
    private javax.swing.JButton jCopyFromClipboardEvent2;
    private javax.swing.JTable jDistanceTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jMaxValue;
    private javax.swing.JTextField jMinValue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
