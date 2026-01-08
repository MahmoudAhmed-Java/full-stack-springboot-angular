import { Coach } from "./Coach";
import { CricketCoach } from "./CricketCoach";
import { GolfCoach } from "./GolfCoach";

let myCricketCoach = new CricketCoach();
let myGolfCoach = new GolfCoach();

let theCoches: Coach[] = [];

theCoches.push(myCricketCoach);
theCoches.push(myGolfCoach);

for(let tempCoach of theCoches ){
    console.log(tempCoach.getDailyWorkout());
}