package LinkedList;

public class Solution {
    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tmp1=list1;
        ListNode tmp2=list2;
        ListNode resulthead;
        ListNode tmpresult=null;
        if (list1==null)
            return list2;
        if (list2==null)
            return list1;

        if (tmp1.val<tmp2.val){
            resulthead=tmp1;
            tmpresult=tmp1;
            tmp1=tmp1.next;
        }
        else{
            resulthead=tmp2;
            tmpresult=tmp2;
            tmp2=tmp2.next;
        }
        while((tmp1!=null) && (tmp2!=null)){
            while((tmp1!=null) && (tmp2!=null) && (tmp1.val<=tmp2.val)){
                tmpresult.next=tmp1;
                tmp1=tmp1.next;
                tmpresult=tmpresult.next;
            }
            while((tmp2!=null) && (tmp1!=null) && (tmp1.val>=tmp2.val)){
                tmpresult.next=tmp2;
                tmp2=tmp2.next;
                tmpresult=tmpresult.next;
            }
        }
        while((tmp2!=null) && (tmp1==null)){
            tmpresult.next=tmp2;
            tmp2=tmp2.next;
            tmpresult=tmpresult.next;
        }
        while((tmp1!=null) && (tmp2==null)){
            tmpresult.next=tmp1;
            tmp1=tmp1.next;
            tmpresult=tmpresult.next;
        }
        return resulthead;
    }
