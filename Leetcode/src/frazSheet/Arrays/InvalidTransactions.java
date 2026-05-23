package frazSheet.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class InvalidTransactions {
	class Transactions{
		private String name;
		private int time;
		private int amount;
		private String city;
		private boolean valid;
		public Transactions(String detail[]) {
			this.name=detail[0];
			this.time=Integer.parseInt(detail[1]);
			this.amount=Integer.parseInt(detail[2]);
			this.city=detail[3];
			this.valid=true;
		}

		public int getTime() {
			return time;
		}

		public int getAmount() {
			return amount;
		}


		public String getCity() {
			return city;
		}



		public boolean isValid() {
			return valid;
		}


		public void setValid(boolean valid) {
			this.valid = valid;
		}

		@Override
		public String toString() {
			return "Transactions [time=" + time + ", amount=" + amount + ", city=" + city + ", valid=" + valid + "]";
		}




	}
	public List<String> invalidTransactions(String[] transactions) {
		HashMap<String,ArrayList<Transactions>>map=new HashMap<>();
		for(String s:transactions) {


			String detailsSeperated[]=s.split(",");
			if(!map.containsKey(detailsSeperated[0])) {
				ArrayList<Transactions>temp=new ArrayList<>();
				Transactions newTransaction=new Transactions(detailsSeperated);
				temp.add(newTransaction);
				map.put(detailsSeperated[0], temp);
			}
			else {
				ArrayList<Transactions>temp=map.get(detailsSeperated[0]);
				Transactions newTransaction=new Transactions(detailsSeperated);
				temp.add(newTransaction);
				map.put(detailsSeperated[0], temp);
			}


		}

		for(String name:map.keySet()) {
			ArrayList<Transactions>transactionsOfPerson=map.get(name);

			for(int i=0;i<transactionsOfPerson.size();i++) {
				if(transactionsOfPerson.get(i).getAmount()>1000) {
					transactionsOfPerson.get(i).setValid(false);
				}
				
		
			
					for(int j=i+1;j<transactionsOfPerson.size();j++) {
				
						
							Transactions ofFirstPerson=transactionsOfPerson.get(i);
							Transactions ofSecondPerson=transactionsOfPerson.get(j);
							if(!ofFirstPerson.getCity().equals(ofSecondPerson.getCity())&& Math.abs(ofFirstPerson.getTime()-ofSecondPerson.getTime())<=60) {
								ofFirstPerson.setValid(false);
								ofSecondPerson.setValid(false);
//								break;
												
					}
				}

			}
		}
		ArrayList<String> ans=new ArrayList<>();
		for(String name:map.keySet()) {
			ArrayList<Transactions>transactionsOfPerson=map.get(name);
			for(int i=0;i<transactionsOfPerson.size();i++) {
				if(transactionsOfPerson.get(i).isValid()) {
					continue;
				}
				else {
				String ansString=name+","+transactionsOfPerson.get(i).getTime()+","+transactionsOfPerson.get(i).getAmount()+","+transactionsOfPerson.get(i).city;
				ans.add(ansString);
				}
				}
		}
		
		return ans;
	}
	public static void main(String[] args) {

		String transactions []= {"alice,20,800,mtv","alice,50,100,mtv","alice,151,100,frankfurt"};
		List<String>ans=new InvalidTransactions().invalidTransactions(transactions);

		System.out.println(ans);




	}

}
