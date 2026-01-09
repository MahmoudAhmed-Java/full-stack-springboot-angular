import { Component } from '@angular/core';
import { SalesPerson } from './sales-person';
import { CommonModule, NgForOf, NgIf, NgClass } from '@angular/common';
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-sales-person-list',
  imports: [NgForOf, NgIf, CurrencyPipe, NgClass],
  templateUrl: './sales-person-list-bootstrap.component.html',
  styleUrl: './sales-person-list.component.css'
})
export class SalesPersonListComponent {

    salesPersonList:SalesPerson[] = [
      new SalesPerson("Anup" , "Kumor" , "anup.kumor@luv2code.com",50000),
      new SalesPerson("John" , "Doe" , "john.doe@luv2code.com",40000),
      new SalesPerson("Clarie" , "Murphy" , "claire.murphy@luv2code.com",90000),
      new SalesPerson("Mai" , "Truong" , "mai.truong@luv2code.com",60000),
    ];

    constructor(){}
    ngOnInit(){}
}
