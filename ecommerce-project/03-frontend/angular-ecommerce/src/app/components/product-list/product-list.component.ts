import { Component, OnInit } from '@angular/core';
import { Product } from '../../common/product';
import { ProductService } from '../../services/product.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-list',
  standalone: false,
  templateUrl: './product-list-grid.component.html',
  //templateUrl: './product-list-table.component.html',
  //templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {

  products:Product[] = [];
  currentCategoryId: number = 1;
  currentCategoryName: string = "";

  constructor(private productedService: ProductService, private route: ActivatedRoute){}

  ngOnInit(): void{
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
    
  }

  listProducts() {
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');
    if(hasCategoryId){
        this.currentCategoryId = +this.route.snapshot.paramMap.get('id')!;
        this.currentCategoryName = this.route.snapshot.paramMap.get('name')!;
    }else{
      this.currentCategoryId = 1;
      this.currentCategoryName = 'Books';
    }
    this.productedService.getProductList(this.currentCategoryId).subscribe(
      data => { this.products = data; }
    );
  }

}
