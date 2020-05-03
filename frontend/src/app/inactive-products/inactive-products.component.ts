import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { Product } from '../model/products';

@Component({
  selector: 'app-inactive-products',
  templateUrl: './inactive-products.component.html',
  styleUrls: ['./inactive-products.component.css']
})
export class InactiveProductsComponent implements OnInit {

  constructor(private productService: ProductService) { }

  products: Product[];

  ngOnInit(): void {
    this.getInactiveProducts();
  }

  getInactiveProducts(): void{
    this.productService.getInactiveProducts().subscribe(products =>{
      this.products = products;
    });
  }

}
