import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: LucasXu
 * @email: 18140041@bjtu.edu.cn
 * @github: https://github.com/LucasXu01
 * @Date: 2022/03/01/11:06 上午
 */
public class LRUCacheX {
    int size;
    int capacity;
    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    Map<Integer, DoubleLinkedNode> cache = new HashMap<>();

    public LRUCacheX(int capacity){
        this.capacity = capacity;
        size = 0;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.nxt = tail;
        tail.pre = head;
    }

    public DoubleLinkedNode  get(int key){
        DoubleLinkedNode node = cache.get(key);
        move2Head(node);
        return node;
    }

    public void put(int key, int value){
        DoubleLinkedNode node = cache.get(key);
        if (node == null){
            node = new DoubleLinkedNode(key, value);
            add2Head(node);
            size++;

            if (size>capacity){
                DoubleLinkedNode node2 = removeTail();
                size--;
            }

        }else {
            move2Head(node);
        }
    }

   public class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode pre;
        DoubleLinkedNode nxt;

        public DoubleLinkedNode(){
        }

        public DoubleLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
   }


    public void add2Head(DoubleLinkedNode ndoe){

    }

    public void remove(DoubleLinkedNode node){

    }

    public void move2Head(DoubleLinkedNode node){
        remove(node);
        add2Head(node);
    }

    public DoubleLinkedNode removeTail(){
        return new DoubleLinkedNode(1,1);
    }
}
