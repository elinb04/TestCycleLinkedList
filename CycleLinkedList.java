
class CycleLinkedList1<T>
{
    private T data;
	private CycleLinkedList1<T> next;
	
	public CycleLinkedList1(T data, CycleLinkedList1<T> next)
	{
		this.data = data;
		this.next = next;
	}
	
	public CycleLinkedList1(T data)
	{
		this(data, null);
	}
	
	public void setData(T data)
	{
		this.data = data;
	}
	
	public void setNext(CycleLinkedList1<T> next)
	{
		this.next = next;
	}
	
	public T getData()
	{
		return data;
	}
	
	public CycleLinkedList1<T> getNext()
	{
		return next;
	}

}

public class CycleLinkedList<T> {
    private CycleLinkedList1<T> start;
	private CycleLinkedList1<T> end;
	private int size;
	

    private void clear() {
            start = end = null;
            size = 0;
        }
        
    public boolean isEmpty()
    {
        return start == null;
    }

    public int size(){
        return size;
    }
    public void add(T element){
        if(isEmpty()){
            start = new CycleLinkedList1<T>(element);
        }else{
            start = new CycleLinkedList1<T>(element, start);
            end = start;
        }
        size++;
    }
    void add(int index, T element){
        if(index > size){
            throw new IndexOutOfBoundsException();
        }
        CycleLinkedList1<T> currentNode = start;
		CycleLinkedList1<T> previousNode = null;
		while(index > 0)
		{
			previousNode = currentNode;
			currentNode = currentNode.getNext();
			index--;
		}
		if(previousNode != null)
		{
			previousNode.setNext(new CycleLinkedList1<T>(element, currentNode));
		}
		else
		{
			start = new CycleLinkedList1<T>(element, start);
		}
		size++;
    }
    public T get(int index){
        CycleLinkedList1 current = start;
        while(index > 0)
		{
			current = current.getNext();
			index--;
		}
        return current.getData();
    }
}
