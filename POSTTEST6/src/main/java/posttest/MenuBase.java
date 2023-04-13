/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package posttest;

/**
 *
 * @author Viabel
 */
public interface MenuBase {
    int LoginMenu();
    int IntersectMenu(String Active, String SAd, boolean Admin);
    int AdminMenu(String Active, String SAd);
    int UserMenu(String Active);
}
