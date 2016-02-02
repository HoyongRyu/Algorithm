package leetcode.complete;

public class ZigzagConversion{

	public static void main(String[] args){
		ZigzagConversion z = new ZigzagConversion();
		System.out.println(z.convert("PAYPALISHIRING", 3));
		System.out.println(z.convert("AB", 1));
	}

	public String convert(String s, int nRows) {
		char[] charArr = s.toCharArray();
		StringBuffer[] resultTemp = new StringBuffer[nRows]; 
		boolean indexAddFlag = true;
		int index = 0;
		
		for (int i=0;i<nRows;i++){
			resultTemp[i] = new StringBuffer();
		}
		
		for (char c : charArr) {
			
			resultTemp[index].append(c);
			
			if (index == 0) {
				indexAddFlag = true;
			}else if (index >= nRows-1){
				indexAddFlag = false;
			}
			
			if (nRows == 1){
				continue;
			}
			
			if (indexAddFlag) {
				index++;
			}else {
				index--;
			}
		}

		StringBuffer result = new StringBuffer(); 
		for (StringBuffer sb : resultTemp) {
			result.append(sb);
		}
		
		return result.toString();
	}
}
