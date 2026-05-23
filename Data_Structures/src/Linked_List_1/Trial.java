package Linked_List_1;

public class Trial {

public static void inc(int arr2[]) {
	
	arr2[0]+=1;
}

public static int length(Node<Integer> head){
    int length=0;
    while(head.data!=-1){
        head=head.next;
        length++;
    }
    return length;


}
	
	public static void main(String[] args) {
Node<Integer>a1=new Node<Integer>(12);
Node<Integer>a2=new Node<Integer>(12);
Node<Integer>a3=new Node<Integer>(12);
Node<Integer>a4=new Node<Integer>(-1);
a1.next=a2;
a2.next=a3;
a3.next=a4;
System.out.println(length(a1));
//		int arr[]= {1,3};
//		inc(arr);
//		System.out.println(arr[0]);

		
	}

}
