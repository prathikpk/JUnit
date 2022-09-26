package comm.Aurionpro.model1;

public class StringUtil {
	
	public String truncateAInFirstTwoPlace(String str) {
		StringBuilder sb=new StringBuilder(str);
		if(sb.charAt(0)=='a') {
	      sb.deleteCharAt(0);
		}
		if(sb.charAt(0)=='a') {
		      sb.deleteCharAt(0);
		}
		return sb.toString();
	}
	public Boolean FirstAndLastTwoCharAreEqual(String str) {
		StringBuilder sb=new StringBuilder(str);
		if((sb.charAt(0)&sb.charAt(1))==(sb.charAt(4)&sb.charAt(5))) {
			return true;
		}
		return false;
	}

}
