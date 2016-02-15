package study.sample;

public class ArrayEx3 {

	public static void main(String[] args) {
		String[] customers = {"김도훈", "박건영", "박용우", "최아람", "정세은", "이시연"};
		
//		deleteCustomer(customers, "최아람");
		
//		System.out.println(findCustomer(customers, "정세은"));
		
		addCustomer(customers, "박건우", "김선미");
	}

	
	static void deleteCustomer(String[] customers, String deleteCustomer){
		int deleteIdx = -1;
		for (int i=0;i<customers.length;i++){
			if (customers[i].equals(deleteCustomer)){
				deleteIdx = i;
			}
		}
		if (deleteIdx == customers.length - 1){
			customers[deleteIdx] = null;
		}else {
			for (int i=deleteIdx;i<customers.length;i++){
				customers[i-1] = customers[i];
			}
			customers[customers.length-1] = null;
		}
	}
	
	static int findCustomer(String[] customers, String findCustomer){
		for (int i=0;i<customers.length;i++){
			if (customers[i].equals(findCustomer)){
				return i+1;
			}
		}
		return -1;
	}
	
	static void addCustomer(String[] customers, String... addCustomers) {
		String[] resultCustomers = new String[customers.length+addCustomers.length];
		
		for (int i=0;i<customers.length;i++){
			resultCustomers[i] = customers[i];
		}
		
		for (int i=0;i<addCustomers.length;i++){
			resultCustomers[customers.length+i] = addCustomers[i];
		}
		
		customers = resultCustomers;
		
		//java 메소드는 call by references 이므로 reference 자체를 바꾸는 건 소용이 없음
	}
}
