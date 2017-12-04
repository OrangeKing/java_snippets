/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zusapp;

/**
 *
 * @author Norbert
 */
public interface ZUSMBean 
{
    public int getCaseCount();
    public void setCaseCount(int caseCount);
    public String[] getCategories();
    public void setCategories(String[] categories);
    public String getPendingCaseLabel();
    public void setPendingCaseLabel(String pendingCaseLabel);
 
    public String doConfig();
}
