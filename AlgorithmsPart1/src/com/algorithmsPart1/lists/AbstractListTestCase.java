package com.algorithmsPart1.lists;


import junit.framework.TestCase;

public abstract class AbstractListTestCase extends TestCase {

	protected static final Object VALUE_A = "A";
	
	protected static final Object VALUE_B = "B";
	
	protected static final Object VALUE_C = "C";
	
	
	protected abstract List createList();

	public void testInsertIntoEmptyList(){
		
		List list = createList();
		
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		list.insert(0, VALUE_A);
		
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		assertSame(VALUE_A, list.get(0));
	}
	
	public void testInsertBetweenElements() {
		
		List list = createList();
		
		list.insert(0, VALUE_A);
		list.insert(1, VALUE_B);
		list.insert(1, VALUE_C);
		
		
		assertEquals(3, list.size());
		
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_C, list.get(1));
		assertSame(VALUE_C, list.get(2));
		
	}
	
	public void testInsertBeforeFirstElement(){
		
		List list = createList();
		
		list.insert(0, VALUE_A);
		list.insert(0, VALUE_B);
		
		assertEquals(2, list.size());
		
		assertSame(VALUE_B, list.get(0));
		assertSame(VALUE_A, list.get(1));
		
	}
	
	public void testInsertAfterLastElement(){
		
		List list = createList();
		
		list.insert(0, VALUE_A);
		list.insert(1, VALUE_B);
		
		assertEquals(2, list.size());
		
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
		
	}
	
	
	public void testInsertIndexOutOfBounds(){
		
		List list = createList();
		
		try {
			
			list.insert(-1, VALUE_A);
			fail();
			
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		try {
			
			list.insert(1, VALUE_B);
			
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		
	}
	
	public void testAdd(){
		
		List list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_C);
		list.add(VALUE_B);
		
		assertEquals(3, list.size());
		
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_C, list.get(1));
		assertSame(VALUE_C, list.get(2));
	}
	
	
	
	public void testSet(){
		
		List list = createList();
		
		list.insert(0, VALUE_A);
		
		assertSame(VALUE_A, list.get(0));
		
		assertSame(VALUE_A, list.set(0, VALUE_B));
		assertSame(VALUE_B, list.get(0));
		
	}
	
	public void testGetOutOfBounds(){
		
		List list = createList();
		
		try {
			
			list.get(-1);
			fail();
			
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		try {
			
			list.get(0);
			fail();
			
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		list.add(VALUE_A);
		
		try {
			
			list.get(1);
			fail();
			
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}
	
	public void testSetOutOfBounds(){
		
		List list = createList();
		
		try {
			
			list.set(-1, VALUE_A);
			fail();
			
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		try {
			
			list.set(0, VALUE_B);
			fail();
			
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		
		list.insert(0, VALUE_C);
		
		try {
			
			list.set(1, VALUE_C);
			fail();
			
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}
	
	public void testDeleteOnlyElement(){
		
		List list = createList();
		
		list.add(VALUE_A);
		
		assertEquals(1, list.size());
		assertSame(VALUE_A,list.get(0));
		assertSame(VALUE_A, list.delete(0));
		
		assertEquals(0, list.size());
		
	}
	
	public void testDeleteFirstElemet(){
		
		List list  = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		assertEquals(3, list.size());
		
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
		assertSame(VALUE_C, list.get(2));
		
		assertSame(VALUE_A,list.delete(0));
		
		assertEquals(2, list.size());
		assertSame(VALUE_B, list.get(0));
		assertSame(VALUE_C, list.get(1));
	}
	
	public void testDeleteLastElement(){
		
		List list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		assertEquals(3, list.size());
		
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
		assertSame(VALUE_C, list.get(2));
		
		assertSame(VALUE_C, list.delete(2));
		
		assertEquals(2,list.size());
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
		
	}
	
	public void testDeleteMiddleElement(){
		
		
		List list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_C);
		list.add(VALUE_B);
		
		assertEquals(3, list.size());
		
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_C, list.get(1));
		assertSame(VALUE_B, list.get(2));
		
		assertSame(VALUE_C, list.delete(1));
		
		assertEquals(2, list.size());
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
	}
	
	public void testDeleteOutOfBounds(){
		
		List list = createList();
		
		try {
			
			list.delete(-1);
			fail();
			
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		try {
			
			list.delete(0);
			fail();
			
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}
	
	public void testDeleteByValue(){
		
		List list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_A);
		
		assertEquals(3, list.size());
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
		assertSame(VALUE_A, list.get(2));
		
		assertTrue(list.delete(VALUE_A));
		
		assertEquals(2, list.size());
		
		assertSame(VALUE_B,list.get(0));
		assertSame(VALUE_A, list.get(1));
		
		assertTrue(list.delete(VALUE_A));
		
		assertEquals(1, list.size());
		
		assertSame(VALUE_B, list.get(0));
		
		assertFalse(list.delete(VALUE_C));
		
		assertEquals(1, list.size());
		assertSame(VALUE_B, list.get(0));
		
		assertTrue(list.delete(VALUE_B));
		
		assertEquals(0, list.size());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
