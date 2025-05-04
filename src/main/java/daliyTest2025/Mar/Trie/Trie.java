package daliyTest2025.Mar.Trie;

class Node{
    Node[] son = new Node[26];
    boolean end;
}

class Trie {
    private Node root;
    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node cur = this.root;
        for(char c : word.toCharArray()){
            c -= 'a';
            if(cur.son[c]==null){
                cur.son[c] = new Node();
            }
            cur = cur.son[c];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return find(word) == 2;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) > 0;
    }
    private int find(String words){
        Node cur = this.root;
        for(char c : words.toCharArray()){
            c -= 'a';
            if(cur.son[c]!=null){
                cur = cur.son[c];
            }else
                return 0;
        }
        if(cur.end)
            return 2;
        else
            return 1;
    }
}
