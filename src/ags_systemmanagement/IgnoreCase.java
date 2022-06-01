/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ags_systemmanagement;
import java.util.Comparator;

/**
 *
 * @author Prem Sharaan
 */
public class IgnoreCase implements Comparator<String> {

    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
    
}