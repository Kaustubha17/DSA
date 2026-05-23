/*
 * Implementation of hash maps using separate chaining
 */

package HashMap;

import java.util.ArrayList;

public class Map<K,V> {

	ArrayList<MapNode<K, V>>buckets;
	int numBuckets;
	int count=0;
	public Map() {
		buckets=new ArrayList<>();
		this.numBuckets=5;

		for(int i=0;i<numBuckets;i++) {
			buckets.add(null);
		}
	}

	
	
	private int getBucketIndex(K key) {
		//		if key is string then String class will provide hashcode if for some class hashcode is not present then object class will provide it since it is super class of all the classes

		int hc=key.hashCode();
		int index=hc%numBuckets;//this is compression step
		return index;
	}

	public void insert(K key,V value) {
		int bucketIndex=getBucketIndex(key);
		MapNode<K,V>head=buckets.get(bucketIndex);
//		updating key with new value
		while(head!=null) {
			if(head.key.equals(key)) {
				head.value=value;
				return;
			}
			head=head.next;
		}
//		adding new element with same hashcode
		
		head=buckets.get(bucketIndex);
		MapNode<K, V>newNode=new MapNode<K, V>(key, value);
		newNode.next=head;
		buckets.set(bucketIndex, newNode);
		count++;
		double loadFactor=(1.0*count)/numBuckets;
		if(loadFactor>0.7) {
			reHash();
		}
	}
	
	public double loadFactor() {
		return (1.0*count)/numBuckets;
	}
	
	public int size() {
		return count;
	}

	public V getValue(K key) {
		int bucketIndex=getBucketIndex(key);
		MapNode<K,V>head=buckets.get(bucketIndex);
		while(head!=null) {
			if(head.key.equals(key)) {
				
				return head.value;
			}
			head=head.next;
		}
		return null;
	}

	private void reHash() {
		ArrayList<MapNode<K, V>>temp=buckets;
		buckets=new ArrayList<>();
		
		for(int i=0;i<2*numBuckets;i++) {
			buckets.add(null);
		}
		count=0;
		numBuckets=numBuckets*2;
		
		for(int i=0;i<temp.size();i++) {
			MapNode<K, V>head=temp.get(i);
			while(head!=null) {
				insert(head.key,head.value);
				head=head.next;
			}
		}
		
	}
	
	public V removeKey(K key) {
		int bucketIndex=getBucketIndex(key);
		MapNode<K,V>head=buckets.get(bucketIndex);
		MapNode<K, V>prev=null;
		while(head!=null) {
			if(head.key.equals(key)) {
				if(prev!=null)
				prev.next=head.next;
				else {
					buckets.set(bucketIndex, head.next);
					}
				count--;
				return head.value;
			}
			
			prev=head;
			head=head.next;
		}
		
		return null;
	}
	}


