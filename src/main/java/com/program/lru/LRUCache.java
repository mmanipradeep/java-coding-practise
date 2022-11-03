package com.program.lru;

import java.util.HashMap;
//REf :https://krishankantsinghal.medium.com/my-first-blog-on-medium-583159139237
public class LRUCache {

    HashMap<Integer, Entry> hashMap;
    Entry start ,end ;
    int LRU_SIZE=4;

    public LRUCache(){
        hashMap =new HashMap<>();
    }

    public int getEntry(int key) {
        if (hashMap.containsKey(key)) // Key Already Exist, just update the
        {
            Entry entry = hashMap.get(key);
            removeNode(entry);
            addAtTop(entry);
            return entry.value;
        }
        return -1;
    }

    public void addAtTop(Entry node){
        node.right = start;
        node.left = null;
        if(start !=null)
            start.left = node;
        start = node;
        if(end == null)
            end =start;
    }
    public void removeNode(Entry node){
        if(node.left !=null){
            node.left.right = node.right;
        }else{
            start = node.right;
        }

        if(node.right !=null){
            node.right.left = node.left;
        }else{
            end = node.left;
        }
    }

    public void putEntry(int key,int value){
        if(hashMap.containsKey(key)){
            Entry entry =hashMap.get(key);
            entry.value = value;
            removeNode(entry);
            addAtTop(entry);
        }else{
            Entry newnode = new Entry();
            newnode.left = null ;
            newnode.right = null ;
            newnode.value = value;
            newnode.key = key ;

            if(hashMap.size() >LRU_SIZE){
                hashMap.remove(end.key);
                removeNode(end);
                addAtTop(newnode);
            }else{
                addAtTop(newnode);
            }
            hashMap.put(key,newnode);
        }
    }
    public static void main(String[] args)  {
        // your code goes here
        LRUCache lrucache = new LRUCache();
        lrucache.putEntry(1, 1);
        lrucache.putEntry(10, 15);
        lrucache.putEntry(15, 10);
        lrucache.putEntry(10, 16);
        lrucache.putEntry(12, 15);
        lrucache.putEntry(18, 10);
        lrucache.putEntry(13, 16);

        System.out.println(lrucache.getEntry(1));
        System.out.println(lrucache.getEntry(15));
        System.out.println(lrucache.getEntry(13));

    }
}


class Entry{
    int value;
    int key;
    Entry left;
    Entry right;
}

