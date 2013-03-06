declare default element namespace "http://www.khveras.com/TimeTable";

declare function local:tripsToTZCount($shift as xs:string) {
let $cnt:= count(doc("TimeTable.xml")//destStation[timeZone/text()=$shift])
return if ($cnt>0) 
then <tripsCount timezone='{$shift}'>{$cnt}</tripsCount>
else()
};

for $shift in (-11 to 11)
return if ($shift<0)
then local:tripsToTZCount(concat("GMT",$shift))
else
if ($shift=0)
then local:tripsToTZCount('GMT')
else local:tripsToTZCount(concat('GMT+',$shift))