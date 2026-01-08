"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var CricketCoach_1 = require("./CricketCoach");
var GolfCoach_1 = require("./GolfCoach");
var myCricketCoach = new CricketCoach_1.CricketCoach();
var myGolfCoach = new GolfCoach_1.GolfCoach();
var theCoches = [];
theCoches.push(myCricketCoach);
theCoches.push(myGolfCoach);
for (var _i = 0, theCoches_1 = theCoches; _i < theCoches_1.length; _i++) {
    var tempCoach = theCoches_1[_i];
    console.log(tempCoach.getDailyWorkout());
}
