package ATOZsheet.GreedyAlgo;

import java.util.Arrays;

public class meetingInNRooms {
    static class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;

        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }

        Arrays.sort(meetings, (a, b) -> a.end - b.end);

        int count = 1;
        int lastEnd = meetings[0].end;

        for (int i = 1; i < n; i++) {
            if (meetings[i].start > lastEnd) {
                count++;
                lastEnd = meetings[i].end;
            }
        }

        return count;
    }
}
