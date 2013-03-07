declare default element namespace "http://www.khveras.com/TimeTable";

let $cities:=distinct-values (doc("TimeTable.xml")//destStation/city/text())

for $city in $cities
let $percForCity:=count (doc("TimeTable.xml")//destStation/city[text() = $city]) div count(doc("TimeTable.xml")//trip) * 100
return <tripsToCityPerc city='{$city}'>{$percForCity}</tripsToCityPerc>