
public class TryGenerics {
	
	
	class  MyGenericClass<T> {
		T val;
		
		public T get() {
			return this.val;
		}
		
		public void set(T t) {
			this.val = t;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyGenericClass<Integer> obj = new MyGenericClass<Integer>();
				
		
	}

}
