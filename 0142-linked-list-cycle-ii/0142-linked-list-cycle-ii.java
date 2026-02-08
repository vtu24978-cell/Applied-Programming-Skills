public class Solution {
/**
* Detects if a linked list has a cycle and returns the node where the cycle begins.
* Uses Floyd's Cycle-Finding Algorithm (Tortoise and Hare).
*
* @param head The head of the linked list
* @return The node where the cycle begins, or null if no cycle exists
*/
public ListNode detectCycle(ListNode head) {
ListNode fastPointer = head;
ListNode slowPointer = head;
while (fastPointer != null && fastPointer.next != null) {
slowPointer = slowPointer.next; 
fastPointer = fastPointer.next.next; 
if (slowPointer == fastPointer) {
ListNode startPointer = head;
while (startPointer != slowPointer) {
startPointer = startPointer.next;
slowPointer = slowPointer.next;
}
return startPointer;
}
}
return null;
}
}