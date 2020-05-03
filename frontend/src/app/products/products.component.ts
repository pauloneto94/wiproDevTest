import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { Product } from '../model/products';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  constructor(private productService: ProductService) { }

  products: Product[];

  ngOnInit(): void {
    this.getAtiveProducts();
  }

  getAtiveProducts(): void{
    this.productService.getActiveProducts().subscribe(products =>{
      this.products = products;
    });
  }

}
