public class Solution {
/**
* Finds the intersection node of two singly-linked lists.
* Uses the two-pointer technique where both pointers traverse both lists.
* When a pointer reaches the end of one list, it continues from the head of the other list.
* If there's an intersection, both pointers will meet at the intersection node.
* If there's no intersection, both pointers will eventually become null simultaneously.
*
* @param headA The head of the first linked list
* @param headB The head of the second linked list
* @return The intersection node if it exists, otherwise null
*/
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
ListNode pointerA = headA;
ListNode pointerB = headB;
while (pointerA != pointerB) {
pointerA = (pointerA == null) ? headB : pointerA.next;
pointerB = (pointerB == null) ? headA : pointerB.next;
}
return pointerA;
}
}