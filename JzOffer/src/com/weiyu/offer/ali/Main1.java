package com.weiyu.offer.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }
        scanner.close();

        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }
    }
    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < lineList.size(); i++){
            UnilateralLine currentLine = lineList.get(0);
        	String currentType = currentLine.getTType();
        	String currentId = currentLine.getId();
        	String currentSCen = currentLine.getSCen();
        	String currentSPro = currentLine.getSPro();
        	String currentECen = currentLine.getECen();

        	for(int j = i + 1; j < lineList.size(); j++){
        		if(lineList.get(j).getSCen().equals(currentECen) && lineList.get(j).getTType().equals(currentType)){
        			if(lineList.get(j).getEPro().equals(currentSPro)){
        				result.add("rule3:"+currentId + "+" + lineList.get(j).getId());
            			i--;
            			j--;
            			break;
        			}
        			else{
	        			for(int k = 0; k < lineList.size(); k++){
	        				if(lineList.get(k).getSCen().equals(lineList.get(j).getECen()) && lineList.get(k).getECen().equals(currentSCen) && lineList.get(k).getTType().equals(currentType)){
	        					result.add("rule2:"+currentId + "+" + lineList.get(j).getId() + "+" + lineList.get(k).getId());
	                			lineList.remove(j);
	                			lineList.remove(i);
	                			if(k > j){
	                				lineList.remove(k-2);
	                			}
	                			else if(k > i){
	                				lineList.remove(k-1);
	                				j--;
	                			}
	                			else{
	                				lineList.remove(k);
	                				j--;
	                			}
	        					i--;
	        					j--;
	        					break;
	        				}
	        			}
        			}
        		}else if(lineList.get(j).getECen().equals(currentSCen) && lineList.get(j).getSCen().equals(currentECen) && lineList.get(j).getTType().equals(currentType)){
					result.add("rule1:"+currentId + "+" + lineList.get(j).getId());
					lineList.remove(i);
					lineList.remove(j);
					i--;
					j--;
					break;
				}
			}
        }
        return result;
    }
public static class UnilateralLine {
private String id;
private String sCen;//出发分拨
private String sPro;//出发省
private String eCen;//到达分拨
private String ePro;//到达省
//9.6m/17.5m
private String tType;//车型
public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro,String tType) {
            this.id 

 

 = id;this.sCen = sCen;this.sPro = sPro;this.eCen = eCen;this.ePro = ePro;this.tType = tType;}
public String getId() {return id;}
public void setId(String id) {this.id 

 

 = id;}
public String getSCen() {return sCen;}
public void setSCen(String ePro) {this.ePro = ePro;}
public String getSPro() {return sPro;}
public void setSPro(String sPro) {this.sPro = sPro;}
public String getECen() {return eCen;}
public void setECen(String eCen) {this.eCen = eCen;}
public String getEPro() {return ePro;}
public void setEPro(String ePro) {this.ePro = ePro;}
public String getTType() {return tType;}
public void setTType(String tType) {this.tType = tType;}
}
}
