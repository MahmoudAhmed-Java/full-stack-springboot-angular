import {Shape} from "./Shape";
 
export class Circle extends Shape {
    
    constructor(private theX:number , private theY:number, private _raduis: number){
        super(theX,theY);
    }

    public get raduis():number {
        return this._raduis;
    }

    public set raduis(value: number){
        this._raduis = value;
    }

    calculateArea(): number {
        return Math.PI * Math.pow(this._raduis,2);
    }

    getInfo(): string {
        return super.getInfo() + `, raduis=${this._raduis}`;
    }
}