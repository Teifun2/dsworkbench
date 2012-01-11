/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ResourceDataReadPanel.java
 *
 * Created on Jan 2, 2012, 1:42:34 PM
 */
package de.tor.tribes.ui.wiz.red;

import de.tor.tribes.types.StorageStatus;
import de.tor.tribes.types.Tag;
import de.tor.tribes.types.ext.Village;
import de.tor.tribes.types.VillageMerchantInfo;
import de.tor.tribes.ui.components.GroupSelectionList;
import de.tor.tribes.ui.renderer.DefaultTableHeaderRenderer;
import de.tor.tribes.ui.renderer.NumberFormatCellRenderer;
import de.tor.tribes.ui.renderer.StorageCellRenderer;
import de.tor.tribes.ui.renderer.TradeDirectionCellRenderer;
import de.tor.tribes.util.Constants;
import de.tor.tribes.util.TagUtils;
import de.tor.tribes.util.UIHelper;
import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import org.netbeans.spi.wizard.Wizard;
import org.netbeans.spi.wizard.WizardPage;
import org.netbeans.spi.wizard.WizardPanelNavResult;

/**
 *
 * @author Torridity
 */
public class ResourceDistributorSettingsPanel extends WizardPage {

    private static final String GENERAL_INFO = "Du befindest dich in der Dorfauswahl. Hier kannst du die Herkunftsd&ouml;rfer ausw&auml;hlen, "
            + "mit denen du angreifen m&ouml;chtest. Hierf&uuml;r hast die folgenden M&ouml;glichkeiten:"
            + "<ul> <li>Einf&uuml;gen von Dorfkoordinaten aus der Zwischenablage per STRG+V</li>"
            + "<li>Einf&uuml;gen der Herkunftsd&ouml;rfer aus Gruppen der Gruppen&uuml;bersicht</li>"
            + "</ul></html>";
    private static ResourceDistributorSettingsPanel singleton = null;
    private GroupSelectionList groupList = null;

    public static synchronized ResourceDistributorSettingsPanel getSingleton() {
        if (singleton == null) {
            singleton = new ResourceDistributorSettingsPanel();
        }

        return singleton;
    }

    /**
     * Creates new form ResourceDataReadPanel
     */
    ResourceDistributorSettingsPanel() {
        initComponents();
        jXCollapsiblePane1.setLayout(new BorderLayout());
        jXCollapsiblePane1.add(jInfoScrollPane, BorderLayout.CENTER);
        jInfoTextPane.setText(GENERAL_INFO);
        jDataTable.setModel(new ExtendedMerchantTableModel());
        jDataTable.getTableHeader().setDefaultRenderer(new DefaultTableHeaderRenderer());
        jDataTable.setHighlighters(HighlighterFactory.createAlternateStriping(Constants.DS_ROW_A, Constants.DS_ROW_B));
        jDataTable.setDefaultRenderer(StorageStatus.class, new StorageCellRenderer());

        jDataTable.setDefaultRenderer(VillageMerchantInfo.Direction.class, new TradeDirectionCellRenderer());
        jDataTable.setDefaultRenderer(Integer.class, new NumberFormatCellRenderer());
        groupList = new GroupSelectionList("/res/awards/group.png");
        jGroupScrollPane.setViewportView(groupList);

        List<GroupSelectionList.ListItem> tags = new LinkedList<GroupSelectionList.ListItem>();
        for (Tag t : TagUtils.getTags(Tag.CASE_INSENSITIVE_ORDER)) {
            tags.add(new GroupSelectionList.ListItem(t));
        }
        groupList.setListData(tags.toArray(new GroupSelectionList.ListItem[tags.size()]));
        groupList.setEnabled(false);
    }

    public static String getDescription() {
        return "Transporte anpassen";
    }

    public static String getStep() {
        return "id-settings";
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jInfoScrollPane = new javax.swing.JScrollPane();
        jInfoTextPane = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jXCollapsiblePane1 = new org.jdesktop.swingx.JXCollapsiblePane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDataTable = new org.jdesktop.swingx.JXTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jEnableFarmSettingsBox = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSenderFarmSpace = new javax.swing.JTextField();
        jReceiverFarmSpace = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jFullStashAsSender = new javax.swing.JCheckBox();
        jSelectionAsReceiver = new javax.swing.JCheckBox();
        jSelectionAsSender = new javax.swing.JCheckBox();
        jSelectionAsBoth = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jEnableGroupSettingsBox = new javax.swing.JCheckBox();
        jGroupScrollPane = new javax.swing.JScrollPane();
        jGroupDirectionBox = new javax.swing.JComboBox();

        jInfoScrollPane.setMinimumSize(new java.awt.Dimension(19, 180));
        jInfoScrollPane.setPreferredSize(new java.awt.Dimension(19, 180));

        jInfoTextPane.setContentType("text/html");
        jInfoTextPane.setEditable(false);
        jInfoTextPane.setText("<html>Du befindest dich im <b>Angriffsmodus</b>. Hier kannst du die Herkunftsd&ouml;rfer ausw&auml;hlen, die f&uuml;r Angriffe verwendet werden d&uuml;rfen. Hierf&uuml;r hast die folgenden M&ouml;glichkeiten:\n<ul>\n<li>Einf&uuml;gen von Dorfkoordinaten aus der Zwischenablage per STRG+V</li>\n<li>Einf&uuml;gen der Herkunftsd&ouml;rfer aus der Gruppen&uuml;bersicht</li>\n<li>Einf&uuml;gen der Herkunftsd&ouml;rfer aus dem SOS-Analyzer</li>\n<li>Einf&uuml;gen der Herkunftsd&ouml;rfer aus Berichten</li>\n<li>Einf&uuml;gen aus der Auswahlübersicht</li>\n<li>Manuelle Eingabe</li>\n</ul>\n</html>\n");
        jInfoScrollPane.setViewportView(jInfoTextPane);

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Informationen einblenden");
        jLabel1.setToolTipText("Blendet Informationen zu dieser Ansicht und zu den Datenquellen ein/aus");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireShowHideInfoEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabel1, gridBagConstraints);

        jXCollapsiblePane1.setCollapsed(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jXCollapsiblePane1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(312, 387));

        jDataTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jDataTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jPanel4.setPreferredSize(new java.awt.Dimension(529, 300));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bauernhof"));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jEnableFarmSettingsBox.setText("Aktiviert");
        jEnableFarmSettingsBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fireEnableFarmSettingsEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jEnableFarmSettingsBox, gridBagConstraints);

        jLabel2.setText("Lieferant ab");
        jLabel2.setEnabled(false);
        jLabel2.setMaximumSize(new java.awt.Dimension(80, 14));
        jLabel2.setMinimumSize(new java.awt.Dimension(80, 14));
        jLabel2.setPreferredSize(new java.awt.Dimension(80, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Empfänger ab");
        jLabel3.setEnabled(false);
        jLabel3.setMaximumSize(new java.awt.Dimension(80, 14));
        jLabel3.setMinimumSize(new java.awt.Dimension(80, 14));
        jLabel3.setPreferredSize(new java.awt.Dimension(80, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel2.add(jLabel3, gridBagConstraints);

        jSenderFarmSpace.setText("23000");
        jSenderFarmSpace.setEnabled(false);
        jSenderFarmSpace.setMinimumSize(new java.awt.Dimension(36, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel2.add(jSenderFarmSpace, gridBagConstraints);

        jReceiverFarmSpace.setText("20000");
        jReceiverFarmSpace.setEnabled(false);
        jReceiverFarmSpace.setMinimumSize(new java.awt.Dimension(36, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel2.add(jReceiverFarmSpace, gridBagConstraints);

        jLabel4.setText("Plätzen");
        jLabel4.setEnabled(false);
        jLabel4.setMaximumSize(new java.awt.Dimension(40, 14));
        jLabel4.setMinimumSize(new java.awt.Dimension(40, 14));
        jLabel4.setPreferredSize(new java.awt.Dimension(40, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Plätzen");
        jLabel5.setEnabled(false);
        jLabel5.setMaximumSize(new java.awt.Dimension(40, 14));
        jLabel5.setMinimumSize(new java.awt.Dimension(40, 14));
        jLabel5.setPreferredSize(new java.awt.Dimension(40, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jLabel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jPanel2, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sonstiges"));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jFullStashAsSender.setText("Volle Speicher als Lieferanten");
        jFullStashAsSender.setMaximumSize(new java.awt.Dimension(140, 23));
        jFullStashAsSender.setMinimumSize(new java.awt.Dimension(140, 23));
        jFullStashAsSender.setPreferredSize(new java.awt.Dimension(140, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jFullStashAsSender, gridBagConstraints);

        jSelectionAsReceiver.setText("Gewählte Dörfer als 'Empfänger'");
        jSelectionAsReceiver.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fireChangeClipboardHandlingEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jSelectionAsReceiver, gridBagConstraints);

        jSelectionAsSender.setText("Gewählte Dörfer als 'Lieferant'");
        jSelectionAsSender.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fireChangeClipboardHandlingEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jSelectionAsSender, gridBagConstraints);

        jSelectionAsBoth.setText("Gewählte Dörfer als 'Beides'");
        jSelectionAsBoth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fireChangeClipboardHandlingEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jSelectionAsBoth, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jPanel3, gridBagConstraints);

        jButton1.setText("Anwenden");
        jButton1.setMaximumSize(new java.awt.Dimension(120, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(120, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(120, 23));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                firePerformSettingsEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jButton1, gridBagConstraints);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Gruppen"));
        jPanel5.setMinimumSize(new java.awt.Dimension(150, 50));
        jPanel5.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jEnableGroupSettingsBox.setText("Aktiviert");
        jEnableGroupSettingsBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fireEnableGroupSettingsEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jEnableGroupSettingsBox, gridBagConstraints);

        jGroupScrollPane.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jGroupScrollPane, gridBagConstraints);

        jGroupDirectionBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Empfänger", "Lieferanten", "Beides" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jGroupDirectionBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void fireShowHideInfoEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireShowHideInfoEvent
        if (jXCollapsiblePane1.isCollapsed()) {
            jXCollapsiblePane1.setCollapsed(false);
            jLabel1.setText("Informationen ausblenden");
        } else {
            jXCollapsiblePane1.setCollapsed(true);
            jLabel1.setText("Informationen einblenden");
        }
    }//GEN-LAST:event_fireShowHideInfoEvent

    private void fireEnableFarmSettingsEvent(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fireEnableFarmSettingsEvent
        jLabel2.setEnabled(jEnableFarmSettingsBox.isSelected());
        jLabel3.setEnabled(jEnableFarmSettingsBox.isSelected());
        jLabel4.setEnabled(jEnableFarmSettingsBox.isSelected());
        jLabel5.setEnabled(jEnableFarmSettingsBox.isSelected());
        jSenderFarmSpace.setEnabled(jEnableFarmSettingsBox.isSelected());
        jReceiverFarmSpace.setEnabled(jEnableFarmSettingsBox.isSelected());
    }//GEN-LAST:event_fireEnableFarmSettingsEvent

    private void fireEnableGroupSettingsEvent(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fireEnableGroupSettingsEvent
        jGroupScrollPane.setEnabled(jEnableGroupSettingsBox.isSelected());
        groupList.setEnabled(jEnableGroupSettingsBox.isSelected());
    }//GEN-LAST:event_fireEnableGroupSettingsEvent

    private void fireChangeClipboardHandlingEvent(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fireChangeClipboardHandlingEvent
        if (evt.getSource().equals(jSelectionAsReceiver)) {
            if (jSelectionAsReceiver.isSelected()) {
                jSelectionAsBoth.setSelected(false);
                jSelectionAsSender.setSelected(false);
            }
        } else if (evt.getSource().equals(jSelectionAsSender)) {
            if (jSelectionAsSender.isSelected()) {
                jSelectionAsBoth.setSelected(false);
                jSelectionAsReceiver.setSelected(false);
            }
        } else if (evt.getSource().equals(jSelectionAsBoth)) {
            if (jSelectionAsBoth.isSelected()) {
                jSelectionAsReceiver.setSelected(false);
                jSelectionAsSender.setSelected(false);
            }
        }
    }//GEN-LAST:event_fireChangeClipboardHandlingEvent

    private void firePerformSettingsEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firePerformSettingsEvent
        applySettings();
    }//GEN-LAST:event_firePerformSettingsEvent

    private void applySettings() {
        VillageMerchantInfo[] allElements = getAllElementsInternal();
        filterMisc(allElements);
        filterByFarm(allElements);
        filterByGroup(allElements);
        getModel().fireTableDataChanged();
    }

    private void filterMisc(VillageMerchantInfo[] pAllElements) {
        if (jFullStashAsSender.isSelected()) {
            for (VillageMerchantInfo element : pAllElements) {
                int capacity = element.getStashCapacity();
                if (element.getWoodStock() == capacity || element.getClayStock() == capacity || element.getIronStock() == capacity) {
                    element.setDirection(VillageMerchantInfo.Direction.OUTGOING);
                }
            }
        }

        //do selection handling
        VillageMerchantInfo.Direction newDir = null;
        if (jSelectionAsSender.isSelected()) {
            newDir = VillageMerchantInfo.Direction.OUTGOING;
        } else if (jSelectionAsReceiver.isSelected()) {
            newDir = VillageMerchantInfo.Direction.INCOMING;
        } else if (jSelectionAsBoth.isSelected()) {
            newDir = VillageMerchantInfo.Direction.BOTH;
        }

        if (newDir != null) {
            for (VillageMerchantInfo element : getSelection()) {
                element.setDirection(newDir);
            }
        }
    }

    private void filterByFarm(VillageMerchantInfo[] pAllElements) {
        if (jEnableFarmSettingsBox.isSelected()) {
            int senderFarmSpace = UIHelper.parseIntFromField(jSenderFarmSpace, 23000);
            int receiverFarmSpace = UIHelper.parseIntFromField(jReceiverFarmSpace, 20000);
            for (VillageMerchantInfo element : pAllElements) {
                if (element.getAvailableFarm() >= senderFarmSpace) {
                    element.setDirection(VillageMerchantInfo.Direction.OUTGOING);
                } else if (element.getAvailableFarm() <= receiverFarmSpace) {
                    element.setDirection(VillageMerchantInfo.Direction.INCOMING);
                }
            }
        }
    }

    private void filterByGroup(VillageMerchantInfo[] pAllElements) {
        if (jEnableGroupSettingsBox.isSelected()) {
            VillageMerchantInfo.Direction newDir = VillageMerchantInfo.Direction.BOTH;
            switch (jGroupDirectionBox.getSelectedIndex()) {
                case 0:
                    newDir = VillageMerchantInfo.Direction.INCOMING;
                    break;
                case 1:
                    newDir = VillageMerchantInfo.Direction.OUTGOING;
                    break;
                default:
                    newDir = VillageMerchantInfo.Direction.BOTH;
                    break;
            }

            for (VillageMerchantInfo element : pAllElements) {
                if (!element.getDirection().equals(newDir)) {
                    if (groupList.isVillageValid(element.getVillage())) {
                        element.setDirection(newDir);
                    }
                }
            }
        }
    }

    public void setup() {
        ExtendedMerchantTableModel model = getModel();
        model.clear();
        for (VillageMerchantInfo newInfo : ResourceDistributorDataReadPanel.getSingleton().getAllElements()) {
            model.addRow(newInfo.getVillage(),
                    newInfo.getStashCapacity(),
                    newInfo.getWoodStock(),
                    newInfo.getClayStock(),
                    newInfo.getIronStock(),
                    newInfo.getAvailableMerchants(),
                    newInfo.getOverallMerchants(),
                    newInfo.getAvailableFarm(),
                    newInfo.getOverallFarm(), false);
        }
        model.fireTableDataChanged();
    }

    public List<VillageMerchantInfo> getSelection() {
        int[] selection = jDataTable.getSelectedRows();
        List<VillageMerchantInfo> result = new LinkedList<VillageMerchantInfo>();
        if (selection.length > 0) {
            for (int i : selection) {
                result.add(getModel().getRow(jDataTable.convertRowIndexToModel(i)));
            }
        }
        return result;
    }

    private ExtendedMerchantTableModel getModel() {
        return (ExtendedMerchantTableModel) jDataTable.getModel();
    }

    private VillageMerchantInfo[] getAllElementsInternal() {
        List<VillageMerchantInfo> elements = new LinkedList<VillageMerchantInfo>();
        ExtendedMerchantTableModel model = getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            elements.add(model.getRow(i));
        }
        return elements.toArray(new VillageMerchantInfo[elements.size()]);
    }

    public VillageMerchantInfo[] getAllElements() {
        List<VillageMerchantInfo> elements = new LinkedList<VillageMerchantInfo>();
        ExtendedMerchantTableModel model = getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            elements.add(model.getRow(i).clone());
        }
        return elements.toArray(new VillageMerchantInfo[elements.size()]);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private org.jdesktop.swingx.JXTable jDataTable;
    private javax.swing.JCheckBox jEnableFarmSettingsBox;
    private javax.swing.JCheckBox jEnableGroupSettingsBox;
    private javax.swing.JCheckBox jFullStashAsSender;
    private javax.swing.JComboBox jGroupDirectionBox;
    private javax.swing.JScrollPane jGroupScrollPane;
    private javax.swing.JScrollPane jInfoScrollPane;
    private javax.swing.JTextPane jInfoTextPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jReceiverFarmSpace;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jSelectionAsBoth;
    private javax.swing.JCheckBox jSelectionAsReceiver;
    private javax.swing.JCheckBox jSelectionAsSender;
    private javax.swing.JTextField jSenderFarmSpace;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public WizardPanelNavResult allowNext(String string, Map map, Wizard wizard) {
        ResourceDistributorCalculationPanel.getSingleton().setup();
        return WizardPanelNavResult.PROCEED;
    }

    @Override
    public WizardPanelNavResult allowBack(String string, Map map, Wizard wizard) {
        return WizardPanelNavResult.PROCEED;

    }

    @Override
    public WizardPanelNavResult allowFinish(String string, Map map, Wizard wizard) {
        return WizardPanelNavResult.PROCEED;
    }

    private static class ExtendedMerchantTableModel extends AbstractTableModel {

        private String[] columnNames = new String[]{
            "Dorf", "Rohstoffe", "Speicher", "Händler", "Bauernhof", "Handelsrichtung"
        };
        Class[] types = new Class[]{
            Village.class, new double[0].getClass(), Integer.class, String.class, String.class, VillageMerchantInfo.Direction.class
        };
        private final List<VillageMerchantInfo> elements = new LinkedList<VillageMerchantInfo>();

        public ExtendedMerchantTableModel() {
            super();
        }

        public void clear() {
            elements.clear();
            fireTableDataChanged();
        }

        public void addRow(final Village pVillage, int pStash, int pWood, int pClay, int pIron, int pAvailableMerchants, int pMerchants, int pAvailableFarm, int pOverallFarm, boolean pCheck) {
            Object result = CollectionUtils.find(elements, new Predicate() {

                @Override
                public boolean evaluate(Object o) {
                    return ((VillageMerchantInfo) o).getVillage().equals(pVillage);
                }
            });

            if (result == null) {
                elements.add(new VillageMerchantInfo(pVillage, pStash, pWood, pClay, pIron, pAvailableMerchants, pMerchants, pAvailableFarm, pOverallFarm));
            } else {
                VillageMerchantInfo resultElem = (VillageMerchantInfo) result;
                resultElem.setWoodStock(pWood);
                resultElem.setClayStock(pClay);
                resultElem.setIronStock(pIron);
                resultElem.setStashCapacity(pStash);
                resultElem.setAvailableMerchants(pAvailableMerchants);
                resultElem.setOverallMerchants(pMerchants);
                resultElem.setAvailableFarm(pAvailableFarm);
                resultElem.setOverallFarm(pOverallFarm);
            }
            if (pCheck) {
                fireTableDataChanged();
            }
        }

        public void addRow(final Village pVillage, int pStash, int pWood, int pClay, int pIron, int pAvailableMerchants, int pMerchants, int pAvailableFarm, int pOverallFarm) {
            addRow(pVillage, pStash, pWood, pClay, pIron, pAvailableMerchants, pMerchants, pAvailableFarm, pOverallFarm, true);
        }

        @Override
        public int getRowCount() {
            if (elements == null) {
                return 0;
            }
            return elements.size();
        }

        @Override
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        public void removeRow(int row) {
            elements.remove(row);
            fireTableDataChanged();
        }

        public VillageMerchantInfo getRow(int row) {
            return elements.get(row);
        }

        @Override
        public Object getValueAt(int row, int column) {
            if (elements == null || elements.size() - 1 < row) {
                return null;
            }
            VillageMerchantInfo element = elements.get(row);
            switch (column) {
                case 0:
                    return element.getVillage();
                case 1:
                    return new StorageStatus(element.getWoodStock(), element.getClayStock(),
                            element.getIronStock(), element.getStashCapacity());
                case 2:
                    return element.getStashCapacity();
                case 3:
                    return element.getAvailableMerchants() + "/" + element.getOverallMerchants();
                case 4:
                    return element.getAvailableFarm() + "/" + element.getOverallFarm();
                default:
                    return element.getDirection();
            }
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }
    }
}
