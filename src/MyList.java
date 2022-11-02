public class MyList<T> {
    private static int capacity=10;
    private static int i=0;
    private T[] arr= (T[]) new Object[MyList.capacity];

    public MyList(){
    }

    public MyList(int capacity){
        MyList.capacity=capacity;
    }

    public int size(){
        return i;
    }

    public int getCapacity(){
        if ((i+1)==MyList.capacity) {
            MyList.capacity *= 2;
            T[] arr2=arr;
            arr=(T[]) new Object[MyList.capacity];

            for (int i=0;i<arr2.length;i++) {
                arr[i]=arr2[i];
            }
        }
        return MyList.capacity;
    }

    public void add(T data){
        if ((i+1)==MyList.capacity){
            getCapacity();
        }
        arr[i]=data;
        MyList.i+=1;
    }

    public T get(int index){
        if (index>MyList.capacity){
            return null;
        }else
            return arr[index];
    }

    public T remove(int index){
        T a;
        if (index>MyList.capacity){
            return null;
        }else{
            a=arr[index];
            for (int y=index;y<MyList.capacity-1;y++){
                arr[y]=arr[y+1];
            }
            MyList.i-=1;
        }
        return a;
    }

    public T set(int index,T data){
        if (index>MyList.capacity){
            return null;
        }else{
            arr[index]=data;
            return data;
        }
    }

    public String toString(){
        String s="[";
        for (T t:arr) {
            if (t!=null){
               s+=t+",";
            }
        }
        if (s.length()>2){
            s=s.substring(0,s.length()-1);
        }
        s+="]";
        return s;
    }

    public int indexOf(T data){
        int val=0;
        for (T t:arr) {
            if (t==data){
                return val;
            }else {
                val++;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        int val = MyList.i;
        for (int i = 0; i < MyList.i + 1; i++){
            if (arr[val] == data) {
                return val;
            } else {
                val--;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        for (T t:arr) {
            if (t!=null){
                return false;
            }
        }
        return true;
    }

    public Object[] toArray(){
        Object[] newArr= new Object[i+1];
        for (int x=0;x<i+1;x++){
            newArr[x]=arr[x];
        }
        return newArr;
    }

    public void clear(){
        for (int i=0;i<arr.length;i++){
            arr[i]=null;
        }
    }

    boolean contains(T data){
        for (T t:arr) {
            if (t!=null && t.equals(data)){
                return true;
            }
        }
        return false;
    }

    public MyList<T> subList(int start, int finish) {
        MyList<T> subList= new MyList<>();
       for (int j=start;j<finish+1;j++){
            if (start<=finish){
                subList.add(arr[j]);
            }
       }

        return subList;
    }
}
