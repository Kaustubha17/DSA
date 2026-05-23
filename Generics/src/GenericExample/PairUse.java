package GenericExample;

public class PairUse {

	public static void main(String[] args) {
//		Pair p=new Pair(10,20);
//		Pair<Integer>pI=new Pair<>(10,20);
//		Pair<String>ps;
//		ps=new Pair<>("a","b");
		
//		
//		String s=new String();
//		System.out.println(s);
//		
//		System.out.println(pI.getFirst());
		Pair<Pair<String,Integer>,Integer> p=new Pair<>();
		p.setSecond(12);
		System.out.println(p.getFirst());
		Pair<String,Integer>p2=new Pair<>("abc",10);
		p.setFirst(p2);
		System.out.println(p.getFirst().getFirst());
		
		
	}

}
