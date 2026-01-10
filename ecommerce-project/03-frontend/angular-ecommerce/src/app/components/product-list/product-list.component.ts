import { Component, OnInit } from '@angular/core';
import { Product } from '../../common/product';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-list',
  standalone: false,
  templateUrl: './product-list-table.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {

  products:Product[] = [];

  constructor(private productedService: ProductService){}

  ngOnInit(): void{
    this.listProducts();
  }

  listProducts() {
    this.productedService.getProductList().subscribe(
      data => { this.products = data; }
    );
  }

}
