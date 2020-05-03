import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { Product } from '../model/products';

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent implements OnInit {

  constructor(private productService: ProductService) { }

  product: Product;

  ngOnInit(): void {
    this.product = {code: "", description: "", productActivation: null, price: 0, date: null};
  }

  onSubmit(){
    this.productService.addProduct(this.product);
  }

}
