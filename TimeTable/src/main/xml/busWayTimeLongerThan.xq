declare default element namespace "http://www.khveras.com/TimeTable";
doc("TimeTable.xml")//timetable/trip[@tripType="BUS"][number(substring(timeInWay,1,2))*60+number(substring(timeInWay,4,2))>90]

