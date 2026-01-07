"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Customer {
    _firstName;
    _lastName;
    constructor(theFirst, theLast) {
        this._firstName = theFirst;
        this._lastName = theLast;
    }
    get firstName() {
        return this._firstName;
    }
    set firstName(value) {
        this._firstName = value;
    }
    get lastName() {
        return this._lastName;
    }
    set lastName(value) {
        this._lastName = value;
    }
}
let myCustomer = new Customer("Martin", "Dixon");
/*myCustomer.firstName = "Martin";
myCustomer.lastName = "Dixon";*/
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
//# sourceMappingURL=Customer.js.map