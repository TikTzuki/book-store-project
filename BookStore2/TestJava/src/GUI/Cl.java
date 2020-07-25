/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.border.Border;

/**
 *
 * @author Tik
 */
public class Cl {
    static public Color colorRed = new Color(255,84,117,255);
    static public Color colorBackground = new Color(24,23,23,255);
    static public Color colorGreen = new Color(199,244,101,255);
    static public Color colorBlue = new Color(51,204,204,255);
    static public Color colorCream = new Color(255, 218, 185,255);

    static public Border blueLineS = BorderFactory.createLineBorder(colorBlue, 1,true);
    static public Border greenLineS = BorderFactory.createLineBorder(colorGreen, 1,true);
    static public Border blackLineS = BorderFactory.createLineBorder(colorBackground, 1,true);
    static public Border whiteLineS = BorderFactory.createLineBorder(Color.white, 1, true);
    static public Border redLineS = BorderFactory.createLineBorder(Cl.colorRed, 1, true);
    static public Border creamLineS = BorderFactory.createLineBorder(Cl.colorCream, 1, true);
    
    static public Border blueLine = BorderFactory.createLineBorder(colorBlue, 2,true);
    static public Border greenLine = BorderFactory.createLineBorder(colorGreen, 2,true);
    static public Border blackLine = BorderFactory.createLineBorder(colorBackground, 2,true);
    static public Border whiteLine = BorderFactory.createLineBorder(Color.white, 2, true);
    static public Border redLine = BorderFactory.createLineBorder(Cl.colorRed, 2, true);
    static public Border creamLine = BorderFactory.createLineBorder(Cl.colorCream, 2, true);
    
    static public Border blueLineL = BorderFactory.createLineBorder(colorBlue, 4,true);
    static public Border greenLineL = BorderFactory.createLineBorder(colorGreen, 4,true);
    static public Border blackLineL = BorderFactory.createLineBorder(colorBackground, 4,true);
    static public Border whiteLineL = BorderFactory.createLineBorder(Color.white, 4, true);
    static public Border redLineL = BorderFactory.createLineBorder(Cl.colorRed, 4, true);
    static public Border creamLineL = BorderFactory.createLineBorder(Cl.colorCream, 4, true);
    
    static public Font fontContentS = new Font(Font.DIALOG, 0, 12);
    static public Font fontContentM = new Font(Font.DIALOG, 0, 14);
    static public Font fontContentL = new Font(Font.DIALOG, 0, 16);
    static public Font fontContentXL = new Font(Font.DIALOG, 0, 18);
    static public Font fontContentXXL = new Font(Font.DIALOG, 0, 24);
    
    static public Font fontContentSB = new Font(Font.DIALOG, 1, 12);
    static public Font fontContentMB = new Font(Font.DIALOG, 1, 14);
    static public Font fontContentLB = new Font(Font.DIALOG, 1, 16);
    static public Font fontContentXLB = new Font(Font.DIALOG, 1, 18);
    static public Font fontContentXXLB = new Font(Font.DIALOG, 1, 24);
    
    static JScrollBar scrollBar = new JScrollBar(1);
    public static  JScrollBar verticalScrollBar(){
        scrollBar.setBackground(Cl.colorBackground);
        return scrollBar;
    }
    static public JTable[] showColorTable(JTable TableArray[]){
        for(int i=0; i<TableArray.length; i++){
            TableArray[i].setBackground(Cl.colorBackground);
            TableArray[i].setForeground(Color.white);
            TableArray[i].setGridColor(Color.DARK_GRAY);
            TableArray[i].setSelectionForeground(Cl.colorBlue);
            TableArray[i].setSelectionBackground(Cl.colorBackground);
            TableArray[i].getTableHeader().setBackground(Cl.colorBackground);
            TableArray[i].getTableHeader().setForeground(Cl.colorBlue);
            TableArray[i].getTableHeader().setFont(Cl.fontContentMB);
        }
        return TableArray;
    }
    static public JTable showColorTable(JTable TableArray){
        
            TableArray.setBackground(Cl.colorBackground);
            TableArray.setForeground(Color.white);
            TableArray.setGridColor(Color.DARK_GRAY);
            TableArray.setSelectionForeground(Cl.colorBlue);
            TableArray.setSelectionBackground(Cl.colorBackground);
            TableArray.getTableHeader().setBackground(Cl.colorBackground);
            TableArray.getTableHeader().setForeground(Cl.colorBlue);
            TableArray.getTableHeader().setFont(Cl.fontContentMB);
        
        return TableArray;
    }
        
}
