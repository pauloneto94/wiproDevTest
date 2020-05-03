import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { Product } from '../model/products';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent implements OnInit {

  constructor(private productService: ProductService) { }

  products: Product[];
  searchText = "";

  ngOnInit(): void {
    
  }

  getProduct(): void{
    this.products = [];
    this.productService.getProduct(this.searchText).subscribe(product =>{
      if(product != null) this.products.push(product);
    })
  }

}
