
/*
 * Dustin Jutras and Pamela Phan
 * CS 332 HW 11
 * 11/14/2017
 */


import java.util.Collection;

// Implementation details in underlying set are encapsulated again
public class InstrumentedCollection<E> extends ForwardingCollection<E>{
   private int addCount = 0;	

   public InstrumentedCollection(Collection<E> s){ super(s); }
   @Override public boolean add(E e){ addCount++; return super.add(e); }
   @Override public boolean addAll(Collection<? extends E> c) { 
         addCount += c.size(); return super.addAll(c); 
   }
   public int getAddCount(){ return addCount; }
}