/**
 * Find Median from Data Stream
 *
 * Median is the middle value in ordered integer list; If the size of the list is even, there in no middle 
 * value so the median is the mean of the two middle values
 *
 * @author Wali Morris 
 * @since 06/10/2020
 */

import java.util.*;

class MedianFinder {
    private List<Integer> list;

    public MedianFinder() {
        this.list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        if (this.list.size() == 0 ) {
            this.list.add(num);
        } else {
            // flag to comfirm number has been added into sorted list
            boolean added = false;
            for ( int i = 0; i < list.size(); i++ ) {
                if ( num < this.list.get(i) ) {
                    this.list.add(i, num);
                    // number added, flag equals true and break loop
                    added = true;
                    break;
                }
            }
            /* added still equates to false, number is greater than any element in list, 
             * append to the end */
            if (added != true ) { 
                this.list.add(num);
            } 
        } 
    } 

    public double findMedian() { 
        if ( this.list.size() == 0 ) { 
            return 0.0; 
        } else if ( this.list.size() == 1 ) { 
            return (double) this.list.get(0);  
        } else if ( this.list.size() % 2 != 0 ) { 
            return (double) this.list.get(this.list.size() / 2); 
        } else { 
            double first = this.list.get(this.list.size() / 2 - 1); 
            double second = this.list.get(this.list.size() / 2); 
            double median = (first + second) / 2; 
            return median; 
        } 
    } 
}
