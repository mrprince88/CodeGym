import java.util.*;

class CalenderMatching {

	static void solve(ArrayList<Time[]> calender1, ArrayList<Time[]> calender2,
	                  Time[]dailyBound1, Time[]dailyBound2, Time meetingDuration) {

		ArrayList<Time[]>updatedCalender1 = updateCalender(calender1, dailyBound1);
		ArrayList<Time[]>updatedCalender2 = updateCalender(calender2, dailyBound2);
		ArrayList<Time[]>mergedCalender = mergeCalender(updatedCalender1, updatedCalender2);
		ArrayList<Time[]>flattenedCalender = flattenCalender(mergedCalender);

		PossibleMeetingTimes(flattenedCalender, meetingDuration);
	}

	static ArrayList<Time[]> updateCalender(ArrayList<Time[]> calender, Time[]dailyBound) {
		Time []a = {new Time("0:00"), dailyBound[0]};
		calender.add(0, a);
		Time []b = {dailyBound[1], new Time("23:59")};
		calender.add(b);

		return calender;

	}

	static ArrayList<Time[]> mergeCalender(ArrayList<Time[]> calender1,
	                                       ArrayList<Time[]> calender2) {
		int i = 0, j = 0;
		ArrayList<Time[]> mergedList = new ArrayList<>();
		while (i < calender1.size() && j < calender2.size()) {
			if (compare(calender1.get(i)[0], calender2.get(j)[0]) > 0)
				mergedList.add(calender2.get(j++));
			else
				mergedList.add(calender1.get(i++));
		}
		while (i < calender1.size())
			mergedList.add(calender2.get(i++));
		while (j < calender2.size())
			mergedList.add(calender2.get(j++));

		return mergedList;
	}

	static ArrayList<Time[]> flattenCalender(ArrayList<Time[]> calender) {

		if (calender.isEmpty())
			return calender;

		ArrayList<Time[]> flattenedList = new ArrayList<>();
		flattenedList.add(calender.get(0));
		Time[] previousMeeting = flattenedList.get(0);

		for (int i = 1; i < calender.size(); i++) {
			Time[] currentMeeting = calender.get(i);

			if (compare(previousMeeting[1], currentMeeting[0]) >= 0)
				previousMeeting[1] = compare(previousMeeting[1], currentMeeting[1]) >= 0 ? previousMeeting[1] : currentMeeting[1];
			else {
				flattenedList.add(currentMeeting);
				previousMeeting = currentMeeting;
			}
		}

		return flattenedList;
	}

	static void PossibleMeetingTimes(ArrayList<Time[]> calender, Time meetingDuration) {
		int duration = meetingDuration.h * 60 + meetingDuration.min;

		for (int i = 1; i < calender.size(); i++) {
			Time start = calender.get(i - 1)[1];
			Time end = calender.get(i)[0];

			if (compare(end, start) >= duration)
				System.out.println(start.h1 + ":" + start.min1 + "-" + end.h1 + ":"
				                   + end.min1);
		}
	}


	static class Time {
		int h = 0;
		int min = 0;
		String h1 = "";
		String min1 = "";

		Time(String time) {
			int pos = time.indexOf(":");
			h1 = time.substring(0, pos);
			h = Integer.parseInt(h1);
			min1 = time.substring(pos + 1);
			min = Integer.parseInt(min1);
		}

	}

	static int compare(Time t1, Time t2) {
		return (t1.h * 60 + t1.min) - (t2.h * 60 + t2.min);
	}

	public static void main(String[] args) {
		ArrayList<Time[]>calender1 = new ArrayList<>();
		Time[] a = {new Time("9:00"), new Time("10:30")};
		calender1.add(a);
		Time[] b = {new Time("12:00"), new Time("13:00")};
		calender1.add(b);
		Time[] c = {new Time("16:00"), new Time("18:00")};
		calender1.add(c);

		Time []dailyBound1 = {new Time("9:00"), new Time("20:00")};

		ArrayList<Time[]>calender2 = new ArrayList<>();
		Time []d = {new Time("10:00"), new Time("11:30")};
		calender2.add(d);
		Time []e = {new Time("12:30"), new Time("14:30")};
		calender2.add(e);
		Time []f = {new Time("14:30"), new Time("15:00")};
		calender2.add(f);
		Time []g = {new Time("14:30"), new Time("15:00")};
		calender2.add(g);
		Time []h = {new Time("16:00"), new Time("17:00")};
		calender2.add(h);

		Time []dailyBound2 = {new Time("10:00"), new Time("18:30")};

		Time meetingDuration = new Time("0:30");

		solve(calender1, calender2, dailyBound1, dailyBound2, meetingDuration);

	}
}
