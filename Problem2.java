/*
Copy List With Random Pointer
approach: use a map to store created nodes or copy nodes and place next to current node(3 pass)
time: map: O(n) or 3pass: O(3n)
space: map: O(n) 3pass: O(1)
 */
public class Problem2 {
    /*
    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        Node curr = head;
        Node copyHead = clone(head);
        Node copyCurr = copyHead;

        while(curr!=null) {
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);
            copyCurr = copyCurr.next;
            curr = curr.next;
        }
        return copyHead;
    }

    private Node clone(Node node) {
        if(node == null) return null;
        if(map.containsKey(node)) {
            return map.get(node);
        }

        Node n = new Node(node.val);
        map.put(node, n);
        return n;
    }

     */

    /*
    3 Pass Solution
        public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr = head;

        while(curr!=null) {
            Node n = new Node(curr.val);
            n.next = curr.next;
            curr.next = n;
            curr = curr.next.next;
        }
        curr = head;
        while(curr!=null) {
            if(curr.random!=null)
            curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        curr = head;
        Node copyHead = head.next;
        Node copyCurr = copyHead;
        while(curr!=null && copyCurr.next!=null) {
            curr.next = curr.next.next;
            copyCurr.next = copyCurr.next.next;
            copyCurr = copyCurr.next;
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return copyHead;
    }
     */
}
