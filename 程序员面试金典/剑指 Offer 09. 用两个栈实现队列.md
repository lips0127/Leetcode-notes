```java
class CQueue {
    Deque<Integer> stackIn;
    Deque<Integer> stackOut;
    
    public CQueue() {
        stackIn = new LinkedList<Integer>();
        stackOut = new LinkedList<Integer>();
    }
    
    public void appendTail(int value) {
        stackIn.push(value);
    }
    
    public int deleteHead() {
        // 如果第二个栈为空
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        } 
        if (stackOut.isEmpty()) {
            return -1;
        } else {
            int deleteItem = stackOut.pop();
            return deleteItem;
        }
    }
}
```

```python
```



